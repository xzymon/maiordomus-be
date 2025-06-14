package com.xzymon.maiordomus.mapper.daytime;

import com.xzymon.maiordomus.mapper.Period;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class OneMinuteDayTimeMapper extends AbstractDayTimeMapper {
	private static final OneMinuteDayTimeMapper INSTANCE = new OneMinuteDayTimeMapper();

	@Getter
	@Setter
	private Period[] periods;

	@Getter
	@Setter
	private Map<Integer, String> numberToPeriodEndTimeMap;
	@Getter
	@Setter
	private Map<String, Integer> periodEndTimeToNumberMap;
	@Getter
	@Setter
	private Map<Integer, String> numberToPeriodStartTimeMap;
	@Getter
	@Setter
	private Map<String, Integer> periodStartTimeToNumberMap;

	@Getter
	private final int intervalHours = 0;
	@Getter
	private final int intervalMinutes = 1;
	@Getter
	private final int intervalSeconds = 0;

	private OneMinuteDayTimeMapper() {
		super();
	}

	public static OneMinuteDayTimeMapper getInstance() {
		return INSTANCE;
	}
}
