package com.xzymon.maiordomus.controller.v1;

import com.xzymon.maiordomus.model.csv.CmcHistoryCsvRecord;
import com.xzymon.maiordomus.service.FileFinderService;
import com.xzymon.maiordomus.service.cmc.CmcHistoryCSVUploadService;
import com.xzymon.maiordomus.service.cmc.CmcHistoryDataValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(ForceCmcHistoryCSVUploadController.BASE_URL)
public class ForceCmcHistoryCSVUploadController {
	public static final String BASE_URL = "/api/v1/forcecmc";
	private static final Logger LOGGER = LoggerFactory.getLogger(ForceCmcHistoryCSVUploadController.class);

	private final FileFinderService fileFinderService;
	private final CmcHistoryCSVUploadService uploadService;
	private final CmcHistoryDataValidationService validationService;

	public ForceCmcHistoryCSVUploadController(FileFinderService fileFinderService, CmcHistoryCSVUploadService uploadService, CmcHistoryDataValidationService validationService) {
		this.fileFinderService = fileFinderService;
		this.uploadService = uploadService;
		this.validationService = validationService;
	}

	@GetMapping()
	public ResponseEntity<String> performForceCmcUpload(@RequestParam("filename") String filename) {
		LOGGER.info("Performing force cmc upload, with file: " + filename);

		try {
			File file = fileFinderService.getFileByName(filename);

			List<CmcHistoryCsvRecord> newestToOldest = uploadService.convertCSV(file);
			List<CmcHistoryCsvRecord> cmcHistoryCsvRecords = newestToOldest.reversed();

			Iterator<CmcHistoryCsvRecord> recordIt = cmcHistoryCsvRecords.iterator();
			long primordialNo = 1; long reversedNo = cmcHistoryCsvRecords.size() - 1;
			while (recordIt.hasNext()) {
				validationService.validate(recordIt.next(), primordialNo, reversedNo);
				primordialNo++; reversedNo--;
			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		return ResponseEntity.ok("OK");
	}
}
