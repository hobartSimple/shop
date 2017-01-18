package com.interview.hobart.shop.model;

import java.io.File;

import org.springframework.stereotype.Component;

@Component("fileImage")
public class FileImage {
	private File file;
	private String contentType;
	private String fileName;
	
	public File getUpload() {
		return file;
	}

	public String getUploadContentType() {
		return contentType;
	}

	public String getUploadFilename() {
		return fileName;
	}

	public void setUpload(File upload) {//set方法可以不用和属性名一样，但是前台传进来时的参数得和set方法名相同。即前台传的参数为fileImage.upload
		this.file = upload;
	}
	
	public void setUploadContentType(String uploadContentType) {
		this.contentType = uploadContentType;
	}
	
	public void setUploadFileName(String uploadFileName) {
		this.fileName = uploadFileName;
	}
	
}
