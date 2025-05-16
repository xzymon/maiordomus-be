package com.xzymon.maiordomus.mapper;

import com.xzymon.maiordomus.dto.CmcHistoryDto;
import com.xzymon.maiordomus.dto.DummyMessageDto;
import com.xzymon.maiordomus.dto.ProtoHistoryDto;
import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.mapper.daytime.DailyDayTimeMapper;
import com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper;
import com.xzymon.maiordomus.model.csv.CmcHistoryCsvRecord;
import com.xzymon.maiordomus.model.db.*;
import liquibase.logging.mdc.customobjects.History;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DefaultMapper {
	DefaultMapper INSTANCE = Mappers.getMapper(DefaultMapper.class);

	@Mapping(target = "id", source = "id")
	@Mapping(target = "message", source = "message")
	DummyMessageDto toDummyMessageDto(DummyMessage message);

	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.dateToDayString(stockCandle.getDay()))")
	@Mapping(target = "periodStart", expression = "java(com.xzymon.maiordomus.mapper.daytime.DailyDayTimeMapper.getInstance().getNumberToPeriodStartTimeMap().get(stockCandle.getCandleNo().toString()))")
	@Mapping(target = "periodEnd", expression = "java(com.xzymon.maiordomus.mapper.daytime.DailyDayTimeMapper.getInstance().getNumberToPeriodEndTimeMap().get(stockCandle.getCandleNo().toString()))")
	@Mapping(target = "candleNo", source = "candleNo")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	StockCandleDto toStockCandleDto(StooqDailyStockCandle stockCandle);

	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.dateToDayString(stockCandle.getDay()))")
	@Mapping(target = "periodStart", expression = "java(com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper.getInstance().getNumberToPeriodStartTimeMap().get(stockCandle.getCandleNo()))")
	@Mapping(target = "periodEnd", expression = "java(com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper.getInstance().getNumberToPeriodEndTimeMap().get(stockCandle.getCandleNo()))")
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
	@Mapping(target = "valor", ignore = true)
	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.dayStringToDate(stockCandleDto.getDay()))")
	@Mapping(target = "candleNo", expression = "java(com.xzymon.maiordomus.mapper.daytime.DailyDayTimeMapper.getInstance().getPeriodEndTimeToNumberMap().get(stockCandleDto.getPeriodEnd()))")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	StooqDailyStockCandle toDailyStockCandle(StockCandleDto stockCandleDto);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "valor", ignore = true)
	@Mapping(target = "day", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.dayStringToDate(stockCandleDto.getDay()))")
	@Mapping(target = "candleNo", expression = "java(com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper.getInstance().getPeriodEndTimeToNumberMap().get(stockCandleDto.getPeriodEnd()))")
	@Mapping(target = "open", source = "open")
	@Mapping(target = "close", source = "close")
	@Mapping(target = "high", source = "high")
	@Mapping(target = "low", source = "low")
	StooqQuarterStockCandle toQuarterStockCandle(StockCandleDto stockCandleDto);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "orderTimestamp", source = "orderTimestamp")
	@Mapping(target = "orderType", source = "orderType")
	@Mapping(target = "orderNo", source = "orderNo")
	@Mapping(target = "transaction", source = "transaction")
	@Mapping(target = "relatedOrder", source = "relatedOrder")
	@Mapping(target = "instrument", source = "instrument")
	@Mapping(target = "volume", source = "volume")
	@Mapping(target = "price", source = "price")
	@Mapping(target = "priceTolerance", source = "priceTolerance")
	@Mapping(target = "stopLoss", source = "stopLoss")
	@Mapping(target = "takeProfit", source = "takeProfit")
	@Mapping(target = "securityDepositPln", source = "securityDepositPln")
	@Mapping(target = "exchangeRate", source = "exchangeRate")
	@Mapping(target = "orderValuePln", source = "orderValuePln")
	@Mapping(target = "postedValuePln", source = "postedValuePln")
	@Mapping(target = "balancePln", source = "balancePln")
	@Mapping(target = "valueWithoutCommission", source = "valueWithoutCommission")
	@Mapping(target = "commission", source = "commission")
	@Mapping(target = "maintenanceChargeValue", source = "maintenanceChargeValue")
	@Mapping(target = "dailyMaintenanceChargeRate", source = "dailyMaintenanceChargeRate")
	@Mapping(target = "maintenanceChargePln", source = "maintenanceChargePln")
	@Mapping(target = "maintenanceChargeSumPln", source = "maintenanceChargeSumPln")
	@Mapping(target = "charge2", source = "charge2")
	@Mapping(target = "revenueInPercents", source = "revenueInPercents")
	@Mapping(target = "direction", source = "direction")
	@Mapping(target = "profitPayoff", source = "profitPayoff")
	@Mapping(target = "neutralPayoff", source = "neutralPayoff")
	@Mapping(target = "opening", source = "opening")
	@Mapping(target = "expiration", source = "expiration")
	@Mapping(target = "clearance1", source = "clearance1")
	@Mapping(target = "clearance1Price", source = "clearance1Price")
	@Mapping(target = "outcome", source = "outcome")
	@Mapping(target = "payoff", source = "payoff")
	@Mapping(target = "type", source = "type")
	@Mapping(target = "expiration2", source = "expiration2")
	@Mapping(target = "executionPrice", source = "executionPrice")
	@Mapping(target = "clearance2", source = "clearance2")
	@Mapping(target = "clearance2Price", source = "clearance2Price")
	@Mapping(target = "profit", source = "profit")
	@Mapping(target = "loss", source = "loss")
	ProtoHistory toProtoHistory(ProtoHistoryDto dto);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "orderTimestamp", source = "orderTimestamp")
	@Mapping(target = "orderType", source = "orderType")
	@Mapping(target = "orderNo", source = "orderNo")
	@Mapping(target = "transaction", source = "transaction")
	@Mapping(target = "relatedOrder", source = "relatedOrder")
	@Mapping(target = "instrument", ignore = true) // do ustawiania w serwisie, nie w mapperze
	@Mapping(target = "volume", source = "volume")
	@Mapping(target = "price", source = "price")
	@Mapping(target = "priceTolerance", source = "priceTolerance")
	@Mapping(target = "stopLoss", source = "stopLoss")
	@Mapping(target = "takeProfit", source = "takeProfit")
	@Mapping(target = "securityDepositPln", source = "securityDepositPln")
	@Mapping(target = "exchangeRate", source = "exchangeRate")
	@Mapping(target = "orderValuePln", source = "orderValuePln")
	@Mapping(target = "postedValuePln", source = "postedValuePln")
	@Mapping(target = "balancePln", source = "balancePln")
	@Mapping(target = "valueWithoutCommission", source = "valueWithoutCommission")
	@Mapping(target = "commission", source = "commission")
	@Mapping(target = "maintenanceChargeValue", source = "maintenanceChargeValue")
	@Mapping(target = "dailyMaintenanceChargeRate", source = "dailyMaintenanceChargeRate")
	@Mapping(target = "maintenanceChargePln", source = "maintenanceChargePln")
	@Mapping(target = "maintenanceChargeSumPln", source = "maintenanceChargeSumPln")
	@Mapping(target = "charge2", source = "charge2")
	@Mapping(target = "revenueInPercents", source = "revenueInPercents")

		//@Mapping(target = "direction", source = "direction")
		//@Mapping(target = "profitPayoff", source = "profitPayoff")
		//@Mapping(target = "neutralPayoff", source = "neutralPayoff")
		//@Mapping(target = "opening", source = "opening")
		//@Mapping(target = "expiration", source = "expiration")
		//@Mapping(target = "clearance1", source = "clearance1")
		//@Mapping(target = "clearance1Price", source = "clearance1Price")
		//@Mapping(target = "outcome", source = "outcome")
		//@Mapping(target = "payoff", source = "payoff")
		//@Mapping(target = "type", source = "type")
		//@Mapping(target = "expiration2", source = "expiration2")
		//@Mapping(target = "executionPrice", source = "executionPrice")
		//@Mapping(target = "clearance2", source = "clearance2")
		//@Mapping(target = "clearance2Price", source = "clearance2Price")
		//@Mapping(target = "profit", source = "profit")
		//@Mapping(target = "loss", source = "loss")
	CmcHistory toCmcHistory(CmcHistoryDto dto);

	// Kolekcje
	List<StockCandleDto> dailyListToStockCandleDtoList(List<StooqDailyStockCandle> stockCandleList);
	List<StockCandleDto> quarterListToStockCandleDtoList(List<StooqQuarterStockCandle> stockCandleList);
}
