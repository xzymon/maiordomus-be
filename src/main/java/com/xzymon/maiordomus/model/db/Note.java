package com.xzymon.maiordomus.model.db;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "note")
@Data
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(columnDefinition = "UUID")
	private java.util.UUID id;

	@Column(nullable = false, length = 255)
	private String title;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 255)
	private NoteCategory category;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime updatedAt;

	@Column(name = "time_reference", columnDefinition = "TIMESTAMP")
	private LocalDateTime timeReference;

	@ElementCollection
	@CollectionTable(name = "note_tags", joinColumns = @JoinColumn(name = "note_id"))
	@Column(name = "tag", nullable = false)
	private List<String> tags;

	@Column(length = 255)
	private String source;

	@Column(name = "additional_info", length = 255)
	private String additionalInfo;

	@Column(name = "author_name", length = 255)
	private String authorName;

}
