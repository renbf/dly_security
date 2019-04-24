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
import com.project.web.mapper.TInspectTitleTeamMapper;
import com.project.web.domian.TInspectTitleTeam;
import com.project.web.service.ITInspectTitleTeamService;
import com.project.common.support.Convert;

/**
 * 标题和检查项目关系 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TInspectTitleTeamServiceImpl implements ITInspectTitleTeamService 
{
	private static final Logger log = LoggerFactory.getLogger(TInspectTitleTeamServiceImpl.class);
	@Autowired
	@Qualifier("tInspectTitleTeamMapper")
	private TInspectTitleTeamMapper tInspectTitleTeamMapper;

	/**
     * 查询标题和检查项目关系信息
     * 
     * @param titleId 标题和检查项目关系ID
     * @return 标题和检查项目关系信息
     */
    @Override
	public TInspectTitleTeam selectTInspectTitleTeamById(String titleId)
	{
	    return tInspectTitleTeamMapper.selectTInspectTitleTeamById(titleId);
	}
	
	/**
     * 查询标题和检查项目关系列表
     * 
     * @param tInspectTitleTeam 标题和检查项目关系信息
     * @return 标题和检查项目关系集合
     */
	@Override
	public List<TInspectTitleTeam> selectTInspectTitleTeamList(TInspectTitleTeam tInspectTitleTeam)
	{
	    return tInspectTitleTeamMapper.selectTInspectTitleTeamList(tInspectTitleTeam);
	}
	
    /**
     * 新增标题和检查项目关系
     * 
     * @param tInspectTitleTeam 标题和检查项目关系信息
     * @return 结果
     */
	@Override
	public int insertTInspectTitleTeam(TInspectTitleTeam tInspectTitleTeam)
	{
	    return tInspectTitleTeamMapper.insertTInspectTitleTeam(tInspectTitleTeam);
	}
	
	/**
     * 修改标题和检查项目关系
     * 
     * @param tInspectTitleTeam 标题和检查项目关系信息
     * @return 结果
     */
	@Override
	public int updateTInspectTitleTeam(TInspectTitleTeam tInspectTitleTeam)
	{
	    return tInspectTitleTeamMapper.updateTInspectTitleTeam(tInspectTitleTeam);
	}

	/**
     * 删除标题和检查项目关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTInspectTitleTeamByIds(String ids)
	{
		return tInspectTitleTeamMapper.deleteTInspectTitleTeamByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
