package com.xzymon.maiordomus.mapper.daytime;

public class QuarterDayTimeMapper extends AbstractDayTimeMapper {

	@Override
	protected int getIntervalHours() {
		return 0;
	}

	@Override
	protected int getIntervalMinutes() {
		return 15;
	}

	@Override
	protected int getIntervalSeconds() {
		return 0;
	}

	@Override
	protected void periodEndTimeToNumberExtenstion() {
		PERIOD_END_TIME_TO_NUMBER.put("24:00:00", PERIODS.length-1);
	}
}