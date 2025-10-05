package com.xzymon.maiordomus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockCandleDto {
	private String day;
	private String periodStart;
	private String periodEnd;
	private Integer candleNo;
	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
}
