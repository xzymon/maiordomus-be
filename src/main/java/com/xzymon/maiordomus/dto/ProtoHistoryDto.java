package com.xzymon.maiordomus.dto;

import lombok.Data;

@Data
public class ProtoHistoryDto {
	private String orderTimestamp;
	private String orderType;
	private String orderNo;
	private String transaction;
	private String relatedOrder;
	private String instrument;
	private String volume;
	private String price;
	private String priceTolerance;
	private String stopLoss;
	private String takeProfit;
	private String securityDepositPln;
	private String exchangeRate;
	private String orderValuePln;
	private String postedValuePln;
	private String balancePln;
	private String valueWithoutCommission;
	private String commission;
	private String maintenanceChargeValue;
	private String dailyMaintenanceChargeRate;
	private String maintenanceChargePln;
	private String maintenanceChargeSumPln;
	private String charge2;
	private String revenueInPercents;
	private String direction;
	private String profitPayoff;
	private String neutralPayoff;
	private String opening;
	private String expiration;
	private String clearance1;
	private String clearance1Price;
	private String outcome;
	private String payoff;
	private String type;
	private String expiration2;
	private String executionPrice;
	private String clearance2;
	private String clearance2Price;
	private String profit;
	private String loss;
}
