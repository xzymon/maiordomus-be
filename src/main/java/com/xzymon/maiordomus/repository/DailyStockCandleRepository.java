package com.xzymon.maiordomus.repository;

import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.model.db.StooqDailyStockCandle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface DailyStockCandleRepository extends JpaRepository<StooqDailyStockCandle, Long> {
	List<StooqDailyStockCandle> findByDay(Date day);

	List<StooqDailyStockCandle> findByValorName(String name);

	List<StooqDailyStockCandle> findByValor(StockValor valor);

	List<StooqDailyStockCandle> findByValorAndDay(StockValor valor, Date day);

	StooqDailyStockCandle findByValorAndDayAndCandleNo(StockValor valor, Date day, Integer candleNo);
}