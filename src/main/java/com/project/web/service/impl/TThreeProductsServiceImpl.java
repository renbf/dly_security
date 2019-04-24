package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TThreeProducts;
import com.project.web.mapper.TThreeProductsMapper;
import com.project.web.service.ITThreeProductsService;

/**
 * 三品查处记录 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TThreeProductsServiceImpl implements ITThreeProductsService 
{
	@Autowired
	private TThreeProductsMapper tThreeProductsMapper;

	/**
     * 查询三品查处记录信息
     * 
     * @param id 三品查处记录ID
     * @return 三品查处记录信息
     */
    @Override
	public TThreeProducts selectTThreeProductsById(Long id)
	{
	    return tThreeProductsMapper.selectTThreeProductsById(id);
	}
	
	/**
     * 查询三品查处记录列表
     * 
     * @param tThreeProducts 三品查处记录信息
     * @return 三品查处记录集合
     */
	@Override
	public List<TThreeProducts> selectTThreeProductsList(TThreeProducts tThreeProducts)
	{
	    return tThreeProductsMapper.selectTThreeProductsList(tThreeProducts);
	}
	
    /**
     * 新增三品查处记录
     * 
     * @param tThreeProducts 三品查处记录信息
     * @return 结果
     */
	@Override
	public int insertTThreeProducts(TThreeProducts tThreeProducts)
	{
		tThreeProducts.setId(UUIDUtil.getUUID());
		tThreeProducts.setCreateTime(new Date());
		return tThreeProductsMapper.insertTThreeProducts(tThreeProducts);
	}
	
	/**
     * 修改三品查处记录
     * 
     * @param tThreeProducts 三品查处记录信息
     * @return 结果
     */
	@Override
	public int updateTThreeProducts(TThreeProducts tThreeProducts)
	{
	    return tThreeProductsMapper.updateTThreeProducts(tThreeProducts);
	}

	/**
     * 删除三品查处记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTThreeProductsByIds(String ids)
	{
		return tThreeProductsMapper.deleteTThreeProductsByIds(Convert.toStrArray(ids));
	}
	
}
