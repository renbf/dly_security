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
import com.project.web.mapper.TUserSubjectCollectMapper;
import com.project.web.domian.TUserSubjectCollect;
import com.project.web.service.ITUserSubjectCollectService;
import com.project.common.support.Convert;

/**
 * 用户收藏记录 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TUserSubjectCollectServiceImpl implements ITUserSubjectCollectService 
{
	private static final Logger log = LoggerFactory.getLogger(TUserSubjectCollectServiceImpl.class);
	@Autowired
	@Qualifier("tUserSubjectCollectMapper")
	private TUserSubjectCollectMapper tUserSubjectCollectMapper;

	/**
     * 查询用户收藏记录信息
     * 
     * @param userId 用户收藏记录ID
     * @return 用户收藏记录信息
     */
    @Override
	public TUserSubjectCollect selectTUserSubjectCollectById(String userId)
	{
	    return tUserSubjectCollectMapper.selectTUserSubjectCollectById(userId);
	}
	
	/**
     * 查询用户收藏记录列表
     * 
     * @param tUserSubjectCollect 用户收藏记录信息
     * @return 用户收藏记录集合
     */
	@Override
	public List<TUserSubjectCollect> selectTUserSubjectCollectList(TUserSubjectCollect tUserSubjectCollect)
	{
	    return tUserSubjectCollectMapper.selectTUserSubjectCollectList(tUserSubjectCollect);
	}
	
    /**
     * 新增用户收藏记录
     * 
     * @param tUserSubjectCollect 用户收藏记录信息
     * @return 结果
     */
	@Override
	public int insertTUserSubjectCollect(TUserSubjectCollect tUserSubjectCollect)
	{
	    return tUserSubjectCollectMapper.insertTUserSubjectCollect(tUserSubjectCollect);
	}
	
	/**
     * 修改用户收藏记录
     * 
     * @param tUserSubjectCollect 用户收藏记录信息
     * @return 结果
     */
	@Override
	public int updateTUserSubjectCollect(TUserSubjectCollect tUserSubjectCollect)
	{
	    return tUserSubjectCollectMapper.updateTUserSubjectCollect(tUserSubjectCollect);
	}

	/**
     * 删除用户收藏记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserSubjectCollectByIds(String ids)
	{
		return tUserSubjectCollectMapper.deleteTUserSubjectCollectByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
