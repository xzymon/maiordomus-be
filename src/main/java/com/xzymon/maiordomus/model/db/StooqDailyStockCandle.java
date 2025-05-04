package com.xzymon.maiordomus.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "stock_candle_stq1d",
		uniqueConstraints = @UniqueConstraint(columnNames = {"valor_id", "day", "candle_no"})
)
@Data
@NoArgsConstructor
public class StooqDailyStockCandle extends StockCandle {

	public StooqDailyStockCandle(StockValor valor,
	                             Date day,
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

	public StooqDailyStockCandle(StockValor valor,
	                             Date day,
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
