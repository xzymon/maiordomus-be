package com.xzymon.maiordomus.scheduler.fileloading;

import java.nio.file.Path;

public interface DataLoadingCapsuleService {
	DataLoadingCapsule createFromPath(Path path);
}