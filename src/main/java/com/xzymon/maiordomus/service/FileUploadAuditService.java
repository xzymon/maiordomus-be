package com.xzymon.maiordomus.service;

import com.xzymon.maiordomus.model.db.FileUploadAudit;
import com.xzymon.maiordomus.repository.FileUploadAuditRepository;
import org.springframework.stereotype.Service;

@Service
public class FileUploadAuditService {

	private FileUploadAuditRepository fileUploadAuditRepository;

	public FileUploadAuditService(FileUploadAuditRepository fileUploadAuditRepository) {
		this.fileUploadAuditRepository = fileUploadAuditRepository;
	}

	public FileUploadAudit createOrUpdate(FileUploadAudit fileUploadAudit) {
		return fileUploadAuditRepository.save(fileUploadAudit);
	}
}
