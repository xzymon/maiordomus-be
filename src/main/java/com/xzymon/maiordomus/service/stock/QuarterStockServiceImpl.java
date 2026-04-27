package com.xzymon.maiordomus.service.stock;

import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.dto.request.DayInQuarterCandlesRequest;
import com.xzymon.maiordomus.dto.response.DayInQuarterCandlesResponse;
import com.xzymon.maiordomus.mapper.StockMapper;
import com.xzymon.maiordomus.mapper.StructureMapper;
import com.xzymon.maiordomus.mapper.daytime.QuarterDayTimeMapper;
import com.xzymon.maiordomus.mapper.helper.CmcInstrumentDetails;
import com.xzymon.maiordomus.mapper.helper.CmcInstrumentHelper;
import com.xzymon.maiordomus.model.db.Note;
import com.xzymon.maiordomus.model.db.StooqQuarterStockCandle;
import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.repository.NoteRepository;
import com.xzymon.maiordomus.repository.QuarterStockCandleRepository;
import com.xzymon.maiordomus.repository.StockValorRepository;
import com.xzymon.maiordomus.utils.MapperHelper;
import com.xzymon.maiordomus.utils.PreviousDayHelper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(name = "mockServices", havingValue = "false")
public class QuarterStockServiceImpl implements QuarterStockService {

	private QuarterStockCandleRepository quarterStockCandleRepository;
	private StockValorRepository stockValorRepository;
	private NoteRepository noteRepository;

	public QuarterStockServiceImpl(QuarterStockCandleRepository quarterStockCandleRepository,
	                               StockValorRepository stockValorRepository,
	                               NoteRepository noteRepository) {
		this.quarterStockCandleRepository = quarterStockCandleRepository;
		this.stockValorRepository = stockValorRepository;
		this.noteRepository = noteRepository;
	}

	@Override
	public List<StooqQuarterStockCandle> getAll() {
		return quarterStockCandleRepository.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public DayInQuarterCandlesResponse getByValorAndDay(DayInQuarterCandlesRequest request) {
		DayInQuarterCandlesResponse response = new DayInQuarterCandlesResponse();
		response.setValorName(request.getSymbol());
		response.setYyyymmdd(request.getDashSeparatedYYYYMMDD());
		LocalDate day = MapperHelper.dayStringToLocalDate(request.getDashSeparatedYYYYMMDD());
		String previousDayString = PreviousDayHelper.getByValorNameAndDayString(request.getSymbol(), request.getDashSeparatedYYYYMMDD());
		LocalDate previousDay = MapperHelper.dayStringToLocalDate(previousDayString);
		response.setDayOfWeek(getDayOfWeek(day));
		StockValor stockValor = stockValorRepository.findByName(request.getSymbol());
		if (stockValor != null) {
			List<StooqQuarterStockCandle> stockCandles = quarterStockCandleRepository.findByValorAndDayOrderByCandleNoAsc(stockValor, day);
			List<StockCandleDto> candleDtos = StockMapper.INSTANCE.quarterListToStockCandleDtoList(stockCandles);
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
				StockCandleDto previousDayLastCandleDto = StockMapper.INSTANCE.toStockCandleDto(previousDayStockCandles.get(previousDayStockCandles.size() - 1));
				response.setPreviousDayClose(previousDayLastCandleDto.getClose());
			}

			CmcInstrumentDetails cmcInstrumentDetails = CmcInstrumentHelper.VALOR_NAME_TO_INSTRUMENT_MAP.get(request.getSymbol());
			LocalDateTime dayStartTime = day.atStartOfDay();
			LocalDateTime dayEndTime = day.atTime(23, 59, 59);
			List<Note> allDayNotesForTag = new ArrayList<>();
			for (String tag : cmcInstrumentDetails.getTags()) {
				List<Note> notes = noteRepository.findByTagAndDayOfTimeReference(tag, dayStartTime, dayEndTime);
				allDayNotesForTag.addAll(notes);
			}
			allDayNotesForTag = allDayNotesForTag.stream().distinct().collect(Collectors.toList());
			response.setNotes(StructureMapper.INSTANCE.noteListToDtoList(allDayNotesForTag));
		}
		return response;
	}

	@Override
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

	private String getDayOfWeek(LocalDate day) {
		return day.getDayOfWeek().toString();
	}
}
