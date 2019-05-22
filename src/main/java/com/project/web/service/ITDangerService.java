package com.project.web.service;

import com.project.web.domian.TDanger;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * 隐患 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITDangerService 
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
     * 	根据整改人查询隐患列表
     * 
     * @param tDanger 隐患信息
     * @return 隐患集合
     */
	public List<TDanger> selectTDangerListByUser(TDanger tDanger);
	
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
	public int updateTDanger(TDanger tDanger,MultipartFile dochangePicture);
		
	/**
     * 删除隐患信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDangerByIds(String ids);
	//以上自动生成的尽量别动
}
