package com.xzymon.maiordomus.service.stock;

import com.opencsv.bean.CsvToBeanBuilder;
import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.mapper.CsvMapper;
import com.xzymon.maiordomus.mapper.DefaultMapper;
import com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper;
import com.xzymon.maiordomus.model.csv.DateTimeStockCandleCsvRecord;
import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.model.db.StooqQuarterStockCandle;
import com.xzymon.maiordomus.repository.QuarterStockCandleRepository;
import com.xzymon.maiordomus.scheduler.fileloading.FileType;
import com.xzymon.maiordomus.service.StockValorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class QuarterStockCsvUploadService extends AbstractStockCsvUploadService {

	private QuarterDayTimeMapper quarterDayTimeMapper;
	private QuarterStockCandleRepository quarterStockCandleRepository;

	public QuarterStockCsvUploadService(StockValorService stockValorService, QuarterStockCandleRepository quarterStockCandleRepository) {
		super(stockValorService);
		this.quarterStockCandleRepository = quarterStockCandleRepository;
		this.quarterDayTimeMapper = QuarterDayTimeMapper.getInstance();
	}

	@Override
	protected void extractAndSave(BufferedReader reader, FileType fileType, StockValor stockValor) {
		List<DateTimeStockCandleCsvRecord> records = extract(reader);
		int rowIndex = FIRST_ROW_WITH_DATA_ONE_BASED;
		StockCandleDto dto;
		DateTimeStockCandleCsvRecord enhancedCsvRecord = null;
		List<StockCandleDto> dtos = new ArrayList<>();
		for (DateTimeStockCandleCsvRecord record : records) {
			enhancedCsvRecord = enhanceBeforeValidation(record);
			if (isValid(enhancedCsvRecord, rowIndex)) {
				dto = convertToDto(enhancedCsvRecord, rowIndex, fileType);
				dtos.add(dto);
			} else {
				log.debug("Skipping invalid record at row {}", rowIndex);
				log.debug("Record: {}", enhancedCsvRecord);
			}
			rowIndex++;
		}
		storeCandlesForValor(dtos, stockValor);
	}

	public List<DateTimeStockCandleCsvRecord> extract(BufferedReader reader) {
		return new CsvToBeanBuilder<DateTimeStockCandleCsvRecord>(reader)
				       .withType(DateTimeStockCandleCsvRecord.class)
				       .withSeparator(',')
				       .withSkipLines(1)  //skip first line = header
				       .build()
				       .parse();
	}

	public boolean isValid(DateTimeStockCandleCsvRecord record, int rowIndex) {
		StringBuilder sb = new StringBuilder();
		if (record.getDate() == null) {
			sb.append("[").append(rowIndex).append("]");
			sb.append("{Invalid date=").append(record.getDate()).append("}");
		}
		if (quarterDayTimeMapper.getPeriodEndTimeToNumberMap().get(record.getTime()) == null) {
			sb.append("[").append(rowIndex).append("]");
			sb.append("{Invalid time=").append(record.getTime()).append("}");
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

	public DateTimeStockCandleCsvRecord enhanceBeforeValidation(DateTimeStockCandleCsvRecord record) {
		if (record != null && record.getTime().equals("23:59:00")) {
			record.setTime("24:00:00");
		}
		return record;
	}

	public StockCandleDto convertToDto(DateTimeStockCandleCsvRecord record, int rowIndex, FileType fileType) {
		StockCandleDto dto = CsvMapper.INSTANCE.toStockCandleDto(record);
		return dto;
	}

	public boolean storeCandlesForValor(List<StockCandleDto> dtos, StockValor stockValor) {
		log.debug("Storing {} candles", dtos.size());
		dtos.stream().forEach(dto -> {
			StooqQuarterStockCandle candle = DefaultMapper.INSTANCE.toQuarterStockCandle(dto);
			candle.setValor(stockValor);
			StooqQuarterStockCandle savedCandle = quarterStockCandleRepository.save(candle);
			log.debug("Saved candle {}", savedCandle);
		});
		return true;
	}
}
