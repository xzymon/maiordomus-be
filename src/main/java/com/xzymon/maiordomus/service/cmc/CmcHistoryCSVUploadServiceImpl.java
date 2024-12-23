package com.xzymon.maiordomus.service.cmc;

import com.opencsv.bean.CsvToBeanBuilder;
import com.xzymon.maiordomus.model.csv.CmcHistoryCsvRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class CmcHistoryCSVUploadServiceImpl implements CmcHistoryCSVUploadService {
	@Override
	public List<CmcHistoryCsvRecord> convertCSV(File csvFile) {
		List<CmcHistoryCsvRecord> result = null;
		try {
			FileReader fileReader = new FileReader(csvFile);
			result = new CsvToBeanBuilder<CmcHistoryCsvRecord>(fileReader)
					         .withType(CmcHistoryCsvRecord.class)
					         .withSeparator(';')
					         .withSkipLines(1)  //skip first line = header
					         .build()
					         .parse();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		return result;
	}
}
