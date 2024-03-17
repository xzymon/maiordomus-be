package com.xzymon.maiordomus.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "BET")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Bet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "INSTRUMENT")
	private String instrument;

	@Column(name = "ENTER_TIME", columnDefinition = "DATETIME")
	private LocalDateTime enterTime;

	@Column(name = "EXIT_TIME", columnDefinition = "DATETIME")
	private LocalDateTime exitTime;

	@Column(name = "NO_OF_UNITS")
	private BigDecimal noOfUnits;

	@Column(name = "VALUE_ON_ENTER")
	private BigDecimal valueOnEnter;

	@Column(name = "VALUE_ON_EXIT")
	private BigDecimal valueOnExit;
}
