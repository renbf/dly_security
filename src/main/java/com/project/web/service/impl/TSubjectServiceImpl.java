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
import com.project.web.mapper.TSubjectMapper;
import com.project.web.domian.TSubject;
import com.project.web.service.ITSubjectService;
import com.project.common.support.Convert;

/**
 * 题库 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TSubjectServiceImpl implements ITSubjectService 
{
	private static final Logger log = LoggerFactory.getLogger(TSubjectServiceImpl.class);
	@Autowired
	@Qualifier("tSubjectMapper")
	private TSubjectMapper tSubjectMapper;

	/**
     * 查询题库信息
     * 
     * @param id 题库ID
     * @return 题库信息
     */
    @Override
	public TSubject selectTSubjectById(String id)
	{
	    return tSubjectMapper.selectTSubjectById(id);
	}
	
	/**
     * 查询题库列表
     * 
     * @param tSubject 题库信息
     * @return 题库集合
     */
	@Override
	public List<TSubject> selectTSubjectList(TSubject tSubject)
	{
	    return tSubjectMapper.selectTSubjectList(tSubject);
	}
	
    /**
     * 新增题库
     * 
     * @param tSubject 题库信息
     * @return 结果
     */
	@Override
	public int insertTSubject(TSubject tSubject)
	{
		tSubject.setId(UUIDUtil.getUUID());
		tSubject.setCreateDate(new Date());
		tSubject.setAddUserId(ShiroUtils.getUserId().toString());
	    return tSubjectMapper.insertTSubject(tSubject);
	}
	
	/**
     * 修改题库
     * 
     * @param tSubject 题库信息
     * @return 结果
     */
	@Override
	public int updateTSubject(TSubject tSubject)
	{
	    return tSubjectMapper.updateTSubject(tSubject);
	}

	/**
     * 删除题库对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTSubjectByIds(String ids)
	{
		return tSubjectMapper.deleteTSubjectByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
