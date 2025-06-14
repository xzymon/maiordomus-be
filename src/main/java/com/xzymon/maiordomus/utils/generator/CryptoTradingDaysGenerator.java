package com.xzymon.maiordomus.utils.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class CryptoTradingDaysGenerator implements TradingDaysGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(CryptoTradingDaysGenerator.class);

	private static CryptoTradingDaysGenerator INSTANCE;

	private final Map<Integer, Integer> daysInMonth = new LinkedHashMap<>();

	private final List<LocalDate> excludedDays = new ArrayList<>();
	private final List<String> allDays = new ArrayList<>();
	private final List<String> tradeDays = new ArrayList<>();

	private CryptoTradingDaysGenerator() {
		daysInMonth.put(1, 31);
		daysInMonth.put(2, 29);
		daysInMonth.put(3, 31);
		daysInMonth.put(4, 30);
		daysInMonth.put(5, 31);
		daysInMonth.put(6, 30);
		daysInMonth.put(7, 31);
		daysInMonth.put(8, 31);
		daysInMonth.put(9, 30);
		daysInMonth.put(10, 31);
		daysInMonth.put(11, 30);
		daysInMonth.put(12, 31);

		excludedDays.add(LocalDate.of(2024, 1, 1));
		excludedDays.add(LocalDate.of(2025, 1, 1));

		initForLocalDate(LocalDate.of(2023, 12, 31));
		initForYear(2024);
		initForYear(2025);

		tradeDays.addAll(allDays);
		tradeDays.removeAll(excludedDays);
		Collections.sort(tradeDays);
	}

	private void initForLocalDate(LocalDate localDate) {
		String formattedExaminedDate = localDate.format(FORMATTER);
		allDays.add(formattedExaminedDate);
	}

	private void initForYear(Integer year) {
		boolean isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		LocalDate examinedDate;
		String formattedExaminedDate;
		Integer dayOfMonth;
		for (Map.Entry<Integer, Integer> monthDays : daysInMonth.entrySet()) {
			dayOfMonth = 1;
			while (dayOfMonth <= monthDays.getValue()) {
				try {
					examinedDate = LocalDate.of(year, monthDays.getKey(), dayOfMonth);
					formattedExaminedDate = examinedDate.format(FORMATTER);
					allDays.add(formattedExaminedDate);
					dayOfMonth++;
				} catch (DateTimeException dte) {
					if ( !isLeapYear && monthDays.getKey() == 2 && dayOfMonth == 29) {
						dayOfMonth++;
						continue;
					}
					LOGGER.error("For examined date: {}-{}-{}", year, monthDays.getKey(), dayOfMonth, dte);
					break;
				}
			}
		}
	}

	@Override
	public List<String> generate() {
		return new ArrayList<>(tradeDays); // Return a defensive copy
	}

	public static synchronized CryptoTradingDaysGenerator getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CryptoTradingDaysGenerator();
		}
		return INSTANCE;
	}
}
