package com.xzymon.maiordomus.dto;

import java.math.BigDecimal;

public class CreationHelper {

	public static StockCandleDto instanceOfStockCandleDto(String day, String periodStart, String periodEnd, Integer candleNo, double open, double high, double low, double close) {
		StockCandleDto result = new StockCandleDto();
		result.setDay(day);
		result.setPeriodStart(periodStart);
		result.setPeriodEnd(periodEnd);
		result.setCandleNo(candleNo);
		result.setOpen(BigDecimal.valueOf(open));
		result.setHigh(BigDecimal.valueOf(high));
		result.setLow(BigDecimal.valueOf(low));
		result.setClose(BigDecimal.valueOf(close));
		return result;
	}
}
