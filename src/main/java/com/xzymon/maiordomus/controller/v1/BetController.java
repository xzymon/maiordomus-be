package com.xzymon.maiordomus.controller.v1;

import com.xzymon.maiordomus.api.v1.model.BetDTO;
import com.xzymon.maiordomus.service.BetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(BetController.BASE_URL)
public class BetController {
	public static final String BASE_URL = "/api/v1/bet/";
	private static final Logger LOGGER = LoggerFactory.getLogger(BetController.class);

	private final BetService betService;

	public BetController(BetService betService) {
		this.betService = betService;
	}

	@GetMapping("{instrument}")
	public ResponseEntity<BetDTO> getBetByInstrument(@PathVariable String instrument) {
		return new ResponseEntity<BetDTO>(betService.getBetByInstrument(instrument), HttpStatus.OK);
	}
}
