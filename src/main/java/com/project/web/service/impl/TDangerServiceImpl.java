package com.project.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Objects;
import java.util.Date;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.web.mapper.TDangerMapper;
import com.project.web.domian.TDanger;
import com.project.web.service.IFileService;
import com.project.web.service.ITDangerService;
import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;

/**
 * 隐患 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDangerServiceImpl implements ITDangerService 
{
	private static final Logger log = LoggerFactory.getLogger(TDangerServiceImpl.class);
	@Autowired
	@Qualifier("tDangerMapper")
	private TDangerMapper tDangerMapper;
    @Autowired
    private IFileService fileService;

	/**
     * 查询隐患信息
     * 
     * @param id 隐患ID
     * @return 隐患信息
     */
    @Override
	public TDanger selectTDangerById(String id)
	{
	    return tDangerMapper.selectTDangerById(id);
	}
	
	/**
     * 查询隐患列表
     * 
     * @param tDanger 隐患信息
     * @return 隐患集合
     */
	@Override
	public List<TDanger> selectTDangerList(TDanger tDanger)
	{
	    return tDangerMapper.selectTDangerList(tDanger);
	}
	
    /**
     * 新增隐患
     * 
     * @param tDanger 隐患信息
     * @return 结果
     */
	@Override
	public int insertTDanger(TDanger tDanger)
	{
		tDanger.setId(UUIDUtil.getUUID());
		tDanger.setCreateDate(new Date());
		tDanger.setAddUserId(ShiroUtils.getUserId().toString());
	    return tDangerMapper.insertTDanger(tDanger);
	}
	
	/**
     * 修改隐患
     * 
     * @param tDanger 隐患信息
     * @return 结果
     */
	@Override
	public int updateTDanger(TDanger tDanger,MultipartFile dochangePicture)
	{
	    try {
	    	if (Objects.nonNull(dochangePicture) && StringUtils.isNotEmpty(dochangePicture.getOriginalFilename())) {
                String upolad = this.fileService.upolad("zhenggaizhaopian", tDanger.getId(), "整改照片文件", dochangePicture, 0,tDanger.getBusinessId());
                tDanger.setDochangePicture(upolad);
            }
	    	tDanger.setDochangeDate(new Date());
	    	
		} catch (Exception e) {
			
		}
		return tDangerMapper.updateTDanger(tDanger);
	}

	/**
     * 删除隐患对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDangerByIds(String ids)
	{
		return tDangerMapper.deleteTDangerByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动

	@Override
	public List<TDanger> selectTDangerListByUser(TDanger tDanger) {		
		tDanger.setDochangeUserId(ShiroUtils.getUserId());
		return tDangerMapper.selectTDangerListByDochangeUser(tDanger);
	}
}
