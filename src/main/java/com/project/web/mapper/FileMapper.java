package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.File;

/**
 * 附件 数据层
 * 
 * @author lws
 * @date 2019-02-22
 */
public interface FileMapper 
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
     * 删除附件
     * 
     * @param fileId 附件ID
     * @return 结果
     */
	public int deleteFileById(String fileId);
	
	/**
     * 批量删除附件
     * 
     * @param fileIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteFileByIds(String[] fileIds);
	
}