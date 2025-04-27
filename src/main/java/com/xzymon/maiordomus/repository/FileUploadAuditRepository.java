package com.xzymon.maiordomus.repository;

import com.xzymon.maiordomus.model.db.FileUploadAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadAuditRepository extends JpaRepository<FileUploadAudit, Long> {
	FileUploadAudit findByName(String name);
}
