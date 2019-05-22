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
import com.project.util.UUIDUtil;
import com.project.web.domian.TLabourGoods;
import com.project.web.domian.TRelevantMessage;
import com.project.web.mapper.TRelevantMessageMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITRelevantMessageService;

/**
 * 相关方 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TRelevantMessageServiceImpl implements ITRelevantMessageService 
{
	@Autowired
	private TRelevantMessageMapper tRelevantMessageMapper;
	@Autowired
	private IFileService fileService;

	/**
     * 查询相关方信息
     * 
     * @param id 相关方ID
     * @return 相关方信息
     */
    @Override
	public TRelevantMessage selectTRelevantMessageById(Long id)
	{
	    return tRelevantMessageMapper.selectTRelevantMessageById(id);
	}
	
	/**
     * 查询相关方列表
     * 
     * @param tRelevantMessage 相关方信息
     * @return 相关方集合
     */
	@Override
	public List<TRelevantMessage> selectTRelevantMessageList(TRelevantMessage tRelevantMessage)
	{
	    return tRelevantMessageMapper.selectTRelevantMessageList(tRelevantMessage);
	}
	
    /**
     * 新增相关方
     * 
     * @param tRelevantMessage 相关方信息
     * @return 结果
     */
	@Override
	public AjaxResult insertTRelevantMessage(TRelevantMessage tRelevantMessage,MultipartFile relevantlFile)
	{
		if(tRelevantMessage.getRelevantType()==null || "".equals(tRelevantMessage.getRelevantType())) {
			return AjaxResult.error(2,"类别不能为空");
		}
		if(tRelevantMessage.getRelevantName()==null || "".equals(tRelevantMessage.getRelevantName())) {
			return AjaxResult.error(2,"名称不能为空");
		}
		if(tRelevantMessage.getRelevantContacts()==null || "".equals(tRelevantMessage.getRelevantContacts())) {
			return AjaxResult.error(2,"联系人不能为空");
		}	
		if(tRelevantMessage.getRelevantPhone() ==null || "".equals(tRelevantMessage.getRelevantPhone())) {
			return AjaxResult.error(2,"电话不能为空");
		}
		
		try {
			String uuid = UUIDUtil.getUUID();
			tRelevantMessage.setId(uuid);
			tRelevantMessage.setCreateTime(new Date());
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(relevantlFile)&&StringUtils.isNotEmpty(relevantlFile.getOriginalFilename())){
				String Str = fileService.upolad("xiangguanfang",uuid,"相关方文件",relevantlFile,0,tRelevantMessage.getBusinessId());
				tRelevantMessage.setFilePath(Str);
				
			}					
			
							
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		int i=tRelevantMessageMapper.insertTRelevantMessage(tRelevantMessage);
		if(i==1) {
			return AjaxResult.error(0, "操作成功");
		}else {
			return AjaxResult.error(2, "操作失败");
		}
	}
	
	/**
     * 修改相关方
     * 
     * @param tRelevantMessage 相关方信息
     * @return 结果
     */
	@Override
	public int updateTRelevantMessage(TRelevantMessage tRelevantMessage,MultipartFile relevantlFile)
	{
		try {
			tRelevantMessage.setUpdateUserId(ShiroUtils.getUserId());
			tRelevantMessage.setUpdateTime(new Date());
			
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(relevantlFile)&&StringUtils.isNotEmpty(relevantlFile.getOriginalFilename())){
				String Str = fileService.upolad("xiangguanfang",tRelevantMessage.getId(),"相关方文件",relevantlFile,0,tRelevantMessage.getBusinessId());
				tRelevantMessage.setFilePath(Str);
				
			}					
			
							
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tRelevantMessageMapper.updateTRelevantMessage(tRelevantMessage);
	}

	/**
     * 删除相关方对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTRelevantMessageByIds(String ids)
	{
		return tRelevantMessageMapper.deleteTRelevantMessageByIds(Convert.toStrArray(ids));
	}
	
}