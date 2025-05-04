package com.xzymon.maiordomus.mapper.daytime;

public class HalfMinuteDayTimeMapper extends AbstractDayTimeMapper {

	@Override
	protected int getIntervalHours() {
		return 0;
	}

	@Override
	protected int getIntervalMinutes() {
		return 0;
	}

	@Override
	protected int getIntervalSeconds() {
		return 30;
	}
}