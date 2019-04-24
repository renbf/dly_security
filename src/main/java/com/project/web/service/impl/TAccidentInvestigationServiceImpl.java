package com.project.web.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TAccidentInvestigation;
import com.project.web.mapper.TAccidentInvestigationMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITAccidentInvestigationService;

/**
 * 事故调查 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TAccidentInvestigationServiceImpl implements ITAccidentInvestigationService 
{
	@Autowired
	private TAccidentInvestigationMapper tAccidentInvestigationMapper;
	@Autowired
	private IFileService fileService;

	/**
     * 查询事故调查信息
     * 
     * @param id 事故调查ID
     * @return 事故调查信息
     */
    @Override
	public TAccidentInvestigation selectTAccidentInvestigationById(String id)
	{
	    return tAccidentInvestigationMapper.selectTAccidentInvestigationById(id);
	}
	
	/**
     * 查询事故调查列表
     * 
     * @param tAccidentInvestigation 事故调查信息
     * @return 事故调查集合
     */
	@Override
	public List<TAccidentInvestigation> selectTAccidentInvestigationList(TAccidentInvestigation tAccidentInvestigation)
	{
	    return tAccidentInvestigationMapper.selectTAccidentInvestigationList(tAccidentInvestigation);
	}
	
    /**
     * 新增事故调查
     * 
     * @param tAccidentInvestigation 事故调查信息
     * @return 结果
     */
	@Override
	public int insertTAccidentInvestigation(TAccidentInvestigation tAccidentInvestigation,MultipartFile accidentInvestigationFile)
	{
		String uuid=UUIDUtil.getUUID();
		tAccidentInvestigation.setId(uuid);
		tAccidentInvestigation.setCreateTime(new Date());
		tAccidentInvestigation.setUserId(ShiroUtils.getUserId());
		try {
			if(Objects.nonNull(accidentInvestigationFile)&&StringUtils.isNotEmpty(accidentInvestigationFile.getOriginalFilename())){
				String acctStr = fileService.upolad("weixianzuoye",uuid,"事故调查附件上传",accidentInvestigationFile,0);
				tAccidentInvestigation.setFilePath(acctStr);
				
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	    return tAccidentInvestigationMapper.insertTAccidentInvestigation(tAccidentInvestigation);
	}
	
	/**
     * 修改事故调查
     * 
     * @param tAccidentInvestigation 事故调查信息
     * @return 结果
     */
	@Override
	public int updateTAccidentInvestigation(TAccidentInvestigation tAccidentInvestigation,MultipartFile accidentInvestigationFile)
	{
		try {
			if(Objects.nonNull(accidentInvestigationFile)&&StringUtils.isNotEmpty(accidentInvestigationFile.getOriginalFilename())){
				String acctStr = fileService.upolad("weixianzuoye",tAccidentInvestigation.getId(),"事故调查附件上传",accidentInvestigationFile,0);
				tAccidentInvestigation.setFilePath(acctStr);			
			}
			tAccidentInvestigation.setUpdateTime(new Date());
			tAccidentInvestigation.setUpdateUserId(ShiroUtils.getUserId());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    return tAccidentInvestigationMapper.updateTAccidentInvestigation(tAccidentInvestigation);
	}

	/**
     * 删除事故调查对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTAccidentInvestigationByIds(String ids)
	{
		return tAccidentInvestigationMapper.deleteTAccidentInvestigationByIds(Convert.toStrArray(ids));
	}
	
}
