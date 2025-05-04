package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.model.csv.CmcHistoryCsvRecord;
import com.xzymon.maiordomus.service.cmc.CmcHistoryCsvUploadService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CmcHistoryCsvUploadServiceTest {

	CmcHistoryCsvUploadService service = new CmcHistoryCsvUploadService();

	@Test
	void extract() throws FileNotFoundException {
		File file = ResourceUtils.getFile("classpath:csvdata/cmc-history.csv");
		FileInputStream fis = new FileInputStream(file);

		List<CmcHistoryCsvRecord> records = service.extract(fis);

		System.out.println(records.size());

		List<String> orderTypes = getValuesInColumn(records, record -> record.getOrderType());
		System.out.println(orderTypes);

		List<String> directions = getValuesInColumn(records, record -> record.getDirection());
		System.out.println(directions);

		List<String> instruments = getValuesInColumn(records, record -> record.getInstrument());
		System.out.println(instruments);

		List<String> types = getValuesInColumn(records, record -> record.getType());
		System.out.println(types);

		assertThat(records.size()).isGreaterThan(0);
	}

	List<String> getValuesInColumn(List<CmcHistoryCsvRecord> records, Function<CmcHistoryCsvRecord, String> function) {
		return records.stream()
				       .map(function)
				       .distinct()
				       .collect(Collectors.toUnmodifiableList());
	}
}