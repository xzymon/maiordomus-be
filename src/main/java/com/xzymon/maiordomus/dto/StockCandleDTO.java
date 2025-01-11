package com.xzymon.maiordomus.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockCandleDTO {
	private String day;
	private String periodEnd;
	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
}
