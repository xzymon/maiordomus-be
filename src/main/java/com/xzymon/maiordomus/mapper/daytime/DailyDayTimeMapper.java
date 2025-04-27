package com.xzymon.maiordomus.mapper.daytime;

import com.xzymon.maiordomus.mapper.Period;
import com.xzymon.maiordomus.utils.MapperHelper;

public class DailyDayTimeMapper extends AbstractDayTimeMapper {

	@Override
	protected int getIntervalHours() {
		return 24;
	}

	@Override
	protected int getIntervalMinutes() {
		return 0;
	}

	@Override
	protected int getIntervalSeconds() {
		return 0;
	}

	public Period getOnlyPeriod() {
		return PERIODS[0];
	}

	public DailyDayTimeMapper() {
		Period only = new Period();
		only.setStartTime(MapperHelper.getTimeString(0, 0, PERIOD_END_START_OFFSET_IN_SECONDS));
		only.setEndTime(MapperHelper.getTimeString(24, 0, 0));
		PERIODS[0] = only;
		NUMBER_TO_PERIOD_START_TIME.put(0, PERIODS[0].getStartTime());
		PERIOD_START_TIME_TO_NUMBER.put(PERIODS[0].getStartTime(), 0);
		NUMBER_TO_PERIOD_END_TIME.put(0, PERIODS[0].getEndTime());
		PERIOD_END_TIME_TO_NUMBER.put(PERIODS[0].getEndTime(), 0);
	}
}