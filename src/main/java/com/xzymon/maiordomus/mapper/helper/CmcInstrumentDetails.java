package com.xzymon.maiordomus.mapper.helper;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CmcInstrumentDetails {
	private String valorName;
	private String instrumentName;
	private List<String> tags;
}
