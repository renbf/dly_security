package com.project.web.service;

import com.project.common.base.AjaxResult;
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
     * 	查询题库所有列表 选项为一条数据的拼接
     * 
     * @param tSubject 题库信息
     * @return 题库集合
     */
	public List<TSubject> selectTSubjectListByOneData(TSubject tSubject);
	
	
	/**
     * 新增题库
     * 
     * @param tSubject 题库信息
     * @return 结果
     */
	public AjaxResult insertTSubject(TSubject tSubject);
	
	/**
     * 修改题库
     * 
     * @param tSubject 题库信息
     * @return 结果
     */
	public AjaxResult updateTSubject(TSubject tSubject);
		
	/**
     * 删除题库信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSubjectByIds(String ids);
	//以上自动生成的尽量别动
	
	//根据题库id 查询出下面的题
	public List<TSubject> selectTPaperListByPageId(String ids);
	//根据试卷ID查询出本企业未生成题库的题
	public List<TSubject> selectTPaperListByNotInPageId(TSubject tSubject);
	
	//根据试卷ID查询出本企业生成题库的题 包含分数等信息   换题时用
	public List<TSubject> selectTPaperListAllByInPageId(TSubject tSubject);
	
}
