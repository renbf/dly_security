package com.project.security.mapper;

import com.project.security.domain.TUserSubject;
import java.util.List;	

/**
 * 用户答题记录 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface TUserSubjectMapper 
{
	/**
     * 查询用户答题记录信息
     * 
     * @param id 用户答题记录ID
     * @return 用户答题记录信息
     */
	public TUserSubject selectTUserSubjectById(String id);
	
	/**
     * 查询用户答题记录列表
     * 
     * @param tUserSubject 用户答题记录信息
     * @return 用户答题记录集合
     */
	public List<TUserSubject> selectTUserSubjectList(TUserSubject tUserSubject);
	
	/**
     * 新增用户答题记录
     * 
     * @param tUserSubject 用户答题记录信息
     * @return 结果
     */
	public int insertTUserSubject(TUserSubject tUserSubject);
	
	/**
     * 修改用户答题记录
     * 
     * @param tUserSubject 用户答题记录信息
     * @return 结果
     */
	public int updateTUserSubject(TUserSubject tUserSubject);
	
	/**
     * 删除用户答题记录
     * 
     * @param id 用户答题记录ID
     * @return 结果
     */
	public int deleteTUserSubjectById(String id);
	
	/**
     * 批量删除用户答题记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserSubjectByIds(String[] ids);
	//以上自动生成的尽量别动
}