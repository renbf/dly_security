package com.project.security.mapper;

import com.project.security.domain.TSubjectOption;
import java.util.List;	

/**
 * 题库选项关系 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface TSubjectOptionMapper 
{
	/**
     * 查询题库选项关系信息
     * 
     * @param subjectId 题库选项关系ID
     * @return 题库选项关系信息
     */
	public TSubjectOption selectTSubjectOptionById(String subjectId);
	
	/**
     * 查询题库选项关系列表
     * 
     * @param tSubjectOption 题库选项关系信息
     * @return 题库选项关系集合
     */
	public List<TSubjectOption> selectTSubjectOptionList(TSubjectOption tSubjectOption);
	
	/**
     * 新增题库选项关系
     * 
     * @param tSubjectOption 题库选项关系信息
     * @return 结果
     */
	public int insertTSubjectOption(TSubjectOption tSubjectOption);
	
	/**
     * 修改题库选项关系
     * 
     * @param tSubjectOption 题库选项关系信息
     * @return 结果
     */
	public int updateTSubjectOption(TSubjectOption tSubjectOption);
	
	/**
     * 删除题库选项关系
     * 
     * @param subjectId 题库选项关系ID
     * @return 结果
     */
	public int deleteTSubjectOptionById(String subjectId);
	
	/**
     * 批量删除题库选项关系
     * 
     * @param subjectIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSubjectOptionByIds(String[] subjectIds);
	//以上自动生成的尽量别动
}