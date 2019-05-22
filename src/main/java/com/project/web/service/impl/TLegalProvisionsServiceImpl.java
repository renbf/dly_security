package com.project.web.service.impl;

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
import com.project.util.UUIDUtil;
import com.project.web.domian.TLegalProvisions;
import com.project.web.mapper.TLegalProvisionsMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITLegalProvisionsService;

/**
 * 法律法规 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TLegalProvisionsServiceImpl implements ITLegalProvisionsService 
{
	@Autowired
	private TLegalProvisionsMapper tLegalProvisionsMapper;
	@Autowired
	private IFileService fileService;

	/**
     * 查询法律法规信息
     * 
     * @param id 法律法规ID
     * @return 法律法规信息
     */
    @Override
	public TLegalProvisions selectTLegalProvisionsById(String id)
	{
	    return tLegalProvisionsMapper.selectTLegalProvisionsById(id);
	}
	
	/**
     * 查询法律法规列表
     * 
     * @param tLegalProvisions 法律法规信息
     * @return 法律法规集合
     */
	@Override
	public List<TLegalProvisions> selectTLegalProvisionsList(TLegalProvisions tLegalProvisions)
	{
	    return tLegalProvisionsMapper.selectTLegalProvisionsList(tLegalProvisions);
	}
	
    /**
     * 新增法律法规
     * 
     * @param tLegalProvisions 法律法规信息
     * @return 结果
     */
	@Override
	public AjaxResult insertTLegalProvisions(TLegalProvisions tLegalProvisions,MultipartFile legalFile)
	{
		if(tLegalProvisions==null || tLegalProvisions.getLegalName()==null || "".equals(tLegalProvisions.getLegalName())) {
			return AjaxResult.error(2,"法规名称不允许为空");
		}
		if(tLegalProvisions.getLegalType() ==null || "".equals(tLegalProvisions.getLegalType())) {
			return AjaxResult.error(2,"类别不允许为空");
		}
		if(tLegalProvisions.getLegalUnit() ==null || "".equals(tLegalProvisions.getLegalUnit())) {
			return AjaxResult.error(2,"颁发单位不允许为空");
		}
		if(tLegalProvisions.getLegalDeptId() ==null ) {
			return AjaxResult.error(2,"部门不允许为空");
		}
		try {
			String uuid = UUIDUtil.getUUID();
			tLegalProvisions.setId(uuid);
			tLegalProvisions.setCreateTime(new Date());
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(legalFile)&&StringUtils.isNotEmpty(legalFile.getOriginalFilename())){
				String Str = fileService.upolad("falvfagui",uuid,"法律法规文件",legalFile,0,tLegalProvisions.getBusinessId());
				tLegalProvisions.setLegalFilePath(Str);
			}
			int i = tLegalProvisionsMapper.insertTLegalProvisions(tLegalProvisions);
			if(i==1) {
				return AjaxResult.success();
			}
		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
		}
	
		return AjaxResult.error();
	}
	
	/**
     * 修改法律法规
     * 
     * @param tLegalProvisions 法律法规信息
     * @return 结果
     */
	@Override
	public AjaxResult updateTLegalProvisions(TLegalProvisions tLegalProvisions,MultipartFile legalFile)
	{
		try {
			tLegalProvisions.setUpdateTime(new Date());
			tLegalProvisions.setUpdateUserId(ShiroUtils.getUserId());
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(legalFile)&&StringUtils.isNotEmpty(legalFile.getOriginalFilename())){
				String Str = fileService.upolad("falvfagui",tLegalProvisions.getId(),"法律法规文件",legalFile,0,tLegalProvisions.getBusinessId());
				tLegalProvisions.setFilePath(Str);
			}
			int i = tLegalProvisionsMapper.updateTLegalProvisions(tLegalProvisions);
			if(i >=1) {
				return AjaxResult.success();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return AjaxResult.error();
	}

	/**
     * 删除法律法规对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTLegalProvisionsByIds(String ids)
	{
		return tLegalProvisionsMapper.deleteTLegalProvisionsByIds(Convert.toStrArray(ids));
	}
	
	private boolean regCheck(Object obj) {
		if(obj==null || "".equals(obj)) {
			return true;
		}
		return false;
	}
	
}
