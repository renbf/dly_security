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
import com.project.web.mapper.TCarTroubleMapper;
import com.project.web.domian.TCarTrouble;
import com.project.web.service.ITCarTroubleService;
import com.project.common.support.Convert;

/**
 * 车辆机损事故登记 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarTroubleServiceImpl implements ITCarTroubleService 
{
	private static final Logger log = LoggerFactory.getLogger(TCarTroubleServiceImpl.class);
	@Autowired
	@Qualifier("tCarTroubleMapper")
	private TCarTroubleMapper tCarTroubleMapper;

	/**
     * 查询车辆机损事故登记信息
     * 
     * @param id 车辆机损事故登记ID
     * @return 车辆机损事故登记信息
     */
    @Override
	public TCarTrouble selectTCarTroubleById(String id)
	{
	    return tCarTroubleMapper.selectTCarTroubleById(id);
	}
	
	/**
     * 查询车辆机损事故登记列表
     * 
     * @param tCarTrouble 车辆机损事故登记信息
     * @return 车辆机损事故登记集合
     */
	@Override
	public List<TCarTrouble> selectTCarTroubleList(TCarTrouble tCarTrouble)
	{
	    return tCarTroubleMapper.selectTCarTroubleList(tCarTrouble);
	}
	
    /**
     * 新增车辆机损事故登记
     * 
     * @param tCarTrouble 车辆机损事故登记信息
     * @return 结果
     */
	@Override
	public int insertTCarTrouble(TCarTrouble tCarTrouble)
	{
		tCarTrouble.setId(UUIDUtil.getUUID());
		tCarTrouble.setCreateDate(new Date());
		tCarTrouble.setAddUserId(ShiroUtils.getUserId().toString());
	    return tCarTroubleMapper.insertTCarTrouble(tCarTrouble);
	}
	
	/**
     * 修改车辆机损事故登记
     * 
     * @param tCarTrouble 车辆机损事故登记信息
     * @return 结果
     */
	@Override
	public int updateTCarTrouble(TCarTrouble tCarTrouble)
	{
	    return tCarTroubleMapper.updateTCarTrouble(tCarTrouble);
	}

	/**
     * 删除车辆机损事故登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCarTroubleByIds(String ids)
	{
		return tCarTroubleMapper.deleteTCarTroubleByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
