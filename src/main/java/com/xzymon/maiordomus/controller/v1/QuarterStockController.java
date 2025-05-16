package com.xzymon.maiordomus.controller.v1;

import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.dto.request.DayInQuarterCandlesRequest;
import com.xzymon.maiordomus.dto.response.DayInQuarterCandlesResponse;
import com.xzymon.maiordomus.mapper.DefaultMapper;
import com.xzymon.maiordomus.model.db.StockCandle;
import com.xzymon.maiordomus.model.db.StockValor;
import com.xzymon.maiordomus.model.db.StooqQuarterStockCandle;
import com.xzymon.maiordomus.service.stock.QuarterStockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(QuarterStockController.BASE_URL)
@Tag(name = "Quarter stock controller")
public class QuarterStockController {
	public static final String BASE_URL = "/api/v1/qstock";
	private static final Logger LOGGER = LoggerFactory.getLogger(QuarterStockController.class);

	private QuarterStockService quarterStockService;

	public QuarterStockController(QuarterStockService quarterStockService) {
		this.quarterStockService = quarterStockService;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	@Operation(summary = "Pobierz wszystkie informacje o akcjach", description = "Zapytanie zwraca wszystkie akcje ze szczegółami w formie DTO.")
	public ResponseEntity<List<StockCandleDto>> getAll() {
		LOGGER.info("Performing getAll");
		var fromDB = quarterStockService.getAll();
		List<StockCandleDto> dtos = fromDB.stream().map(DefaultMapper.INSTANCE::toStockCandleDto).toList();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/day4symbol")
	public ResponseEntity<DayInQuarterCandlesResponse> getDayForValor(@ModelAttribute DayInQuarterCandlesRequest request) {
		LOGGER.info("Performing getDayForValor with {}", request);
		DayInQuarterCandlesResponse response = quarterStockService.getByValorAndDay(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
