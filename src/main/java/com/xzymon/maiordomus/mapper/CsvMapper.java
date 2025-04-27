package com.xzymon.maiordomus.mapper;

import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.mapper.daytime.DailyDayTimeMapper;
import com.xzymon.maiordomus.model.csv.DateStockCandleCsvRecord;
import com.xzymon.maiordomus.model.csv.DateTimeStockCandleCsvRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CsvMapper {
	CsvMapper INSTANCE = Mappers.getMapper(CsvMapper.class);
	DailyDayTimeMapper DAILY_DAY_TIME_MAPPER = new DailyDayTimeMapper();

	@Mapping(target = "day", source = "date")
	@Mapping(target = "periodEnd", source = "time")
	@Mapping(target = "open", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.stringToBigDecimal(csvRecord.getOpen()))")
	@Mapping(target = "close", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.stringToBigDecimal(csvRecord.getClose()))")
	@Mapping(target = "high", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.stringToBigDecimal(csvRecord.getHigh()))")
	@Mapping(target = "low", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.stringToBigDecimal(csvRecord.getLow()))")
	StockCandleDto toStockCandleDto(DateTimeStockCandleCsvRecord csvRecord);

	@Mapping(target = "day", source = "date")
	@Mapping(target = "periodEnd", expression = "java(DAILY_DAY_TIME_MAPPER.getOnlyPeriod().getEndTime())")
	@Mapping(target = "open", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.stringToBigDecimal(csvRecord.getOpen()))")
	@Mapping(target = "close", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.stringToBigDecimal(csvRecord.getClose()))")
	@Mapping(target = "high", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.stringToBigDecimal(csvRecord.getHigh()))")
	@Mapping(target = "low", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.stringToBigDecimal(csvRecord.getLow()))")
	StockCandleDto toStockCandleDto(DateStockCandleCsvRecord csvRecord);
}
