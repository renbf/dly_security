package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.TimeUuidUtil;
import com.project.framework.util.ShiroUtils;
import com.project.web.domian.Post;
import com.project.web.domian.TUsersManagement;
import com.project.web.mapper.PostMapper;
import com.project.web.service.IPostService;
import com.project.web.service.ITUsersManagementService;

/**
 * 岗位 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class PostServiceImpl implements IPostService 
{
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private ITUsersManagementService tUsersManagementService;

	/**
     * 查询岗位信息
     * 
     * @param postId 岗位ID
     * @return 岗位信息
     */
    @Override
	public Post selectPostById(Long postId)
	{
	    return postMapper.selectPostById(postId);
	}
	
	/**
     * 查询岗位列表
     * 
     * @param post 岗位信息
     * @return 岗位集合
     */
	@Override
	public List<Post> selectPostList(Post post)
	{
	    return postMapper.selectPostList(post);
	}
	
    /**
     * 新增岗位
     * 
     * @param post 岗位信息
     * @return 结果
     */
	@Override
	public AjaxResult insertPost(Post post)
	{
	    if(post==null || post.getPostName() ==null || "".equals(post.getPostName()) ) {
	    	return AjaxResult.error(2, "岗位名称不能为空");
	    }
	    if(post.getDeptId()==null) {
	    	return AjaxResult.error(2, "部门不能为空");
	    }
	    post.setPostId(TimeUuidUtil.get16UUID());
	    post.setCreateTime(new Date());
	    post.setCreateBy(ShiroUtils.getLoginName());
	    post.setPostCode("0");
	    post.setPostSort(0);
	    post.setStatus("0");//正常
	    int i =  postMapper.insertPost(post);
	    if(i==1) {
	    	return AjaxResult.success();
	    }else {
	    	return AjaxResult.error(2, "操作失败");
	    }
	}
	
	/**
     * 修改岗位
     * 
     * @param post 岗位信息
     * @return 结果
     */
	@Override
	public AjaxResult updatePost(Post post)
	{
		 if(post==null || post.getPostName() ==null || "".equals(post.getPostName()) ) {
		    	return AjaxResult.error(2, "岗位名称不能为空");
		    }
		    if(post.getDeptId()==null) {
		    	return AjaxResult.error(2, "部门不能为空");
		    }
		    
		    int i = postMapper.updatePost(post);
		    if(i==1) {
		    	return AjaxResult.success();
		    }else {
		    	return AjaxResult.error(2, "操作失败");
		    }
	}

	/**
     * 删除岗位对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public AjaxResult deletePostByIds(String ids)
	{
		//删除岗位之前,先判断下面是否存在人员  若存在 则不允许删除
		TUsersManagement tu =new TUsersManagement();
		tu.setManagementPost(Long.valueOf(ids));
		List<TUsersManagement> tuList= tUsersManagementService.selectTUsersManagementListByPostId(tu);
		if(tuList!=null && tuList.size() >0) {
			AjaxResult.error(2, "该岗位下面存在人员,不允许删除岗位");
		}
		int i =  postMapper.deletePostByIds(Convert.toStrArray(ids));
		if(i>=0) {
			return AjaxResult.success();
		}
		 return AjaxResult.error();
	}

	@Override
	public List<Post> selectPostListByDept(Post post) {
		
		return postMapper.selectPostListByDept(post);
	}
	
}
