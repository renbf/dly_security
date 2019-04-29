package com.project.web.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.Post;
import com.project.web.service.IPostService;
import com.project.web.service.ITUsersManagementService;


/**
 * 岗位 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/webPost")
public class WebPostController extends BaseController
{
    private String prefix = "security/post";
	
	@Autowired
	private IPostService postService;
	@Autowired
	private ITUsersManagementService tUsersManagementService;
	
	@RequiresPermissions("security:post:view")
	@GetMapping()
	public String post()
	{
	    return prefix + "/post";
	}
	
	/**
	 * 查询岗位列表
	 */
//	@RequiresPermissions("security:post:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Post post)
	{
		startPage();
        List<Post> list = postService.selectPostList(post);
		return getDataTable(list);
	}
	
	
	/**
	 * 查询岗位列表
	 */
//	@RequiresPermissions("security:post:list")
	@PostMapping("/listByDept")
	@ResponseBody
	public AjaxResult listByDept(Post post)
	{
		AjaxResult aj =AjaxResult.success();
        List<Post> list = postService.selectPostListByDept(post);
        aj.put("data", list);
		return aj;
	}
	/**
	 * 新增岗位
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存岗位
	 */
//	@RequiresPermissions("security:post:add")
	@Log(title = "岗位", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Post post)
	{		
		return postService.insertPost(post);
	}

	/**
	 * 修改岗位
	 */
	@GetMapping("/edit/{postId}")
	public String edit(@PathVariable("postId") Long postId, ModelMap mmap)
	{
		Post post = postService.selectPostById(postId);
		mmap.put("post", post);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存岗位
	 */
//	@RequiresPermissions("security:post:edit")
	@Log(title = "岗位", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Post post)
	{		
		return postService.updatePost(post);
	}
	
	/**
	 * 删除岗位
	 */
//	@RequiresPermissions("security:post:remove")
	@Log(title = "岗位", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return postService.deletePostByIds(ids);
	}
	
}
