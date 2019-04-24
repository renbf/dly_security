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
import com.project.web.mapper.TDictMapper;
import com.project.web.domian.TDict;
import com.project.web.service.ITDictService;
import com.project.common.support.Convert;

/**
 * 字典 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDictServiceImpl implements ITDictService 
{
	private static final Logger log = LoggerFactory.getLogger(TDictServiceImpl.class);
	@Autowired
	@Qualifier("tDictMapper")
	private TDictMapper tDictMapper;

	/**
     * 查询字典信息
     * 
     * @param id 字典ID
     * @return 字典信息
     */
    @Override
	public TDict selectTDictById(String id)
	{
	    return tDictMapper.selectTDictById(id);
	}
	
	/**
     * 查询字典列表
     * 
     * @param tDict 字典信息
     * @return 字典集合
     */
	@Override
	public List<TDict> selectTDictList(TDict tDict)
	{
	    return tDictMapper.selectTDictList(tDict);
	}
	
    /**
     * 新增字典
     * 
     * @param tDict 字典信息
     * @return 结果
     */
	@Override
	public int insertTDict(TDict tDict)
	{
		tDict.setId(UUIDUtil.getUUID());
		tDict.setCreateDate(new Date());
		tDict.setAddUserId(ShiroUtils.getUserId().toString());
	    return tDictMapper.insertTDict(tDict);
	}
	
	/**
     * 修改字典
     * 
     * @param tDict 字典信息
     * @return 结果
     */
	@Override
	public int updateTDict(TDict tDict)
	{
	    return tDictMapper.updateTDict(tDict);
	}

	/**
     * 删除字典对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDictByIds(String ids)
	{
		return tDictMapper.deleteTDictByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
