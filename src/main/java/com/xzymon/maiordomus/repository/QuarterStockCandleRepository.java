package com.xzymon.maiordomus.repository;

import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.model.db.StooqQuarterStockCandle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface QuarterStockCandleRepository extends JpaRepository<StooqQuarterStockCandle, Long> {
	List<StooqQuarterStockCandle> findByDay(Date day);

	List<StooqQuarterStockCandle> findByValorName(String name);

	List<StooqQuarterStockCandle> findByValor(StockValor valor);

	List<StooqQuarterStockCandle> findByValorAndDay(StockValor valor, Date day);

	StooqQuarterStockCandle findByValorAndDayAndCandleNo(StockValor valor, Date day, Integer candleNo);
}