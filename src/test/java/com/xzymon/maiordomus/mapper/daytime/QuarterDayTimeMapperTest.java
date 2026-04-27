package com.xzymon.maiordomus.mapper.daytime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuarterDayTimeMapperTest {

	QuarterDayTimeMapper mapper = QuarterDayTimeMapper.getInstance();

	@Test
	void zero() {
		assertEquals("00:15:00", mapper.getNumberToPeriodEndTimeMap().get(0));
		assertEquals("00:00:01", mapper.getNumberToPeriodStartTimeMap().get(0));
	}

	@Test
	void first() {
		assertEquals("00:30:00", mapper.getNumberToPeriodEndTimeMap().get(1));
		assertEquals("00:15:01", mapper.getNumberToPeriodStartTimeMap().get(1));
	}

	@Test
	void third() {
		assertEquals("01:00:00", mapper.getNumberToPeriodEndTimeMap().get(3));
		assertEquals("00:45:01", mapper.getNumberToPeriodStartTimeMap().get(3));
	}

	@Test
	void seventh() {
		assertEquals("02:00:00", mapper.getNumberToPeriodEndTimeMap().get(7));
		assertEquals("01:45:01", mapper.getNumberToPeriodStartTimeMap().get(7));
	}

	@Test
	void halfway() {
		assertEquals("12:00:00", mapper.getNumberToPeriodEndTimeMap().get(47));
		assertEquals("11:45:01", mapper.getNumberToPeriodStartTimeMap().get(47));
	}

	@Test
	void fiftieth() {
		assertEquals("12:45:00", mapper.getNumberToPeriodEndTimeMap().get(50));
		assertEquals("12:30:01", mapper.getNumberToPeriodStartTimeMap().get(50));
	}

	@Test
	void beforeLast() {
		assertEquals("23:45:00", mapper.getNumberToPeriodEndTimeMap().get(94));
		assertEquals("23:30:01", mapper.getNumberToPeriodStartTimeMap().get(94));
	}

	@Test
	void last() {
		assertEquals("00:00:00", mapper.getNumberToPeriodEndTimeMap().get(95));
		assertEquals("23:45:01", mapper.getNumberToPeriodStartTimeMap().get(95));
	}

	@Test
	void periodsCount() {
		assertEquals(96, mapper.getPeriodsInDayCount());
	}
}