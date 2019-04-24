package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TBusinessFile;	

/**
 * 企业文件 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TBusinessFileMapper 
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
	public int insertTBusinessFile(TBusinessFile tBusinessFile);
	
	/**
     * 修改企业文件
     * 
     * @param tBusinessFile 企业文件信息
     * @return 结果
     */
	public int updateTBusinessFile(TBusinessFile tBusinessFile);
	
	/**
     * 删除企业文件
     * 
     * @param id 企业文件ID
     * @return 结果
     */
	public int deleteTBusinessFileById(String id);
	
	/**
     * 批量删除企业文件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTBusinessFileByIds(String[] ids);
	
}