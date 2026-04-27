package com.xzymon.maiordomus.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stock_valor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockValor {

	@Id
	@GeneratedValue(generator = "stock_valor_seq", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;

	@Column(name = "cmc_name")
	private String cmcName;
}
