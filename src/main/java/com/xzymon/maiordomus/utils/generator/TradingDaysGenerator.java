package com.xzymon.maiordomus.utils.generator;

import java.time.format.DateTimeFormatter;
import java.util.List;

public interface TradingDaysGenerator {
	DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	List<String> generate();
}