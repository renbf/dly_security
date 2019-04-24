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
import com.project.web.mapper.TClassHourConfigMapper;
import com.project.web.domian.TClassHourConfig;
import com.project.web.service.ITClassHourConfigService;
import com.project.common.support.Convert;

/**
 * 课时配置 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TClassHourConfigServiceImpl implements ITClassHourConfigService 
{
	private static final Logger log = LoggerFactory.getLogger(TClassHourConfigServiceImpl.class);
	@Autowired
	@Qualifier("tClassHourConfigMapper")
	private TClassHourConfigMapper tClassHourConfigMapper;

	/**
     * 查询课时配置信息
     * 
     * @param id 课时配置ID
     * @return 课时配置信息
     */
    @Override
	public TClassHourConfig selectTClassHourConfigById(String id)
	{
	    return tClassHourConfigMapper.selectTClassHourConfigById(id);
	}
	
	/**
     * 查询课时配置列表
     * 
     * @param tClassHourConfig 课时配置信息
     * @return 课时配置集合
     */
	@Override
	public List<TClassHourConfig> selectTClassHourConfigList(TClassHourConfig tClassHourConfig)
	{
	    return tClassHourConfigMapper.selectTClassHourConfigList(tClassHourConfig);
	}
	
    /**
     * 新增课时配置
     * 
     * @param tClassHourConfig 课时配置信息
     * @return 结果
     */
	@Override
	public int insertTClassHourConfig(TClassHourConfig tClassHourConfig)
	{
		tClassHourConfig.setId(UUIDUtil.getUUID());
		tClassHourConfig.setCreateDate(new Date());
		tClassHourConfig.setAddUserId(ShiroUtils.getUserId().toString());
	    return tClassHourConfigMapper.insertTClassHourConfig(tClassHourConfig);
	}
	
	/**
     * 修改课时配置
     * 
     * @param tClassHourConfig 课时配置信息
     * @return 结果
     */
	@Override
	public int updateTClassHourConfig(TClassHourConfig tClassHourConfig)
	{
	    return tClassHourConfigMapper.updateTClassHourConfig(tClassHourConfig);
	}

	/**
     * 删除课时配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTClassHourConfigByIds(String ids)
	{
		return tClassHourConfigMapper.deleteTClassHourConfigByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
