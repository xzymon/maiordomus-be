package com.xzymon.maiordomus.api.v1.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BetDTO {
	private Long id;
	private String instrument;
	private LocalDateTime enterTime;
	private LocalDateTime exitTime;
	private BigDecimal noOfUnits;
	private BigDecimal valueOnEnter;
	private BigDecimal valueOnExit;
}
