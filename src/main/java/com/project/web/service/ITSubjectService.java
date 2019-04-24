package com.project.web.service;

import com.project.web.domian.TSubject;
import java.util.List;

/**
 * 题库 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITSubjectService 
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
     * 删除题库信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSubjectByIds(String ids);
	//以上自动生成的尽量别动
}
