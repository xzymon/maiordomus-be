package com.xzymon.maiordomus.model.csv;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class DateTimeStockCandleCsvRecord {
	//Date
	@CsvBindByPosition(position = 0)
	private String date;

	//Time
	@CsvBindByPosition(position = 1)
	private String time;

	//Open
	@CsvBindByPosition(position = 2)
	private String open;

	//High
	@CsvBindByPosition(position = 3)
	private String high;

	//Low
	@CsvBindByPosition(position = 4)
	private String low;

	//Close
	@CsvBindByPosition(position = 5)
	private String close;
}
