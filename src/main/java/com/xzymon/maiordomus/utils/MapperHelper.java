package com.xzymon.maiordomus.utils;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class MapperHelper {

	public static String dateToDayString(Date date) {
		LocalDate localDate = date.toLocalDate();
		int day = localDate.getDayOfMonth();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();
		return String.format("%04d-%02d-%02d", year, day, month);
	}

	public static Date dayStringToDate(String dayString) {
		String[] parts = dayString.split("-");
		int year = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int day = Integer.parseInt(parts[2]);
		return Date.valueOf(LocalDate.of(year, month, day));
	}

	public static String timeToTimeString(Time time) {
		LocalTime localTime = time.toLocalTime();
		int hour = localTime.getHour();
		int minute = localTime.getMinute();
		int second = localTime.getSecond();
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

	public static Time timeStringToTime(String timeString) {
		String[] parts = timeString.split(":");
		int hour = Integer.parseInt(parts[0]);
		int minute = Integer.parseInt(parts[1]);
		int second = Integer.parseInt(parts[2]);
		return Time.valueOf(LocalTime.of(hour, minute, second));
	}
}
