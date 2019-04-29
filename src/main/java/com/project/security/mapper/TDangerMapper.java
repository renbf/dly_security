package com.project.security.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.security.domain.TDanger;
import com.project.security.domain.vo.TDangerVo;	

/**
 * 隐患 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Repository("dangerMapper")
public interface TDangerMapper 
{
	/**
     * 查询隐患信息
     * 
     * @param id 隐患ID
     * @return 隐患信息
     */
	public TDanger selectTDangerById(String id);
	
	/**
     * 查询隐患列表
     * 
     * @param tDanger 隐患信息
     * @return 隐患集合
     */
	public List<TDanger> selectTDangerList(TDanger tDanger);
	
	/**
     * 新增隐患
     * 
     * @param tDanger 隐患信息
     * @return 结果
     */
	public int insertTDanger(TDanger tDanger);
	
	/**
     * 修改隐患
     * 
     * @param tDanger 隐患信息
     * @return 结果
     */
	public int updateTDanger(TDanger tDanger);
	
	/**
     * 删除隐患
     * 
     * @param id 隐患ID
     * @return 结果
     */
	public int deleteTDangerById(String id);
	
	/**
     * 批量删除隐患
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDangerByIds(String[] ids);
	//以上自动生成的尽量别动
	
	public TDangerVo selectTDangerVoByDangerId(String dangerId);
	/**
	 * 隐患整改
	 * @param userId
	 * @param status
	 * @return
	 */
	public List<TDangerVo> rectification(@Param("userId") String userId,@Param("status") String status);
	/**
	 * 隐患验收
	 * @param userId
	 * @param status
	 * @return
	 */
	public List<TDangerVo> rectificationCheck(@Param("userId") String userId,@Param("status") String status);
}