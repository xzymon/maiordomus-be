package com.xzymon.maiordomus.scheduler.fileloading;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DataLoadingCapsule {
	private byte[] data;
	private Map<DataLoadingStringAttributes, String> stringAttributes;
	private Map<DataLoadingObjectAttributes, Object> objectAttributes;

	public DataLoadingCapsule() {
		this.data = null;
		this.stringAttributes = new HashMap<>();
		this.objectAttributes = new HashMap<>();
	}
}
