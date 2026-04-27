package com.xzymon.maiordomus.mapper.daytime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DailyDayTimeMapperTest {

	DailyDayTimeMapper mapper = DailyDayTimeMapper.getInstance();

	@Test
	void zero() {
		assertEquals("24:00:00", mapper.getNumberToPeriodEndTimeMap().get(0));
		assertEquals("00:00:01", mapper.getNumberToPeriodStartTimeMap().get(0));
	}

	@Test
	void periodsCount() {
		assertEquals(1, mapper.getPeriodsInDayCount());
	}
}