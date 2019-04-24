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
import com.project.web.mapper.TUserSubjectMapper;
import com.project.web.domian.TUserSubject;
import com.project.web.service.ITUserSubjectService;
import com.project.common.support.Convert;

/**
 * 用户答题记录 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TUserSubjectServiceImpl implements ITUserSubjectService 
{
	private static final Logger log = LoggerFactory.getLogger(TUserSubjectServiceImpl.class);
	@Autowired
	@Qualifier("tUserSubjectMapper")
	private TUserSubjectMapper tUserSubjectMapper;

	/**
     * 查询用户答题记录信息
     * 
     * @param id 用户答题记录ID
     * @return 用户答题记录信息
     */
    @Override
	public TUserSubject selectTUserSubjectById(String id)
	{
	    return tUserSubjectMapper.selectTUserSubjectById(id);
	}
	
	/**
     * 查询用户答题记录列表
     * 
     * @param tUserSubject 用户答题记录信息
     * @return 用户答题记录集合
     */
	@Override
	public List<TUserSubject> selectTUserSubjectList(TUserSubject tUserSubject)
	{
	    return tUserSubjectMapper.selectTUserSubjectList(tUserSubject);
	}
	
    /**
     * 新增用户答题记录
     * 
     * @param tUserSubject 用户答题记录信息
     * @return 结果
     */
	@Override
	public int insertTUserSubject(TUserSubject tUserSubject)
	{
		tUserSubject.setId(UUIDUtil.getUUID());
	    return tUserSubjectMapper.insertTUserSubject(tUserSubject);
	}
	
	/**
     * 修改用户答题记录
     * 
     * @param tUserSubject 用户答题记录信息
     * @return 结果
     */
	@Override
	public int updateTUserSubject(TUserSubject tUserSubject)
	{
	    return tUserSubjectMapper.updateTUserSubject(tUserSubject);
	}

	/**
     * 删除用户答题记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserSubjectByIds(String ids)
	{
		return tUserSubjectMapper.deleteTUserSubjectByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
