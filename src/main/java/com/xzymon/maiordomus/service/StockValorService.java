package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.model.db.StockValor;

public interface StockValorService {
	StockValor getByName(String name);
	StockValor save(StockValor stockValor);
}
