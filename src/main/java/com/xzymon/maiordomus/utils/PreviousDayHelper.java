package com.xzymon.maiordomus.utils;

import com.xzymon.maiordomus.utils.generator.CryptoTradingDaysGenerator;
import com.xzymon.maiordomus.utils.generator.StockTradingDaysGenerator;
import com.xzymon.maiordomus.utils.generator.TradingDaysGenerator;

import java.util.List;

public class PreviousDayHelper {
	private static final String VALOR_NAME_CRYPTO_SUFFIX = ".V";

	public static final TradingDaysGenerator STOCK_GEN = StockTradingDaysGenerator.getInstance();
	public static final TradingDaysGenerator CRYPTO_GEN = CryptoTradingDaysGenerator.getInstance();

	public static String getByValorNameAndDayString(String valorName, String dayString) {
		if (valorName == null || dayString == null) {
			return null;
		}
		TradingDaysGenerator generator = valorName.endsWith(VALOR_NAME_CRYPTO_SUFFIX) ? CRYPTO_GEN : STOCK_GEN;
		List<String> daysList = generator.generate();
		int dayIndex = daysList.indexOf(dayString);
		if (dayIndex == -1) {
			return null;
		}
		return daysList.get(dayIndex - 1);
	}
}
