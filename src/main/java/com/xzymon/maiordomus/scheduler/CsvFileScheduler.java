package com.xzymon.maiordomus.scheduler;

import com.xzymon.maiordomus.scheduler.fileloading.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Configuration
public class CsvFileScheduler {
	private static final Logger LOGGER = LoggerFactory.getLogger(CsvFileScheduler.class);

	private static final String DIR_IN_PATH_PROBLEM_HINT = "Property loading.directory.in problem. Should be Read-Write directory. Hint: ";
	private static final String DIR_PROC_PATH_PROBLEM_HINT = "Property loading.directory.processed problem. Should be Read-Write directory. Hint: ";
	private static final String DIR_ERR_PATH_PROBLEM_HINT = "Property loading.directory.error problem. Should be Read-Write directory. Hint: ";

	@Value("${fileprocessing.csv.in}")
	private String loadingDirectoryIn;

	@Value("${fileprocessing.csv.processed}")
	private String loadingDirectoryProcessed;

	@Value("${fileprocessing.csv.error}")
	private String loadingDirectoryError;

	private DataLoadingCapsuleService dataLoadingCapsuleService;
	private CsvDataLoadingProcessor processor;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public CsvFileScheduler(DataLoadingCapsuleService dataLoadingCapsuleService, CsvDataLoadingProcessor processor) {
		this.dataLoadingCapsuleService = dataLoadingCapsuleService;
		this.processor = processor;
	}

	//@Scheduled(fixedRate = 60 * 1000)
	@Scheduled(cron = "0 * * * * *")
	public void reportCurrentTime() {
		LOGGER.info("The time is now {}", dateFormat.format(new Date()));
		LOGGER.info(loadingDirectoryIn);
		checkDirectory(loadingDirectoryIn, DIR_IN_PATH_PROBLEM_HINT);
		checkDirectory(loadingDirectoryProcessed, DIR_PROC_PATH_PROBLEM_HINT);
		checkDirectory(loadingDirectoryError, DIR_ERR_PATH_PROBLEM_HINT);
		processFiles(loadingDirectoryIn);
	}

	private void processFiles(String loadingDirectoryIn) {
		Path path = Paths.get(loadingDirectoryIn);
		List<Path> pathsToFiles;
		//CsvOutput csvOutput;
		try {
			pathsToFiles = Files.list(path)
					               .filter(p -> !Files.isDirectory(p))
					               .collect(Collectors.toUnmodifiableList());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		boolean processedFlag;
		for (Path pathToFile : pathsToFiles) {
			LOGGER.info(String.format("Loadinging file: %1$s", pathToFile.getFileName().toString()));
			DataLoadingCapsule dataLoadingCapsule = dataLoadingCapsuleService.createFromPath(pathToFile);
			LOGGER.info(String.format("Processing file: %1$s", pathToFile.getFileName().toString()));
			processedFlag = processor.loadData(dataLoadingCapsule);
			if (processedFlag) {
				LOGGER.info(String.format("File %1$s processed.", pathToFile.getFileName().toString()));
			}
			moveFile(pathToFile);
		}
	}

	private void moveFile(Path path) {
		Path processedDirPath = Paths.get(loadingDirectoryProcessed);
		Path movedFilePath =  processedDirPath.resolve(path.getFileName());
		try {
			Files.move(path, movedFilePath);
			LOGGER.info(String.format("File %1$s moved to processed directory.", path.getFileName().toString()));
		} catch (FileAlreadyExistsException ee) {
			try {
				LOGGER.info(String.format("File %1$s could not be moved. So it will be deleted...", path.getFileName().toString()));
				Files.delete(path);
				LOGGER.info(String.format("File %1$s deleted.", path.getFileName().toString()));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} catch (IOException e) {
			LOGGER.error("Error when moving file {}", path.getFileName().toString());
			throw new RuntimeException(e);
		}
	}

	private void checkDirectory(String directoryPath, String loggerHint) {
		Path path = Paths.get(directoryPath);
		if (!Files.exists(path)) {
			LOGGER.info(loggerHint + "directory does not exist.");
			return;
		}
		if (!Files.isDirectory(path)) {
			LOGGER.info(loggerHint + "is not a directory.");
			return;
		}
		if (!Files.isReadable(path)) {
			LOGGER.info(loggerHint + "is not readable.");
			return;
		}
		if (!Files.isWritable(path)) {
			LOGGER.info(loggerHint + "is not writable.");
			return;
		}
		try {
			Files.list(path)
					.filter(p -> !Files.isDirectory(p))
					.forEach(p -> LOGGER.debug(String.format("file: %1$s", p.getFileName().toString())));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
