package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.dto.NoteDto;
import com.xzymon.maiordomus.mapper.StructureMapper;
import com.xzymon.maiordomus.model.db.Note;
import com.xzymon.maiordomus.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

	public List<NoteDto> getAllByTagAndDate(String tag, LocalDate date) {
		List<Note> result = noteRepository.findAllByTagsContainingAndTimeReferenceBetween(tag, date, date);
		return structureMapper.noteListToDtoList(result);
	}
}
