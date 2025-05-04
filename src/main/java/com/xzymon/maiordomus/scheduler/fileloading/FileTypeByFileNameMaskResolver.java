package com.xzymon.maiordomus.scheduler.fileloading;

public class FileTypeByFileNameMaskResolver {
	public static FileType resolve(String fileName) {
		for (FileType fileType : FileType.getAllButUnrecognized()) {
			if (fileName.matches(fileType.getMask())) {
				return fileType;
			}
		}
		return FileType.UNRECOGNIZED;
	}
}
