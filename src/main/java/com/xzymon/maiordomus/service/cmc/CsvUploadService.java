package com.xzymon.maiordomus.service.cmc;

import com.xzymon.maiordomus.scheduler.fileloading.DataLoadingCapsule;

public interface CsvUploadService {
	void upload(DataLoadingCapsule capsule);
}
