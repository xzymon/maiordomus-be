package com.xzymon.maiordomus.service.cmc;

import com.xzymon.maiordomus.model.csv.CmcHistoryCsvRecord;

import java.io.File;
import java.util.List;

public interface CmcHistoryCSVUploadService {
	List<CmcHistoryCsvRecord> convertCSV(File csvFile);
}
