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
import org.springframework.transaction.annotation.Transactional;

import com.project.web.mapper.TSubjectPaperMapper;
import com.project.web.domian.TSubjectPaper;
import com.project.web.service.ITSubjectPaperService;
import com.project.common.support.Convert;

/**
 * 考卷题目关系 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TSubjectPaperServiceImpl implements ITSubjectPaperService 
{
	private static final Logger log = LoggerFactory.getLogger(TSubjectPaperServiceImpl.class);
	@Autowired
	@Qualifier("tSubjectPaperMapper")
	private TSubjectPaperMapper tSubjectPaperMapper;

	/**
     * 查询考卷题目关系信息
     * 
     * @param paperId 考卷题目关系ID
     * @return 考卷题目关系信息
     */
    @Override
	public TSubjectPaper selectTSubjectPaperById(String paperId)
	{
	    return tSubjectPaperMapper.selectTSubjectPaperById(paperId);
	}
	
	/**
     * 查询考卷题目关系列表
     * 
     * @param tSubjectPaper 考卷题目关系信息
     * @return 考卷题目关系集合
     */
	@Override
	public List<TSubjectPaper> selectTSubjectPaperList(TSubjectPaper tSubjectPaper)
	{
	    return tSubjectPaperMapper.selectTSubjectPaperList(tSubjectPaper);
	}
	
    /**
     * 新增考卷题目关系
     * 
     * @param tSubjectPaper 考卷题目关系信息
     * @return 结果
     */
	@Override
	public int insertTSubjectPaper(TSubjectPaper tSubjectPaper)
	{
	    return tSubjectPaperMapper.insertTSubjectPaper(tSubjectPaper);
	}
	
	/**
     * 修改考卷题目关系
     * 
     * @param tSubjectPaper 考卷题目关系信息
     * @return 结果
     */
	@Override
	public int updateTSubjectPaper(TSubjectPaper tSubjectPaper)
	{
	    return tSubjectPaperMapper.updateTSubjectPaper(tSubjectPaper);
	}

	/**
     * 删除考卷题目关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTSubjectPaperByIds(String ids)
	{
		return tSubjectPaperMapper.deleteTSubjectPaperByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动

	@Override
	@Transactional
	public int deleteTSubjectPaperBySubId(TSubjectPaper tSubjectPaper) {
		//根据旧的题库id和试卷id查询出  之前这道题在这个试卷中的分值和排序
		TSubjectPaper ts =new TSubjectPaper();
		ts.setPaperId(tSubjectPaper.getPaperId());
		ts.setSubjectId(tSubjectPaper.getOldSubjectId());
		List<TSubjectPaper> tempList = tSubjectPaperMapper.selectTSubjectPaperList(ts);
		
		//先删除 再新增一条数据
		TSubjectPaper tsTemp = new TSubjectPaper();
		tsTemp.setPaperId(tSubjectPaper.getPaperId());
		tsTemp.setSubjectId(tSubjectPaper.getOldSubjectId());
		int i=tSubjectPaperMapper.deleteTSubjectPaperBySubId(tsTemp);
		if(i==0) {
			return 0;
		}
		tSubjectPaper.setSubjectScore(tempList.get(0).getSubjectScore());//分值
		tSubjectPaper.setSubjectSort(tempList.get(0).getSubjectSort());//排序
		i=tSubjectPaperMapper.insertTSubjectPaper(tSubjectPaper);
		if(i==0) {
			return 0;
		}
		return 1;
	}
}
