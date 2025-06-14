package com.xzymon.maiordomus.mapper.daytime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HalfMinuteDayTimeMapperTest {

	HalfMinuteDayTimeMapper mapper = HalfMinuteDayTimeMapper.getInstance();

	@Test
	void zero() {
		assertEquals("00:00:30", mapper.getNumberToPeriodEndTimeMap().get(0));
		assertEquals("00:00:01", mapper.getNumberToPeriodStartTimeMap().get(0));
	}

	@Test
	void first() {
		assertEquals("00:01:00", mapper.getNumberToPeriodEndTimeMap().get(1));
		assertEquals("00:00:31", mapper.getNumberToPeriodStartTimeMap().get(1));
	}

	@Test
	void fiftyNineth() {
		assertEquals("00:30:00", mapper.getNumberToPeriodEndTimeMap().get(59));
		assertEquals("00:29:31", mapper.getNumberToPeriodStartTimeMap().get(59));
	}

	@Test
	void halfway() {
		assertEquals("12:00:00", mapper.getNumberToPeriodEndTimeMap().get(1439));
		assertEquals("11:59:31", mapper.getNumberToPeriodStartTimeMap().get(1439));
	}

	@Test
	void beforeLast() {
		assertEquals("23:59:30", mapper.getNumberToPeriodEndTimeMap().get(2878));
		assertEquals("23:59:01", mapper.getNumberToPeriodStartTimeMap().get(2878));
	}

	@Test
	void last() {
		assertEquals("00:00:00", mapper.getNumberToPeriodEndTimeMap().get(2879));
		assertEquals("23:59:31", mapper.getNumberToPeriodStartTimeMap().get(2879));
	}

	@Test
	void periodsCount() {
		assertEquals(2880, mapper.getPeriodsInDayCount());
	}
}