package com.xzymon.maiordomus.dto.request;

import lombok.Data;

@Data
public class DayInQuarterCandlesRequest {
	private String symbol;
	private String dashSeparatedYYYYMMDD;
}
