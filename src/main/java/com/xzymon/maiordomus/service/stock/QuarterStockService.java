package com.xzymon.maiordomus.service.stock;

import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.dto.request.DayInQuarterCandlesRequest;
import com.xzymon.maiordomus.dto.response.DayInQuarterCandlesResponse;
import com.xzymon.maiordomus.mapper.DefaultMapper;
import com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper;
import com.xzymon.maiordomus.model.db.StooqQuarterStockCandle;
import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.repository.QuarterStockCandleRepository;
import com.xzymon.maiordomus.repository.StockValorRepository;
import com.xzymon.maiordomus.utils.MapperHelper;
import com.xzymon.maiordomus.utils.PreviousDayHelper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuarterStockService {

	private QuarterStockCandleRepository quarterStockCandleRepository;
	private StockValorRepository stockValorRepository;

	public QuarterStockService(QuarterStockCandleRepository quarterStockCandleRepository, StockValorRepository stockValorRepository) {
		this.quarterStockCandleRepository = quarterStockCandleRepository;
		this.stockValorRepository = stockValorRepository;
	}

	public void initRepo() {
		List<StockValor> stockValors = new ArrayList<>();
		StockValor usdjpy = new StockValor();
		usdjpy.setName("USDJPY");
		stockValors.add(usdjpy);
		stockValorRepository.saveAll(stockValors);

		List<StooqQuarterStockCandle> qsCandles = new ArrayList<>();
		Date day20240927 = Date.valueOf(LocalDate.of(2024,9, 27));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240927, "95","142.18056","142.18056","142.18056","142.18056"));
		Date day20240930 = Date.valueOf(LocalDate.of(2024,9, 30));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "0","142.26852","142.56019","142.25926","142.51852"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "1","142.49074","142.58333","142.41204","142.58333"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "2","142.56944","142.65741","142.55556","142.58333"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "3","142.58333","142.70370","142.56019","142.68056"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "4","142.68056","142.76389","142.59722","142.76389"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "5","142.76389","142.84259","142.75926","142.81019"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "6","142.81019","142.91204","142.75463","142.75463"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "7","142.75","142.94444","142.75","142.81019"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "8","142.80093","142.83796","142.63426","142.80093"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "9","142.79630","142.80556","142.58333","142.64815"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "10","142.64815","142.72685","142.51852","142.60648"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "11","142.60648","142.73148","142.48148","142.68981"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "12","142.69444","142.84722","142.62963","142.68056"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "13","142.67593","142.68056","142.55556","142.57407"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "14","142.58333","142.64815","142.45833","142.60185"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "15","142.61574","142.62963","142.41667","142.46759"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "16","142.45833","142.47685","142.31944","142.39352"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "17","142.39352","142.43519","142.31944","142.41667"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "18","142.40741","142.44444","142.28241","142.41667"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "19","142.41667","142.55093","142.40741","142.53241"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "20","142.52778","142.52778","142.43056","142.43519"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "21","142.43519","142.43519","142.33796","142.37037"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "22","142.375","142.43519","142.35648","142.41204"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "23","142.41204","142.49074","142.37037","142.45833"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "24","142.45370","142.50","142.26852","142.26852"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "25","142.26389","142.31481","142.18519","142.22222"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "26","142.22685","142.25463","142.17130","142.24074"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "27","142.23148","142.26852","142.08796","142.12037"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "28","142.125","142.16204","141.99537","142.00926"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "29","142.00","142.06019","141.91204","142.01389"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "30","142.02315","142.10185","141.75","141.76389"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "31","141.76389","141.81944","141.66204","141.69907"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "32","141.70833","141.89815","141.65278","141.875"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "33","141.88889","141.90741","141.66667","141.78241"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "34","141.80556","142.04167","141.74074","142.00926"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "35","142.00926","142.07870","141.91204","142.06019"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "36","142.06019","142.20370","142.02778","142.05093"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "37","142.04630","142.06481","141.93056","141.97222"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "38","141.98148","142.31481","141.97222","142.31019"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "39","142.31481","142.41667","142.24537","142.375"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "40","142.37037","142.47222","142.35185","142.41204"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "41","142.41667","142.49537","142.37037","142.42593"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "42","142.42130","142.47685","142.34722","142.43519"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "43","142.41667","142.56481","142.37037","142.54167"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "44","142.52778","142.57407","142.46759","142.48148"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "45","142.46759","142.57407","142.45833","142.52778"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "46","142.53241","142.60185","142.51389","142.51852"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "47","142.51852","142.57407","142.46296","142.53241"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "48","142.55093","142.65278","142.54630","142.64352"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "49","142.64815","142.75","142.64352","142.72222"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "50","142.72685","142.79167","142.65278","142.69444"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "51","142.69444","142.69907","142.58333","142.60185"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "52","142.61111","142.61111","142.45833","142.49074"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "53","142.49074","142.55556","142.42130","142.43981"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "54","142.43981","142.54630","142.41204","142.53241"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "55","142.53241","142.56481","142.49074","142.56481"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "56","142.56481","142.76852","142.55093","142.71296"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "57","142.71759","142.86574","142.68981","142.81019"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "58","142.81481","142.88889","142.80093","142.82407"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "59","142.82407","142.98611","142.82407","142.94907"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "60","142.95370","142.96296","142.79167","142.85185"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "61","142.86574","142.88426","142.75","142.79167"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "62","142.80556","142.97685","142.80093","142.96296"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "63","142.97685","143.14352","142.96296","143.09722"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "64","143.125","143.18981","142.96296","142.96759"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "65","142.98148","143.03241","142.86111","142.93981"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "66","142.90278","143.04167","142.82870","142.94444"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "67","142.94907","143.08333","142.92593","143.04630"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "68","143.03241","143.29630","143.00463","143.22222"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "69","143.21759","143.27315","143.17130","143.27315"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "70","143.26389","143.32870","143.16667","143.32407"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "71","143.32870","143.37037","143.26852","143.26852"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "72","143.25926","143.26852","143.15278","143.22222"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "73","143.22222","143.31944","143.20370","143.20370"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "74","143.20370","143.23611","143.09259","143.15278"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "75","143.15278","143.19444","143.08796","143.11574"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "76","143.11574","143.12963","142.95833","142.96296"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "77","142.96759","143.03704","142.95833","142.97222"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "78","142.97685","143.07870","142.97685","143.07407"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "79","143.06944","143.11574","142.96759","143.09722"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "80","143.09722","143.66204","143.09722","143.58333"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "81","143.625","143.91204","143.625","143.84722"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "82","143.84259","143.84722","143.68981","143.69907"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "83","143.68981","143.74537","143.625","143.68056"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "84","143.68519","143.84722","143.65741","143.82870"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "85","143.83796","143.88889","143.80093","143.81481"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "86","143.81481","143.91204","143.77315","143.78241"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "87","143.78241","143.78704","143.71296","143.73148"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "88","143.72685","143.72685","143.61574","143.62037"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "89","143.62037","143.67593","143.61574","143.62037"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "90","143.63426","143.71759","143.63426","143.70833"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "91","143.70833","143.70833","143.625","143.63889"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "92","143.64352","143.65741","143.60648","143.60648"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "93","143.60648","143.61574","143.58333","143.59722"));
		qsCandles.add(new StooqQuarterStockCandle(usdjpy, day20240930, "94","143.59722","143.61574","143.58796","143.60648"));
		quarterStockCandleRepository.saveAll(qsCandles);
	}

	public void addCandle(StooqQuarterStockCandle stockCandle) {

	}

	public StockValor getValorByName(String name) {
		return stockValorRepository.findByName(name);
	}

	public List<StooqQuarterStockCandle> getAll() {
		return quarterStockCandleRepository.findAll().stream().collect(Collectors.toList());
	}

	public DayInQuarterCandlesResponse getByValorAndDay(DayInQuarterCandlesRequest request) {
		DayInQuarterCandlesResponse response = new DayInQuarterCandlesResponse();
		response.setValorName(request.getSymbol());
		response.setYyyymmdd(request.getDashSeparatedYYYYMMDD());
		Date day = MapperHelper.dayStringToDate(request.getDashSeparatedYYYYMMDD());
		String previousDayString = PreviousDayHelper.getByValorNameAndDayString(request.getSymbol(), request.getDashSeparatedYYYYMMDD());
		Date previousDay = MapperHelper.dayStringToDate(previousDayString);
		response.setDayOfWeek(getDayOfWeek(day));
		StockValor stockValor = stockValorRepository.findByName(request.getSymbol());
		if (stockValor != null) {
			List<StooqQuarterStockCandle> stockCandles = quarterStockCandleRepository.findByValorAndDayOrderByCandleNoAsc(stockValor, day);
			List<StockCandleDto> candleDtos = DefaultMapper.INSTANCE.quarterListToStockCandleDtoList(stockCandles);
			response.setQuarterCandles(candleDtos);

			StockCandleDto openCandle = candleDtos.get(0);
			StockCandleDto closeCandle = candleDtos.get(candleDtos.size()-1);

			StockCandleDto lowCandle = candleDtos.stream().min(Comparator.comparing(StockCandleDto::getLow)).get();
			StockCandleDto highCandle = candleDtos.stream().max(Comparator.comparing(StockCandleDto::getHigh)).get();

			StockCandleDto dailyCandle = new StockCandleDto();
			dailyCandle.setOpen(openCandle.getOpen());
			dailyCandle.setClose(closeCandle.getClose());
			dailyCandle.setLow(lowCandle.getLow());
			dailyCandle.setHigh(highCandle.getHigh());
			dailyCandle.setDay(closeCandle.getDay());
			response.setDailyCandle(dailyCandle);

			List<StooqQuarterStockCandle> previousDayStockCandles = quarterStockCandleRepository.findByValorAndDayOrderByCandleNoAsc(stockValor, previousDay);
			if (!previousDayStockCandles.isEmpty()) {
				StockCandleDto previousDayLastCandleDto = DefaultMapper.INSTANCE.toStockCandleDto(previousDayStockCandles.get(previousDayStockCandles.size() - 1));
				response.setPreviousDayClose(previousDayLastCandleDto.getClose());
			}
		}
		return response;
	}

	public StooqQuarterStockCandle getByValorAndDayAndTime(StockValor stockValor, Date day, Time time) {
		if (stockValor != null) {
			String timeString = MapperHelper.timeToTimeString(time);
			Integer candleNo = QuarterDayTimeMapper.getInstance().getPeriodEndTimeToNumberMap().get(timeString);
			//return quarterStockCandleRepository.findByValorAndDayAndCandleNo(stockValor, day, candleNo);
		}
		return null;
	}

	private String getDayOfWeek(Date date) {
		return date.toLocalDate().getDayOfWeek().toString();
	}
}
