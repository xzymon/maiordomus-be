package com.xzymon.maiordomus.mapper.helper;

import java.util.List;
import java.util.Optional;

public class MappingHelper {


	public static String mapFromStringArray(String[] array) {
		return Optional.ofNullable(array).map(arr -> String.join("|", arr)).orElse("");
	}

	public static String[] mapToStringArray(String string) {
		return Optional.ofNullable(string).map(str -> str.split("\\|")).orElse(new String[0]);
	}

	public static String mapFromListToString(List<String> list) {
		return String.join("|", list);
	}

	public static List<String> mapFromStringToList(String string) {
		return List.of(Optional.ofNullable(string)
				               .map(str -> str.split("\\|"))
				               .orElse(new String[0]));
	}

	public static String mapFromInstrumentDetailsToString(CmcInstrumentDetails details) {
		return String.format("%s|%s|%s", details.getValorName(), details.getInstrumentName(), String.join("|", details.getTags()));
	}
}
