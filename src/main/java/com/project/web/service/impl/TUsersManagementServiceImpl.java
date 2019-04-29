package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.TimeUuidUtil;
import com.project.framework.shiro.service.PasswordService;
import com.project.framework.util.ShiroUtils;
import com.project.system.domain.SysUser;
import com.project.system.service.ISysUserService;
import com.project.util.UUIDUtil;
import com.project.web.domian.TUsersManagement;
import com.project.web.mapper.TUsersManagementMapper;
import com.project.web.service.ITUsersManagementService;

/**
 * 人员台账 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TUsersManagementServiceImpl implements ITUsersManagementService 
{
	@Autowired
	private TUsersManagementMapper tUsersManagementMapper;	
	@Autowired
	private ISysUserService userService;
	
	@Autowired
    private PasswordService passwordService;

	/**
     * 查询人员台账信息
     * 
     * @param id 人员台账ID
     * @return 人员台账信息
     */
    @Override
	public TUsersManagement selectTUsersManagementById(String id)
	{
	    return tUsersManagementMapper.selectTUsersManagementById(id);
	}
	
	/**
     * 查询人员台账列表
     * 
     * @param tUsersManagement 人员台账信息
     * @return 人员台账集合
     */
	@Override
	public List<TUsersManagement> selectTUsersManagementList(TUsersManagement tUsersManagement)
	{
	    return tUsersManagementMapper.selectTUsersManagementList(tUsersManagement);
	}
	
    /**
     * 新增人员台账
     * 
     * @param tUsersManagement 人员台账信息
     * @return 结果
     */
	@Override
//    @Transactional
	public AjaxResult insertTUsersManagement(TUsersManagement tUsersManagement)
	{
		/**
		 * 新增用户时，也需要向sys_user表插入一条数据
		 */
		if(tUsersManagement ==null || tUsersManagement.getManagementName()==null || "".equals(tUsersManagement.getManagementName())) {
			AjaxResult.error(2, "姓名不能为空");
		}
		if(tUsersManagement.getManagementSex()==null || "".equals(tUsersManagement.getManagementSex())) {
			AjaxResult.error(2, "性别不能为空");
		}
		if(tUsersManagement.getManagementPhone()==null || "".equals(tUsersManagement.getManagementPhone())) {
			AjaxResult.error(2, "手机号不能为空");
		}
		if(tUsersManagement.getManagementDeptId()==null ) {
			AjaxResult.error(2, "任职部门不能为空");
		}
		if(tUsersManagement.getManagementPost()==null ) {
			AjaxResult.error(2, "任职岗位不能为空");
		}
//		//校验输入的手机号是否存在
		SysUser userTemp =new SysUser();
		userTemp.setPhonenumber(tUsersManagement.getManagementPhone());
		String j= userService.checkPhoneUnique(userTemp);
		if("1".equals(j)) {
			AjaxResult.error(2, "该手机号已存在");
		}
		SysUser user =new SysUser();
		long uuid = TimeUuidUtil.get16UUID();//生成的user_id
		user.setSalt(ShiroUtils.randomSalt());
	    user.setPassword(passwordService.encryptPassword(user.getLoginName(), "123456", user.getSalt()));//默认密码
	    user.setCreateBy(ShiroUtils.getLoginName());
	    user.setCreateTime(new Date());
	    user.setDeptId(tUsersManagement.getManagementDeptId());//部门ID
	    user.setLoginName(tUsersManagement.getManagementPhone());//登录账号 就是手机号
	    user.setUserName(tUsersManagement.getManagementName());//用户姓名
	    user.setEmail(tUsersManagement.getManagementEmail());//用户邮箱
	    user.setPhonenumber(tUsersManagement.getManagementPhone());//手机号码	    
	    userService.insertUserByManagement(user, uuid);//新增一条数据	    
		tUsersManagement.setId(UUIDUtil.getUUID());
		tUsersManagement.setManagementUserId(uuid);
		tUsersManagement.setCreateTime(new Date());
		tUsersManagement.setCreateBy(ShiroUtils.getLoginName());
		int i =tUsersManagementMapper.insertTUsersManagement(tUsersManagement);
		if(i==0) {
			return AjaxResult.error(2, "操作失败");
		}else {
			return AjaxResult.success();
		}
		 
	}
	
	/**
     * 修改人员台账
     * 
     * @param tUsersManagement 人员台账信息
     * @return 结果
     */
	@Override
	public int updateTUsersManagement(TUsersManagement tUsersManagement)
	{
	    return tUsersManagementMapper.updateTUsersManagement(tUsersManagement);
	}

	/**
     * 删除人员台账对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUsersManagementByIds(String ids)
	{
		return tUsersManagementMapper.deleteTUsersManagementByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<TUsersManagement> selectTUsersManagementListByPostId(TUsersManagement tUsersManagement) {
		
		return tUsersManagementMapper.selectTUsersManagementListByPostId(tUsersManagement);
	}
	
}
