package com.xzymon.maiordomus.mapper.util;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@Slf4j
public class IntegerDateTime {
	int year;
	int month;
	int day;
	int hour;
	int minute;
	int second;

	public static final Map<String, Integer> MONTH_TO_INT_MAP = new HashMap<>() {{
		put("Sty", 1);
		put("Luty", 2);
		put("Mar", 3);
		put("Kw", 4);
		put("Maj", 5);
		put("Cze", 6);
		put("Lip", 7);
		put("Sie", 8);
		put("Wrz", 9);
		put("Paź", 10);
		put("List", 11);
		put("Gru", 12);
	}};

	public static final Map<Integer, String> INT_TO_MONTH_MAP = new HashMap<>() {{
		put(1, "Sty");
		put(2, "Luty");
		put(3, "Mar");
		put(4, "Kw");
		put(5, "Maj");
		put(6, "Cze");
		put(7, "Lip");
		put(8, "Sie");
		put(9, "Wrz");
		put(10, "Paź");
		put(11, "List");
		put(12, "Gru");
	}};

	public static IntegerDateTime getInstance(String sourceDateString) {
		log.debug("IntegerDateTime sourceDateString: {}", sourceDateString);
		String[] dateParts = getDateParts(sourceDateString);
		String[] timeParts = dateParts[3].split(":");
		if (timeParts.length != 3) {
			throw new IllegalArgumentException("Extraction Exception: Invalid date format: sourceDateString has invalid number of time parts: " + sourceDateString);
		}
		IntegerDateTime result = IntegerDateTime.builder()
				                         .year(Integer.parseInt(dateParts[2]))
				                         .month(MONTH_TO_INT_MAP.get(dateParts[1]))
				                         .day(Integer.parseInt(dateParts[0]))
				                         .hour(Integer.parseInt(timeParts[0]))
				                         .minute(Integer.parseInt(timeParts[1]))
				                         .second(Integer.parseInt(timeParts[2]))
				                         .build();
		log.debug("IntegerDateTime created: {}", result);
		return result;
	}

	private static String[] getDateParts(String sourceDateString) {
		if (sourceDateString == null) {
			throw new NullPointerException("Extraction Exception: Source string is null");
		}
		String trimmed = sourceDateString.trim();
		if (trimmed.length() < 18) {
			throw new IllegalArgumentException("Extraction Exception: Invalid date format: sourceDateString after trimming is to short: " + sourceDateString);
		}
		if (trimmed.length() > 21) {
			throw new IllegalArgumentException("Extraction Exception: Invalid date format: sourceDateString after trimming is to long: " + sourceDateString);
		}
		String[] dateParts = trimmed.split(" ");
		if (dateParts.length != 4) {
			throw new IllegalArgumentException("Extraction Exception: Invalid date format: sourceDateString has invalid number of parts: " + sourceDateString);
		}
		return dateParts;
	}
}
