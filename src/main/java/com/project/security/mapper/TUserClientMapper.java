package com.project.security.mapper;

import com.project.security.domain.TUserClient;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 用户和设备关系 数据层
 * 
 * @author rbf
 * @date 2019-04-30
 */
 @Repository("userClientMapper")
public interface TUserClientMapper 
{
	/**
     * 查询用户和设备关系信息
     * 
     * @param userId 用户和设备关系ID
     * @return 用户和设备关系信息
     */
	public TUserClient selectTUserClientById(Long userId);
	
	/**
     * 查询用户和设备关系列表
     * 
     * @param tUserClient 用户和设备关系信息
     * @return 用户和设备关系集合
     */
	public List<TUserClient> selectTUserClientList(TUserClient tUserClient);
	
	/**
     * 新增用户和设备关系
     * 
     * @param tUserClient 用户和设备关系信息
     * @return 结果
     */
	public int insertTUserClient(TUserClient tUserClient);
	
	/**
     * 修改用户和设备关系
     * 
     * @param tUserClient 用户和设备关系信息
     * @return 结果
     */
	public int updateTUserClient(TUserClient tUserClient);
	
	/**
     * 删除用户和设备关系
     * 
     * @param userId 用户和设备关系ID
     * @return 结果
     */
	public int deleteTUserClientById(Long userId);
	
	/**
     * 批量删除用户和设备关系
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserClientByIds(String[] userIds);
	//以上自动生成的尽量别动
}