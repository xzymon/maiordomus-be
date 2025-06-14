package com.xzymon.maiordomus.mapper.daytime;

import com.xzymon.maiordomus.mapper.Period;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class TenMinutesDayTimeMapper extends AbstractDayTimeMapper {
	private static final TenMinutesDayTimeMapper INSTANCE = new TenMinutesDayTimeMapper();

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
	private final int intervalMinutes = 10;
	@Getter
	private final int intervalSeconds = 0;

	private TenMinutesDayTimeMapper() {
		super();
	}

	public static TenMinutesDayTimeMapper getInstance() {
		return INSTANCE;
	}
}
