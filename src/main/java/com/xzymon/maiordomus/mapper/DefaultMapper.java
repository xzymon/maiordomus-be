package com.xzymon.maiordomus.mapper;

import com.xzymon.maiordomus.dto.DummyMessageDto;
import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.mapper.daytime.DailyDayTimeMapper;
import com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper;
import com.xzymon.maiordomus.model.db.DummyMessage;
import com.xzymon.maiordomus.model.db.StooqDailyStockCandle;
import com.xzymon.maiordomus.model.db.StooqQuarterStockCandle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DefaultMapper {
	DefaultMapper INSTANCE = Mappers.getMapper(DefaultMapper.class);
	QuarterDayTimeMapper QUARTER_DAY_TIME_MAPPER = new QuarterDayTimeMapper();
	DailyDayTimeMapper DAILY_DAY_TIME_MAPPER = new DailyDayTimeMapper();

	@Mapping(target = "id", source = "id")
	@Mapping(target = "message", source = "message")
	DummyMessageDto toDummyMessageDto(DummyMessage message);

	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.dateToDayString(stockCandle.getDay()))")
	@Mapping(target = "periodEnd", expression = "java(com.xzymon.maiordomus.mapper.daytime.DailyDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(stockCandle.getCandleNo().toString()))")
	@Mapping(target = "candleNo", source = "candleNo")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	StockCandleDto toStockCandleDto(StooqDailyStockCandle stockCandle);

	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.dateToDayString(stockCandle.getDay()))")
	@Mapping(target = "periodEnd", expression = "java(com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(stockCandle.getCandleNo().toString()))")
	@Mapping(target = "candleNo", source = "candleNo")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	StockCandleDto toStockCandleDto(StooqQuarterStockCandle stockCandle);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "message", source = "message")
	DummyMessage toDummyMessage(DummyMessageDto message);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.dayStringToDate(stockCandleDto.getDay()))")
	@Mapping(target = "candleNo", expression = "java(DAILY_DAY_TIME_MAPPER.PERIOD_END_TIME_TO_NUMBER.get(stockCandleDto.getPeriodEnd()))")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	StooqDailyStockCandle toDailyStockCandle(StockCandleDto stockCandleDto);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.dayStringToDate(stockCandleDto.getDay()))")
	@Mapping(target = "candleNo", expression = "java(QUARTER_DAY_TIME_MAPPER.PERIOD_END_TIME_TO_NUMBER.get(stockCandleDto.getPeriodEnd()))")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	StooqQuarterStockCandle toQuarterStockCandle(StockCandleDto stockCandleDto);


}
