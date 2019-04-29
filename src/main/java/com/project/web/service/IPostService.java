package com.project.web.service;

import java.util.List;

import com.project.common.base.AjaxResult;
import com.project.web.domian.Post;

/**
 * 岗位 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface IPostService 
{
	/**
     * 查询岗位信息
     * 
     * @param postId 岗位ID
     * @return 岗位信息
     */
	public Post selectPostById(Long postId);
	
	/**
     * 查询岗位列表
     * 
     * @param post 岗位信息
     * @return 岗位集合
     */
	public List<Post> selectPostList(Post post);
	
	/**
     * 查询岗位列表
     * 
     * @param post 岗位信息
     * @return 岗位集合
     */
	public List<Post> selectPostListByDept(Post post);
	/**
     * 新增岗位
     * 
     * @param post 岗位信息
     * @return 结果
     */
	public AjaxResult insertPost(Post post);
	
	/**
     * 修改岗位
     * 
     * @param post 岗位信息
     * @return 结果
     */
	public AjaxResult updatePost(Post post);
		
	/**
     * 删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public AjaxResult deletePostByIds(String ids);
	
}
