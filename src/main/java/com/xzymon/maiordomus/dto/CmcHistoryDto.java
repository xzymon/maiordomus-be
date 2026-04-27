package com.xzymon.maiordomus.dto;

import com.xzymon.maiordomus.model.db.CmcOrderType;
import com.xzymon.maiordomus.model.db.StockValor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CmcHistoryDto {
	private LocalDateTime orderTimestamp;
	private CmcOrderType orderType;
	private String orderNo;
	private String transaction;
	private String relatedOrder;
	private String instrument;
	private BigDecimal volume;
	private BigDecimal price;
	private BigDecimal priceTolerance;
	private BigDecimal stopLoss;
	private BigDecimal takeProfit;
	private BigDecimal securityDepositPln;
	private BigDecimal exchangeRate;
	private BigDecimal orderValuePln;
	private BigDecimal postedValuePln;
	private BigDecimal balancePln;
	private BigDecimal valueWithoutCommission;
	private BigDecimal commission;
	private BigDecimal maintenanceChargeValue;
	private BigDecimal dailyMaintenanceChargeRate;
	private BigDecimal maintenanceChargePln;
	private BigDecimal maintenanceChargeSumPln;
	private BigDecimal charge2;
	private BigDecimal revenueInPercents;
}
