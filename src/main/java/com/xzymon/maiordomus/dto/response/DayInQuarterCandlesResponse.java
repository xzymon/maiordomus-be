package com.xzymon.maiordomus.dto.response;

import com.xzymon.maiordomus.dto.BetDto;
import com.xzymon.maiordomus.dto.NotesDto;
import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.dto.StockEventsDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class DayInQuarterCandlesResponse {
	private String valorName;
	private String yyyymmdd;
	private String dayOfWeek;
	private StockCandleDto dailyCandle;
	private BigDecimal previousDayClose;
	private List<StockCandleDto> quarterCandles;
	private List<StockEventsDto> events;
	private List<NotesDto> notes;
	private List<BetDto> bets;
}
