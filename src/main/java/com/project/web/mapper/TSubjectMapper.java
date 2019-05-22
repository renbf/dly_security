package com.project.web.mapper;

import com.project.web.domian.TSubject;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 题库 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tSubjectMapper")
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
	
	
	/**
     *	根据题库id 进行分组列表查询
     * 
     * @param tSubject 题库信息
     * @return 题库集合
     */
	public List<TSubject> selectTSubjectListByOne(TSubject tSubject);
	
	/**
     *	根据题库id 进行查询
     * 
     * @param tSubject 题库信息
     * @return 题库集合
     */
	public List<TSubject> selectTSubjectListByPageId(String[] ids);
	
	/**
     *	换题的时候，查询出本企业下  未生成题库的剩余题 
     */
	public List<TSubject> selectTSubjectListByBusiness(TSubject tSubject);
	
	/**
     *	根据题库id 进行查询题的所有信息 包含分数 (换题时用)
     * 
     * @param tSubject 题库信息
     * @return 题库集合
     */
	public List<TSubject> selectTSubjectListAllByPageId(TSubject tSubject);

	
}