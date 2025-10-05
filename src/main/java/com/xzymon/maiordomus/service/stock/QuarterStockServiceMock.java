package com.xzymon.maiordomus.service.stock;

import com.xzymon.maiordomus.dto.CreationHelper;
import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.dto.request.DayInQuarterCandlesRequest;
import com.xzymon.maiordomus.dto.response.DayInQuarterCandlesResponse;
import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.model.db.StooqQuarterStockCandle;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
@ConditionalOnProperty(name = "mockServices", havingValue = "true")
public class QuarterStockServiceMock implements QuarterStockService {
	@Override
	public List<StooqQuarterStockCandle> getAll() {
		return List.of();
	}

	@Override
	public DayInQuarterCandlesResponse getByValorAndDay(DayInQuarterCandlesRequest request) {
		return valorAndDayFullResponse();
	}

	@Override
	public StooqQuarterStockCandle getByValorAndDayAndTime(StockValor stockValor, Date day, Time time) {
		return null;
	}

	private DayInQuarterCandlesResponse valorAndDayFullResponse() {
		String day = "2024-09-30";
		DayInQuarterCandlesResponse response = new DayInQuarterCandlesResponse();
		response.setValorName("USDJPY");
		response.setYyyymmdd(day);
		response.setDayOfWeek("MONDAY");
		response.setDailyCandle(CreationHelper.instanceOfStockCandleDto(day, null, null, null, 142.26852, 143.91204, 141.65278, 43.60759));
		response.setPreviousDayClose(BigDecimal.valueOf(142.18056));
		List<StockCandleDto> quarterCandles = new ArrayList<>();
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "00:00:01", "00:15:00", 0, 142.26852, 142.56019, 142.25926, 142.51852));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "00:15:01", "00:30:00", 1, 142.49074, 142.58333, 142.41204, 142.58333));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "00:30:01", "00:45:00", 2, 142.56944, 142.65741, 142.55556, 142.58333));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "00:45:01", "01:00:00", 3, 142.58333, 142.70370, 142.56019, 142.68056));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "01:00:01", "01:15:00", 4, 142.68056, 142.76389, 142.59722, 142.76389));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "01:15:01", "01:30:00", 5, 142.76389, 142.84259, 142.75926, 142.81019));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "01:30:01", "01:45:00", 6, 142.81019, 142.91204, 142.75463, 142.75463));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "01:45:01", "02:00:00", 7, 142.75, 142.94444, 142.75, 142.81019));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "02:00:01", "02:15:00", 8, 142.80093, 142.83796, 142.63426, 142.80093));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "02:15:01", "02:30:00", 9, 142.79630, 142.80556, 142.58333, 142.64815));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "02:30:01", "02:45:00", 10, 142.64815, 142.72685, 142.51852, 142.60648));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "02:45:01", "03:00:00", 11, 142.60648, 142.73148, 142.48148, 142.68981));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "03:00:01", "03:15:00", 12, 142.69444, 142.84722, 142.62963, 142.68056));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "03:15:01", "03:30:00", 13, 142.67593, 142.68056, 142.55556, 142.57407));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "03:30:01", "03:45:00", 14, 142.58333, 142.64815, 142.45833, 142.60185));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "03:45:01", "04:00:00", 15, 142.61574, 142.62963, 142.41667, 142.46759));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "04:00:01", "04:15:00", 16, 142.45833, 142.47685, 142.31944, 142.39352));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "04:15:01", "04:30:00", 17, 142.39352, 142.43519, 142.31944, 142.41667));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "04:30:01", "04:45:00", 18, 142.40741, 142.44444, 142.28241, 142.41667));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "04:45:01", "05:00:00", 19, 142.41667, 142.55093, 142.40741, 142.53241));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "05:00:01", "05:15:00", 20, 142.52778, 142.52778, 142.43056, 142.43519));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "05:15:01", "05:30:00", 21, 142.43519, 142.43519, 142.33796, 142.37037));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "05:30:01", "05:45:00", 22, 142.375, 142.43519, 142.35648, 142.41204));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "05:45:01", "06:00:00", 23, 142.41204, 142.49074, 142.37037, 142.45833));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "06:00:01", "06:15:00", 24, 142.45370, 142.50, 142.26852, 142.26852));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "06:15:01", "06:30:00", 25, 142.26389, 142.31481, 142.18519, 142.22222));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "06:30:01", "06:45:00", 26, 142.22685, 142.25463, 142.17130, 142.24074));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "06:45:01", "07:00:00", 27, 142.23148, 142.26852, 142.08796, 142.12037));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "07:00:01", "07:15:00", 28, 142.125, 142.16204, 141.99537, 142.00926));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "07:15:01", "07:30:00", 29, 142.00, 142.06019, 141.91204, 142.01389));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "07:30:01", "07:45:00", 30, 142.02315, 142.10185, 141.75, 141.76389));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "07:45:01", "08:00:00", 31, 141.76389, 141.81944, 141.66204, 141.69907));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "08:00:01", "08:15:00", 32, 141.70833, 141.89815, 141.65278, 141.875));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "08:15:01", "08:30:00", 33, 141.88889, 141.90741, 141.66667, 141.78241));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "08:30:01", "08:45:00", 34, 141.80556, 142.04167, 141.74074, 142.00926));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "08:45:01", "09:00:00", 35, 142.00926, 142.07870, 141.91204, 142.06019));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "09:00:01", "09:15:00", 36, 142.06019, 142.20370, 142.02778, 142.05093));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "09:15:01", "09:30:00", 37, 142.04630, 142.06481, 141.93056, 141.97222));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "09:30:01", "09:45:00", 38, 141.98148, 142.31481, 141.97222, 142.31019));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "09:45:01", "10:00:00", 39, 142.31481, 142.41667, 142.24537, 142.375));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "10:00:01", "10:15:00", 40, 142.37037, 142.47222, 142.35185, 142.41204));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "10:15:01", "10:30:00", 41, 142.41667, 142.49537, 142.37037, 142.42593));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "10:30:01", "10:45:00", 42, 142.42130, 142.47685, 142.34722, 142.43519));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "10:45:01", "11:00:00", 43, 142.41667, 142.56481, 142.37037, 142.54167));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "11:00:01", "11:15:00", 44, 142.52778, 142.57407, 142.46759, 142.48148));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "11:15:01", "11:30:00", 45, 142.46759, 142.57407, 142.45833, 142.52778));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "11:30:01", "11:45:00", 46, 142.53241, 142.60185, 142.51389, 142.51852));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "11:45:01", "12:00:00", 47, 142.51852, 142.57407, 142.46296, 142.53241));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "12:00:01", "12:15:00", 48, 142.55093, 142.65278, 142.54630, 142.64352));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "12:15:01", "12:30:00", 49, 142.64815, 142.75, 142.64352, 142.72222));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "12:30:01", "12:45:00", 50, 142.72685, 142.79167, 142.65278, 142.69444));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "12:45:01", "13:00:00", 51, 142.69444, 142.69907, 142.58333, 142.60185));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "13:00:01", "13:15:00", 52, 142.61111, 142.61111, 142.45833, 142.49074));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "13:15:01", "13:30:00", 53, 142.49074, 142.55556, 142.42130, 142.43981));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "13:30:01", "13:45:00", 54, 142.43981, 142.54630, 142.41204, 142.53241));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "13:45:01", "14:00:00", 55, 142.53241, 142.56481, 142.49074, 142.56481));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "14:00:01", "14:15:00", 56, 142.56481, 142.76852, 142.55093, 142.71296));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "14:15:01", "14:30:00", 57, 142.71759, 142.86574, 142.68981, 142.81019));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "14:30:01", "14:45:00", 58, 142.81481, 142.88889, 142.80093, 142.82407));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "14:45:01", "15:00:00", 59, 142.82407, 142.98611, 142.82407, 142.94907));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "15:00:01", "15:15:00", 60, 142.95370, 142.96296, 142.79167, 142.85185));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "15:15:01", "15:30:00", 61, 142.86574, 142.88426, 142.75, 142.79167));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "15:30:01", "15:45:00", 62, 142.80556, 142.97685, 142.80093, 142.96296));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "15:45:01", "16:00:00", 63, 142.97685, 143.14352, 142.96296, 143.09722));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "16:00:01", "16:15:00", 64, 143.125, 143.18981, 142.96296, 142.96759));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "16:15:01", "16:30:00", 65, 142.98148, 143.03241, 142.86111, 142.93981));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "16:30:01", "16:45:00", 66, 142.90278, 143.04167, 142.82870, 142.94444));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "16:45:01", "17:00:00", 67, 142.94907, 143.08333, 142.92593, 143.04630));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "17:00:01", "17:15:00", 68, 143.03241, 143.29630, 143.00463, 143.22222));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "17:15:01", "17:30:00", 69, 143.21759, 143.27315, 143.17130, 143.27315));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "17:30:01", "17:45:00", 70, 143.26389, 143.32870, 143.16667, 143.32407));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "17:45:01", "18:00:00", 71, 143.32870, 143.37037, 143.26852, 143.26852));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "18:00:01", "18:15:00", 72, 143.25926, 143.26852, 143.15278, 143.22222));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "18:15:01", "18:30:00", 73, 143.22222, 143.31944, 143.20370, 143.20370));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "18:30:01", "18:45:00", 74, 143.20370, 143.23611, 143.09259, 143.15278));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "18:45:01", "19:00:00", 75, 143.15278, 143.19444, 143.08796, 143.11574));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "19:00:01", "19:15:00", 76, 143.11574, 143.12963, 142.95833, 142.96296));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "19:15:01", "19:30:00", 77, 142.96759, 143.03704, 142.95833, 142.97222));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "19:30:01", "19:45:00", 78, 142.97685, 143.07870, 142.97685, 143.07407));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "19:45:01", "20:00:00", 79, 143.06944, 143.11574, 142.96759, 143.09722));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "20:00:01", "20:15:00", 80, 143.09722, 143.66204, 143.09722, 143.58333));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "20:15:01", "20:30:00", 81, 143.625, 143.91204, 143.625, 143.84722));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "20:30:01", "20:45:00", 82, 143.84259, 143.84722, 143.68981, 143.69907));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "20:45:01", "21:00:00", 83, 143.68981, 143.74537, 143.625, 143.68056));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "21:00:01", "21:15:00", 84, 143.68519, 143.84722, 143.65741, 143.82870));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "21:15:01", "21:30:00", 85, 143.83796, 143.88889, 143.80093, 143.81481));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "21:30:01", "21:45:00", 86, 143.81481, 143.91204, 143.77315, 143.78241));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "21:45:01", "22:00:00", 87, 143.78241, 143.78704, 143.71296, 143.73148));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "22:00:01", "22:15:00", 88, 143.72685, 143.72685, 143.61574, 143.62037));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "22:15:01", "22:30:00", 89, 143.62037, 143.67593, 143.61574, 143.62037));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "22:30:01", "22:45:00", 90, 143.63426, 143.71759, 143.63426, 143.70833));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "22:45:01", "23:00:00", 91, 143.70833, 143.70833, 143.625, 143.63889));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "23:00:01", "23:15:00", 92, 143.64352, 143.65741, 143.60648, 143.60648));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "23:15:01", "23:30:00", 93, 143.60648, 143.61574, 143.58333, 143.59722));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "23:30:01", "23:45:00", 94, 143.59722, 143.61574, 143.58796, 143.60648));
		quarterCandles.add(CreationHelper.instanceOfStockCandleDto(day, "23:45:01", "00:00:00", 95, 143.60759, 143.60759, 143.60759, 143.60759));
		response.setQuarterCandles(quarterCandles);
		response.setEvents(List.of());
		response.setNotes(List.of());
		response.setBets(List.of());
		return response;
	}
}
