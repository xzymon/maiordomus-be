package com.xzymon.maiordomus.repository;

import com.xzymon.maiordomus.model.db.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
    List<Note> findAllByTagsContainingAndTimeReferenceBetween(String tag, LocalDate startOfDay, LocalDate endOfDay);
}
