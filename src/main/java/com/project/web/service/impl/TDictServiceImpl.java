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
		
	     Map<String, Object> allMap = new HashMap<>();
		 AjaxResult ajaxResult= AjaxResult.success();
		//查询行车检查参数
		if("car_info".equals(tDict.getDictCode())) {
			return queryCarIno(tDict);
		}
		//查询检查类型参数
		if("check_type".equals(tDict.getDictCode())) {
			TDict t =new TDict();
			t.setRemark("1");
			t.setDictCode(tDict.getDictCode());
			List<TDict> allInfo = tDictMapper.selectTDictList(tDict);
			allMap.put("checkTypeList", allInfo);
			ajaxResult.put("data", allMap);
		}else {
			List<TDict> allInfo = tDictMapper.selectTDictList(tDict);
			allMap.put("List", allInfo);
			ajaxResult.put("data", allMap);
		}
		
		
	     return AjaxResult.error();
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
		String uuid = UUIDUtil.getUUID();
		tDict.setId(uuid);
		tDict.setDictCode(tDict.getDictCode());//字典类型
		tDict.setStatus("0");//有效
		tDict.setCreateDate(new Date());
		tDict.setAddUserId(ShiroUtils.getUserId()+"");
		//判断是否有一级子项
		if(tDict.getChildOneList() !=null && tDict.getChildOneList().size() >0) {
			//若有则进行遍历
			for(TDict td1:tDict.getChildOneList()) {
				String uuidOne = UUIDUtil.getUUID(); //生成一级子项的主键ID
				TDict one =new TDict();
				one.setId(uuidOne);
				one.setParentId(uuid);//总项目的主键ID
				one.setDictCode(tDict.getDictCode());//字典类型
				one.setStatus("0");//有效
				one.setCreateDate(new Date());
				one.setAddUserId(ShiroUtils.getUserId()+"");
				one.setDictName(td1.getDictName());//名称
				//判断是否有二级子项   
				if(tDict.getChildTwoList()!=null && tDict.getChildTwoList().size()>0) {
					for(TDict td2:tDict.getChildTwoList()) {
						//若有则进行遍历
						String uuidTwo = UUIDUtil.getUUID(); //生成二级子项的主键ID
						TDict two =new TDict();
						two.setId(uuidTwo);
						two.setParentId(uuidOne);//一级子项的主键ID
						two.setDictCode(tDict.getDictCode());//字典类型
						two.setStatus("0");//有效
						two.setCreateDate(new Date());
						two.setAddUserId(ShiroUtils.getUserId()+"");
						two.setDictName(td2.getDictName());//名称
						tDictMapper.insertTDict(two);//新增为二级子类
					}				
					
				}
				tDictMapper.insertTDict(one);//新增一级子类
			}
		}
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
	
	
	//查询行车前  行车中 行车后参数
	private AjaxResult queryCarIno(TDict tDict) {
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
}
