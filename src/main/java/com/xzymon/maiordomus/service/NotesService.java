package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.dto.NoteDto;
import com.xzymon.maiordomus.mapper.StructureMapper;
import com.xzymon.maiordomus.model.db.Note;
import com.xzymon.maiordomus.repository.NoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotesService {
	private NoteRepository noteRepository;
	private StructureMapper structureMapper = StructureMapper.INSTANCE;

	public NotesService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	public NoteDto createNote(NoteDto noteDto) {
		Note newNote = structureMapper.toNote(noteDto);
		Note savedNote = noteRepository.save(newNote);
		return structureMapper.toNoteDto(savedNote);
	}

	@Transactional
	public List<NoteDto> getAllByTagAndDate(String tag, LocalDate date) {
		LocalDateTime dateStartOfDay = date.atStartOfDay();
		LocalDateTime dateEndOfDay = date.atTime(23, 59, 59);
		List<Note> result = noteRepository.findByTagAndDayOfTimeReference(tag, dateStartOfDay, dateEndOfDay);
		return structureMapper.noteListToDtoList(result);
	}
}
