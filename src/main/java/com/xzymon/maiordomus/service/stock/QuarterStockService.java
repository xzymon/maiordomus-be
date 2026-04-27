package com.xzymon.maiordomus.service.stock;

import com.xzymon.maiordomus.dto.request.DayInQuarterCandlesRequest;
import com.xzymon.maiordomus.dto.response.DayInQuarterCandlesResponse;
import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.model.db.StooqQuarterStockCandle;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface QuarterStockService {
	List<StooqQuarterStockCandle> getAll();
	DayInQuarterCandlesResponse getByValorAndDay(DayInQuarterCandlesRequest request);
	StooqQuarterStockCandle getByValorAndDayAndTime(StockValor stockValor, Date day, Time time);
}
