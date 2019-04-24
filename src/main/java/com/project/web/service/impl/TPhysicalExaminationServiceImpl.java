package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TPhysicalExamination;
import com.project.web.mapper.TPhysicalExaminationMapper;
import com.project.web.service.ITPhysicalExaminationService;

/**
 * 体检记录 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TPhysicalExaminationServiceImpl implements ITPhysicalExaminationService 
{
	@Autowired
	private TPhysicalExaminationMapper tPhysicalExaminationMapper;

	/**
     * 查询体检记录信息
     * 
     * @param id 体检记录ID
     * @return 体检记录信息
     */
    @Override
	public TPhysicalExamination selectTPhysicalExaminationById(Long id)
	{
	    return tPhysicalExaminationMapper.selectTPhysicalExaminationById(id);
	}
	
	/**
     * 查询体检记录列表
     * 
     * @param tPhysicalExamination 体检记录信息
     * @return 体检记录集合
     */
	@Override
	public List<TPhysicalExamination> selectTPhysicalExaminationList(TPhysicalExamination tPhysicalExamination)
	{
	    return tPhysicalExaminationMapper.selectTPhysicalExaminationList(tPhysicalExamination);
	}
	
    /**
     * 新增体检记录
     * 
     * @param tPhysicalExamination 体检记录信息
     * @return 结果
     */
	@Override
	public int insertTPhysicalExamination(TPhysicalExamination tPhysicalExamination)
	{
		tPhysicalExamination.setId(UUIDUtil.getUUID());
		tPhysicalExamination.setCreateTime(new Date());
		return tPhysicalExaminationMapper.insertTPhysicalExamination(tPhysicalExamination);
	}
	
	/**
     * 修改体检记录
     * 
     * @param tPhysicalExamination 体检记录信息
     * @return 结果
     */
	@Override
	public int updateTPhysicalExamination(TPhysicalExamination tPhysicalExamination)
	{
	    return tPhysicalExaminationMapper.updateTPhysicalExamination(tPhysicalExamination);
	}

	/**
     * 删除体检记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTPhysicalExaminationByIds(String ids)
	{
		return tPhysicalExaminationMapper.deleteTPhysicalExaminationByIds(Convert.toStrArray(ids));
	}
	
}
