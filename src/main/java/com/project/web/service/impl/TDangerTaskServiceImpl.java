package com.project.web.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.enums.FileSourceTypeEnum;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TDangerTask;
import com.project.web.mapper.TDangerTaskMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITDangerTaskService;

/**
 * 危险作业 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TDangerTaskServiceImpl implements ITDangerTaskService 
{
	@Autowired
	private TDangerTaskMapper tDangerTaskMapper;
	@Autowired
	private IFileService fileService;

	/**
     * 查询危险作业信息
     * 
     * @param id 危险作业ID
     * @return 危险作业信息
     */
    @Override
	public TDangerTask selectTDangerTaskById(Long id)
	{
	    return tDangerTaskMapper.selectTDangerTaskById(id);
	}
	
	/**
     * 查询危险作业列表
     * 
     * @param tDangerTask 危险作业信息
     * @return 危险作业集合
     */
	@Override
	public List<TDangerTask> selectTDangerTaskList(TDangerTask tDangerTask)
	{
	    return tDangerTaskMapper.selectTDangerTaskList(tDangerTask);
	}
	
    /**
     * 新增危险作业
     * 
     * @param tDangerTask 危险作业信息
     * @return 结果
     */
	@Override
	public int insertTDangerTask(TDangerTask tDangerTask,MultipartFile technologyFile,MultipartFile licenceFile)
	{
		String uuid = UUIDUtil.getUUID();
		tDangerTask.setId(uuid);
		tDangerTask.setCreateTime(new Date());
		tDangerTask.setUserId(ShiroUtils.getUserId());	
		try {
			if(Objects.nonNull(technologyFile)&&StringUtils.isNotEmpty(technologyFile.getOriginalFilename())){
				String technologyStr = fileService.upolad("weixianzuoye",uuid,"危险作业技术交底文件",technologyFile,0,tDangerTask.getBusinessId());
				tDangerTask.setTechnologyFilePath(technologyStr);
				
			}	
			if(Objects.nonNull(licenceFile)&&StringUtils.isNotEmpty(licenceFile.getOriginalFilename())){
				String licenceStr = fileService.upolad("weixianzuoye",uuid,"危险作业许可文件文件",technologyFile,0,tDangerTask.getBusinessId());
				tDangerTask.setLicenceFilePath(licenceStr);
				
			}				
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	    return tDangerTaskMapper.insertTDangerTask(tDangerTask);
	    
	}
	
	/**
     * 修改危险作业
     * 
     * @param tDangerTask 危险作业信息
     * @return 结果
     */
	@Override
	public int updateTDangerTask(TDangerTask tDangerTask,MultipartFile technologyFile, MultipartFile licenceFile)
	{
		try {			
			if(Objects.nonNull(technologyFile)&&StringUtils.isNotEmpty(technologyFile.getOriginalFilename())){
				String technologyStr = fileService.upolad("weixianzuoye",tDangerTask.getId(),"危险作业技术交底文件",technologyFile,0,tDangerTask.getBusinessId());
				tDangerTask.setTechnologyFilePath(technologyStr);
				
			}	
			if(Objects.nonNull(licenceFile)&&StringUtils.isNotEmpty(licenceFile.getOriginalFilename())){
				String licenceStr = fileService.upolad("weixianzuoye",tDangerTask.getId(),"危险作业许可文件文件",technologyFile,0,tDangerTask.getBusinessId());
				tDangerTask.setLicenceFilePath(licenceStr);
				
			}				
		} catch (IOException e) {
			e.printStackTrace();
		}
		tDangerTask.setUpdateUserId(ShiroUtils.getUserId());//更新人
		tDangerTask.setUpdateTime(new Date());//更新时间
	    return tDangerTaskMapper.updateTDangerTask(tDangerTask);
	}

	/**
     * 删除危险作业对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDangerTaskByIds(String ids)
	{
		if(ids!=null && !"".equals(ids)) {
			return tDangerTaskMapper.deleteTDangerTaskByIds(Convert.toStrArray(ids));
		}
		return 0;
	}
	
}
