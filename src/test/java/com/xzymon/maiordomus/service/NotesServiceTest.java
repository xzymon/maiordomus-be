package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.dto.NoteDto;
import com.xzymon.maiordomus.model.db.Note;
import com.xzymon.maiordomus.model.db.NoteCategory;
import com.xzymon.maiordomus.repository.NoteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotesServiceTest {

	@Autowired
	private NotesService notesService;

	@Autowired
	private NoteRepository noteRepository;

	@Test
	void createNote() {
		// Przykład tworzenia notatki
		Note note = new Note();
		note.setTitle("Test Note");
		note.setContent("This is a test note.");
		note.setCategory(NoteCategory.CFD_TRADES);
		note.setTimeReference(LocalDateTime.now());
		note.setTags(List.of("test"));

		// Zapis do bazy danych
		Note savedNote = noteRepository.save(note);

		// Weryfikacja
		assertNotNull(savedNote.getId());
		assertEquals("Test Note", savedNote.getTitle());
	}

	@Test
	void getAllByTagAndDate() {
		// Przygotowanie danych testowych
		NoteDto septemberLastDayNoteDto = new NoteDto();
		septemberLastDayNoteDto.setTitle("First day Note");
		septemberLastDayNoteDto.setContent("This is a test note.");
		septemberLastDayNoteDto.setCategory(NoteCategory.CFD_TRADES);
		septemberLastDayNoteDto.setTimeReference(LocalDateTime.of(2024, 9, 30, 12, 0, 0));
		septemberLastDayNoteDto.setTags(List.of("aaa"));

		NoteDto octoberFirstDayNoteDto = new NoteDto();
		octoberFirstDayNoteDto.setTitle("October Note");
		octoberFirstDayNoteDto.setContent("Content 2");
		octoberFirstDayNoteDto.setCategory(NoteCategory.CFD_TRADES);
		octoberFirstDayNoteDto.setTimeReference(LocalDateTime.of(2024, 10, 1, 13, 0, 0));
		octoberFirstDayNoteDto.setTags(List.of("aaa"));

		notesService.createNote(septemberLastDayNoteDto);
		notesService.createNote(octoberFirstDayNoteDto);

		// Pobranie notatek na podstawie tagu i daty
		LocalDate lastSeptember = LocalDate.of(2024, 9, 30);
		List<NoteDto> aaaLastSeptember = notesService.getAllByTagAndDate("aaa", lastSeptember);

		// Weryfikacja
		assertEquals(1, aaaLastSeptember.size());
		//assertTrue(notes.stream().anyMatch(note -> note.getTitle().equals("Note 1")));
		//assertTrue(notes.stream().anyMatch(note -> note.getTitle().equals("Note 2")));
	}
}