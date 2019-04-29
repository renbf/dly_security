package com.project.web.service;

import java.util.List;

import com.project.web.domian.TSafetyTarget;
import org.springframework.web.multipart.MultipartFile;

/**
 * 安全目标 服务层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface ITSafetyTargetService 
{
	/**
     * 查询安全目标信息
     * 
     * @param id 安全目标ID
     * @return 安全目标信息
     */
	public TSafetyTarget selectTSafetyTargetById(String id);
	
	/**
     * 查询安全目标列表
     * 
     * @param tSafetyTarget 安全目标信息
     * @return 安全目标集合
     */
	public List<TSafetyTarget> selectTSafetyTargetList(TSafetyTarget tSafetyTarget);
	
	/**
     * 新增安全目标
     * 
     * @param tSafetyTarget 安全目标信息
     * @return 结果
     */
	public int insertTSafetyTarget(TSafetyTarget tSafetyTarget, MultipartFile targetFile);
	

	/**
	 * 修改安全目标
	 *
	 * @param tSafetyTarget 安全目标信息
	 * @return 结果
	 */
	public int updateTSafetyTarget(TSafetyTarget tSafetyTarget, MultipartFile targetFile);

	/**
     * 删除安全目标信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSafetyTargetByIds(String ids);
	
}
