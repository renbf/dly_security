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
import com.project.web.mapper.TPaperMapper;
import com.project.web.domian.TPaper;
import com.project.web.service.ITPaperService;
import com.project.common.support.Convert;

/**
 * 考卷 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TPaperServiceImpl implements ITPaperService 
{
	private static final Logger log = LoggerFactory.getLogger(TPaperServiceImpl.class);
	@Autowired
	@Qualifier("tPaperMapper")
	private TPaperMapper tPaperMapper;

	/**
     * 查询考卷信息
     * 
     * @param id 考卷ID
     * @return 考卷信息
     */
    @Override
	public TPaper selectTPaperById(String id)
	{
	    return tPaperMapper.selectTPaperById(id);
	}
	
	/**
     * 查询考卷列表
     * 
     * @param tPaper 考卷信息
     * @return 考卷集合
     */
	@Override
	public List<TPaper> selectTPaperList(TPaper tPaper)
	{
	    return tPaperMapper.selectTPaperList(tPaper);
	}
	
    /**
     * 新增考卷
     * 
     * @param tPaper 考卷信息
     * @return 结果
     */
	@Override
	public int insertTPaper(TPaper tPaper)
	{
		tPaper.setId(UUIDUtil.getUUID());
		tPaper.setCreateDate(new Date());
		tPaper.setAddUserId(ShiroUtils.getUserId().toString());
	    return tPaperMapper.insertTPaper(tPaper);
	}
	
	/**
     * 修改考卷
     * 
     * @param tPaper 考卷信息
     * @return 结果
     */
	@Override
	public int updateTPaper(TPaper tPaper)
	{
	    return tPaperMapper.updateTPaper(tPaper);
	}

	/**
     * 删除考卷对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTPaperByIds(String ids)
	{
		return tPaperMapper.deleteTPaperByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
