package com.project.security.service;

import org.springframework.web.multipart.MultipartFile;

import com.project.common.result.DataResult;

public interface ICheckService {
	/**
	 * 检查计划接口
	 * @return
	 */
	public DataResult checkPlan(String userId,Integer pageNumber,Long total);
	
	/**
	 * 查询检查项接口
	 * @return
	 */
	public DataResult queryCheckProject(String inspectPlanId,String projectId);
	
	/**
	 * 保存检查项接口
	 * @return
	 */
	public DataResult saveCheckProject(String inspectTeamProjectJson);
	/**
	 * 完成检查计划接口
	 * @return
	 */
	public DataResult completeCheck(String inspectRecordJson,MultipartFile file);
	
	/**
	 * 上传隐患——查询部门等接口
	 * @return
	 */
	public DataResult queryHiddenDanger(String businessId);
	
	/**
	 * 隐患详情接口
	 * @return
	 */
	public DataResult queryHiddenDangerDetail(String dangerId);
	
	/**
	 * 上报隐患接口
	 * @return
	 */
	public DataResult uploadHiddenDanger(String dangerJson,MultipartFile[] file,String inspectPlanId);
	/**
	 * 隐患整改接口
	 * @param userId
	 * @return
	 */
	public DataResult rectification(Integer pageNumber,Long total,String userId);
	
	/**
	 * 隐患整改提交接口
	 * @return
	 */
	public DataResult rectificationDetail(String dangerJson,MultipartFile file);
	
	/**
	 * 拒绝整改接口
	 * @return
	 */
	public DataResult refuseDochange(String dangerId,String refuseText);
	
	/**
	 * 隐患验收接口
	 * @return
	 */
	public DataResult rectificationCheck(Integer pageNumber,Long total,String userId);
	
	/**
	 * 提交隐患验收接口
	 * @return
	 */
	public DataResult rectificationClose(String dangerJson,MultipartFile file);
}
