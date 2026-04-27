package com.xzymon.maiordomus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xzymon.maiordomus.model.db.StockValor;

public interface StockValorRepository extends JpaRepository<StockValor, Long> {
	StockValor findByName(String name);
}