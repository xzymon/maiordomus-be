package com.xzymon.maiordomus.scheduler.fileloading;

import com.xzymon.maiordomus.model.db.FileUploadAudit;
import com.xzymon.maiordomus.model.db.FileUploadStatus;
import com.xzymon.maiordomus.scheduler.fileloading.exception.EmptyFileNameAttribute;
import com.xzymon.maiordomus.service.FileUploadAuditService;
import com.xzymon.maiordomus.service.cmc.CmcHistoryCsvUploadService;
import com.xzymon.maiordomus.service.cmc.CsvUploadService;
import com.xzymon.maiordomus.service.stock.DailyStockCsvUploadService;
import com.xzymon.maiordomus.service.stock.QuarterStockCsvUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
@Slf4j
public class CsvDataLoadingProcessor {

	private CmcHistoryCsvUploadService cmcHistoryCsvUploadService;
	private QuarterStockCsvUploadService quarterStockCsvUploadService;
	private DailyStockCsvUploadService dailyStockCsvUploadService;
	private FileUploadAuditService fileUploadAuditService;

	public CsvDataLoadingProcessor(CmcHistoryCsvUploadService cmcHistoryCsvUploadService,
								   DailyStockCsvUploadService dailyStockCsvUploadService,
	                               QuarterStockCsvUploadService quarterStockCsvUploadService,
	                               FileUploadAuditService fileUploadAuditService) {
		this.cmcHistoryCsvUploadService = cmcHistoryCsvUploadService;
		this.dailyStockCsvUploadService = dailyStockCsvUploadService;
		this.quarterStockCsvUploadService = quarterStockCsvUploadService;
		this.fileUploadAuditService = fileUploadAuditService;
	}

	public boolean loadData(DataLoadingCapsule capsule) {
		if (isCapsuleValid(capsule)) {
			//db
			//db check name -> performed by db
			String checksum = calculateChecksumSHA512(capsule.getData());
			Long linesCount = getLinesCount(capsule.getData());
			FileUploadAudit createdAudit, updatedAudit;
			FileUploadAudit audit = new FileUploadAudit();
			audit.setName(capsule.getStringAttributes().get(DataLoadingStringAttributes.FILE_NAME));
			audit.setHash(checksum);
			audit.setLines(linesCount);
			audit.setLength(capsule.getData().length);
			try {
				createdAudit = fileUploadAuditService.createOrUpdate(audit);
			} catch (DataIntegrityViolationException dive) {
				log.error(dive.getMessage());
				log.error("File couldn't be uploaded.");
				return false;
			}
			//db check duplicate checksum -> performed by db
			processByFileNameMask(capsule);
			createdAudit.setType((FileType) capsule.getObjectAttributes().get(DataLoadingObjectAttributes.FILE_TYPE));
			createdAudit.setStatus((FileUploadStatus) capsule.getObjectAttributes().get(DataLoadingObjectAttributes.PROCESSING_STATUS));
			updatedAudit = fileUploadAuditService.createOrUpdate(createdAudit);
			return true;
		} else {
			log.error( "DataLoadingCapsule is not valid. Can't process data");
			return false;
		}
	}

	private void processByFileNameMask(DataLoadingCapsule capsule) {
		String fileName = capsule.getStringAttributes().get(DataLoadingStringAttributes.FILE_NAME);
		if (fileName == null || fileName.isEmpty()) {
			throw new EmptyFileNameAttribute();
		}
		//get processor by file name
		FileType fileType = FileTypeByFileNameMaskResolver.resolve(fileName);
		capsule.getObjectAttributes().put(DataLoadingObjectAttributes.FILE_TYPE, fileType);
		CsvUploadService csvUploadService = getServiceForFileType(fileType);
		// tu się powinno odbyć po prostu wywołanie serwisu i on powinien zrobić swoją robotę - i tyle
		csvUploadService.upload(capsule);
	}

	private Long getLinesCount(byte[] data) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data)));
		return reader.lines().count();
	}

	private CsvUploadService getServiceForFileType(FileType fileType) {
		switch (fileType) {
			case CMC_HISTORY -> {
				log.debug("CMC_HISTORY file type detected");
				return cmcHistoryCsvUploadService;
			}
			case STOOQ_BLOCK_1D -> {
				log.debug("STOOQ_BLOCK_1D file type detected");
				return dailyStockCsvUploadService;
			}
			case STOOQ_BLOCK_CRYPTO_1D -> {
				log.debug("STOOQ_BLOCK_CRYPTO_1D file type detected");
				return dailyStockCsvUploadService;
			}
			case STOOQ_BLOCK_CRYPTO_15M -> {
				log.debug("STOOQ_BLOCK_CRYPTO_15M file type detected");
				return quarterStockCsvUploadService;
			}
			case STOOQ_BLOCK_CURR_15M -> {
				log.debug("STOOQ_BLOCK_CURR_15M file type detected");
				return quarterStockCsvUploadService;
			}
			default -> {
				log.error("Unsupported file type: {}", fileType);
				throw new IllegalArgumentException("Unsupported file type: " + fileType);
			}
		}
	}

	private String calculateChecksumSHA512(byte[] data) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			byte[] hash = digest.digest(data);
			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			log.error("Failed to calculate SHA-512 checksum", e);
			throw new RuntimeException("Unable to calculate SHA-512 checksum", e);
		}
	}

	private static boolean isCapsuleValid(DataLoadingCapsule capsule) {
		if (capsule == null) {
			log.error( "DataLoadingCapsule is null");
			return false;
		}
		if (capsule.getData() == null) {
			log.error( "DataLoadingCapsule.Data is null");
			return false;
		}
		if (capsule.getData().length == 0) {
			log.error( "DataLoadingCapsule.Data is empty");
			return false;
		}
		if (capsule.getObjectAttributes().get(DataLoadingObjectAttributes.SOURCE_TYPE) == null) {
			log.error( "DataLoadingCapsule.ObjectAttributes.SOURCE_TYPE is null");
			return false;
		}
		if (capsule.getObjectAttributes().get(DataLoadingObjectAttributes.SOURCE_TYPE).equals(SourceType.FILE)
			&& capsule.getStringAttributes().get(DataLoadingStringAttributes.FILE_NAME) == null ) {
			log.error( "DataLoadingCapsule.StringAttributes.FILE_NAME is null");
			return false;
		}
		return true;
	}


}
