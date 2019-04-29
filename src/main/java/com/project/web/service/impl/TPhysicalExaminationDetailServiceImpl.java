package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TPhysicalExaminationDetail;
import com.project.web.mapper.TPhysicalExaminationDetailMapper;
import com.project.web.service.ITPhysicalExaminationDetailService;

/**
 * 体检记录明细 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TPhysicalExaminationDetailServiceImpl implements ITPhysicalExaminationDetailService 
{
	@Autowired
	private TPhysicalExaminationDetailMapper tPhysicalExaminationDetailMapper;

	/**
     * 查询体检记录明细信息
     * 
     * @param id 体检记录明细ID
     * @return 体检记录明细信息
     */
    @Override
	public TPhysicalExaminationDetail selectTPhysicalExaminationDetailById(String id)
	{
	    return tPhysicalExaminationDetailMapper.selectTPhysicalExaminationDetailById(id);
	}
	
	/**
     * 查询体检记录明细列表
     * 
     * @param tPhysicalExaminationDetail 体检记录明细信息
     * @return 体检记录明细集合
     */
	@Override
	public List<TPhysicalExaminationDetail> selectTPhysicalExaminationDetailList(TPhysicalExaminationDetail tPhysicalExaminationDetail)
	{
	    return tPhysicalExaminationDetailMapper.selectTPhysicalExaminationDetailList(tPhysicalExaminationDetail);
	}
	
    /**
     * 新增体检记录明细
     * 
     * @param tPhysicalExaminationDetail 体检记录明细信息
     * @return 结果
     */
	@Override
	public int insertTPhysicalExaminationDetail(TPhysicalExaminationDetail tPhysicalExaminationDetail)
	{
		tPhysicalExaminationDetail.setId(UUIDUtil.getUUID());
		tPhysicalExaminationDetail.setCreateTime(new Date());
		return tPhysicalExaminationDetailMapper.insertTPhysicalExaminationDetail(tPhysicalExaminationDetail);
	}
	
	/**
     * 修改体检记录明细
     * 
     * @param tPhysicalExaminationDetail 体检记录明细信息
     * @return 结果
     */
	@Override
	public int updateTPhysicalExaminationDetail(TPhysicalExaminationDetail tPhysicalExaminationDetail)
	{
	    return tPhysicalExaminationDetailMapper.updateTPhysicalExaminationDetail(tPhysicalExaminationDetail);
	}

	/**
     * 删除体检记录明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTPhysicalExaminationDetailByIds(String ids)
	{
		return tPhysicalExaminationDetailMapper.deleteTPhysicalExaminationDetailByIds(Convert.toStrArray(ids));
	}

	@Override
	public int deleteTPhysicalExaminationDetailByexaminationIds(String examinationId) {
		return tPhysicalExaminationDetailMapper.deleteTPhysicalExaminationDetailByexaminationIds(examinationId);
	}

	@Override
	public List<TPhysicalExaminationDetail> selectTPhysicalExaminationDetailListById(
			TPhysicalExaminationDetail tPhysicalExaminationDetail) {
		
		return tPhysicalExaminationDetailMapper.selectTPhysicalExaminationDetailListById(tPhysicalExaminationDetail);
	}
	
}

