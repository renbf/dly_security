package com.project.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.web.domian.TBusinessFile;

/**
 * 企业文件 服务层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface ITBusinessFileService 
{
	/**
     * 查询企业文件信息
     * 
     * @param id 企业文件ID
     * @return 企业文件信息
     */
	public TBusinessFile selectTBusinessFileById(String id);
	
	/**
     * 查询企业文件列表
     * 
     * @param tBusinessFile 企业文件信息
     * @return 企业文件集合
     */
	public List<TBusinessFile> selectTBusinessFileList(TBusinessFile tBusinessFile);
	
	/**
     * 新增企业文件
     * 
     * @param tBusinessFile 企业文件信息
     * @return 结果
     */
	public int insertTBusinessFile(TBusinessFile tBusinessFile,MultipartFile businessFile);
	
	/**
     * 修改企业文件
     * 
     * @param tBusinessFile 企业文件信息
     * @return 结果
     */
	public int updateTBusinessFile(TBusinessFile tBusinessFile,MultipartFile businessFile);
		
	/**
     * 删除企业文件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTBusinessFileByIds(String ids);
	
}
