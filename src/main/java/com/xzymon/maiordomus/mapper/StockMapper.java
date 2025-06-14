package com.xzymon.maiordomus.mapper;

import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.model.db.StooqDailyStockCandle;
import com.xzymon.maiordomus.model.db.StooqQuarterStockCandle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StockMapper {
	StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.localDateToDayString(stockCandle.getDay()))")
	@Mapping(target = "periodStart", expression = "java(com.xzymon.maiordomus.mapper.daytime.DailyDayTimeMapper.getInstance().getNumberToPeriodStartTimeMap().get(stockCandle.getCandleNo().toString()))")
	@Mapping(target = "periodEnd", expression = "java(com.xzymon.maiordomus.mapper.daytime.DailyDayTimeMapper.getInstance().getNumberToPeriodEndTimeMap().get(stockCandle.getCandleNo().toString()))")
	@Mapping(target = "candleNo", source = "candleNo")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	StockCandleDto toStockCandleDto(StooqDailyStockCandle stockCandle);

	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.localDateToDayString(stockCandle.getDay()))")
	@Mapping(target = "periodStart", expression = "java(com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper.getInstance().getNumberToPeriodStartTimeMap().get(stockCandle.getCandleNo()))")
	@Mapping(target = "periodEnd", expression = "java(com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper.getInstance().getNumberToPeriodEndTimeMap().get(stockCandle.getCandleNo()))")
	@Mapping(target = "candleNo", source = "candleNo")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	StockCandleDto toStockCandleDto(StooqQuarterStockCandle stockCandle);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "valor", ignore = true)
	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.dayStringToLocalDate(stockCandleDto.getDay()))")
	@Mapping(target = "candleNo", expression = "java(com.xzymon.maiordomus.mapper.daytime.DailyDayTimeMapper.getInstance().getPeriodEndTimeToNumberMap().get(stockCandleDto.getPeriodEnd()))")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	StooqDailyStockCandle toDailyStockCandle(StockCandleDto stockCandleDto);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "valor", ignore = true)
	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.dayStringToLocalDate(stockCandleDto.getDay()))")
	@Mapping(target = "candleNo", expression = "java(com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper.getInstance().getPeriodEndTimeToNumberMap().get(stockCandleDto.getPeriodEnd()))")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	StooqQuarterStockCandle toQuarterStockCandle(StockCandleDto stockCandleDto);

	// Kolekcje
	List<StockCandleDto> dailyListToStockCandleDtoList(List<StooqDailyStockCandle> stockCandleList);
	List<StockCandleDto> quarterListToStockCandleDtoList(List<StooqQuarterStockCandle> stockCandleList);
}
