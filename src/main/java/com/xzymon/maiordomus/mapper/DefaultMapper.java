package com.xzymon.maiordomus.mapper;

import com.xzymon.maiordomus.dto.DummyMessageDTO;
import com.xzymon.maiordomus.dto.StockCandleDTO;
import com.xzymon.maiordomus.model.db.DummyMessage;
import com.xzymon.maiordomus.model.db.QuarterStockCandle;
import com.xzymon.maiordomus.model.db.StockCandle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DefaultMapper {
	DefaultMapper INSTANCE = Mappers.getMapper(DefaultMapper.class);

	@Mapping(target = "id", source = "id")
	@Mapping(target = "message", source = "message")
	DummyMessageDTO toDummyMessageDto(DummyMessage message);

	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.dateToDayString(stockCandle.getDay()))")
	@Mapping(target = "periodEnd", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.timeToTimeString(stockCandle.getPeriodEnd()))")
	@Mapping(target = "periodEndInDayNo", expression = "java(com.xzymon.maiordomus.mapper.QuarterDayTimeMapper.PERIOD_END_TO_NUMBER.get(stockCandle.getPeriodEnd().toString()))")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	StockCandleDTO toStockCandleDto(StockCandle stockCandle);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "message", source = "message")
	DummyMessage toDummyMessage(DummyMessageDTO message);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.dayStringToDate(stockCandleDTO.getDay()))")
	@Mapping(target = "periodEnd", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.timeStringToTime(stockCandleDTO.getPeriodEnd()))")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	QuarterStockCandle toQuarterStockCandle(StockCandleDTO stockCandleDTO);


}
