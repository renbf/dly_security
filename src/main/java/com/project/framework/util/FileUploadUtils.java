package com.project.framework.util;

import java.io.File;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.springframework.web.multipart.MultipartFile;
import com.project.common.config.Global;
import com.project.common.exception.file.FileNameLengthLimitExceededException;
import com.project.common.utils.Md5Utils;

/**
 * 文件上传工具类
 *
 * @author lws
 */
public class FileUploadUtils {
    /**
     * 默认大小 50M
     */
    public static final long DEFAULT_MAX_SIZE = 52428800;

    /**
     * 默认上传的地址
     */
    private static String defaultBaseDir = Global.getProfile();

    /**
     * 默认的文件名最大长度
     */
    public static final int DEFAULT_FILE_NAME_LENGTH = 200;

    /**
     * 允许图片类型
     */
    public static final String IMAGE_JPG_EXTENSION = "jpg,gif,png,ico,bmp,jpeg";

    private static int counter = 0;

    public static void setDefaultBaseDir(String defaultBaseDir) {
        FileUploadUtils.defaultBaseDir = defaultBaseDir;
    }

    public static String getDefaultBaseDir() {
        return defaultBaseDir;
    }

    /**
     * 以默认配置进行文件上传
     *
     * @param file 上传的文件
     * @return 文件名称
     * @throws Exception
     */
    public static final String upload(MultipartFile file) throws IOException {
        try {
                String fileType=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length());
            return upload(getDefaultBaseDir(), file, fileType);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /**
     * 根据文件路径上传
     *
     * @param baseDir 相对应用的基目录
     * @param file    上传的文件
     * @return 文件名称
     * @throws IOException
     */
    public static final String upload(String baseDir, MultipartFile file) throws IOException {
        try {
            String fileType=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length());
            return upload(baseDir, file, fileType);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /**
     * 文件上传
     *
     * @param baseDir                   相对应用的基目录
     * @param file                      上传的文件
     * @param extension                 上传文件类型
     * @return 返回上传成功的文件名
     * @throws FileSizeLimitExceededException       如果超出最大大小
     * @throws FileNameLengthLimitExceededException 文件名太长
     * @throws IOException                          比如读写文件出错时
     */
    public static final String upload(String baseDir, MultipartFile file, String extension)
            throws FileSizeLimitExceededException, IOException, FileNameLengthLimitExceededException {

        int fileNamelength = file.getOriginalFilename().length();
        if (fileNamelength > FileUploadUtils.DEFAULT_FILE_NAME_LENGTH) {
            throw new FileNameLengthLimitExceededException(file.getOriginalFilename(), fileNamelength,
                    FileUploadUtils.DEFAULT_FILE_NAME_LENGTH);
        }

        assertAllowed(file);

        String fileName = encodingFilename(file.getOriginalFilename(), extension);

        File desc = getAbsoluteFile(baseDir, baseDir +File.separator+ fileName);
        file.transferTo(desc);
        return fileName;
    }

    private static final File getAbsoluteFile(String uploadDir, String filename) throws IOException {
        File desc = new File(File.separator + filename);

        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }
        if (!desc.exists()) {
            desc.createNewFile();
        }
        return desc;
    }

    /**
     * 编码文件名
     */
    private static final String encodingFilename(String filename, String extension) {
        filename = filename.replace("_", " ");
        filename = Md5Utils.hash(filename + System.nanoTime() + counter++) + extension;
        return filename;
    }

    /**
     * 文件大小校验
     *
     * @param file 上传的文件
     * @return
     * @throws FileSizeLimitExceededException 如果超出最大大小
     */
    public static final void assertAllowed(MultipartFile file) throws FileSizeLimitExceededException {
        long size = file.getSize();
        if (DEFAULT_MAX_SIZE != -1 && size > DEFAULT_MAX_SIZE) {
            throw new FileSizeLimitExceededException("not allowed upload upload", size, DEFAULT_MAX_SIZE);
        }
    }
    /**
     * 判断是否为允许的上传文件类型,true表示允许
     */
    public static boolean checkImgFile(MultipartFile file) {
        try {
			String fileName = file.getOriginalFilename();
			// 获取文件后缀
			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
			if (IMAGE_JPG_EXTENSION.contains(suffix.trim().toLowerCase())) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
    }
    /**
     * 判断是否为允许的上传文件类型,true表示允许
     */
    public static boolean checkImgFiles(MultipartFile[] files) {
        try {
        	if(files != null && files.length > 0) {
        		for(MultipartFile file:files) {
        			String fileName = file.getOriginalFilename();
        			// 获取文件后缀
        			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        			if (!IMAGE_JPG_EXTENSION.contains(suffix.trim().toLowerCase())) {
        				return false;
        			}
        		}
        		return true;
        	}
			return false;
		} catch (Exception e) {
			return false;
		}
    }
}
