package com.xzymon.maiordomus.controller.v1;

import com.xzymon.maiordomus.dto.DummyMessageDto;
import com.xzymon.maiordomus.mapper.DefaultMapper;
import com.xzymon.maiordomus.model.db.DummyMessage;
import com.xzymon.maiordomus.service.DummyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(DummyController.BASE_URL)
public class DummyController {
	public static final String BASE_URL = "/v1/dummy";
	private static final Logger LOGGER = LoggerFactory.getLogger(DummyController.class);

	private final DummyService dummyService;

	public DummyController(DummyService dummyService) {
		this.dummyService = dummyService;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public ResponseEntity<List<DummyMessageDto>> performDummyGet() {
		LOGGER.info("Performing dummy get");
		List<DummyMessage> fromDB = dummyService.getAll();
		List<DummyMessageDto> dtos = fromDB.stream().map(DefaultMapper.INSTANCE::toDummyMessageDto).toList();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/post")
	public ResponseEntity performDummyPost(@RequestBody DummyMessageDto dummyMessageDTO) {
		LOGGER.info("Performing dummy post");
		dummyService.add(DefaultMapper.INSTANCE.toDummyMessage(dummyMessageDTO));
		return new ResponseEntity(HttpStatus.CREATED);
	}
}