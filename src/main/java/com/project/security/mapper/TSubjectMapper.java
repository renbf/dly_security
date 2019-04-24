package com.project.security.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.security.domain.TSubject;
import com.project.security.domain.vo.TSubjectVo;	

/**
 * 题库 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Repository("subjectMapper")
public interface TSubjectMapper 
{
	/**
     * 查询题库信息
     * 
     * @param id 题库ID
     * @return 题库信息
     */
	public TSubject selectTSubjectById(String id);
	
	/**
     * 查询题库列表
     * 
     * @param tSubject 题库信息
     * @return 题库集合
     */
	public List<TSubject> selectTSubjectList(TSubject tSubject);
	
	/**
     * 新增题库
     * 
     * @param tSubject 题库信息
     * @return 结果
     */
	public int insertTSubject(TSubject tSubject);
	
	/**
     * 修改题库
     * 
     * @param tSubject 题库信息
     * @return 结果
     */
	public int updateTSubject(TSubject tSubject);
	
	/**
     * 删除题库
     * 
     * @param id 题库ID
     * @return 结果
     */
	public int deleteTSubjectById(String id);
	
	/**
     * 批量删除题库
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSubjectByIds(String[] ids);
	//以上自动生成的尽量别动
	
	public List<TSubjectVo> examCollection(String userId);
}