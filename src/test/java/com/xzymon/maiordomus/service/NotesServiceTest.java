package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.model.db.Note;
import com.xzymon.maiordomus.repository.NoteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		note.setTimeReference(LocalDateTime.now());
		note.setTags(List.of("test"));

		// Zapis do bazy danych
		Note savedNote = noteRepository.save(note);

		// Weryfikacja
		assertNotNull(savedNote.getId());
		assertEquals("Test Note", savedNote.getTitle());
	}

	/*
	@Test
	void getAllByTagAndDate() {
		// Przygotowanie danych testowych
		Note note1 = new Note();
		note1.setTitle("Note 1");
		note1.setContent("Content 1");
		note1.setDate(LocalDate.now());
		note1.setTag("work");

		Note note2 = new Note();
		note2.setTitle("Note 2");
		note2.setContent("Content 2");
		note2.setDate(LocalDate.now());
		note2.setTag("work");

		noteRepository.save(note1);
		noteRepository.save(note2);

		// Pobranie notatek na podstawie tagu i daty
		List<Note> notes = notesService.getAllByTagAndDate("work", LocalDate.now());

		// Weryfikacja
		assertEquals(2, notes.size());
		assertTrue(notes.stream().anyMatch(note -> note.getTitle().equals("Note 1")));
		assertTrue(notes.stream().anyMatch(note -> note.getTitle().equals("Note 2")));
	}*/
}