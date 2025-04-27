package com.xzymon.maiordomus.model.db;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.math.BigDecimal;

@Data
@MappedSuperclass
public abstract class StockCandle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_candle_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "valor_id")
	private StockValor valor;

	private Date day;

	@Column(name = "candle_no")
	private Integer candleNo;

	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
}