package com.project.security.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author rbf
 *
 */
public interface IFileSystemService {
	
	String uploadFile(MultipartFile file) throws Exception;
	
	String uploadFiles(MultipartFile[] files) throws Exception;
	
    File downloadFile(String targetPath) throws Exception;
 
    boolean deleteFile(String targetPath) throws Exception;
}
