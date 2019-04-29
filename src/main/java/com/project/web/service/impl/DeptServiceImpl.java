package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.TimeUuidUtil;
import com.project.framework.util.ShiroUtils;
import com.project.system.domain.SysDept;
import com.project.web.domian.Dept;
import com.project.web.domian.Post;
import com.project.web.mapper.DeptMapper;
import com.project.web.service.IDeptService;
import com.project.web.service.IPostService;

/**
 * 部门 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class DeptServiceImpl implements IDeptService 
{
	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private IPostService postService;

	/**
     * 查询部门信息
     * 
     * @param deptId 部门ID
     * @return 部门信息
     */
    @Override
	public Dept selectDeptById(Long deptId)
	{
	    return deptMapper.selectDeptById(deptId);
	}
	
	/**
     * 查询部门列表
     * 
     * @param dept 部门信息
     * @return 部门集合
     */
	@Override
	public List<Dept> selectDeptList(Dept dept)
	{
	    return deptMapper.selectDeptList(dept);
	}
	
	/**
     * 查询部门列表
     * 
     * @param dept 部门信息
     * @return 部门集合
     */
	@Override
	public List<Dept> selectDeptListByBus(Dept dept)
	{
	    return deptMapper.selectDeptListByBusiness(dept);
	}
	
    /**
     * 新增部门
     * 
     * @param dept 部门信息
     * @return 结果
     */
	@Override
	public AjaxResult insertDept(Dept dept)
	{
		if(dept==null || dept.getDeptName() ==null || "".equals(dept.getDeptName()) || "".equals(dept.getDeptName().trim())){
			return AjaxResult.error(2, "部门名称不能为空");
		}
		//新增部门之前先查询 该企业下新增部门是否已存在 
    	List<Dept> temp=deptMapper.selectDeptList(dept);
    	if(temp!=null && temp.size()>0) {
    		return AjaxResult.error(2, "该部门已存在,请重新设置");
    	}
        dept.setDeptId(TimeUuidUtil.get16UUID());
        dept.setCreateBy(ShiroUtils.getLoginName());
        dept.setStatus("0");
        dept.setCreateTime(new Date());
        dept.setJbdm("0");
        int i=deptMapper.insertDept(dept);
        if(i==1) {
        	return AjaxResult.success();
        }else {
        	return AjaxResult.error(2, "操作失败");
        }
	}
	
	/**
     * 修改部门
     * 
     * @param dept 部门信息
     * @return 结果
     */
	@Override
	public AjaxResult updateDept(Dept dept)
	{
		
		if(dept==null || dept.getDeptName() ==null || "".equals(dept.getDeptName()) || "".equals(dept.getDeptName().trim())){
			return AjaxResult.error(2, "部门名称不能为空");
		}
		Dept t =new Dept();
		t.setDeptName(dept.getDeptName());
		t.setBusinessId(dept.getBusinessId());
		//修改部门之前先查询 该企业下新增部门是否已存在 
    	List<Dept> temp=deptMapper.selectDeptList(t);
    	if(temp!=null && temp.size()>0) {
    		return AjaxResult.error(2, "该部门已存在,请重新设置");
    	}   	
		dept.setUpdateTime(new Date());
		dept.setUpdateBy(ShiroUtils.getLoginName());
		int i=  deptMapper.updateDept(dept);
		if(i==1) {
        	return AjaxResult.success();
        }else {
        	return AjaxResult.error(2, "操作失败");
        }
	}

	/**
     * 删除部门对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public AjaxResult deleteDeptByIds(String ids)
	{
		//删除部门时,首先查询部门下面是否有岗位，若有则不允许删除
		Post po =new Post();
		po.setDeptId(Long.valueOf(ids));
		List<Post> postList=postService.selectPostListByDept(po);
		if(postList!=null && postList.size()>0) {
			return AjaxResult.error(2, "该部门下存在岗位,不能进行删除");
		}
		int i = deptMapper.deleteDeptByIds(Convert.toStrArray(ids));
		if(i>=1) {
			return AjaxResult.success();
		}
		return AjaxResult.error();
	}
	
}
