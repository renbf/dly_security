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
import com.project.web.domian.TManagementSystem;
import com.project.web.mapper.TManagementSystemMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITManagementSystemService;

/**
 * 管理制度 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TManagementSystemServiceImpl implements ITManagementSystemService 
{
	@Autowired
	private TManagementSystemMapper tManagementSystemMapper;
	@Autowired
	private IFileService fileService;

	/**
     * 查询管理制度信息
     * 
     * @param id 管理制度ID
     * @return 管理制度信息
     */
    @Override
	public TManagementSystem selectTManagementSystemById(String id)
	{
	    return tManagementSystemMapper.selectTManagementSystemById(id);
	}
	
	/**
     * 查询管理制度列表
     * 
     * @param tManagementSystem 管理制度信息
     * @return 管理制度集合
     */
	@Override
	public List<TManagementSystem> selectTManagementSystemList(TManagementSystem tManagementSystem)
	{
	    return tManagementSystemMapper.selectTManagementSystemList(tManagementSystem);
	}
	
    /**
     * 新增管理制度
     * 
     * @param tManagementSystem 管理制度信息
     * @return 结果
     */
	@Override
	public int insertTManagementSystem(TManagementSystem tManagementSystem,MultipartFile managementFile)
	{
		String uuid = UUIDUtil.getUUID();
		tManagementSystem.setId(uuid);
		tManagementSystem.setCreateTime(new Date());
		try {			
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(managementFile)&&StringUtils.isNotEmpty(managementFile.getOriginalFilename())){
				String Str = fileService.upolad("guanlizhidu",uuid,"管理制度文件",managementFile,0,tManagementSystem.getBusinessId());
				tManagementSystem.setManagementFilePath(Str);
			}	
		} catch (Exception e) {
			e.getStackTrace();
		}
		return tManagementSystemMapper.insertTManagementSystem(tManagementSystem);
	}
	
	/**
     * 修改管理制度
     * 
     * @param tManagementSystem 管理制度信息
     * @return 结果
     */
	@Override
	public int updateTManagementSystem(TManagementSystem tManagementSystem,MultipartFile managementFile)
	{
		try {		
			tManagementSystem.setUpdateTime(new Date());
			tManagementSystem.setUpdateUserId(ShiroUtils.getUserId());
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(managementFile)&&StringUtils.isNotEmpty(managementFile.getOriginalFilename())){
				String Str = fileService.upolad("guanlizhidu",tManagementSystem.getId(),"管理制度文件",managementFile,0,tManagementSystem.getBusinessId());
				tManagementSystem.setManagementFilePath(Str);
			}	
		} catch (Exception e) {
			e.getStackTrace();
		}
		return tManagementSystemMapper.updateTManagementSystem(tManagementSystem);
	}

	/**
     * 删除管理制度对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTManagementSystemByIds(String ids)
	{
		return tManagementSystemMapper.deleteTManagementSystemByIds(Convert.toStrArray(ids));
	}
	
}
