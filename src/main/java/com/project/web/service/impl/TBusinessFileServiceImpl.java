package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TBusinessFile;
import com.project.web.mapper.TBusinessFileMapper;
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
	public int insertTBusinessFile(TBusinessFile tBusinessFile)
	{
		tBusinessFile.setId(UUIDUtil.getUUID());
		tBusinessFile.setCreateTime(new Date());
		tBusinessFile.setUserId(ShiroUtils.getUserId());
		return tBusinessFileMapper.insertTBusinessFile(tBusinessFile);
	}
	
	/**
     * 修改企业文件
     * 
     * @param tBusinessFile 企业文件信息
     * @return 结果
     */
	@Override
	public int updateTBusinessFile(TBusinessFile tBusinessFile)
	{
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
