package com.xzymon.maiordomus.scheduler.fileloading;

import java.util.Arrays;
import java.util.List;

public enum FileType {
	CMC_HISTORY("CMC Historia", "cmc-historia_\\d{8}-\\d{8}.csv"),
	STOOQ_BLOCK_15M("Stooq Block 15m", "\\w{6}_b15m_\\d{8}_\\d{2}.csv"),
	STOOQ_BLOCK_1D("Stooq Block 1d", "\\w{6}_b1d_\\d{8}_\\d{2}.csv"),
	UNRECOGNIZED("Unrecognized", ".*");

	private String name;
	private String mask;

	FileType(String name, String mask) {
		this.name = name;
		this.mask = mask;
	}

	public String getName() {
		return name;
	}

	public String getMask() {
		return mask;
	}

	public static List<FileType> getAllButUnrecognized() {
		return Arrays.stream(FileType.values())
		             .filter(fileType -> fileType != UNRECOGNIZED)
		             .toList();
	}
}
