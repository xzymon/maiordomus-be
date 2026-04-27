package com.xzymon.maiordomus.utils;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class MapperHelper {
	public static final int DAY_IN_HOURS = 24;
	public static final int HOUR_IN_MINUTES = 60;
	public static final int MINUTE_IN_SECONDS = 60;

	public static final int DAY_IN_SECONDS = DAY_IN_HOURS * HOUR_IN_MINUTES * MINUTE_IN_SECONDS;

	public static final String TIME_FORMAT = "%02d:%02d:%02d";
	public static final String DATE_FORMAT = "%04d-%02d-%02d";

	public static String getDateString(int year, int month, int day) {
		return String.format(DATE_FORMAT, year, month, day);
	}

	public static String dateToDayString(Date date) {
		LocalDate localDate = date.toLocalDate();
		int day = localDate.getDayOfMonth();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();
		return getDateString(year, month, day);
	}

	public static Date dayStringToDate(String dayString) {
		String[] parts = dayString.split("-");
		int year = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int day = Integer.parseInt(parts[2]);
		return Date.valueOf(LocalDate.of(year, month, day));
	}

	public static String localDateToDayString(LocalDate localDate) {
		int day = localDate.getDayOfMonth();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();
		return getDateString(year, month, day);
	}

	public static LocalDate dayStringToLocalDate(String dayString) {
		String[] parts = dayString.split("-");
		int year = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int day = Integer.parseInt(parts[2]);
		return LocalDate.of(year, month, day);
	}

	public static String getTimeString(int hour, int minute, int second) {
		return String.format(TIME_FORMAT, hour, minute, second);
	}

	public static String timeToTimeString(Time time) {
		LocalTime localTime = time.toLocalTime();
		int hour = localTime.getHour();
		int minute = localTime.getMinute();
		int second = localTime.getSecond();
		return getTimeString(hour, minute, second);
	}

	public static Time timeStringToTime(String timeString) {
		String[] parts = timeString.split(":");
		int hour = Integer.parseInt(parts[0]);
		int minute = Integer.parseInt(parts[1]);
		int second = Integer.parseInt(parts[2]);
		return Time.valueOf(LocalTime.of(hour, minute, second));
	}

	public static BigDecimal stringToBigDecimal(String string) {
		if (string == null) {
			return null;
		}
		return new BigDecimal(string);
	}
}
