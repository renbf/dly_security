package com.project.web.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.JsonUtil;
import com.project.util.UUIDUtil;
import com.project.web.domian.TPhysicalExamination;
import com.project.web.domian.TPhysicalExaminationDetail;
import com.project.web.mapper.TPhysicalExaminationMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITPhysicalExaminationDetailService;
import com.project.web.service.ITPhysicalExaminationService;

import net.sf.json.JSONObject;

/**
 * 体检记录 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TPhysicalExaminationServiceImpl implements ITPhysicalExaminationService 
{
	@Autowired
	private TPhysicalExaminationMapper tPhysicalExaminationMapper;
	@Autowired
	private IFileService fileService;
	@Autowired
	private ITPhysicalExaminationDetailService physicalExaminationDetailService;

	/**
     * 查询体检记录信息
     * 
     * @param id 体检记录ID
     * @return 体检记录信息
     */
    @Override
	public TPhysicalExamination selectTPhysicalExaminationById(Long id)
	{
	    return tPhysicalExaminationMapper.selectTPhysicalExaminationById(id);
	}
	
	/**
     * 查询体检记录列表
     * 
     * @param tPhysicalExamination 体检记录信息
     * @return 体检记录集合
     */
	@Override
	public List<TPhysicalExamination> selectTPhysicalExaminationList(TPhysicalExamination tPhysicalExamination)
	{
		List<TPhysicalExamination> mainList =tPhysicalExaminationMapper.selectTPhysicalExaminationList(tPhysicalExamination);
		//根据体检表ID查询体检的人
		if(mainList != null && mainList.size()>0) {
			TPhysicalExaminationDetail tp =new TPhysicalExaminationDetail();
			tp.setExaminationId(tPhysicalExamination.getId());
			List<TPhysicalExaminationDetail> detailList= physicalExaminationDetailService.selectTPhysicalExaminationDetailListById(tp);
			mainList.get(0).setPhysicalExaminationDetail(detailList);
		}
		return mainList;
		
	}
	
 

	/**
     * 新增体检记录
     * 
     * @param tPhysicalExamination 体检记录信息
     * @return 结果
     */
	@Override
	public AjaxResult insertTPhysicalExamination(TPhysicalExamination tPhysicalExamination,MultipartFile physicalFile)
	{

	
		  JSONObject jSONObject = JSONObject.fromObject(tPhysicalExamination.getObj());  
		  String a =jSONObject.toString();
		  TPhysicalExaminationDetail b=JsonUtil.fromJson(a, TPhysicalExaminationDetail.class);
		
		
//			String [] a= tPhysicalExamination.getPhysicalExaminationDetailStr();
//			String b =a[0];
		if( tPhysicalExamination.getId()==null) {
			return AjaxResult.error(2, "主键不能为空");
		}	
		if(tPhysicalExamination==null || tPhysicalExamination.getPhysicalDate()==null) {
			return AjaxResult.error(2, "体检时间不能为空");
		}
		if( tPhysicalExamination.getSuspectedNum()==null || "".equals(tPhysicalExamination.getSuspectedNum())) {
			return AjaxResult.error(2, "疑似病人数不能为空");
		}
		if( tPhysicalExamination.getPhysicalUnit()==null || "".equals(tPhysicalExamination.getPhysicalUnit())) {
			return AjaxResult.error(2, "体检单位不能为空");
		}

		tPhysicalExamination.setId(tPhysicalExamination.getId());
		tPhysicalExamination.setCreateTime(new Date());
		try {
			if(Objects.nonNull(physicalFile)&&StringUtils.isNotEmpty(physicalFile.getOriginalFilename())){
				String str = fileService.upolad("tijianjilu",tPhysicalExamination.getId(),"体检记录文件",physicalFile,0);
				tPhysicalExamination.setFilePath(str);				
			}		
			int i=tPhysicalExaminationMapper.insertTPhysicalExamination(tPhysicalExamination);
			if(i==0) {
				return AjaxResult.error(2, "操作失败");
			}
			//插入体检明细表
			if(tPhysicalExamination.getPhysicalExaminationDetail()!=null && tPhysicalExamination.getPhysicalExaminationDetail().size() >0) {
				for(TPhysicalExaminationDetail detail:tPhysicalExamination.getPhysicalExaminationDetail()) {
					detail.setExaminationId(tPhysicalExamination.getId());//体检记录表主键
					detail.setId(UUIDUtil.getUUID());//主键的主键
					
					i =physicalExaminationDetailService.insertTPhysicalExaminationDetail(detail);
					if(i==0) {
						return AjaxResult.error(2, "操作失败");
					}
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return AjaxResult.success();
	}
	
	/**
     * 修改体检记录
     * 
     * @param tPhysicalExamination 体检记录信息
     * @return 结果
     */
	@Override
	public AjaxResult updateTPhysicalExamination(TPhysicalExamination tPhysicalExamination,MultipartFile physicalFile)
	{
		try {
			if(tPhysicalExamination==null || tPhysicalExamination.getPhysicalDate()==null) {
				return AjaxResult.error(2, "体检时间不能为空");
			}
			if( tPhysicalExamination.getSuspectedNum()==null || "".equals(tPhysicalExamination.getSuspectedNum())) {
				return AjaxResult.error(2, "疑似病人数不能为空");
			}
			if( tPhysicalExamination.getPhysicalUnit()==null || "".equals(tPhysicalExamination.getPhysicalUnit())) {
				return AjaxResult.error(2, "体检单位不能为空");
			}
			if(Objects.nonNull(physicalFile)&&StringUtils.isNotEmpty(physicalFile.getOriginalFilename())){
				String str = fileService.upolad("tijianjilu",tPhysicalExamination.getId(),"体检记录文件",physicalFile,0);
				tPhysicalExamination.setFilePath(str);				
			}	
			tPhysicalExamination.setUpdateTime(new Date());
			tPhysicalExamination.setUpdateUserId(ShiroUtils.getUserId());
			tPhysicalExaminationMapper.updateTPhysicalExamination(tPhysicalExamination);
			int i=0;
			//更新体检明细表
			if(tPhysicalExamination.getPhysicalExaminationDetail()!=null && tPhysicalExamination.getPhysicalExaminationDetail().size() >0) {				
				//根据体检表id先删除再插入
				physicalExaminationDetailService.deleteTPhysicalExaminationDetailByexaminationIds(tPhysicalExamination.getId());
				for(TPhysicalExaminationDetail detail:tPhysicalExamination.getPhysicalExaminationDetail()) {
					detail.setExaminationId(tPhysicalExamination.getId());//体检表主键id
					detail.setId(UUIDUtil.getUUID());
					i =physicalExaminationDetailService.insertTPhysicalExaminationDetail(detail);
					if(i==0) {
						return AjaxResult.error(2, "操作失败");
					}
				}
				
			}
			
			if(i==0) {
				return AjaxResult.error(2, "操作失败");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return AjaxResult.success();
	}

	/**
     * 删除体检记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTPhysicalExaminationByIds(String ids)
	{
		int i= tPhysicalExaminationMapper.deleteTPhysicalExaminationByIds(Convert.toStrArray(ids));
		if(i==0) {
			return 0;
		}
		int j = physicalExaminationDetailService.deleteTPhysicalExaminationDetailByexaminationIds(ids);
		if(j==0) {
			return 0;
		}
		return 1;
	}
	
}

