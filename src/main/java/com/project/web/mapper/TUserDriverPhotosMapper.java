package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TUserDriverPhotos;	

/**
 * 驾驶员照片 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TUserDriverPhotosMapper 
{
	/**
     * 查询驾驶员照片信息
     * 
     * @param id 驾驶员照片ID
     * @return 驾驶员照片信息
     */
	public TUserDriverPhotos selectTUserDriverPhotosById(String id);
	
	/**
     * 查询驾驶员照片列表
     * 
     * @param tUserDriverPhotos 驾驶员照片信息
     * @return 驾驶员照片集合
     */
	public List<TUserDriverPhotos> selectTUserDriverPhotosList(TUserDriverPhotos tUserDriverPhotos);
	
	/**
     * 新增驾驶员照片
     * 
     * @param tUserDriverPhotos 驾驶员照片信息
     * @return 结果
     */
	public int insertTUserDriverPhotos(TUserDriverPhotos tUserDriverPhotos);
	
	/**
     * 修改驾驶员照片
     * 
     * @param tUserDriverPhotos 驾驶员照片信息
     * @return 结果
     */
	public int updateTUserDriverPhotos(TUserDriverPhotos tUserDriverPhotos);
	
	/**
     * 删除驾驶员照片
     * 
     * @param id 驾驶员照片ID
     * @return 结果
     */
	public int deleteTUserDriverPhotosById(String id);
	
	/**
     * 批量删除驾驶员照片
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserDriverPhotosByIds(String[] ids);
	
}