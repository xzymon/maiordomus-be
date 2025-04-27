package com.xzymon.maiordomus.mapper.daytime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HalfMinuteDayTimeMapperTest {

	HalfMinuteDayTimeMapper mapper;

	@BeforeEach
	void setUp() {
		mapper = new HalfMinuteDayTimeMapper();
	}

	@Test
	void zero() {
		assertEquals("00:00:30", HalfMinuteDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(0));
		assertEquals("00:00:01", HalfMinuteDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(0));
	}

	@Test
	void first() {
		assertEquals("00:01:00", HalfMinuteDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(1));
		assertEquals("00:00:31", HalfMinuteDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(1));
	}

	@Test
	void fiftyNineth() {
		assertEquals("00:30:00", HalfMinuteDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(59));
		assertEquals("00:29:31", HalfMinuteDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(59));
	}

	@Test
	void halfway() {
		assertEquals("12:00:00", HalfMinuteDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(1439));
		assertEquals("11:59:31", HalfMinuteDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(1439));
	}

	@Test
	void beforeLast() {
		assertEquals("23:59:30", HalfMinuteDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(2878));
		assertEquals("23:59:01", HalfMinuteDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(2878));
	}

	@Test
	void last() {
		assertEquals("00:00:00", HalfMinuteDayTimeMapper.NUMBER_TO_PERIOD_END_TIME.get(2879));
		assertEquals("23:59:31", HalfMinuteDayTimeMapper.NUMBER_TO_PERIOD_START_TIME.get(2879));
	}

	@Test
	void periodsCount() {
		assertEquals(2880, mapper.getPeriodsInDayCount());
	}
}