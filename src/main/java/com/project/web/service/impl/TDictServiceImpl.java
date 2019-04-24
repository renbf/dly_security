package com.project.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TDict;
import com.project.web.mapper.TDictMapper;
import com.project.web.service.ITDictService;

/**
 * 字典 服务层实现
 * 
 * @author rbf
 * @date 2019-04-22
 */
@Service
public class TDictServiceImpl implements ITDictService 
{
	@Autowired
	private TDictMapper tDictMapper;

	/**
     * 查询字典信息
     * 
     * @param id 字典ID
     * @return 字典信息
     */
    @Override
	public TDict selectTDictById(String id)
	{
	    return tDictMapper.selectTDictById(id);
	}
	
	/**
     * 查询字典列表
     * 
     * @param tDict 字典信息
     * @return 字典集合
     */
	@Override
	public AjaxResult selectTDictListCar(TDict tDict)
	{
		if(tDict ==null || "".equals(tDict.getDictCode())) {
			 return AjaxResult.error(2, "字典类型不能为空");
		}
		AjaxResult ajaxResult= AjaxResult.success();
		//总返回的数据
	     Map<String, Object> allMap = new HashMap<>();
	    List<TDict> carBeforList =null;
	    List<TDict> carNowList =null;
	    List<TDict> carafterList =null;
		List<TDict> allInfo = tDictMapper.selectTDictList(tDict);
		if(allInfo!=null && allInfo.size() > 0) {
			//定义三种参数所用到的数据	
			 String partenId="";
		     for(TDict t:allInfo) {
				//判断最顶级的id值为多少
				if("0".equals(t.getParentId())) {
					partenId=t.getId();
					break;
				}
		     }
		     //根据参数id   查询出出行车中  行车前   行车后的参数
			TDict td =new TDict();
		    td.setParentId(partenId);
		    td.setBusinessId(tDict.getBusinessId());
		    List<TDict> allInfo2 = tDictMapper.selectTDictList(td);
	    	String beforPartenId="";
			String nowPartenId="";
			String afterPartenId="";
		    if(allInfo2!=null && allInfo2.size()>0) {
		    	for(TDict t:allInfo2) {
		    		//sort 为0  行车前  1行车中   2行车后
		    		if(0==t.getDictSort()) {
		    			beforPartenId=t.getId();
		    			continue;
		    		}else if(1==t.getDictSort()) {
		    			nowPartenId=t.getId();
		    			continue;
		    		}else {
		    			afterPartenId=t.getId();
		    			continue;
		    		}
		    	}
		    	//查询行车前参数
		    	TDict before =new TDict();
		    	before.setParentId(beforPartenId);
		    	carBeforList = tDictMapper.selectTDictList(before);
		    	//查询行车中参数
		    	 TDict now =new TDict();
			     now.setParentId(nowPartenId);
			     carNowList = tDictMapper.selectTDictList(now);
			     //查询行车后参数
		    	 TDict after =new TDict();
		    	 after.setParentId(afterPartenId);
			     carafterList = tDictMapper.selectTDictList(after);
				
		    }
		    
			allMap.put("carafterList", carafterList);//行车后
			allMap.put("carNowList", carNowList);//行车中
			allMap.put("carBeforList", carBeforList);//行车前
			allMap.put("allPartenId", beforPartenId+","+nowPartenId+","+afterPartenId);//行车前
			return ajaxResult.put("data", allMap);

		}else {
			return AjaxResult.error(2, "操作失败");
		}

		
		
	     
	}
	
    /**
     * 新增字典
     * 
     * @param tDict 字典信息
     * @return 结果
     */
	@Override
	public int insertTDict(TDict tDict)
	{
		tDict.setId(UUIDUtil.getUUID());
		tDict.setDictCode(tDict.getDictCode());
		tDict.setStatus("0");
		tDict.setCreateDate(new Date());
		tDict.setAddUserId(ShiroUtils.getUserId()+"");
	    return tDictMapper.insertTDict(tDict);
	}
	
	/**
     * 修改字典
     * 
     * @param tDict 字典信息
     * @return 结果
     */
	@Override
	public int updateTDict(TDict tDict)
	{
		String[] ids =tDict.getId().split(",");
//		tDict.setArray(ids);
		tDict.setUpdateDate(new Date());
		tDict.setUpdateUserId(ShiroUtils.getUserId()+"");
		tDictMapper.updateNotStausTDictByids(tDict);
		
		return tDictMapper.updateYesStausTDictByids(tDict);
	}

	/**
     * 删除字典对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDictByIds(String ids)
	{
		return tDictMapper.deleteTDictByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<TDict> selectTDictList(TDict tDict) {
		return tDictMapper.selectTDictList(tDict);
	}
	
}
