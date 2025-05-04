package com.xzymon.maiordomus.mapper.daytime;

public class TenMinutesDayTimeMapper extends AbstractDayTimeMapper {

	@Override
	protected int getIntervalHours() {
		return 0;
	}

	@Override
	protected int getIntervalMinutes() {
		return 10;
	}

	@Override
	protected int getIntervalSeconds() {
		return 0;
	}
}
