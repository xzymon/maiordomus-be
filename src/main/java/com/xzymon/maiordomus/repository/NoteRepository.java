package com.xzymon.maiordomus.repository;

import com.xzymon.maiordomus.model.db.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
	//FIXME: dodaj like zamiast member of
	//@Query("SELECT n FROM Note n LEFT JOIN FETCH n.tags WHERE :tag MEMBER OF n.tags AND n.timeReference >= :startOfDay AND n.timeReference <= :endOfDay")
	@Query("SELECT n FROM Note n WHERE n.tags LIKE CONCAT('%', :tag, '%') AND n.timeReference >= :startOfDay AND n.timeReference <= :endOfDay")
	List<Note> findByTagAndDayOfTimeReference(String tag, LocalDateTime startOfDay, LocalDateTime endOfDay);
}
