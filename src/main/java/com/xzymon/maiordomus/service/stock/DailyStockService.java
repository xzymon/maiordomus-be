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

	public void initRepo() {
		List<StockValor> stockValors = new ArrayList<>();
		StockValor usdgbp = new StockValor();
		usdgbp.setName("USDGBP");
		stockValors.add(usdgbp);
		stockValorRepository.saveAll(stockValors);

		List<StooqDailyStockCandle> dsCandles = new ArrayList<>();
		dsCandles.add(new StooqDailyStockCandle(usdgbp, Date.valueOf(LocalDate.of(1900,3,01)),"0","0.2047","0.2047","0.2047","0.2047"));
		dsCandles.add(new StooqDailyStockCandle(usdgbp, Date.valueOf(LocalDate.of(1900,6,01)),"0","0.2047","0.2047","0.2043","0.2043"));
		dsCandles.add(new StooqDailyStockCandle(usdgbp, Date.valueOf(LocalDate.of(1900,9,01)),"0","0.2043","0.2062","0.2043","0.2062"));
		dsCandles.add(new StooqDailyStockCandle(usdgbp, Date.valueOf(LocalDate.of(1900,12,01)),"0","0.2062","0.2062","0.2058","0.2058"));
		dsCandles.add(new StooqDailyStockCandle(usdgbp, Date.valueOf(LocalDate.of(1901,3,01)),"0","0.2058","0.2058","0.2056","0.2056"));
		dsCandles.add(new StooqDailyStockCandle(usdgbp, Date.valueOf(LocalDate.of(1901,6,01)),"0","0.2056","0.2058","0.2056","0.2058"));
		dsCandles.add(new StooqDailyStockCandle(usdgbp, Date.valueOf(LocalDate.of(1901,9,01)),"0","0.2058","0.2058","0.2043","0.2043"));
		dailyStockCandleRepository.saveAll(dsCandles);
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
