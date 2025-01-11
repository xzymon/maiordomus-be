package com.xzymon.maiordomus.model.db;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("900") // 900s = 15m
@Table(name = "stock_candle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
public class QuarterStockCandle extends StockCandle {

	private String type = "900";

	public QuarterStockCandle(StockValor valor,
	                          Date day,
	                          Time periodEnd,
	                          BigDecimal open,
	                          BigDecimal high,
	                          BigDecimal low,
	                          BigDecimal close) {
		super.setValor(valor);
		super.setDay(day);
		super.setPeriodEnd(periodEnd);
		super.setOpen(open);
		super.setHigh(high);
		super.setLow(low);
		super.setClose(close);
	}

	public QuarterStockCandle(StockValor valor,
	                          Date day,
	                          String periodEndString,
	                          String openString,
	                          String highString,
	                          String lowString,
	                          String closeString) {
		super.setValor(valor);
		super.setDay(day);
		super.setPeriodEnd(Time.valueOf(periodEndString));
		super.setOpen(new BigDecimal(openString));
		super.setHigh(new BigDecimal(highString));
		super.setLow(new BigDecimal(lowString));
		super.setClose(new BigDecimal(closeString));
	}


}
