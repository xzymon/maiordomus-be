package com.xzymon.maiordomus.service;

import java.io.File;
import java.io.FileNotFoundException;

public interface FileFinderService {
	File getFileByName(String fileName) throws FileNotFoundException;
}
