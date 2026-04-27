package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.repository.StockValorRepository;
import org.springframework.stereotype.Service;

@Service
public class StockValorServiceImpl implements StockValorService {

	private StockValorRepository stockValorRepository;

	public StockValorServiceImpl(StockValorRepository stockValorRepository) {
		this.stockValorRepository = stockValorRepository;
	}

	@Override
	public StockValor getByName(String name) {
		return stockValorRepository.findByName(name);
	}

	@Override
	public StockValor save(StockValor stockValor) {
		return stockValorRepository.save(stockValor);
	}
}
