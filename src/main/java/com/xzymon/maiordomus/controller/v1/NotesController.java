package com.xzymon.maiordomus.controller.v1;

import com.xzymon.maiordomus.dto.NoteDto;
import com.xzymon.maiordomus.service.NotesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping(NotesController.BASE_URL)
@Tag(name = "Note controller")
public class NotesController {
	public static final String BASE_URL = "/v1/note";
	private static final Logger LOGGER = LoggerFactory.getLogger(NotesController.class);

	private NotesService notesService;

	public NotesController(NotesService notesService) {
		this.notesService = notesService;
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	@Operation(summary = "Creates a new note", description = "Creates a new note and returns its UUID")
	public ResponseEntity<UUID> postNote(@RequestBody @Parameter(description = "Note data transfer object") NoteDto noteDto) {
		LOGGER.info("Performing postNote with {}", noteDto);
		NoteDto createdDto = notesService.createNote(noteDto);
		return ResponseEntity.ok(createdDto.getId());
	}

}
