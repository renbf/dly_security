package com.project.web.service;

import com.project.common.enums.FileSourceTypeEnum;
import com.project.web.domian.File;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 附件 服务层
 * 
 * @author lws
 * @date 2019-02-22
 */
public interface IFileService 
{
	/**
     * 查询附件信息
     * 
     * @param fileId 附件ID
     * @return 附件信息
     */
	public File selectFileById(String fileId);
	
	/**
     * 查询附件列表
     * 
     * @param file 附件信息
     * @return 附件集合
     */
	public List<File> selectFileList(File file);
	
	/**
     * 新增附件
     * 
     * @param file 附件信息
     * @return 结果
     */
	public int insertFile(File file);
	
	/**
     * 修改附件
     * 
     * @param file 附件信息
     * @return 结果
     */
	public int updateFile(File file);
		
	/**
     * 删除附件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFileByIds(String ids);

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
	public String upolad(String sourceType, String sourceId, String fileName, MultipartFile multipartFile,Integer state) throws IOException;
}
