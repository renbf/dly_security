package com.project.web.mapper;

import com.project.web.domian.TUserSubjectCollect;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 用户收藏记录 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tUserSubjectCollectMapper")
public interface TUserSubjectCollectMapper 
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
     * 删除用户收藏记录
     * 
     * @param userId 用户收藏记录ID
     * @return 结果
     */
	public int deleteTUserSubjectCollectById(String userId);
	
	/**
     * 批量删除用户收藏记录
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserSubjectCollectByIds(String[] userIds);
	//以上自动生成的尽量别动
}