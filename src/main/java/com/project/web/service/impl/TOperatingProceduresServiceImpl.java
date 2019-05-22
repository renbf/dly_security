package com.project.web.service.impl;

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
import com.project.web.domian.TOperatingProcedures;
import com.project.web.mapper.TOperatingProceduresMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITOperatingProceduresService;

/**
 * 操作规程 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TOperatingProceduresServiceImpl implements ITOperatingProceduresService 
{
	@Autowired
	private TOperatingProceduresMapper tOperatingProceduresMapper;
	@Autowired
	private IFileService fileService;

	/**
     * 查询操作规程信息
     * 
     * @param id 操作规程ID
     * @return 操作规程信息
     */
    @Override
	public TOperatingProcedures selectTOperatingProceduresById(String id)
	{
	    return tOperatingProceduresMapper.selectTOperatingProceduresById(id);
	}
	
	/**
     * 查询操作规程列表
     * 
     * @param tOperatingProcedures 操作规程信息
     * @return 操作规程集合
     */
	@Override
	public List<TOperatingProcedures> selectTOperatingProceduresList(TOperatingProcedures tOperatingProcedures)
	{
	    return tOperatingProceduresMapper.selectTOperatingProceduresList(tOperatingProcedures);
	}
	
    /**
     * 新增操作规程
     * 
     * @param tOperatingProcedures 操作规程信息
     * @return 结果
     */
	@Override
	public int insertTOperatingProcedures(TOperatingProcedures tOperatingProcedures,MultipartFile operatingFile)
	{
		String uuid= UUIDUtil.getUUID();
		tOperatingProcedures.setId(uuid);
		tOperatingProcedures.setCreateTime(new Date());
		tOperatingProcedures.setIsApply("1");//适用     0：不适用
		try {			
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(operatingFile)&&StringUtils.isNotEmpty(operatingFile.getOriginalFilename())){
				String Str = fileService.upolad("caozuoguicheng",uuid,"操作规程文件",operatingFile,0,tOperatingProcedures.getBusinessId());
				tOperatingProcedures.setOperatingFilePath(Str);
			}	
		} catch (Exception e) {
			e.getStackTrace();
		}
		return tOperatingProceduresMapper.insertTOperatingProcedures(tOperatingProcedures);
	}
	
	/**
     * 修改操作规程
     * 
     * @param tOperatingProcedures 操作规程信息
     * @return 结果
     */
	@Override
	public int updateTOperatingProcedures(TOperatingProcedures tOperatingProcedures,MultipartFile operatingFile)
	{
		try {		
			tOperatingProcedures.setUpdateTime(new Date());
			tOperatingProcedures.setUpdateUserId(ShiroUtils.getUserId());
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(operatingFile)&&StringUtils.isNotEmpty(operatingFile.getOriginalFilename())){
				String Str = fileService.upolad("caozuoguicheng",tOperatingProcedures.getId(),"操作规程文件",operatingFile,0,tOperatingProcedures.getBusinessId());
				tOperatingProcedures.setOperatingFilePath(Str);
			}	
		} catch (Exception e) {
			e.getStackTrace();
		}
		return tOperatingProceduresMapper.updateTOperatingProcedures(tOperatingProcedures);
	}

	/**
     * 删除操作规程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTOperatingProceduresByIds(String ids)
	{
		return tOperatingProceduresMapper.deleteTOperatingProceduresByIds(Convert.toStrArray(ids));
	}
	
}
