package com.xzymon.maiordomus.mapper.daytime;

import com.xzymon.maiordomus.mapper.Period;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class QuarterDayTimeMapper extends AbstractDayTimeMapper {
	private static final QuarterDayTimeMapper INSTANCE = new QuarterDayTimeMapper();

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
	private final int intervalMinutes = 15;
	@Getter
	private final int intervalSeconds = 0;

	private QuarterDayTimeMapper() {
		super();
	}

	public static QuarterDayTimeMapper getInstance() {
		return INSTANCE;
	}

	@Override
	protected void periodEndTimeToNumberExtenstion() {
		getPeriodEndTimeToNumberMap().put("24:00:00", getPeriods().length - 1);
	}

}