package com.xzymon.maiordomus.mapper.daytime;

import com.xzymon.maiordomus.mapper.Period;
import com.xzymon.maiordomus.utils.MapperHelper;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class DailyDayTimeMapper extends AbstractDayTimeMapper {
	private static final DailyDayTimeMapper INSTANCE = new DailyDayTimeMapper();

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
	private final int intervalHours = 24;
	@Getter
	private final int intervalMinutes = 0;
	@Getter
	private final int intervalSeconds = 0;

	private DailyDayTimeMapper() {
		Period only = new Period();
		only.setStartTime(MapperHelper.getTimeString(0, 0, PERIOD_END_START_OFFSET_IN_SECONDS));
		only.setEndTime(MapperHelper.getTimeString(24, 0, 0));
		Period[] periods = new Period[1];
		periods[0] = only;
		numberToPeriodStartTimeMap.put(0, periods[0].getStartTime());
		periodStartTimeToNumberMap.put(periods[0].getStartTime(), 0);
		numberToPeriodEndTimeMap.put(0, periods[0].getEndTime());
		periodEndTimeToNumberMap.put(periods[0].getEndTime(), 0);
	}

	public static DailyDayTimeMapper getInstance() {
		return INSTANCE;
	}

	public Period getOnlyPeriod() {
		return periods[0];
	}
}