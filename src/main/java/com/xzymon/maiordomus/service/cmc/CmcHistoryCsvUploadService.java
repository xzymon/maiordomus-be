package com.xzymon.maiordomus.service.cmc;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import com.xzymon.maiordomus.dto.CmcHistoryDto;
import com.xzymon.maiordomus.dto.ProtoHistoryDto;
import com.xzymon.maiordomus.mapper.CsvMapper;
import com.xzymon.maiordomus.mapper.DefaultMapper;
import com.xzymon.maiordomus.model.csv.CmcHistoryCsvRecord;
import com.xzymon.maiordomus.model.db.CmcHistory;
import com.xzymon.maiordomus.model.db.FileUploadStatus;
import com.xzymon.maiordomus.model.db.ProtoHistory;
import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.repository.CmcHistoryRepository;
import com.xzymon.maiordomus.repository.ProtoHistoryRepository;
import com.xzymon.maiordomus.repository.StockValorRepository;
import com.xzymon.maiordomus.scheduler.fileloading.DataLoadingCapsule;
import com.xzymon.maiordomus.scheduler.fileloading.DataLoadingObjectAttributes;
import com.xzymon.maiordomus.scheduler.fileloading.DataLoadingStringAttributes;
import com.xzymon.maiordomus.scheduler.fileloading.FileType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CmcHistoryCsvUploadService implements CsvUploadService {
	public static final int FIRST_ROW_WITH_DATA_ONE_BASED = 2;

	private CmcHistoryRepository cmcHistoryRepository;
	private ProtoHistoryRepository protoHistoryRepository;
	private StockValorRepository stockValorRepository;
	
	private Map<String, StockValor> stockNameToEntityMap;

	public CmcHistoryCsvUploadService(CmcHistoryRepository cmcHistoryRepository,
	                                  ProtoHistoryRepository protoHistoryRepository,
	                                  StockValorRepository stockValorRepository) {
		this.cmcHistoryRepository = cmcHistoryRepository;
		this.protoHistoryRepository = protoHistoryRepository;
		this.stockValorRepository = stockValorRepository;
		createStockValorMap();
	}

	@Override
	public void upload(DataLoadingCapsule capsule) {
		String fileName = capsule.getStringAttributes().get(DataLoadingStringAttributes.FILE_NAME);
		FileType fileType = (FileType) capsule.getObjectAttributes().get(DataLoadingObjectAttributes.FILE_TYPE);
		byte[] data = capsule.getData();
		try (InputStream inputStream = new ByteArrayInputStream(data)) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			//extractAndSaveProto(reader, fileType);
			extractAndSave(reader, fileType);
			capsule.getObjectAttributes().put(DataLoadingObjectAttributes.PROCESSING_STATUS, FileUploadStatus.DONE);
			log.debug("File {} uploaded successfully", fileName);

		} catch (Exception e) {
			capsule.getObjectAttributes().put(DataLoadingObjectAttributes.PROCESSING_STATUS, FileUploadStatus.ERROR);
			log.error("Error processing data from byte array for file: {}", fileName, e);
		}
	}

	protected void extractAndSave(BufferedReader reader, FileType fileType) {
		List<CmcHistoryCsvRecord> records = extract(reader);
		int rowIndex = FIRST_ROW_WITH_DATA_ONE_BASED;
		CmcHistoryDto dto;
		List<CmcHistoryDto> dtos = new ArrayList<>();
		for (CmcHistoryCsvRecord record : records) {
			if (isValid(record, rowIndex)) {
				dto = CsvMapper.INSTANCE.toCmcHistoryDto(record);
				dtos.add(dto);
			} else {
				log.debug("Skipping invalid record at row {}", rowIndex);
				log.debug("Record: {}", record);
			}
			rowIndex++;
		}
		store(dtos);
	}

	protected void extractAndSaveProto(BufferedReader reader, FileType fileType) {
		List<CmcHistoryCsvRecord> records = extract(reader);
		int rowIndex = FIRST_ROW_WITH_DATA_ONE_BASED;
		ProtoHistoryDto dto;
		List<ProtoHistoryDto> dtos = new ArrayList<>();
		for (CmcHistoryCsvRecord record : records) {
			if (isValid(record, rowIndex)) {
				dto = CsvMapper.INSTANCE.toProtoHistoryDto(record);
				dtos.add(dto);
			} else {
				log.debug("Skipping invalid record at row {}", rowIndex);
				log.debug("Record: {}", record);
			}
			rowIndex++;
		}
		storeProto(dtos);
	}

	public List<CmcHistoryCsvRecord> extract(BufferedReader reader) {
		return new CsvToBeanBuilder<CmcHistoryCsvRecord>(reader)
				       .withType(CmcHistoryCsvRecord.class)
				       .withSeparator(';')
				       .withQuoteChar('\"')
				       .withIgnoreLeadingWhiteSpace(true)
					   .withIgnoreEmptyLine(true)
				       .withSkipLines(1)  //skip first line = header
				       .build()
				       .parse();
	}

	public boolean isValid(CmcHistoryCsvRecord record, int rowIndex) {
		log.info("Validating record at row {}", rowIndex);
		StringBuilder sb = new StringBuilder();
		/*
		if (record.getDate() == null) {
			sb.append("[").append(rowIndex).append("]");
			sb.append("{Invalid date=").append(record.getDate()).append("}");
		}*/
		return sb.length() == 0;
	}

	public boolean store(List<CmcHistoryDto> dtos) {
		CmcHistory cmcHistory, savedCmcHistory;
		int rowIndex = FIRST_ROW_WITH_DATA_ONE_BASED;
		log.info("Storing {} cmcHistories", dtos.size());
		for (CmcHistoryDto dto : dtos) {
			cmcHistory = DefaultMapper.INSTANCE.toCmcHistory(dto);
			cmcHistory.setInstrument(stockNameToEntityMap.get(dto.getInstrument()));
			savedCmcHistory = cmcHistoryRepository.save(cmcHistory);
			log.debug("Saved cmcHistory {}", savedCmcHistory);
			rowIndex++;
			if (rowIndex % 100 == 0) {
				log.info("Stored {} records", rowIndex);
			}
		}
		return true;
	}

	public boolean storeProto(List<ProtoHistoryDto> dtos) {
		ProtoHistory protoHistory, savedProtoHistory;
		int rowIndex = FIRST_ROW_WITH_DATA_ONE_BASED;
		log.info("Storing {} protoHistories", dtos.size());
		for (ProtoHistoryDto dto : dtos) {
			protoHistory = DefaultMapper.INSTANCE.toProtoHistory(dto);
			savedProtoHistory = protoHistoryRepository.save(protoHistory);
			log.debug("Saved protoHistory {}", savedProtoHistory);
			rowIndex++;
			if (rowIndex % 100 == 0) {
				log.info("Stored {} records", rowIndex);
			}
		}
		return true;
	}

	public void createStockValorMap() {
		List<StockValor> valors = stockValorRepository.findAll();
		stockNameToEntityMap = valors.stream()
			.collect(Collectors.toMap(StockValor::getCmcName, valor -> valor));
	}
}
