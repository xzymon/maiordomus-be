package com.xzymon.maiordomus.model.db;

import com.xzymon.maiordomus.scheduler.fileloading.FileType;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "file_upload_audit",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = { "name" }),
		@UniqueConstraint(columnNames = { "hash" })
	}
)
public class FileUploadAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_upload_audit_seq")
	private Long id;

	private String name;
	private String hash;
	private Integer length;
	private Long lines;

	@Enumerated(EnumType.STRING)
	private FileType type;

	@Enumerated(EnumType.STRING)
	private FileUploadStatus status;
	private String error;

	@Timestamp
	private LocalDateTime uploaded;

	@Timestamp
	private LocalDateTime processed;

	@PrePersist
	private void onInsert() {
		this.uploaded = LocalDateTime.now();
		this.status = FileUploadStatus.WAITING;
	}

	@PreUpdate
	private void onUpdate() {
		this.processed = LocalDateTime.now();
	}
}
