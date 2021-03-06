package com.project.web.mapper;

import com.project.web.domian.TSubjectPaper;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 考卷题目关系 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tSubjectPaperMapper")
public interface TSubjectPaperMapper 
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
     * 删除考卷题目关系
     * 
     * @param paperId 考卷题目关系ID
     * @return 结果
     */
	public int deleteTSubjectPaperById(String paperId);
	
	/**
     * 批量删除考卷题目关系
     * 
     * @param paperIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSubjectPaperByIds(String[] paperIds);
	//以上自动生成的尽量别动
	
	
	/**
     * 	删除试卷下的题库
     * 
     * @param paperId 考卷题目关系ID
     * @return 结果
     */
	public int deleteTSubjectPaperBySubId(TSubjectPaper tSubjectPaper);
	
	
}