package com.xzymon.maiordomus.service.cmc;

import com.opencsv.bean.CsvToBeanBuilder;
import com.xzymon.maiordomus.model.csv.CmcHistoryCsvRecord;
import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.scheduler.fileloading.DataLoadingCapsule;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class CmcHistoryCsvUploadService implements CsvUploadService {

	@Override
	public void upload(DataLoadingCapsule capsule) {

	}

	public List<CmcHistoryCsvRecord> extract(InputStream inputStream) {
		List<CmcHistoryCsvRecord> result = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		result = new CsvToBeanBuilder<CmcHistoryCsvRecord>(reader)
				         .withType(CmcHistoryCsvRecord.class)
				         .withSeparator(';')
				         .withQuoteChar('\"')
				         .withSkipLines(1)  //skip first line = header
				         .build()
				         .parse();
		return result;
	}

	public CmcHistoryCsvRecord validate(CmcHistoryCsvRecord record) {
		return record;
	}

	public boolean store(List<CmcHistoryCsvRecord> records) {
		return false;
	}


}
