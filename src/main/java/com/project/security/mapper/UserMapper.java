package com.project.security.mapper;

import java.util.List;

import com.project.system.domain.SysUser;	

/**
 * 用户 数据层
 * 
 * @author rbf
 * @date 2019-04-15
 */
public interface UserMapper 
{
	/**
     * 查询用户信息
     * 
     * @param userId 用户ID
     * @return 用户信息
     */
	public SysUser selectUserById(Long userId);
	
	/**
     * 查询用户列表
     * 
     * @param user 用户信息
     * @return 用户集合
     */
	public List<SysUser> selectUserList(SysUser user);
	
	/**
     * 新增用户
     * 
     * @param user 用户信息
     * @return 结果
     */
	public int insertUser(SysUser user);
	
	/**
     * 修改用户
     * 
     * @param user 用户信息
     * @return 结果
     */
	public int updateUser(SysUser user);
	
	/**
     * 删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
	public int deleteUserById(Long userId);
	
	/**
     * 批量删除用户
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserByIds(String[] userIds);
	//以上自动生成的尽量别动
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public SysUser selectUserByLoginName(String userName);
	
	
	/**
     * 更新认证图片
     * @param user
     * @return
     */
    public int updateUserAuth(SysUser user);
    
}