package com.xzymon.maiordomus.service.stock;

import com.xzymon.maiordomus.model.db.FileUploadStatus;
import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.scheduler.fileloading.DataLoadingCapsule;
import com.xzymon.maiordomus.scheduler.fileloading.DataLoadingObjectAttributes;
import com.xzymon.maiordomus.scheduler.fileloading.DataLoadingStringAttributes;
import com.xzymon.maiordomus.scheduler.fileloading.FileType;
import com.xzymon.maiordomus.service.StockValorService;
import com.xzymon.maiordomus.service.cmc.CsvUploadService;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
public abstract class AbstractStockCsvUploadService implements CsvUploadService {
	public static final int FIRST_ROW_WITH_DATA_ONE_BASED = 2;

	private StockValorService stockValorService;

	public AbstractStockCsvUploadService(StockValorService stockValorService) {
		this.stockValorService = stockValorService;
	}

	@Override
	public void upload(DataLoadingCapsule capsule) {
		String fileName = capsule.getStringAttributes().get(DataLoadingStringAttributes.FILE_NAME);
		String valorName = getValorNameFromFileName(fileName);
		StockValor stockValor = findOrAddValorForName(valorName);
		FileType fileType = (FileType) capsule.getObjectAttributes().get(DataLoadingObjectAttributes.FILE_TYPE);
		byte[] data = capsule.getData();
		try (InputStream inputStream = new ByteArrayInputStream(data)) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			extractAndSave(reader, fileType, stockValor);
			capsule.getObjectAttributes().put(DataLoadingObjectAttributes.PROCESSING_STATUS, FileUploadStatus.DONE);
			log.debug("File {} uploaded successfully", fileName);

		} catch (Exception e) {
			capsule.getObjectAttributes().put(DataLoadingObjectAttributes.PROCESSING_STATUS, FileUploadStatus.ERROR);
			log.error("Error processing data from byte array for file: {}", fileName, e);
		}
	}

	protected abstract void extractAndSave(BufferedReader reader, FileType fileType, StockValor stockValor);

	private String getValorNameFromFileName(String fileName) {
		return fileName.substring(0, fileName.indexOf('_'));
	}

	private StockValor findOrAddValorForName(String name) {
		StockValor stockValor = stockValorService.getByName(name);
		if (stockValor == null) {
			stockValor = new StockValor();
			stockValor.setName(name);
			stockValor = stockValorService.save(stockValor);
		}
		return stockValor;
	}
}
