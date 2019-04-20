package com.project.security.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户表 sys_user
 * 
 * @author rbf
 * @date 2019-04-19
 */
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 用户ID */
	private Long userId;
	/** 部门ID */
	private Long deptId;
	/** 登录账号 */
	private String loginName;
	/** 用户昵称 */
	private String userName;
	/** 用户类型（00系统用户） */
	private String userType;
	/** 用户邮箱 */
	private String email;
	/** 手机号码 */
	private String phonenumber;
	/** 用户性别（0男 1女 2未知） */
	private String sex;
	/** 头像路径 */
	private String avatar;
	/** 密码 */
	private String password;
	/** 盐加密 */
	private String salt;
	/** 帐号状态（0正常 1停用） */
	private String status;
	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;
	/** 最后登陆IP */
	private String loginIp;
	/** 最后登陆时间 */
	private Date loginDate;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;
	/** 是否为认证用户0没有认证，1认证 */
	private String isAuth;
	/** 企业id */
	private String businessId;
	/** 认证图片url */
	private String authUrl;

	/** 部门名称 */
	private String deptName;
	/** 岗位名称 */
	private String postName;
	/** 企业名称 */
	private String businessName;
	
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setDeptId(Long deptId) 
	{
		this.deptId = deptId;
	}

	public Long getDeptId() 
	{
		return deptId;
	}
	public void setLoginName(String loginName) 
	{
		this.loginName = loginName;
	}

	public String getLoginName() 
	{
		return loginName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserType(String userType) 
	{
		this.userType = userType;
	}

	public String getUserType() 
	{
		return userType;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setPhonenumber(String phonenumber) 
	{
		this.phonenumber = phonenumber;
	}

	public String getPhonenumber() 
	{
		return phonenumber;
	}
	public void setSex(String sex) 
	{
		this.sex = sex;
	}

	public String getSex() 
	{
		return sex;
	}
	public void setAvatar(String avatar) 
	{
		this.avatar = avatar;
	}

	public String getAvatar() 
	{
		return avatar;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	public void setSalt(String salt) 
	{
		this.salt = salt;
	}

	public String getSalt() 
	{
		return salt;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}
	public void setLoginIp(String loginIp) 
	{
		this.loginIp = loginIp;
	}

	public String getLoginIp() 
	{
		return loginIp;
	}
	public void setLoginDate(Date loginDate) 
	{
		this.loginDate = loginDate;
	}

	public Date getLoginDate() 
	{
		return loginDate;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setIsAuth(String isAuth) 
	{
		this.isAuth = isAuth;
	}

	public String getIsAuth() 
	{
		return isAuth;
	}
	public void setBusinessId(String businessId) 
	{
		this.businessId = businessId;
	}

	public String getBusinessId() 
	{
		return businessId;
	}
	public void setAuthUrl(String authUrl) 
	{
		this.authUrl = authUrl;
	}

	public String getAuthUrl() 
	{
		return authUrl;
	}

    public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("loginName", getLoginName())
            .append("userName", getUserName())
            .append("userType", getUserType())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("sex", getSex())
            .append("avatar", getAvatar())
            .append("password", getPassword())
            .append("salt", getSalt())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("isAuth", getIsAuth())
            .append("businessId", getBusinessId())
            .append("authUrl", getAuthUrl())
            .toString();
    }
}
