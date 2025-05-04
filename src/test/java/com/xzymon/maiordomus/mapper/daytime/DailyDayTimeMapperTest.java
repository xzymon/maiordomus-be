package com.xzymon.maiordomus.mapper.daytime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DailyDayTimeMapperTest {

	DailyDayTimeMapper mapper;

	@BeforeEach
	void setUp() {
		mapper = new DailyDayTimeMapper();
	}

	@Test
	void zero() {
		assertEquals("24:00:00", DailyDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(0));
		assertEquals("00:00:01", DailyDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(0));
	}

	@Test
	void periodsCount() {
		assertEquals(1, mapper.getPeriodsInDayCount());
	}
}