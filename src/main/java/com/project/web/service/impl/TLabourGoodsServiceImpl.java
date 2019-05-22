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
import com.project.web.domian.TLabourGoodsDetail;
import com.project.web.mapper.TLabourGoodsMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITLabourGoodsDetailService;
import com.project.web.service.ITLabourGoodsService;

/**
 * 劳动防护物品 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TLabourGoodsServiceImpl implements ITLabourGoodsService 
{
	@Autowired
	private TLabourGoodsMapper tLabourGoodsMapper;
	@Autowired
	private IFileService fileService;
	@Autowired
	private ITLabourGoodsDetailService tLabourGoodsDetailService;

	/**
     * 查询劳动防护物品信息
     * 
     * @param id 劳动防护物品ID
     * @return 劳动防护物品信息
     */
    @Override
	public TLabourGoods selectTLabourGoodsById(Long id)
	{
	    return tLabourGoodsMapper.selectTLabourGoodsById(id);
	}
	
	/**
     * 查询劳动防护物品列表
     * 
     * @param tLabourGoods 劳动防护物品信息
     * @return 劳动防护物品集合
     */
	@Override
	public List<TLabourGoods> selectTLabourGoodsList(TLabourGoods tLabourGoods)
	{
	    return tLabourGoodsMapper.selectTLabourGoodsList(tLabourGoods);
	}
	
    /**
     * 新增劳动防护物品
     * 
     * @param tLabourGoods 劳动防护物品信息
     * @return 结果
     */
	@Override
	public AjaxResult insertTLabourGoods(TLabourGoods tLabourGoods,MultipartFile labourGoodsFile)
	{
		try {
			if(tLabourGoods==null || tLabourGoods.getGrantDate()==null) {
				return AjaxResult.error(2, "发放日期不能为空");
			}
			if(tLabourGoods.getLabourGoodDetailList()==null) {
				return AjaxResult.error(2, "领取人不能为空");
			}
			if(tLabourGoods.getGoodsName()==null || "".equals(tLabourGoods.getGoodsName())) {
				return AjaxResult.error(2, "发放物品不能为空");
			}
			String uuid = UUIDUtil.getUUID();
			tLabourGoods.setId(uuid);
			tLabourGoods.setCreateTime(new Date());
			tLabourGoods.setUserId(ShiroUtils.getUserId());//创建人
			//若文件不为空   则进行上传文件
			if(Objects.nonNull(labourGoodsFile)&&StringUtils.isNotEmpty(labourGoodsFile.getOriginalFilename())){
				String Str = fileService.upolad("laodongfanghu",uuid,"劳动防护物品信息文件",labourGoodsFile,0,tLabourGoods.getBusinessId());
				tLabourGoods.setFilePath(Str);
			}			
			int i = tLabourGoodsMapper.insertTLabourGoods(tLabourGoods);
			if(i==0) {
				return AjaxResult.error(2, "操作失败");
			}
			//插入物品领取明细表 记录领取人
			for(TLabourGoodsDetail tl:tLabourGoods.getLabourGoodDetailList()){
				TLabourGoodsDetail tg =new TLabourGoodsDetail();
				tg.setId(UUIDUtil.getUUID());//自己的主键
				tg.setLabourGoodsId(uuid);//物品领取表 的主键id
				tg.setReceiveUserId(tl.getReceiveUserId());//领取人user_id
				tg.setReceivePer(tl.getReceivePer());//领取人的姓名
				tg.setSex(tl.getSex());
				tLabourGoodsDetailService.insertTLabourGoodsDetail(tg);
			}
			
							
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return AjaxResult.success(); 
	}
	
	/**
     * 修改劳动防护物品
     * 
     * @param tLabourGoods 劳动防护物品信息
     * @return 结果
     */
	@Override
	public AjaxResult updateTLabourGoods(TLabourGoods tLabourGoods,MultipartFile labourGoodsFile)
	{
		if(tLabourGoods==null || tLabourGoods.getGrantDate()==null) {
			return AjaxResult.error(2, "发放日期不能为空");
		}
		if(tLabourGoods.getLabourGoodDetailList()==null) {
			return AjaxResult.error(2, "领取人不能为空");
		}
		if(tLabourGoods.getGoodsName()==null || "".equals(tLabourGoods.getGoodsName())) {
			return AjaxResult.error(2, "发放物品不能为空");
		}
		//若文件不为空   则进行上传文件
		if(Objects.nonNull(labourGoodsFile)&&StringUtils.isNotEmpty(labourGoodsFile.getOriginalFilename())){
		
			try {
				String Str = fileService.upolad("laodongfanghu",tLabourGoods.getId(),"劳动防护物品信息文件",labourGoodsFile,0,tLabourGoods.getBusinessId());
				tLabourGoods.setFilePath(Str);
				int i = tLabourGoodsMapper.insertTLabourGoods(tLabourGoods);
				if(i==0) {
					return AjaxResult.error(2, "操作失败");
				}
				//对于领取人明细,先删除再新增
				int j=tLabourGoodsDetailService.deleteTLabourGoodsDetailByByGoodsId(tLabourGoods.getId());
				if(j==0) {
					return AjaxResult.error(2, "操作失败");
				}
				for(TLabourGoodsDetail tl:tLabourGoods.getLabourGoodDetailList()){
					TLabourGoodsDetail tg =new TLabourGoodsDetail();
					tg.setId(UUIDUtil.getUUID());//自己的主键
					tg.setLabourGoodsId(tLabourGoods.getId());//物品领取表 的主键id
					tg.setReceiveUserId(tl.getReceiveUserId());//领取人user_id
					tg.setReceivePer(tl.getReceivePer());//领取人的姓名
					tg.setSex(tl.getSex());
					tLabourGoodsDetailService.insertTLabourGoodsDetail(tg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}			

		
		return AjaxResult.success();
	}

	/**
     * 删除劳动防护物品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTLabourGoodsByIds(String ids)
	{
		int i = tLabourGoodsMapper.deleteTLabourGoodsByIds(Convert.toStrArray(ids));
		if(i==0) {
			return 0;
		}
		int j=tLabourGoodsDetailService.deleteTLabourGoodsDetailByByGoodsId(ids);
		if(j==0) {
			return 0;
		}
		return 1;
	}
	
}

