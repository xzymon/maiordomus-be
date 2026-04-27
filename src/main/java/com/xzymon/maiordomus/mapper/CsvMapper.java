package com.xzymon.maiordomus.mapper;

import com.xzymon.maiordomus.dto.CmcHistoryDto;
import com.xzymon.maiordomus.dto.ProtoHistoryDto;
import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.mapper.daytime.DailyDayTimeMapper;
import com.xzymon.maiordomus.model.csv.CmcHistoryCsvRecord;
import com.xzymon.maiordomus.model.csv.DateStockCandleCsvRecord;
import com.xzymon.maiordomus.model.csv.DateTimeStockCandleCsvRecord;
import com.xzymon.maiordomus.model.csv.DateVolumeStockCandleCsvRecord;
import com.xzymon.maiordomus.model.db.CmcHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CsvMapper {
	CsvMapper INSTANCE = Mappers.getMapper(CsvMapper.class);
	DailyDayTimeMapper DAILY_DAY_TIME_MAPPER = DailyDayTimeMapper.getInstance();

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

	@Mapping(target = "day", source = "date")
	@Mapping(target = "periodEnd", expression = "java(DAILY_DAY_TIME_MAPPER.getOnlyPeriod().getEndTime())")
	@Mapping(target = "open", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.stringToBigDecimal(csvRecord.getOpen()))")
	@Mapping(target = "close", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.stringToBigDecimal(csvRecord.getClose()))")
	@Mapping(target = "high", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.stringToBigDecimal(csvRecord.getHigh()))")
	@Mapping(target = "low", expression = "java(com.xzymon.maiordomus.utils.MapperHelper.stringToBigDecimal(csvRecord.getLow()))")
	StockCandleDto toStockCandleDto(DateVolumeStockCandleCsvRecord csvRecord);

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
	ProtoHistoryDto toProtoHistoryDto(CmcHistoryCsvRecord csvRecord);

	@Mapping(target = "orderTimestamp", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getDateTime(csvRecord.getOrderTimestamp()))")
	@Mapping(target = "orderType", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getOrderType(csvRecord.getOrderType()))")
	@Mapping(target = "orderNo", source = "orderNo")
	@Mapping(target = "transaction", source = "transaction")
	@Mapping(target = "relatedOrder", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.convertDashToNull(csvRecord.getRelatedOrder()))")
	@Mapping(target = "instrument", source = "instrument")
	@Mapping(target = "volume", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getVolume(csvRecord.getVolume()))")
	@Mapping(target = "price", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getPrice()))")
	@Mapping(target = "priceTolerance", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getPriceTolerance()))")
	@Mapping(target = "stopLoss", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getStopLoss()))")
	@Mapping(target = "takeProfit", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getTakeProfit()))")
	@Mapping(target = "securityDepositPln", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getSecurityDepositPln()))")
	@Mapping(target = "exchangeRate", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getExchangeRate()))")
	@Mapping(target = "orderValuePln", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getOrderValuePln()))")
	@Mapping(target = "postedValuePln", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getPostedValuePln()))")
	@Mapping(target = "balancePln", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getBalancePln()))")
	@Mapping(target = "valueWithoutCommission", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getValueWithoutCommission()))")
	@Mapping(target = "commission", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getCommission()))")
	@Mapping(target = "maintenanceChargeValue", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getMaintenanceChargeValue()))")
	@Mapping(target = "dailyMaintenanceChargeRate", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimalEliminatingPercent(csvRecord.getDailyMaintenanceChargeRate()))")
	@Mapping(target = "maintenanceChargePln", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getMaintenanceChargePln()))")
	@Mapping(target = "maintenanceChargeSumPln", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getMaintenanceChargeSumPln()))")
	@Mapping(target = "charge2", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimal(csvRecord.getCharge2()))")
	@Mapping(target = "revenueInPercents", expression = "java(com.xzymon.maiordomus.mapper.CmcHistoryMapper.getBigDecimalEliminatingPercent(csvRecord.getMaintenanceChargeValue()))")

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
	CmcHistoryDto toCmcHistoryDto(CmcHistoryCsvRecord csvRecord);
}
