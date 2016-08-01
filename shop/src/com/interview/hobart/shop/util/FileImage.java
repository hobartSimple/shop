package com.interview.hobart.shop.util;

import java.io.File;

import org.springframework.stereotype.Component;

@Component("fileImage")
public class FileImage {
	private File file;
	private String contentType;
	private String filename;
	
	public File getFile() {
		return file;
	}

	public String getContentType() {
		return contentType;
	}

	public String getFilename() {
		return filename;
	}

	public void setUpload(File file) {
		this.file = file;
	}
	
	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public void setUploadFileName(String filename) {
		this.filename = filename;
	}
}
