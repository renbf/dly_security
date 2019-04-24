package com.project.web.service;

import com.project.web.domian.TUserSubjectCollect;
import java.util.List;

/**
 * 用户收藏记录 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITUserSubjectCollectService 
{
	/**
     * 查询用户收藏记录信息
     * 
     * @param userId 用户收藏记录ID
     * @return 用户收藏记录信息
     */
	public TUserSubjectCollect selectTUserSubjectCollectById(String userId);
	
	/**
     * 查询用户收藏记录列表
     * 
     * @param tUserSubjectCollect 用户收藏记录信息
     * @return 用户收藏记录集合
     */
	public List<TUserSubjectCollect> selectTUserSubjectCollectList(TUserSubjectCollect tUserSubjectCollect);
	
	/**
     * 新增用户收藏记录
     * 
     * @param tUserSubjectCollect 用户收藏记录信息
     * @return 结果
     */
	public int insertTUserSubjectCollect(TUserSubjectCollect tUserSubjectCollect);
	
	/**
     * 修改用户收藏记录
     * 
     * @param tUserSubjectCollect 用户收藏记录信息
     * @return 结果
     */
	public int updateTUserSubjectCollect(TUserSubjectCollect tUserSubjectCollect);
		
	/**
     * 删除用户收藏记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserSubjectCollectByIds(String ids);
	//以上自动生成的尽量别动
}
