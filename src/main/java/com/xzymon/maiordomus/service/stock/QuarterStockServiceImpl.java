package com.xzymon.maiordomus.service.stock;

import com.xzymon.maiordomus.dto.StockCandleDTO;
import com.xzymon.maiordomus.mapper.DefaultMapper;
import com.xzymon.maiordomus.model.db.DummyMessage;
import com.xzymon.maiordomus.model.db.QuarterStockCandle;
import com.xzymon.maiordomus.model.db.StockCandle;
import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.repository.QuarterStockCandleRepository;
import com.xzymon.maiordomus.repository.StockValorRepository;
import com.xzymon.maiordomus.utils.MapperHelper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuarterStockServiceImpl implements QuarterStockService {

	private QuarterStockCandleRepository quarterStockCandleRepository;
	private StockValorRepository stockValorRepository;

	public QuarterStockServiceImpl(QuarterStockCandleRepository quarterStockCandleRepository, StockValorRepository stockValorRepository) {
		this.quarterStockCandleRepository = quarterStockCandleRepository;
		this.stockValorRepository = stockValorRepository;
	}

	@Override
	public void initRepo() {
		List<StockValor> stockValors = new ArrayList<>();
		StockValor usdjpy = new StockValor();
		usdjpy.setName("USDJPY");
		stockValors.add(usdjpy);
		stockValorRepository.saveAll(stockValors);

		List<QuarterStockCandle> qsCandles = new ArrayList<>();
		Date day20240927 = Date.valueOf(LocalDate.of(2024,9, 27));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240927, "23:59:00","142.18056","142.18056","142.18056","142.18056"));
		Date day20240930 = Date.valueOf(LocalDate.of(2024,9, 30));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "00:15:00","142.26852","142.56019","142.25926","142.51852"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "00:30:00","142.49074","142.58333","142.41204","142.58333"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "00:45:00","142.56944","142.65741","142.55556","142.58333"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "01:00:00","142.58333","142.70370","142.56019","142.68056"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "01:15:00","142.68056","142.76389","142.59722","142.76389"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "01:30:00","142.76389","142.84259","142.75926","142.81019"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "01:45:00","142.81019","142.91204","142.75463","142.75463"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "02:00:00","142.75","142.94444","142.75","142.81019"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "02:15:00","142.80093","142.83796","142.63426","142.80093"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "02:30:00","142.79630","142.80556","142.58333","142.64815"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "02:45:00","142.64815","142.72685","142.51852","142.60648"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "03:00:00","142.60648","142.73148","142.48148","142.68981"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "03:15:00","142.69444","142.84722","142.62963","142.68056"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "03:30:00","142.67593","142.68056","142.55556","142.57407"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "03:45:00","142.58333","142.64815","142.45833","142.60185"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "04:00:00","142.61574","142.62963","142.41667","142.46759"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "04:15:00","142.45833","142.47685","142.31944","142.39352"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "04:30:00","142.39352","142.43519","142.31944","142.41667"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "04:45:00","142.40741","142.44444","142.28241","142.41667"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "05:00:00","142.41667","142.55093","142.40741","142.53241"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "05:15:00","142.52778","142.52778","142.43056","142.43519"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "05:30:00","142.43519","142.43519","142.33796","142.37037"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "05:45:00","142.375","142.43519","142.35648","142.41204"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "06:00:00","142.41204","142.49074","142.37037","142.45833"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "06:15:00","142.45370","142.50","142.26852","142.26852"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "06:30:00","142.26389","142.31481","142.18519","142.22222"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "06:45:00","142.22685","142.25463","142.17130","142.24074"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "07:00:00","142.23148","142.26852","142.08796","142.12037"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "07:15:00","142.125","142.16204","141.99537","142.00926"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "07:30:00","142.00","142.06019","141.91204","142.01389"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "07:45:00","142.02315","142.10185","141.75","141.76389"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "08:00:00","141.76389","141.81944","141.66204","141.69907"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "08:15:00","141.70833","141.89815","141.65278","141.875"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "08:30:00","141.88889","141.90741","141.66667","141.78241"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "08:45:00","141.80556","142.04167","141.74074","142.00926"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "09:00:00","142.00926","142.07870","141.91204","142.06019"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "09:15:00","142.06019","142.20370","142.02778","142.05093"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "09:30:00","142.04630","142.06481","141.93056","141.97222"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "09:45:00","141.98148","142.31481","141.97222","142.31019"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "10:00:00","142.31481","142.41667","142.24537","142.375"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "10:15:00","142.37037","142.47222","142.35185","142.41204"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "10:30:00","142.41667","142.49537","142.37037","142.42593"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "10:45:00","142.42130","142.47685","142.34722","142.43519"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "11:00:00","142.41667","142.56481","142.37037","142.54167"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "11:15:00","142.52778","142.57407","142.46759","142.48148"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "11:30:00","142.46759","142.57407","142.45833","142.52778"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "11:45:00","142.53241","142.60185","142.51389","142.51852"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "12:00:00","142.51852","142.57407","142.46296","142.53241"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "12:15:00","142.55093","142.65278","142.54630","142.64352"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "12:30:00","142.64815","142.75","142.64352","142.72222"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "12:45:00","142.72685","142.79167","142.65278","142.69444"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "13:00:00","142.69444","142.69907","142.58333","142.60185"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "13:15:00","142.61111","142.61111","142.45833","142.49074"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "13:30:00","142.49074","142.55556","142.42130","142.43981"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "13:45:00","142.43981","142.54630","142.41204","142.53241"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "14:00:00","142.53241","142.56481","142.49074","142.56481"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "14:15:00","142.56481","142.76852","142.55093","142.71296"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "14:30:00","142.71759","142.86574","142.68981","142.81019"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "14:45:00","142.81481","142.88889","142.80093","142.82407"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "15:00:00","142.82407","142.98611","142.82407","142.94907"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "15:15:00","142.95370","142.96296","142.79167","142.85185"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "15:30:00","142.86574","142.88426","142.75","142.79167"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "15:45:00","142.80556","142.97685","142.80093","142.96296"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "16:00:00","142.97685","143.14352","142.96296","143.09722"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "16:15:00","143.125","143.18981","142.96296","142.96759"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "16:30:00","142.98148","143.03241","142.86111","142.93981"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "16:45:00","142.90278","143.04167","142.82870","142.94444"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "17:00:00","142.94907","143.08333","142.92593","143.04630"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "17:15:00","143.03241","143.29630","143.00463","143.22222"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "17:30:00","143.21759","143.27315","143.17130","143.27315"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "17:45:00","143.26389","143.32870","143.16667","143.32407"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "18:00:00","143.32870","143.37037","143.26852","143.26852"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "18:15:00","143.25926","143.26852","143.15278","143.22222"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "18:30:00","143.22222","143.31944","143.20370","143.20370"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "18:45:00","143.20370","143.23611","143.09259","143.15278"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "19:00:00","143.15278","143.19444","143.08796","143.11574"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "19:15:00","143.11574","143.12963","142.95833","142.96296"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "19:30:00","142.96759","143.03704","142.95833","142.97222"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "19:45:00","142.97685","143.07870","142.97685","143.07407"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "20:00:00","143.06944","143.11574","142.96759","143.09722"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "20:15:00","143.09722","143.66204","143.09722","143.58333"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "20:30:00","143.625","143.91204","143.625","143.84722"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "20:45:00","143.84259","143.84722","143.68981","143.69907"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "21:00:00","143.68981","143.74537","143.625","143.68056"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "21:15:00","143.68519","143.84722","143.65741","143.82870"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "21:30:00","143.83796","143.88889","143.80093","143.81481"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "21:45:00","143.81481","143.91204","143.77315","143.78241"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "22:00:00","143.78241","143.78704","143.71296","143.73148"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "22:15:00","143.72685","143.72685","143.61574","143.62037"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "22:30:00","143.62037","143.67593","143.61574","143.62037"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "22:45:00","143.63426","143.71759","143.63426","143.70833"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "23:00:00","143.70833","143.70833","143.625","143.63889"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "23:15:00","143.64352","143.65741","143.60648","143.60648"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "23:30:00","143.60648","143.61574","143.58333","143.59722"));
		qsCandles.add(new QuarterStockCandle(usdjpy, day20240930, "23:45:00","143.59722","143.61574","143.58796","143.60648"));
		quarterStockCandleRepository.saveAll(qsCandles);
	}

	@Override
	public void add(StockCandle stockCandle) {

	}

	@Override
	public List<StockCandle> getAll() {
		return quarterStockCandleRepository.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public List<StockCandle> getAllByValorNameAndDay(String valorName, String day) {
		Date dateDay = MapperHelper.dayStringToDate(day);
		StockValor stockValor = stockValorRepository.findByName(valorName);
		if (stockValor != null) {
			List<QuarterStockCandle> stockCandles = quarterStockCandleRepository.findByValorAndDay(stockValor, dateDay);
			return stockCandles.stream().collect(Collectors.toList());
		}
		return List.of();
	}
}
