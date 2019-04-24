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
import com.project.web.mapper.TUserPaperMapper;
import com.project.web.domian.TUserPaper;
import com.project.web.service.ITUserPaperService;
import com.project.common.support.Convert;

/**
 * 用户考试安排 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TUserPaperServiceImpl implements ITUserPaperService 
{
	private static final Logger log = LoggerFactory.getLogger(TUserPaperServiceImpl.class);
	@Autowired
	@Qualifier("tUserPaperMapper")
	private TUserPaperMapper tUserPaperMapper;

	/**
     * 查询用户考试安排信息
     * 
     * @param id 用户考试安排ID
     * @return 用户考试安排信息
     */
    @Override
	public TUserPaper selectTUserPaperById(String id)
	{
	    return tUserPaperMapper.selectTUserPaperById(id);
	}
	
	/**
     * 查询用户考试安排列表
     * 
     * @param tUserPaper 用户考试安排信息
     * @return 用户考试安排集合
     */
	@Override
	public List<TUserPaper> selectTUserPaperList(TUserPaper tUserPaper)
	{
	    return tUserPaperMapper.selectTUserPaperList(tUserPaper);
	}
	
    /**
     * 新增用户考试安排
     * 
     * @param tUserPaper 用户考试安排信息
     * @return 结果
     */
	@Override
	public int insertTUserPaper(TUserPaper tUserPaper)
	{
		tUserPaper.setId(UUIDUtil.getUUID());
		tUserPaper.setCreateDate(new Date());
		tUserPaper.setAddUserId(ShiroUtils.getUserId().toString());
	    return tUserPaperMapper.insertTUserPaper(tUserPaper);
	}
	
	/**
     * 修改用户考试安排
     * 
     * @param tUserPaper 用户考试安排信息
     * @return 结果
     */
	@Override
	public int updateTUserPaper(TUserPaper tUserPaper)
	{
	    return tUserPaperMapper.updateTUserPaper(tUserPaper);
	}

	/**
     * 删除用户考试安排对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserPaperByIds(String ids)
	{
		return tUserPaperMapper.deleteTUserPaperByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
