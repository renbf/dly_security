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
import com.project.web.mapper.TCarLogMapper;
import com.project.web.domian.TCarLog;
import com.project.web.service.ITCarLogService;
import com.project.common.support.Convert;

/**
 * 车牌号牌变更 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarLogServiceImpl implements ITCarLogService 
{
	private static final Logger log = LoggerFactory.getLogger(TCarLogServiceImpl.class);
	@Autowired
	@Qualifier("tCarLogMapper")
	private TCarLogMapper tCarLogMapper;

	/**
     * 查询车牌号牌变更信息
     * 
     * @param id 车牌号牌变更ID
     * @return 车牌号牌变更信息
     */
    @Override
	public TCarLog selectTCarLogById(String id)
	{
	    return tCarLogMapper.selectTCarLogById(id);
	}
	
	/**
     * 查询车牌号牌变更列表
     * 
     * @param tCarLog 车牌号牌变更信息
     * @return 车牌号牌变更集合
     */
	@Override
	public List<TCarLog> selectTCarLogList(TCarLog tCarLog)
	{
	    return tCarLogMapper.selectTCarLogList(tCarLog);
	}
	
    /**
     * 新增车牌号牌变更
     * 
     * @param tCarLog 车牌号牌变更信息
     * @return 结果
     */
	@Override
	public int insertTCarLog(TCarLog tCarLog)
	{
		tCarLog.setId(UUIDUtil.getUUID());
	    return tCarLogMapper.insertTCarLog(tCarLog);
	}
	
	/**
     * 修改车牌号牌变更
     * 
     * @param tCarLog 车牌号牌变更信息
     * @return 结果
     */
	@Override
	public int updateTCarLog(TCarLog tCarLog)
	{
	    return tCarLogMapper.updateTCarLog(tCarLog);
	}

	/**
     * 删除车牌号牌变更对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCarLogByIds(String ids)
	{
		return tCarLogMapper.deleteTCarLogByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
