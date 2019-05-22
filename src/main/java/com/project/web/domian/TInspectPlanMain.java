package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 检查计划主表 t_inspect_plan_main
 *
 * @author rbf
 * @date 2019-05-05
 */
public class TInspectPlanMain extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id 标题id
     */
    private String titleId;
    /**
     * 标题       #$
     */
    private String checkTitle;
    /**
     * 年度
     */
    private String checkYear;
    /**
     * 计划检查时间       ##
     */
    private Date checkTime;
    /**
     * 检查类型     #
     */
    private String checkType;
    /**
     * 备注
     */
    private String remark;
    /**
     * 企业id
     */
    private String businessId;
    /**
     * 创建人id
     */
    private String addUserId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 修改人id
     */
    private String updateUserId;


    /*查询输入新增*/
    private Date checkTime1;
    //负责人姓名     #$
    private String userName;
    //部门id
    private String deptId;
    //部门名称
    //private String deptName;
    //检查项目名称   #$
    private String projectName;
    /*查询输出新增*/
    private String checkTimeStr;
    private String createDateStr;
    private String checkTypeName;

    /*添加输入新增*/
    private List<InsertUserInfo> insertUserInfos;
    private List<String> projects;


    //public String getDeptName() {
    //    return deptName;
    //}
    //
    //public TInspectPlanMain setDeptName(String deptName) {
    //    this.deptName = deptName;
    //    return this;
    //}

    public String getDeptId() {
        return deptId;
    }

    public TInspectPlanMain setDeptId(String deptId) {
        this.deptId = deptId;
        return this;
    }

    public String getCheckTypeName() {
        return checkTypeName;
    }

    public TInspectPlanMain setCheckTypeName(String checkTypeName) {
        this.checkTypeName = checkTypeName;
        return this;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public TInspectPlanMain setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
        return this;
    }

    public Date getCheckTime1() {
        return checkTime1;
    }

    public TInspectPlanMain setCheckTime1(Date checkTime1) {
        this.checkTime1 = checkTime1;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public TInspectPlanMain setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public TInspectPlanMain setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getCheckTimeStr() {
        return checkTimeStr;
    }

    public TInspectPlanMain setCheckTimeStr(String checkTimeStr) {
        this.checkTimeStr = checkTimeStr;
        return this;
    }

    public List<String> getProjects() {
        return projects;
    }

    public TInspectPlanMain setProjects(List<String> projects) {
        this.projects = projects;
        return this;
    }

    public List<InsertUserInfo> getInsertUserInfos() {
        return insertUserInfos;
    }

    public TInspectPlanMain setInsertUserInfos(List<InsertUserInfo> insertUserInfos) {
        this.insertUserInfos = insertUserInfos;
        return this;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getCheckTitle() {
        return checkTitle;
    }

    public void setCheckTitle(String checkTitle) {
        this.checkTitle = checkTitle;
    }

    public String getCheckYear() {
        return checkYear;
    }

    public void setCheckYear(String checkYear) {
        this.checkYear = checkYear;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("titleId", getTitleId())
                .append("checkTitle", getCheckTitle())
                .append("checkYear", getCheckYear())
                .append("checkTime", getCheckTime())
                .append("checkType", getCheckType())
                .append("remark", getRemark())
                .append("businessId", getBusinessId())
                .append("addUserId", getAddUserId())
                .append("createDate", getCreateDate())
                .append("updateDate", getUpdateDate())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }


    public class InsertUserInfo {
        private String deptId;
        private String userId;

        public String getDeptId() {
            return deptId;
        }

        public InsertUserInfo setDeptId(String deptId) {
            this.deptId = deptId;
            return this;
        }

        public String getUserId() {
            return userId;
        }

        public InsertUserInfo setUserId(String userId) {
            this.userId = userId;
            return this;
        }
    }



}


