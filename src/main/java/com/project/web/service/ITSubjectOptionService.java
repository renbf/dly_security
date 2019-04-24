package com.project.web.service;

import com.project.web.domian.TSubjectOption;
import java.util.List;

/**
 * 题库选项关系 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITSubjectOptionService 
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
     * 删除题库选项关系信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSubjectOptionByIds(String ids);
	//以上自动生成的尽量别动
}
