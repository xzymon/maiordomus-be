package com.xzymon.maiordomus.service.stock;

import com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper;
import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.model.db.StooqDailyStockCandle;
import com.xzymon.maiordomus.model.db.StooqQuarterStockCandle;
import com.xzymon.maiordomus.repository.DailyStockCandleRepository;
import com.xzymon.maiordomus.repository.StockValorRepository;
import com.xzymon.maiordomus.utils.MapperHelper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyStockService {

	private DailyStockCandleRepository dailyStockCandleRepository;
	private StockValorRepository stockValorRepository;

	public DailyStockService(DailyStockCandleRepository dailyStockCandleRepository, StockValorRepository stockValorRepository) {
		this.dailyStockCandleRepository = dailyStockCandleRepository;
		this.stockValorRepository = stockValorRepository;
	}

	public StockValor getValorByName(String name) {
		return stockValorRepository.findByName(name);
	}

	public List<StooqDailyStockCandle> getAll() {
		return dailyStockCandleRepository.findAll().stream().collect(Collectors.toList());
	}

	public List<StooqDailyStockCandle> getAllByValorAndDay(StockValor stockValor, Date day) {
		//Date dateDay = MapperHelper.dayStringToDate(day);
		if (stockValor != null) {
			List<StooqDailyStockCandle> stockCandles = dailyStockCandleRepository.findByValorAndDay(stockValor, day);
			return stockCandles.stream().collect(Collectors.toList());
		}
		return List.of();
	}

	public StooqDailyStockCandle getByValorAndDayAndTime(StockValor stockValor, Date day, Time time) {
		if (stockValor != null) {
			String timeString = MapperHelper.timeToTimeString(time);
			Integer candleNo = QuarterDayTimeMapper.getInstance().getPeriodEndTimeToNumberMap().get(timeString);
			return dailyStockCandleRepository.findByValorAndDayAndCandleNo(stockValor, day, candleNo);
		}
		return null;
	}
}
