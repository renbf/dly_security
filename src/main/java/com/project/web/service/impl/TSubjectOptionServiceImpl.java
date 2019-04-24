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
import com.project.web.mapper.TSubjectOptionMapper;
import com.project.web.domian.TSubjectOption;
import com.project.web.service.ITSubjectOptionService;
import com.project.common.support.Convert;

/**
 * 题库选项关系 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TSubjectOptionServiceImpl implements ITSubjectOptionService 
{
	private static final Logger log = LoggerFactory.getLogger(TSubjectOptionServiceImpl.class);
	@Autowired
	@Qualifier("tSubjectOptionMapper")
	private TSubjectOptionMapper tSubjectOptionMapper;

	/**
     * 查询题库选项关系信息
     * 
     * @param subjectId 题库选项关系ID
     * @return 题库选项关系信息
     */
    @Override
	public TSubjectOption selectTSubjectOptionById(String subjectId)
	{
	    return tSubjectOptionMapper.selectTSubjectOptionById(subjectId);
	}
	
	/**
     * 查询题库选项关系列表
     * 
     * @param tSubjectOption 题库选项关系信息
     * @return 题库选项关系集合
     */
	@Override
	public List<TSubjectOption> selectTSubjectOptionList(TSubjectOption tSubjectOption)
	{
	    return tSubjectOptionMapper.selectTSubjectOptionList(tSubjectOption);
	}
	
    /**
     * 新增题库选项关系
     * 
     * @param tSubjectOption 题库选项关系信息
     * @return 结果
     */
	@Override
	public int insertTSubjectOption(TSubjectOption tSubjectOption)
	{
	    return tSubjectOptionMapper.insertTSubjectOption(tSubjectOption);
	}
	
	/**
     * 修改题库选项关系
     * 
     * @param tSubjectOption 题库选项关系信息
     * @return 结果
     */
	@Override
	public int updateTSubjectOption(TSubjectOption tSubjectOption)
	{
	    return tSubjectOptionMapper.updateTSubjectOption(tSubjectOption);
	}

	/**
     * 删除题库选项关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTSubjectOptionByIds(String ids)
	{
		return tSubjectOptionMapper.deleteTSubjectOptionByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
