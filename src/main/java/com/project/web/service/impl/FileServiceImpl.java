package com.project.web.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.project.common.enums.FileSourceTypeEnum;
import com.project.framework.util.FileUploadUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.File;
import com.project.web.mapper.FileMapper;
import com.project.web.service.IFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 附件 服务层实现
 * 
 * @author lws
 * @date 2019-02-22
 */
@Service
public class FileServiceImpl implements IFileService
{
	@Autowired
	private FileMapper fileMapper;
	@Value("${project.file.host}") //生成的文件外网访问IP
	private String fileHost;
	/**
     * 查询附件信息
     * 
     * @param fileId 附件ID
     * @return 附件信息
     */
    @Override
	public File selectFileById(String fileId)
	{
	    return fileMapper.selectFileById(fileId);
	}
	
	/**
     * 查询附件列表
     * 
     * @param file 附件信息
     * @return 附件集合
     */
	@Override
	public List<File> selectFileList(File file)
	{
	    return fileMapper.selectFileList(file);
	}

    /**
     * 新增附件
     *
     * @param file 附件信息
     * @return 结果
     */
	@Override
	public int insertFile(File file)
	{

		file.setCreateTime(new Date());
		file.setState(0);
		file.setCreaterUserId(ShiroUtils.getUserId().toString());
		return fileMapper.insertFile(file);
	}
	
	/**
     * 修改附件
     * 
     * @param file 附件信息
     * @return 结果
     */
	@Override
	public int updateFile(File file)
	{
		return fileMapper.updateFile(file);
	}

	/**
     * 删除附件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFileByIds(String ids)
	{
		return fileMapper.deleteFileByIds(Convert.toStrArray(ids));
	}
	/**
	 * 附件上传
	 * @param sourceType 来源类型 FileSourceTypeEnum 枚举
	 * @param sourceId 来源ID
	 * @param fileName 附加中文名称
	 * @param multipartFile 附件file
	 * @param state 附件状态 0-正式，2-临时
	 * @param
	 * @return  附件路径
	 */
	@Override
	public String upolad(String sourceType, String sourceId, String fileName, MultipartFile multipartFile, Integer state,String bussinessId) throws IOException {
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM");
		//按日期和企业id生成文件夹
		String path= java.io.File.separator+sdf.format(date)+ java.io.File.separator+bussinessId;
		path=path+java.io.File.separator+FileUploadUtils.upload(FileUploadUtils.getDefaultBaseDir()+ path,multipartFile);
		File file=new File();
		file.setFilePath(path);
		file.setFileName(fileName);
		file.setSourceType(sourceType);
		file.setSourceId(sourceId);
		file.setState(state);
		file.setFileId(UUIDUtil.getUUID());
		file.setCreateTime(new Date());
		file.setMemo(sourceType+" 上传附件:"+fileName);
		file.setCreaterUserId(ShiroUtils.getUserId().toString());
		if(fileMapper.insertFile(file)==0){
			throw new RuntimeException("附件信息保存失败");
		}
		return fileHost+path ;
	}

	public static void main(String[] args) {
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM");
		System.out.println(sdf.format(date));
	}

}
