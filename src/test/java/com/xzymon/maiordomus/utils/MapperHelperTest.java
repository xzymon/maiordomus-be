package com.xzymon.maiordomus.utils;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class MapperHelperTest {

	@Test
	void dateToDayString() {
		LocalDate localDate = LocalDate.of(2020, Month.JANUARY, 2);
		Date date = Date.valueOf(localDate);
		String dayString = MapperHelper.dateToDayString(date);
		assertEquals("2020-01-02", dayString);
	}

	@Test
	void dayStringToDate() {
		Date result = MapperHelper.dayStringToDate("2020-01-02");
		LocalDate localDate = result.toLocalDate();
		assertEquals(2020, localDate.getYear());
		assertEquals(1, localDate.getMonthValue());
		assertEquals(2, localDate.getDayOfMonth());
	}

	@Test
	void timeToTimeString() {
		Time time = Time.valueOf("12:00:00");
		String result = MapperHelper.timeToTimeString(time);
		assertEquals("12:00:00", result);
	}

	@Test
	void timeStringToTime() {
		Time result = MapperHelper.timeStringToTime("12:00:00");
		assertEquals(12, result.getHours());
		assertEquals(0, result.getMinutes());
		assertEquals(0, result.getSeconds());
	}
}