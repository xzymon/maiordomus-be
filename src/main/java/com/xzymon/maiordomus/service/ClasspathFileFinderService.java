package com.xzymon.maiordomus.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@Service
public class ClasspathFileFinderService implements FileFinderService {
	@Override
	public File getFileByName(String fileName) throws FileNotFoundException {
		return ResourceUtils.getFile("classpath:csvdata/" + fileName + ".csv");
	}
}
