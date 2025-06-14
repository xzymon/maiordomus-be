package com.xzymon.maiordomus.controller.v1;

import com.xzymon.maiordomus.dto.StockCandleDto;
import com.xzymon.maiordomus.dto.request.DayInQuarterCandlesRequest;
import com.xzymon.maiordomus.dto.response.DayInQuarterCandlesResponse;
import com.xzymon.maiordomus.mapper.StockMapper;
import com.xzymon.maiordomus.service.stock.QuarterStockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

import java.util.List;

@Controller
@RequestMapping(QuarterStockController.BASE_URL)
@Tag(name = "Quarter stock controller")
public class QuarterStockController {
	public static final String BASE_URL = "/v1/qstock";
	private static final Logger LOGGER = LoggerFactory.getLogger(QuarterStockController.class);

	private QuarterStockService quarterStockService;

	public QuarterStockController(QuarterStockService quarterStockService) {
		this.quarterStockService = quarterStockService;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	@Operation(
			summary = "Pobierz wszystkie informacje o akcjach",
			description = "Zapytanie zwraca wszystkie akcje ze szczegółami w formie DTO.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Sukces",
							content = @Content(array = @ArraySchema(schema = @Schema(implementation = StockCandleDto.class)))),
					@ApiResponse(responseCode = "500", description = "Błąd wewnętrzny serwera")
			}
	)
	public ResponseEntity<List<StockCandleDto>> getAll() {
		LOGGER.info("Performing getAll");
		var fromDB = quarterStockService.getAll();
		List<StockCandleDto> dtos = fromDB.stream().map(StockMapper.INSTANCE::toStockCandleDto).toList();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/day4symbol")
	@Operation(
			summary = "Pozyskaj szczegółowe dane dotyczące akcji dla symbolu",
			description = "Zapytanie zwraca szczegółowe dane dotyczące akcji dla symbolu na dany dzień.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Sukces",
							content = @Content(schema = @Schema(implementation = DayInQuarterCandlesResponse.class))),
					@ApiResponse(responseCode = "400", description = "Nieprawidłowe zapytanie"),
					@ApiResponse(responseCode = "500", description = "Błąd wewnętrzny serwera")
			},
			parameters = {
					@Parameter(name = "dayInQuarterCandlesRequest", description = "Parametry dnia i symbolu",
							required = true, schema = @Schema(implementation = DayInQuarterCandlesRequest.class))
			}
	)
	public ResponseEntity<DayInQuarterCandlesResponse> getDayForValor(@ModelAttribute DayInQuarterCandlesRequest dayInQuarterCandlesRequest) {
		LOGGER.info("Performing getDayForValor with {}", dayInQuarterCandlesRequest);
		DayInQuarterCandlesResponse response = quarterStockService.getByValorAndDay(dayInQuarterCandlesRequest);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
