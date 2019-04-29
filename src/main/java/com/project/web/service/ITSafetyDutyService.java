package com.project.web.service;

import java.util.List;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TSafetyDuty;
import org.springframework.web.multipart.MultipartFile;

/**
 * 安全值班 服务层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface ITSafetyDutyService
{
	/**
	 * 查询安全值班信息
	 *
	 * @param id 安全值班ID
	 * @return 安全值班信息
	 */
	public TSafetyDuty selectTSafetyDutyById(String id);

	/**
	 * 查询安全值班列表
	 *
	 * @param tSafetyDuty 安全值班信息
	 * @return 安全值班集合
	 */
	public List<TSafetyDuty> selectTSafetyDutyList(TSafetyDuty tSafetyDuty);

	/**
	 * 新增安全值班
	 *
	 * @param tSafetyDuty 安全值班信息
	 * @return 结果
	 */
	public AjaxResult insertTSafetyDuty(TSafetyDuty tSafetyDuty, MultipartFile dutyFile);

	/**
	 * 修改安全值班
	 *
	 * @param tSafetyDuty 安全值班信息
	 * @return 结果
	 */
	public AjaxResult updateTSafetyDuty(TSafetyDuty tSafetyDuty,MultipartFile dutyFile);

	/**
	 * 删除安全值班信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteTSafetyDutyByIds(String ids);

}
