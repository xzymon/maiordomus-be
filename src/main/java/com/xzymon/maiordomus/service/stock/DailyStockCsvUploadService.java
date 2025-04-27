package com.xzymon.maiordomus.service.stock;

import com.opencsv.bean.CsvToBeanBuilder;
import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.mapper.CsvMapper;
import com.xzymon.maiordomus.mapper.DefaultMapper;
import com.xzymon.maiordomus.model.csv.DateStockCandleCsvRecord;
import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.model.db.StooqDailyStockCandle;
import com.xzymon.maiordomus.repository.DailyStockCandleRepository;
import com.xzymon.maiordomus.scheduler.fileloading.FileType;
import com.xzymon.maiordomus.service.StockValorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DailyStockCsvUploadService extends AbstractStockCsvUploadService {

	private DailyStockCandleRepository dailyStockCandleRepository;

	public DailyStockCsvUploadService(StockValorService stockValorService, DailyStockCandleRepository dailyStockCandleRepository) {
		super(stockValorService);
		this.dailyStockCandleRepository = dailyStockCandleRepository;
	}

	@Override
	protected void extractAndSave(BufferedReader reader, FileType fileType, StockValor stockValor) {
		List<DateStockCandleCsvRecord> records = extract(reader);
		log.info("Extracted {} records", records.size());
		int rowIndex = FIRST_ROW_WITH_DATA_ONE_BASED;
		StockCandleDto dto;
		List<StockCandleDto> dtos = new ArrayList<>();
		for (DateStockCandleCsvRecord record : records) {
			if (isValid(record, rowIndex)) {
				dto = CsvMapper.INSTANCE.toStockCandleDto(record);
				dtos.add(dto);
			} else {
				log.debug("Skipping invalid record at row {}", rowIndex);
				log.debug("Record: {}", record);
			}
			rowIndex++;
			if (rowIndex % 1000 == 0) {
				log.info("Processed {} records", rowIndex);
			}
		}
		storeCandlesForValor(dtos, stockValor);
	}

	public List<DateStockCandleCsvRecord> extract(BufferedReader reader) {
		return new CsvToBeanBuilder<DateStockCandleCsvRecord>(reader)
				       .withType(DateStockCandleCsvRecord.class)
				       .withSeparator(',')
				       .withSkipLines(1)  //skip first line = header
				       .build()
				       .parse();
	}

	public boolean isValid(DateStockCandleCsvRecord record, int rowIndex) {
		StringBuilder sb = new StringBuilder();
		if (record.getDate() == null) {
			sb.append("[").append(rowIndex).append("]");
			sb.append("{Invalid date=").append(record.getDate()).append("}");
		}
		if (record.getOpen() == null) {
			sb.append("[").append(rowIndex).append("]");
			sb.append("{Invalid open=").append(record.getOpen()).append("}");
		}
		if (record.getHigh() == null) {
			sb.append("[").append(rowIndex).append("]");
			sb.append("{Invalid high=").append(record.getHigh()).append("}");
		}
		if (record.getLow() == null) {
			sb.append("[").append(rowIndex).append("]");
			sb.append("{Invalid low=").append(record.getLow()).append("}");
		}
		if (record.getClose() == null) {
			sb.append("[").append(rowIndex).append("]");
			sb.append("{Invalid close=").append(record.getClose()).append("}");
		}
		return sb.length() == 0;
	}

	public boolean storeCandlesForValor(List<StockCandleDto> dtos, StockValor stockValor) {
		StooqDailyStockCandle candle, savedCandle;
		log.debug("Storing {} candles", dtos.size());
		for (StockCandleDto dto : dtos) {
			candle = DefaultMapper.INSTANCE.toDailyStockCandle(dto);
			candle.setValor(stockValor);
			savedCandle = dailyStockCandleRepository.save(candle);
			log.debug("Saved candle {}", savedCandle);
		}
		return true;
	}
}
