package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TUserDriverPhotos;
import com.project.web.mapper.TUserDriverPhotosMapper;
import com.project.web.service.ITUserDriverPhotosService;

/**
 * 驾驶员照片 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TUserDriverPhotosServiceImpl implements ITUserDriverPhotosService 
{
	@Autowired
	private TUserDriverPhotosMapper tUserDriverPhotosMapper;

	/**
     * 查询驾驶员照片信息
     * 
     * @param id 驾驶员照片ID
     * @return 驾驶员照片信息
     */
    @Override
	public TUserDriverPhotos selectTUserDriverPhotosById(String id)
	{
	    return tUserDriverPhotosMapper.selectTUserDriverPhotosById(id);
	}
	
	/**
     * 查询驾驶员照片列表
     * 
     * @param tUserDriverPhotos 驾驶员照片信息
     * @return 驾驶员照片集合
     */
	@Override
	public List<TUserDriverPhotos> selectTUserDriverPhotosList(TUserDriverPhotos tUserDriverPhotos)
	{
	    return tUserDriverPhotosMapper.selectTUserDriverPhotosList(tUserDriverPhotos);
	}
	
    /**
     * 新增驾驶员照片
     * 
     * @param tUserDriverPhotos 驾驶员照片信息
     * @return 结果
     */
	@Override
	public int insertTUserDriverPhotos(TUserDriverPhotos tUserDriverPhotos)
	{
		tUserDriverPhotos.setId(UUIDUtil.getUUID());
		tUserDriverPhotos.setCreateTime(new Date());
		return tUserDriverPhotosMapper.insertTUserDriverPhotos(tUserDriverPhotos);
	}
	
	/**
     * 修改驾驶员照片
     * 
     * @param tUserDriverPhotos 驾驶员照片信息
     * @return 结果
     */
	@Override
	public int updateTUserDriverPhotos(TUserDriverPhotos tUserDriverPhotos)
	{
	    return tUserDriverPhotosMapper.updateTUserDriverPhotos(tUserDriverPhotos);
	}

	/**
     * 删除驾驶员照片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserDriverPhotosByIds(String ids)
	{
		return tUserDriverPhotosMapper.deleteTUserDriverPhotosByIds(Convert.toStrArray(ids));
	}
	
}
