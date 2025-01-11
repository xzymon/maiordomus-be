package com.xzymon.maiordomus.service.stock;

import com.xzymon.maiordomus.dto.StockCandleDTO;
import com.xzymon.maiordomus.model.db.DummyMessage;
import com.xzymon.maiordomus.model.db.StockCandle;

import java.util.List;

public interface QuarterStockService {
	void initRepo();
	void add(StockCandle stockCandle);
	List<StockCandle> getAll();
	List<StockCandle> getAllByValorNameAndDay(String valorName, String day);
}
