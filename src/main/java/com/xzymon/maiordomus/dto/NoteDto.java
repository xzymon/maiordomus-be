
package com.xzymon.maiordomus.dto;

import com.xzymon.maiordomus.model.db.NoteCategory;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class NoteDto {
	private UUID id;
	private String title;
	private NoteCategory category;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime timeReference;
	private List<String> tags;
	private String source;
	private String additionalInfo;
	private String authorName;
}
