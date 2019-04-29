package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 作业管理表 t_task_management
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TTaskManagement extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 事件名称 */
	private String eventName;
	/** 检查单位 */
	private String checkUnit;
	/** 违章日期 */
	private Date regulationsDate;
	/** 违章日期 */
	private Date regulationsDateEnd;
	/** 违章日期 字符串*/
	private String regulationsDateStr;
	/** 检查人员 */
	private String checkPersonnel;
	/** 扣分 */
	private String deduction;
	/** 是否处理:   0:未处理    1:已处理 */
	private String isHandle;
	/** 驾驶员 */
	private String driver;
	/** 处理日期 */
	private Date handleDate;
	/** 车牌号码 */
	private String plateNum;
	/** 内部处理 */
	private String insideHandle;
	/** 违规类型 */
	private String violationType;
	/** 是否学习 0:未学习   1:已学习 */
	private String isLearn;
	/** 所属部门 */
	private Long deptId;
	/** 违法描述 */
	private String illegalInfo;
	/** 处理情况 */
	private String handleInfo;
	/** 创建时间 */
	private Date createTime;
	/** 创建人 */
	private Long userId;
	/** 备注 */
	private String remark;
	/** 企业ID */
	private String businessId;
	/** 修改人id */
	private Long updateUserId;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setEventName(String eventName) 
	{
		this.eventName = eventName;
	}

	public String getEventName() 
	{
		return eventName;
	}
	public void setCheckUnit(String checkUnit) 
	{
		this.checkUnit = checkUnit;
	}

	public String getCheckUnit() 
	{
		return checkUnit;
	}
	public void setRegulationsDate(Date regulationsDate) 
	{
		this.regulationsDate = regulationsDate;
	}

	public Date getRegulationsDate() 
	{
		return regulationsDate;
	}
	public void setCheckPersonnel(String checkPersonnel) 
	{
		this.checkPersonnel = checkPersonnel;
	}

	public String getCheckPersonnel() 
	{
		return checkPersonnel;
	}
	public void setDeduction(String deduction) 
	{
		this.deduction = deduction;
	}

	public String getDeduction() 
	{
		return deduction;
	}
	public void setIsHandle(String isHandle) 
	{
		this.isHandle = isHandle;
	}

	public String getIsHandle() 
	{
		return isHandle;
	}
	public void setDriver(String driver) 
	{
		this.driver = driver;
	}

	public String getDriver() 
	{
		return driver;
	}
	public void setHandleDate(Date handleDate) 
	{
		this.handleDate = handleDate;
	}

	public Date getHandleDate() 
	{
		return handleDate;
	}
	public void setPlateNum(String plateNum) 
	{
		this.plateNum = plateNum;
	}

	public String getPlateNum() 
	{
		return plateNum;
	}
	public void setInsideHandle(String insideHandle) 
	{
		this.insideHandle = insideHandle;
	}

	public String getInsideHandle() 
	{
		return insideHandle;
	}
	public void setViolationType(String violationType) 
	{
		this.violationType = violationType;
	}

	public String getViolationType() 
	{
		return violationType;
	}
	public void setIsLearn(String isLearn) 
	{
		this.isLearn = isLearn;
	}

	public String getIsLearn() 
	{
		return isLearn;
	}
	
	public Date getRegulationsDateEnd() {
		return regulationsDateEnd;
	}

	public void setRegulationsDateEnd(Date regulationsDateEnd) {
		this.regulationsDateEnd = regulationsDateEnd;
	}

	public String getRegulationsDateStr() {
		return regulationsDateStr;
	}

	public void setRegulationsDateStr(String regulationsDateStr) {
		this.regulationsDateStr = regulationsDateStr;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public void setIllegalInfo(String illegalInfo) 
	{
		this.illegalInfo = illegalInfo;
	}

	public String getIllegalInfo() 
	{
		return illegalInfo;
	}
	public void setHandleInfo(String handleInfo) 
	{
		this.handleInfo = handleInfo;
	}

	public String getHandleInfo() 
	{
		return handleInfo;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setBusinessId(String businessId) 
	{
		this.businessId = businessId;
	}

	public String getBusinessId() 
	{
		return businessId;
	}
	public void setUpdateUserId(Long updateUserId) 
	{
		this.updateUserId = updateUserId;
	}

	public Long getUpdateUserId() 
	{
		return updateUserId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("eventName", getEventName())
            .append("checkUnit", getCheckUnit())
            .append("regulationsDate", getRegulationsDate())
            .append("checkPersonnel", getCheckPersonnel())
            .append("deduction", getDeduction())
            .append("isHandle", getIsHandle())
            .append("driver", getDriver())
            .append("handleDate", getHandleDate())
            .append("plateNum", getPlateNum())
            .append("insideHandle", getInsideHandle())
            .append("violationType", getViolationType())
            .append("isLearn", getIsLearn())
            .append("deptId", getDeptId())
            .append("illegalInfo", getIllegalInfo())
            .append("handleInfo", getHandleInfo())
            .append("createTime", getCreateTime())
            .append("userId", getUserId())
            .append("remark", getRemark())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
