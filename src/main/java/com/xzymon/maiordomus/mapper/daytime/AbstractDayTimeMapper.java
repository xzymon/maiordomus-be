package com.xzymon.maiordomus.mapper.daytime;

import com.xzymon.maiordomus.mapper.Period;
import com.xzymon.maiordomus.utils.MapperHelper;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDayTimeMapper {

	protected abstract int getIntervalHours();

	protected abstract int getIntervalMinutes();

	protected abstract int getIntervalSeconds();

	protected void periodEndTimeToNumberExtenstion() {
	}

	protected int getPeriodsInDayCount() {
		return PERIODS.length;
	}

	public static final int PERIOD_END_START_OFFSET_IN_SECONDS = 1;

	public Period[] PERIODS;

	public static final Map<Integer, String> NUMBER_TO_PERIOD_END_TIME = new HashMap<>();
	public static final Map<String, Integer> PERIOD_END_TIME_TO_NUMBER = new HashMap<>();
	public static final Map<Integer, String> NUMBER_TO_PERIOD_START_TIME = new HashMap<>();
	public static final Map<String, Integer> PERIOD_START_TIME_TO_NUMBER = new HashMap<>();

	protected AbstractDayTimeMapper() {
		int intervalHours = getIntervalHours();
		int intervalMinutes = getIntervalMinutes();
		int intervalSeconds = getIntervalSeconds();

		int intervalsCount = MapperHelper.DAY_IN_SECONDS / (((intervalHours * MapperHelper.HOUR_IN_MINUTES) + intervalMinutes) * MapperHelper.MINUTE_IN_SECONDS + intervalSeconds);
		PERIODS = new Period[intervalsCount];
		
		int cHours = 0;
		int cMinutes = 0;
		int cSeconds = 0;
		Period cPeriod;

		for (int i = 0; i < intervalsCount; i++) {
			cPeriod = new Period();
			cPeriod.setStartTime(MapperHelper.getTimeString(cHours, cMinutes, cSeconds + PERIOD_END_START_OFFSET_IN_SECONDS));
			cHours += intervalHours;
			cMinutes += intervalMinutes;
			cSeconds += intervalSeconds;
			if (cSeconds >= MapperHelper.MINUTE_IN_SECONDS) {
				cSeconds -= MapperHelper.MINUTE_IN_SECONDS;
				cMinutes++;
			}
			if (cMinutes >= MapperHelper.HOUR_IN_MINUTES) {
				cMinutes -= MapperHelper.HOUR_IN_MINUTES;
				cHours++;
			}
			if (cHours >= MapperHelper.DAY_IN_HOURS) {
				cHours -= MapperHelper.DAY_IN_HOURS;
			}
			cPeriod.setEndTime(MapperHelper.getTimeString(cHours, cMinutes, cSeconds));
			PERIODS[i] = cPeriod;
		}

		for (int i = 0; i < PERIODS.length; i++) {
			NUMBER_TO_PERIOD_START_TIME.put(i, PERIODS[i].getStartTime());
			PERIOD_START_TIME_TO_NUMBER.put(PERIODS[i].getStartTime(), i);
			NUMBER_TO_PERIOD_END_TIME.put(i, PERIODS[i].getEndTime());
			PERIOD_END_TIME_TO_NUMBER.put(PERIODS[i].getEndTime(), i);
		}
		periodEndTimeToNumberExtenstion();
	}
}