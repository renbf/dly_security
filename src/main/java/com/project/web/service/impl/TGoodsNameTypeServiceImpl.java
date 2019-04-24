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
import com.project.web.mapper.TGoodsNameTypeMapper;
import com.project.web.domian.TGoodsNameType;
import com.project.web.service.ITGoodsNameTypeService;
import com.project.common.support.Convert;

/**
 * 货物名称类项关系 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TGoodsNameTypeServiceImpl implements ITGoodsNameTypeService 
{
	private static final Logger log = LoggerFactory.getLogger(TGoodsNameTypeServiceImpl.class);
	@Autowired
	@Qualifier("tGoodsNameTypeMapper")
	private TGoodsNameTypeMapper tGoodsNameTypeMapper;

	/**
     * 查询货物名称类项关系信息
     * 
     * @param id 货物名称类项关系ID
     * @return 货物名称类项关系信息
     */
    @Override
	public TGoodsNameType selectTGoodsNameTypeById(String id)
	{
	    return tGoodsNameTypeMapper.selectTGoodsNameTypeById(id);
	}
	
	/**
     * 查询货物名称类项关系列表
     * 
     * @param tGoodsNameType 货物名称类项关系信息
     * @return 货物名称类项关系集合
     */
	@Override
	public List<TGoodsNameType> selectTGoodsNameTypeList(TGoodsNameType tGoodsNameType)
	{
	    return tGoodsNameTypeMapper.selectTGoodsNameTypeList(tGoodsNameType);
	}
	
    /**
     * 新增货物名称类项关系
     * 
     * @param tGoodsNameType 货物名称类项关系信息
     * @return 结果
     */
	@Override
	public int insertTGoodsNameType(TGoodsNameType tGoodsNameType)
	{
		tGoodsNameType.setId(UUIDUtil.getUUID());
		tGoodsNameType.setCreateDate(new Date());
		tGoodsNameType.setAddUserId(ShiroUtils.getUserId().toString());
	    return tGoodsNameTypeMapper.insertTGoodsNameType(tGoodsNameType);
	}
	
	/**
     * 修改货物名称类项关系
     * 
     * @param tGoodsNameType 货物名称类项关系信息
     * @return 结果
     */
	@Override
	public int updateTGoodsNameType(TGoodsNameType tGoodsNameType)
	{
	    return tGoodsNameTypeMapper.updateTGoodsNameType(tGoodsNameType);
	}

	/**
     * 删除货物名称类项关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTGoodsNameTypeByIds(String ids)
	{
		return tGoodsNameTypeMapper.deleteTGoodsNameTypeByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
