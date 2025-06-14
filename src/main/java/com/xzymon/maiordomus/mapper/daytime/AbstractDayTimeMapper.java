package com.xzymon.maiordomus.mapper.daytime;

import com.xzymon.maiordomus.mapper.Period;
import com.xzymon.maiordomus.utils.MapperHelper;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDayTimeMapper {

	protected abstract int getIntervalHours();

	protected abstract int getIntervalMinutes();

	protected abstract int getIntervalSeconds();

	protected abstract Map<Integer, String> getNumberToPeriodEndTimeMap();
	protected abstract void setNumberToPeriodEndTimeMap(Map<Integer, String> numberToPeriodEndTimeMap);

	protected abstract Map<String, Integer> getPeriodEndTimeToNumberMap();
	protected abstract void setPeriodEndTimeToNumberMap(Map<String, Integer> periodEndTimeToNumberMap);

	protected abstract Map<Integer, String> getNumberToPeriodStartTimeMap();
	protected abstract void setNumberToPeriodStartTimeMap(Map<Integer, String> numberToPeriodStartTimeMap);

	protected abstract Map<String, Integer> getPeriodStartTimeToNumberMap();
	protected abstract void setPeriodStartTimeToNumberMap(Map<String, Integer> periodStartTimeToNumberMap);

	protected abstract Period[] getPeriods();
	protected abstract void setPeriods(Period[] periods);

	protected void periodEndTimeToNumberExtenstion() {
	}

	protected int getPeriodsInDayCount() {
		return getPeriods().length;
	}

	public static final int PERIOD_END_START_OFFSET_IN_SECONDS = 1;

	protected AbstractDayTimeMapper() {
		int intervalHours = getIntervalHours();
		int intervalMinutes = getIntervalMinutes();
		int intervalSeconds = getIntervalSeconds();

		int intervalsCount = MapperHelper.DAY_IN_SECONDS / (((intervalHours * MapperHelper.HOUR_IN_MINUTES) + intervalMinutes) * MapperHelper.MINUTE_IN_SECONDS + intervalSeconds);
		Period[] periods = new Period[intervalsCount];
		
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
			periods[i] = cPeriod;
		}
		Map<Integer, String> numberToPeriodStartTimeMap = new HashMap<>();
		Map<Integer, String> numberToPeriodEndTimeMap = new HashMap<>();
		Map<String, Integer> periodStartTimeToNumberMap = new HashMap<>();
		Map<String, Integer> periodEndTimeToNumberMap = new HashMap<>();

		for (int i = 0; i < periods.length; i++) {
			numberToPeriodStartTimeMap.put(i, periods[i].getStartTime());
			periodStartTimeToNumberMap.put(periods[i].getStartTime(), i);
			numberToPeriodEndTimeMap.put(i, periods[i].getEndTime());
			periodEndTimeToNumberMap.put(periods[i].getEndTime(), i);
		}
		setPeriods(periods);
		setNumberToPeriodStartTimeMap(numberToPeriodStartTimeMap);
		setNumberToPeriodEndTimeMap(numberToPeriodEndTimeMap);
		setPeriodStartTimeToNumberMap(periodStartTimeToNumberMap);
		setPeriodEndTimeToNumberMap(periodEndTimeToNumberMap);
		periodEndTimeToNumberExtenstion();
	}
}