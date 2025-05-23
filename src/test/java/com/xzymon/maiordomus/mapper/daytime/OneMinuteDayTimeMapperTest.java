package com.xzymon.maiordomus.mapper.daytime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OneMinuteDayTimeMapperTest {

	OneMinuteDayTimeMapper mapper;

	@BeforeEach
	void setUp() {
		mapper = new OneMinuteDayTimeMapper();
	}

	@Test
	void zero() {
		assertEquals("00:01:00", OneMinuteDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(0));
		assertEquals("00:00:01", OneMinuteDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(0));
	}

	@Test
	void first() {
		assertEquals("00:02:00", OneMinuteDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(1));
		assertEquals("00:01:01", OneMinuteDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(1));
	}

	@Test
	void sixtieth() {
		assertEquals("01:01:00", OneMinuteDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(60));
		assertEquals("01:00:01", OneMinuteDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(60));
	}

	@Test
	void halfway() {
		assertEquals("12:00:00", OneMinuteDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(719));
		assertEquals("11:59:01", OneMinuteDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(719));
	}

	@Test
	void beforeLast() {
		assertEquals("23:59:00", OneMinuteDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(1438));
		assertEquals("23:58:01", OneMinuteDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(1438));
	}

	@Test
	void last() {
		assertEquals("00:00:00", OneMinuteDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(1439));
		assertEquals("23:59:01", OneMinuteDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(1439));
	}

	@Test
	void periodsCount() {
		assertEquals(1440, mapper.getPeriodsInDayCount());
	}
}