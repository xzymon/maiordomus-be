package com.xzymon.maiordomus.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreviousDayHelperTest {

	@Test
	void previousDay_USDJPY_20240930() {
		String result = PreviousDayHelper.getByValorNameAndDayString( "USDJPY", "2024-09-30");
		assertEquals("2024-09-27", result);
	}

	@Test
	void previousDay_BTC_20240930() {
		String result = PreviousDayHelper.getByValorNameAndDayString( "BTC.V", "2024-09-30");
		assertEquals("2024-09-29", result);
	}
}