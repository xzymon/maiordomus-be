package com.xzymon.maiordomus.service.cmc;

import com.xzymon.maiordomus.model.csv.CmcHistoryCsvRecord;

public interface CmcHistoryDataValidationService {
	CmcHistoryCsvRecord validate(CmcHistoryCsvRecord record, Long primordialNo, Long reversedNo);
}
