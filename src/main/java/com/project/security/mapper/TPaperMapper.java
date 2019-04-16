package com.project.security.mapper;

import com.project.security.domain.TPaper;
import java.util.List;	

/**
 * 考卷 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface TPaperMapper 
{
	/**
     * 查询考卷信息
     * 
     * @param id 考卷ID
     * @return 考卷信息
     */
	public TPaper selectTPaperById(String id);
	
	/**
     * 查询考卷列表
     * 
     * @param tPaper 考卷信息
     * @return 考卷集合
     */
	public List<TPaper> selectTPaperList(TPaper tPaper);
	
	/**
     * 新增考卷
     * 
     * @param tPaper 考卷信息
     * @return 结果
     */
	public int insertTPaper(TPaper tPaper);
	
	/**
     * 修改考卷
     * 
     * @param tPaper 考卷信息
     * @return 结果
     */
	public int updateTPaper(TPaper tPaper);
	
	/**
     * 删除考卷
     * 
     * @param id 考卷ID
     * @return 结果
     */
	public int deleteTPaperById(String id);
	
	/**
     * 批量删除考卷
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTPaperByIds(String[] ids);
	//以上自动生成的尽量别动
}