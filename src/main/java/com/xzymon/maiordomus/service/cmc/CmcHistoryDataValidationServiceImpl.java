package com.xzymon.maiordomus.service.cmc;

import com.xzymon.maiordomus.model.csv.CmcHistoryCsvRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CmcHistoryDataValidationServiceImpl implements CmcHistoryDataValidationService {
	@Override
	public CmcHistoryCsvRecord validate(CmcHistoryCsvRecord record, Long primordialNo, Long reversedNo) {
		log.debug( "Validating record with reversedNo={}, primordialNo={}", reversedNo, primordialNo);
		return record;
	}
}
