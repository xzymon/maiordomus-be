package com.xzymon.maiordomus.scheduler.fileloading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class DataLoadingCapsuleServiceImpl implements DataLoadingCapsuleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataLoadingCapsuleServiceImpl.class);

	public DataLoadingCapsule createFromPath(Path path) {
		DataLoadingCapsule capsule = new DataLoadingCapsule();
		try {
			capsule.setData(Files.readAllBytes(path));
			capsule.getStringAttributes().put(DataLoadingStringAttributes.FILE_NAME, path.getFileName().toString());
			capsule.getObjectAttributes().put(DataLoadingObjectAttributes.SOURCE_TYPE, SourceType.FILE);
			capsule.getObjectAttributes().put(DataLoadingObjectAttributes.SOURCE_URI, path.toUri());
		} catch (IOException e) {
			LOGGER.error("ERROR: {}", e.getMessage());
			throw new RuntimeException(e);
		}
		return capsule;
	}
}
