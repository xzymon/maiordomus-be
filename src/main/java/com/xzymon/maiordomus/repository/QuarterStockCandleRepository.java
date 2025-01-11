package com.xzymon.maiordomus.repository;

import com.xzymon.maiordomus.model.db.StockValor;
import org.springframework.data.jpa.repository.JpaRepository;
import com.xzymon.maiordomus.model.db.QuarterStockCandle;

import java.sql.Date;
import java.util.List;

public interface QuarterStockCandleRepository extends JpaRepository<QuarterStockCandle, Long> {
	List<QuarterStockCandle> findByDay(Date day);

	List<QuarterStockCandle> findByValorName(String name);

	List<QuarterStockCandle> findByValor(StockValor valor);

	List<QuarterStockCandle> findByValorAndDay(StockValor valor, Date day);
}