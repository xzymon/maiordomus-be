package com.xzymon.maiordomus.model.db;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@MappedSuperclass
public abstract class StockCandle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_candle_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "valor_id")
	private StockValor valor;

	@Column(name = "candle_day")
	private LocalDate day;

	@Column(name = "candle_no")
	private Integer candleNo;

	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
}