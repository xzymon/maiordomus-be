package com.xzymon.maiordomus.model.db;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.math.BigDecimal;

@Data
@MappedSuperclass
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class StockCandle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_candle_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "valor_id")
	private StockValor valor;

	private Date day;

	@Column(name = "period_end")
	private Time periodEnd;

	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
}