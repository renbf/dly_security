package com.project.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.web.mapper.TPaperMapper;
import com.project.web.domian.TPaper;
import com.project.web.domian.TSubject;
import com.project.web.domian.TSubjectPaper;
import com.project.web.service.ITPaperService;
import com.project.web.service.ITSubjectPaperService;
import com.project.web.service.ITSubjectService;
import com.project.common.base.AjaxResult;
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
	@Autowired
	private ITSubjectService tSubjectService;
	@Autowired
	private ITSubjectPaperService tSubjectPaperService;

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
    @Transactional
	public AjaxResult insertTPaper(TPaper tPaper)
	{
		if(regCheck(tPaper) || regCheck(tPaper.getName())) {
			return AjaxResult.error(2,"考卷名称不能为空");
		}
		if(regCheck(tPaper.getPaperTimes()) || 0==tPaper.getPaperTimes()) {
			return AjaxResult.error(2,"考卷时间不能为空和0");
		}
		if(regCheck(tPaper.getPaperType())) {
			return AjaxResult.error(2,"考卷类型不能为空");
		}
		if(regCheck(tPaper.getPaperSource())) {
			return AjaxResult.error(2,"及格分数不能为空");
		}
		if(regCheck(tPaper.getSubjectNums()) || 0==tPaper.getSubjectNums()) {
			return AjaxResult.error(2,"题目数量不能为空");
		}
		//计算出每道题多少分     100 /  题目数量
		BigDecimal countSource =new BigDecimal(100);
		BigDecimal countNum =new BigDecimal(tPaper.getSubjectNums());

		
		BigDecimal source = countSource.divide(countNum, 2, BigDecimal.ROUND_HALF_UP);//四舍五入 保留两位小数
		//判断分段是否能被整除，若不能则将最后一道题分数进行调整
		BigDecimal addSource =new BigDecimal(0);
		BigDecimal lastSource =new BigDecimal(0);
		BigDecimal allSource = source.multiply(countNum);
		System.out.println("!!!!!!!!!!!source"+source);
		System.out.println("!!!!!!!!!!!source.doubleValue()"+source.doubleValue());
		System.out.println("!!!!!!!!!!!source.floatValue()"+source.floatValue());
		System.out.println("!!!!!!!!!!!source.longValue()"+source.longValue());
		if(allSource.compareTo(allSource)!=0) {
			addSource=countSource.subtract(allSource).abs();
			lastSource=source.add(addSource);
		}else {
			lastSource=source;
		}
		System.out.println("!!!!!!!!!!!lastSource"+lastSource);
		//查询出该企业下面所有的题
		TSubject ts =new TSubject();
		ts.setBusinessId(tPaper.getBusinessId());//企业id
		List<TSubject> allSubList= tSubjectService.selectTSubjectListByOneData(ts);

//		List<TSubject> allSubList
		/**
		 * 若题目数量比该企业下面的题库数量要多，则取本企业题库下面的所有题   
		 * 若  该企业下的题库数量 要比输入的题目数量要多   则对题库的题进行乱序 然后生成 对应的输入题目数量的题
		 */
		String uuid = UUIDUtil.getUUID();//生成试卷的主键		
		tPaper.setId(uuid);
		tPaper.setCreateDate(new Date());
		tPaper.setAddUserId(ShiroUtils.getUserId().toString());
		int y=tPaperMapper.insertTPaper(tPaper);
		if(y==0) {
			return AjaxResult.error();
		}
		if(allSubList!=null && allSubList.size()>0) {
			int h=0;
			int z=allSubList.size();
			if(tPaper.getSubjectNums() >=allSubList.size()) {
				for(TSubject tsTemp:allSubList) {
					//考卷和题库对应关系表
					TSubjectPaper t=new TSubjectPaper();
					t.setSubjectId(tsTemp.getId());//题库ID
					t.setPaperId(uuid);//试卷ID
					if(h==z-1) {
						t.setSubjectScore(lastSource.doubleValue());//分数
					}else {
						t.setSubjectScore(source.doubleValue());//分数
					}
					
					t.setSubjectSort(h);
					h++;
					tSubjectPaperService.insertTSubjectPaper(t);
				}
			}else {
				Collections.shuffle(allSubList);//将顺序打乱
				for(int i=0;i<tPaper.getSubjectNums();i++) {
					//考卷和题库对应关系表
					TSubjectPaper t=new TSubjectPaper();
					t.setSubjectId(allSubList.get(i).getId());//题库ID
					t.setPaperId(uuid);//试卷ID
					if(h==z-1) {
						t.setSubjectScore(lastSource.doubleValue());//分数
					}else {
						t.setSubjectScore(source.doubleValue());//分数
					}
					t.setSubjectSort(h);
					h++;
					tSubjectPaperService.insertTSubjectPaper(t);
				}
			}			
			
		}
		
		AjaxResult aj =AjaxResult.success();
		aj.put("paperId", uuid);	//将生成的试卷ID 
	    return aj;
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
    @Transactional
	public int deleteTPaperByIds(String ids)
	{	
		//删除试卷的同时  将试卷下的考卷也删除
		//获取该试卷下 所有的题库id
		TSubjectPaper ts= new TSubjectPaper();
		ts.setPaperId(ids);
		List<TSubjectPaper> subList=tSubjectPaperService.selectTSubjectPaperList(ts);	
		if(subList!=null && subList.size() >0) {
			StringBuilder sbStr = new StringBuilder();
			for(int i=0;i<subList.size();i++) {
				sbStr.append(subList.get(i).getSubjectId());
				if(i!=subList.size()-1) {
					sbStr.append(",");
				}
			}
			
			tSubjectService.deleteTSubjectByIds(sbStr.toString());
		}				
		return tPaperMapper.deleteTPaperByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
	private boolean regCheck(Object obj) {
		if(obj==null || "".equals(obj)) {
			return true;
		}
		return false;
	}


	@Override
	public List<TSubject> selectTPaperListByPageId(TPaper tPaper) {
		/**
		 * 根据试卷ID 查询出下面题库信息
		 * 
		 * 首先根据试卷ID查询出  下面所有的题库ID
		 * 根据题库ID 查询题
		 */
		TSubjectPaper ts= new TSubjectPaper();
		ts.setPaperId(tPaper.getId());
		//获取该试卷下 所有的题库id
		List<TSubjectPaper> subList=tSubjectPaperService.selectTSubjectPaperList(ts);
		AjaxResult aj =AjaxResult.success();
		List<TSubject> allList = new ArrayList<TSubject>();
		if(subList!=null && subList.size() >0) {
			StringBuilder sbStr = new StringBuilder();
			for(int i=0;i<subList.size();i++) {
				List<TSubject> temp = new ArrayList<TSubject>();
				temp=tSubjectService.selectTPaperListByPageId(subList.get(i).getSubjectId());
				allList.add(temp.get(0));
				
			}			
		}
//		aj.put("data", allList);
		return allList;
	}

	@Override
	public List<TSubject> selectTPaperListByNotInPageId(TPaper tPaper) {
			TSubjectPaper ts= new TSubjectPaper();
			ts.setPaperId(tPaper.getId());
			//获取该试卷下 所有的题库id
			List<TSubjectPaper> subList=tSubjectPaperService.selectTSubjectPaperList(ts);
			StringBuilder sbStr = new StringBuilder();
			if(subList!=null && subList.size() >0) {

				for(int i=0;i<subList.size();i++) {
					sbStr.append(subList.get(i).getSubjectId());
					if(i!=subList.size()-1) {
						sbStr.append(",");
					}
										
				}			
			}
			TSubject tempTs= new TSubject();
			tempTs.setIds(Convert.toStrArray(sbStr.toString()));
			tempTs.setBusinessId(tPaper.getBusinessId());
			//查询出本试卷下 未生成题库的id
			List<TSubject> notInSubList=tSubjectService.selectTPaperListByNotInPageId(tempTs);
			
			List<TSubject> returnList = new ArrayList<TSubject>();
			if(notInSubList!=null && notInSubList.size()>0) {
				for(int i=0;i<notInSubList.size();i++) {
					List<TSubject> temp = new ArrayList<TSubject>();
					temp=tSubjectService.selectTPaperListByPageId(notInSubList.get(i).getId());
					returnList.add(temp.get(0));
					
				}	
			}
		return returnList;
	}
}
