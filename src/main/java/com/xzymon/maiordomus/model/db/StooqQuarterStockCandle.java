package com.xzymon.maiordomus.model.db;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "stock_candle_stq15m",
	   uniqueConstraints = @UniqueConstraint(columnNames = {"valor_id", "candle_day", "candle_no"})
)
@Data
@NoArgsConstructor
public class StooqQuarterStockCandle extends StockCandle {

	public StooqQuarterStockCandle(StockValor valor,
	                               LocalDate day,
	                               Integer candleNo,
	                               BigDecimal open,
	                               BigDecimal high,
	                               BigDecimal low,
	                               BigDecimal close) {
		super.setValor(valor);
		super.setDay(day);
		super.setCandleNo(candleNo);
		super.setOpen(open);
		super.setHigh(high);
		super.setLow(low);
		super.setClose(close);
	}

	public StooqQuarterStockCandle(StockValor valor,
	                               LocalDate day,
	                               String candleNoString,
	                               String openString,
	                               String highString,
	                               String lowString,
	                               String closeString) {
		super.setValor(valor);
		super.setDay(day);
		super.setCandleNo(Integer.parseInt(candleNoString));
		super.setOpen(new BigDecimal(openString));
		super.setHigh(new BigDecimal(highString));
		super.setLow(new BigDecimal(lowString));
		super.setClose(new BigDecimal(closeString));
	}


}
