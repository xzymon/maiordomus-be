package com.xzymon.maiordomus.model.csv;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DateStockCandleCsvRecord {
	//Date
	@CsvBindByPosition(position = 0)
	private String date;

	//Open
	@CsvBindByPosition(position = 1)
	private String open;

	//High
	@CsvBindByPosition(position = 2)
	private String high;

	//Low
	@CsvBindByPosition(position = 3)
	private String low;

	//Close
	@CsvBindByPosition(position = 4)
	private String close;
}
