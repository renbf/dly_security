package com.project.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Date;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.project.web.mapper.TCarSpecialUseMapper;
import com.project.web.domian.TCarSpecialUse;
import com.project.web.service.ITCarSpecialUseService;
import com.project.common.support.Convert;

/**
 * 压力容器和罐式专用车辆的罐体检测报告 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarSpecialUseServiceImpl implements ITCarSpecialUseService 
{
	private static final Logger log = LoggerFactory.getLogger(TCarSpecialUseServiceImpl.class);
	@Autowired
	@Qualifier("tCarSpecialUseMapper")
	private TCarSpecialUseMapper tCarSpecialUseMapper;

	/**
     * 查询压力容器和罐式专用车辆的罐体检测报告信息
     * 
     * @param id 压力容器和罐式专用车辆的罐体检测报告ID
     * @return 压力容器和罐式专用车辆的罐体检测报告信息
     */
    @Override
	public TCarSpecialUse selectTCarSpecialUseById(String id)
	{
	    return tCarSpecialUseMapper.selectTCarSpecialUseById(id);
	}
	
	/**
     * 查询压力容器和罐式专用车辆的罐体检测报告列表
     * 
     * @param tCarSpecialUse 压力容器和罐式专用车辆的罐体检测报告信息
     * @return 压力容器和罐式专用车辆的罐体检测报告集合
     */
	@Override
	public List<TCarSpecialUse> selectTCarSpecialUseList(TCarSpecialUse tCarSpecialUse)
	{
	    return tCarSpecialUseMapper.selectTCarSpecialUseList(tCarSpecialUse);
	}
	
    /**
     * 新增压力容器和罐式专用车辆的罐体检测报告
     * 
     * @param tCarSpecialUse 压力容器和罐式专用车辆的罐体检测报告信息
     * @return 结果
     */
	@Override
	public int insertTCarSpecialUse(TCarSpecialUse tCarSpecialUse)
	{
		tCarSpecialUse.setId(UUIDUtil.getUUID());
		tCarSpecialUse.setCreateDate(new Date());
		tCarSpecialUse.setAddUserId(ShiroUtils.getUserId().toString());
	    return tCarSpecialUseMapper.insertTCarSpecialUse(tCarSpecialUse);
	}
	
	/**
     * 修改压力容器和罐式专用车辆的罐体检测报告
     * 
     * @param tCarSpecialUse 压力容器和罐式专用车辆的罐体检测报告信息
     * @return 结果
     */
	@Override
	public int updateTCarSpecialUse(TCarSpecialUse tCarSpecialUse)
	{
	    return tCarSpecialUseMapper.updateTCarSpecialUse(tCarSpecialUse);
	}

	/**
     * 删除压力容器和罐式专用车辆的罐体检测报告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCarSpecialUseByIds(String ids)
	{
		return tCarSpecialUseMapper.deleteTCarSpecialUseByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
