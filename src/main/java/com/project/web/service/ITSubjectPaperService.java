package com.project.web.service;

import com.project.web.domian.TSubjectPaper;
import java.util.List;

/**
 * 考卷题目关系 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITSubjectPaperService 
{
	/**
     * 查询考卷题目关系信息
     * 
     * @param paperId 考卷题目关系ID
     * @return 考卷题目关系信息
     */
	public TSubjectPaper selectTSubjectPaperById(String paperId);
	
	/**
     * 查询考卷题目关系列表
     * 
     * @param tSubjectPaper 考卷题目关系信息
     * @return 考卷题目关系集合
     */
	public List<TSubjectPaper> selectTSubjectPaperList(TSubjectPaper tSubjectPaper);
	
	/**
     * 新增考卷题目关系
     * 
     * @param tSubjectPaper 考卷题目关系信息
     * @return 结果
     */
	public int insertTSubjectPaper(TSubjectPaper tSubjectPaper);
	
	/**
     * 修改考卷题目关系
     * 
     * @param tSubjectPaper 考卷题目关系信息
     * @return 结果
     */
	public int updateTSubjectPaper(TSubjectPaper tSubjectPaper);
		
	/**
     * 删除考卷题目关系信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSubjectPaperByIds(String ids);
	//以上自动生成的尽量别动
}
