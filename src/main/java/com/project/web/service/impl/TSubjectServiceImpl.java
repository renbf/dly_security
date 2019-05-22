package com.project.web.service.impl;

import org.apache.logging.log4j.util.StringBuilders;
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

import com.project.web.mapper.TSubjectMapper;
import com.project.web.mapper.TSubjectOptionMapper;
import com.project.web.domian.TSubject;
import com.project.web.domian.TSubjectOption;
import com.project.web.service.ITSubjectService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.project.common.base.AjaxResult;
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
	@Autowired
	@Qualifier("tSubjectOptionMapper")
	private TSubjectOptionMapper tSubjectOptionMapper;

	/**
     * 查询题库信息
     * 
     * @param id 题库ID
     * @return 题库信息
     */
    @Override
	public TSubject selectTSubjectById(String id)
	{
    	//首先查询题库总表
    	TSubject subTemp = tSubjectMapper.selectTSubjectById(id);
    	//根据题库表ID 查询出具体的选项情况
    	TSubjectOption to =new TSubjectOption();
    	to.setSubjectId(id);
    	List<TSubjectOption> subOptionList=tSubjectOptionMapper.selectTSubjectOptionList(to);
    	subTemp.setSubList(subOptionList);
    	return subTemp;
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
    @Transactional
	public AjaxResult insertTSubject(TSubject tSubject)
	{		
		AjaxResult aj=checkParam(tSubject);
		if(aj!=null) {
			return aj;
		}
	
		//生成题库主键ID
		String uuid = UUIDUtil.getUUID();
		StringBuilder sbStr =new StringBuilder();
		tSubject.setId(uuid);
		tSubject.setCreateDate(new Date());
		tSubject.setAddUserId(ShiroUtils.getUserId().toString());
		//添加是否有正确答案标识  默认没有
		boolean isTrue=false;
		//计算正确答案数
		int h=0;
		for(TSubjectOption temp:tSubject.getSubList()) {
			//当为判断或者单选时，仅允许有一个正确答案
			if("0".equals(tSubject.getSubjectType()) || "2".equals(tSubject.getSubjectType())) {
				if("1".equals(temp.getIsAnswer())) { //是正确答案时
					isTrue=true;
					h++;
				}
			}else {
				//多选题不用统计正确答案数
				if("1".equals(temp.getIsAnswer())) { //是正确答案时
					isTrue=true;
					h++;
				}
			}
			
		}
		if(!isTrue) {
			return AjaxResult.error(2, "选项里面必须要有一个正确答案");					
		}
		//若为单选题或者判断题时,仅只能有一个正确答案
		if( ("0".equals(tSubject.getSubjectType()) || "2".equals(tSubject.getSubjectType())) && h>=2) {
			return AjaxResult.error(2, "单选题或者判断题里面必须要有一个且仅有一个正确答案");
		}
		//若为多选题时,正确答案必须大于两个
		if("1".equals(tSubject.getSubjectType()) && h <=1) {
			return AjaxResult.error(2, "多选题必须要有两个以上正确答案");
		}		
		if(tSubject.getSubList().size() > 0) {			
			for(TSubjectOption tjo:tSubject.getSubList()) {
				TSubjectOption t= new TSubjectOption();
				t.setSubjectId(uuid);
				t.setIsAnswer(tjo.getIsAnswer());	/** 是否是答案1是0否 */
				//若为判断题,则内容里面无须写东西，系统默认 A：正确   B：错误
				if("2".equals(tSubject.getSubjectType())) { 
					if(tjo.getContent()!=null && !"".equals(tjo.getContent()) && !"".equals(tjo.getContent().trim())) {
						return AjaxResult.error(2, "判断题内容无须输入");
					}
					if("1".equals(tjo.getIsAnswer())) { //是正确答案时
						t.setOptionValue("正确");
					}else {
						t.setOptionValue("错误");
					}
				}
				if("1".equals(tjo.getIsAnswer())) { //是正确答案时
					//并且为单选时
					if("0".equals(tSubject.getSubjectType())) {
						sbStr.append(tjo.getOptionValue());
					}else if("1".equals(tSubject.getSubjectType())){						
						//多选题  正确答案 需要拼接
						sbStr.append(tjo.getOptionValue());
						//最后一个正确答案时,不加逗号
						if(h!=1) {
							sbStr.append(",");
						}
						h--;
					}
				}
				
				t.setOptionValue(tjo.getOptionValue());		/** 选项 */	
				t.setContent(tjo.getContent());//内容		
				int i =tSubjectOptionMapper.insertTSubjectOption(t);
				if(i ==0) {
					return AjaxResult.error();
				}
			}
			
		}
		tSubject.setTrueAnswer(sbStr.toString());//正确答案
		int j = tSubjectMapper.insertTSubject(tSubject);
		if(j ==0) {
			return AjaxResult.error();
		}
	    return AjaxResult.success();
	}
	
	/**
     * 修改题库
     * 
     * @param tSubject 题库信息
     * @return 结果
     */
	@Override
	public AjaxResult updateTSubject(TSubject tSubject)
	{
		AjaxResult aj=checkParam(tSubject);
		if(aj!=null) {
			return aj;
		}
		//生成题库主键ID
		String uuid = tSubject.getId();
		StringBuilder sbStr =new StringBuilder();
		tSubject.setCreateDate(new Date());
		tSubject.setAddUserId(ShiroUtils.getUserId().toString());
		//添加是否有正确答案标识  默认没有
		boolean isTrue=false;
		//计算正确答案数
		int h=0;
		for(TSubjectOption temp:tSubject.getSubList()) {
			//当为判断或者单选时，仅允许有一个正确答案
			if("0".equals(tSubject.getSubjectType()) || "2".equals(tSubject.getSubjectType())) {
				if("1".equals(temp.getIsAnswer())) { //是正确答案时
					isTrue=true;
					h++;
				}
			}else {
				//多选题不用统计正确答案数
				if("1".equals(temp.getIsAnswer())) { //是正确答案时
					isTrue=true;
					h++;
				}
			}
			
		}
		if(!isTrue) {
			return AjaxResult.error(2, "选项里面必须要有一个正确答案");					
		}
		//若为单选题或者判断题时,仅只能有一个正确答案
		if( ("0".equals(tSubject.getSubjectType()) || "2".equals(tSubject.getSubjectType())) && h>=2) {
			return AjaxResult.error(2, "单选题或者判断题里面必须要有一个且仅有一个正确答案");
		}
		//若为多选题时,正确答案必须大于两个
		if("1".equals(tSubject.getSubjectType()) && h <=1) {
			return AjaxResult.error(2, "多选题必须要有两个以上正确答案");
		}		
		if(tSubject.getSubList().size() > 0) {		
			tSubjectOptionMapper.deleteTSubjectOptionById(tSubject.getId());
			for(TSubjectOption tjo:tSubject.getSubList()) {
				TSubjectOption t= new TSubjectOption();
				t.setSubjectId(uuid);
				t.setIsAnswer(tjo.getIsAnswer());	/** 是否是答案1是0否 */
				//若为判断题,则内容里面无须写东西，系统默认 A：正确   B：错误
				if("2".equals(tSubject.getSubjectType())) { 
					if(tjo.getContent()!=null && !"".equals(tjo.getContent()) && !"".equals(tjo.getContent().trim())) {
						return AjaxResult.error(2, "判断题内容无须输入");
					}
					if("1".equals(tjo.getIsAnswer())) { //是正确答案时
						t.setOptionValue("正确");
					}else {
						t.setOptionValue("错误");
					}
				}
				if("1".equals(tjo.getIsAnswer())) { //是正确答案时
					//并且为单选时
					if("0".equals(tSubject.getSubjectType())) {
						sbStr.append(tjo.getOptionValue());
					}else if("1".equals(tSubject.getSubjectType())){						
						//多选题  正确答案 需要拼接
						sbStr.append(tjo.getOptionValue());
						//最后一个正确答案时,不加逗号
						if(h!=1) {
							sbStr.append(",");
						}
						h--;
					}
				}
				
				t.setOptionValue(tjo.getOptionValue());		/** 选项 */	
				t.setContent(tjo.getContent());//内容		
				int i =tSubjectOptionMapper.insertTSubjectOption(t);
				if(i ==0) {
					return AjaxResult.error();
				}
			}
			
		}
		tSubject.setTrueAnswer(sbStr.toString());//正确答案

		int j = tSubjectMapper.updateTSubject(tSubject);
		if(j ==0) {
			return AjaxResult.error();
		}
	    return AjaxResult.success();
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
	
	private boolean regCheck(Object obj) {
		if(obj == null || "".equals(obj)) {
			return true;
		}
		return false;
	}

	@Override
	public List<TSubject> selectTSubjectListByOneData(TSubject tSubject) {
		return tSubjectMapper.selectTSubjectListByOne(tSubject);	
	}

	@Override
	public List<TSubject> selectTPaperListByPageId(String ids) {
		return tSubjectMapper.selectTSubjectListByPageId(Convert.toStrArray(ids));
	}
	
	private AjaxResult checkParam(TSubject tSubject) {
		if(regCheck(tSubject) || regCheck(tSubject.getSubject())) {
			return AjaxResult.error(2, "题目名称不能为空");
		}
		if(regCheck(tSubject.getItemType())) {
			return AjaxResult.error(2, "题目类型不能为空");
		}
		/** 选择类型  0:单选  1:多选   2:判断 */
		if(regCheck(tSubject.getSubjectType())) {
			return AjaxResult.error(2, "选择类型不能为空");
		}
		if(regCheck(tSubject.getSubjectType())) {
			return AjaxResult.error(2, "选择类型不能为空");
		}
		List<TSubjectOption> listAll = JSONArray.parseArray(tSubject.getSubListDetail(),TSubjectOption.class);
		tSubject.setSubList(listAll);
		if(regCheck(tSubject.getSubList())&& regCheck(tSubject.getSubListDetail())) {
			return AjaxResult.error(2, "选择题选项不能为空");
		}
		//若为判断题时,选项最多两个
		if("2".equals(tSubject.getSubjectType()) && tSubject.getSubList().size() !=2) {
			return AjaxResult.error(2, "判断题选项只能有两个");
		}
		//所有题的选项必须大于等于2
		if(tSubject.getSubList().size() <2) {
			return AjaxResult.error(2, "选项最少两个");
		}
		//判断选项里面不能有重复
		int a=0;
		int b=0;
		int c=0;
		int d=0;
		for(TSubjectOption ts:listAll) {
			if("A".equals(ts.getOptionValue())) {
				a++;
				if(a>=2) {
					return AjaxResult.error(2, "A选项不能有重复");
				}
			}else if("B".equals(ts.getOptionValue())) {
				b++;
				if(b>=2) {
					return AjaxResult.error(2, "B选项不能有重复");
				}
			}else if("C".equals(ts.getOptionValue())) {
				c++;
				if(c>=2) {
					return AjaxResult.error(2, "C选项不能有重复");
				}
			}else {
				d++;
				if(d>=2) {
					return AjaxResult.error(2, "D选项不能有重复");
				}
			}
		}
		//ABCD 必须按顺序出现
		if(a==0 ) {
			return AjaxResult.error(2, "A选项不能缺失");
		}
		//ABCD 必须按顺序出现
		if(b==0 ) {
			return AjaxResult.error(2, "B选项不能缺失");
		}
		if(c==0 && d>0) {
			return AjaxResult.error(2, "C选项不能缺失");
		}
	
		return null;
		
	}

	@Override
	public List<TSubject> selectTPaperListByNotInPageId(TSubject tSubject) {
		
		return tSubjectMapper.selectTSubjectListByBusiness(tSubject);
	}
	
	@Override
	public List<TSubject> selectTPaperListAllByInPageId(TSubject tSubject) {
		
		return tSubjectMapper.selectTSubjectListAllByPageId(tSubject);
	}
	
}
