package com.xzymon.maiordomus.mapper;

import com.xzymon.maiordomus.mapper.util.IntegerDateTime;
import com.xzymon.maiordomus.model.db.CmcOrderType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CmcHistoryMapper {

	public static LocalDateTime getDateTime(String sourceDateTimeString) {
		if (convertDashToNull(sourceDateTimeString) == null) return null;
		IntegerDateTime integerDateTime = IntegerDateTime.getInstance(sourceDateTimeString);
		return getDateTime(integerDateTime);
	}

	public static LocalDateTime getDateTime(IntegerDateTime dateTime) {
		return LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), dateTime.getHour(),
				dateTime.getMinute(), dateTime.getSecond());
	}

	public static CmcOrderType getOrderType(String sourceOrderTypeString) {
		if (sourceOrderTypeString == null) {
			throw new IllegalArgumentException("Order type cannot be null");
		}
		String trimmedOrderTypeString = sourceOrderTypeString.trim();
		return CmcOrderType.getByName(trimmedOrderTypeString);
	}

	public static BigDecimal getVolume(String sourceVolumeString) {
		if (convertDashToNull(sourceVolumeString) == null) return null;
		String jednostReplacedString = sourceVolumeString.replace(" Jednost.", "");
		String jednReplacedString = jednostReplacedString.replace(" Jedn", "");
		return getBigDecimalRaw(jednReplacedString);
	}

	public static BigDecimal getBigDecimalRaw(String sourceBigDecimalString) {
		String noSpacesBigDecimalString = sourceBigDecimalString.replace(" ", "");
		String dotBigDecimalString = noSpacesBigDecimalString.replace(",", ".");
		return new BigDecimal(dotBigDecimalString);
	}

	public static BigDecimal getBigDecimal(String sourceBigDecimalString) {
		if (convertDashToNull(sourceBigDecimalString) == null) return null;
		return getBigDecimalRaw(sourceBigDecimalString);
	}

	public static BigDecimal getBigDecimalEliminatingPercent(String sourceBigDecimalWithPercent) {
		if (convertDashToNull(sourceBigDecimalWithPercent) == null) return null;
		String bigDecimalString = sourceBigDecimalWithPercent.replace("%", "");
		return getBigDecimalRaw(bigDecimalString);
	}

	public static String convertDashToNull(String sourceString) {
		if (sourceString == null || sourceString.equals("-")) {
			return null;
		}
		return sourceString;
	}
}
