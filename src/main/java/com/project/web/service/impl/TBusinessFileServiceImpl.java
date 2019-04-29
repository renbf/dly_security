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
import com.project.web.domian.TBusinessFile;
import com.project.web.mapper.TBusinessFileMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITBusinessFileService;

/**
 * 企业文件 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TBusinessFileServiceImpl implements ITBusinessFileService 
{
	@Autowired
	private TBusinessFileMapper tBusinessFileMapper;
	@Autowired
	private IFileService fileService;

	/**
     * 查询企业文件信息
     * 
     * @param id 企业文件ID
     * @return 企业文件信息
     */
    @Override
	public TBusinessFile selectTBusinessFileById(String id)
	{
	    return tBusinessFileMapper.selectTBusinessFileById(id);
	}
	
	/**
     * 查询企业文件列表
     * 
     * @param tBusinessFile 企业文件信息
     * @return 企业文件集合
     */
	@Override
	public List<TBusinessFile> selectTBusinessFileList(TBusinessFile tBusinessFile)
	{
	    return tBusinessFileMapper.selectTBusinessFileList(tBusinessFile);
	}
	
    /**
     * 新增企业文件
     * 
     * @param tBusinessFile 企业文件信息
     * @return 结果
     */
	@Override
	public int insertTBusinessFile(TBusinessFile tBusinessFile,MultipartFile businessFile)
	{
		String uuid= UUIDUtil.getUUID();
		tBusinessFile.setId(uuid);
		tBusinessFile.setCreateTime(new Date());
		tBusinessFile.setUserId(ShiroUtils.getUserId());
		try {			
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(businessFile)&&StringUtils.isNotEmpty(businessFile.getOriginalFilename())){
				String Str = fileService.upolad("qiyewenjian",uuid,"企业文件附件",businessFile,0);
				tBusinessFile.setBusinessFilePath(Str);
			}	
		} catch (Exception e) {
			e.getStackTrace();
		}
		return tBusinessFileMapper.insertTBusinessFile(tBusinessFile);
	}
	
	/**
     * 修改企业文件
     * 
     * @param tBusinessFile 企业文件信息
     * @return 结果
     */
	@Override
	public int updateTBusinessFile(TBusinessFile tBusinessFile,MultipartFile businessFile)
	{
		try {			
			tBusinessFile.setUpdateTime(new Date());
			tBusinessFile.setUpdateUserId(ShiroUtils.getUserId());
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(businessFile)&&StringUtils.isNotEmpty(businessFile.getOriginalFilename())){
				String Str = fileService.upolad("qiyewenjian",tBusinessFile.getId(),"企业文件附件",businessFile,0);
				tBusinessFile.setBusinessFilePath(Str);
			}	
		} catch (Exception e) {
			e.getStackTrace();
		}
		return tBusinessFileMapper.updateTBusinessFile(tBusinessFile);
	}

	/**
     * 删除企业文件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTBusinessFileByIds(String ids)
	{
		return tBusinessFileMapper.deleteTBusinessFileByIds(Convert.toStrArray(ids));
	}
	
}
