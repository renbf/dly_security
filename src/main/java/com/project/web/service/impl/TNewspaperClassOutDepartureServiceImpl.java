package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TNewspaperClassOutDeparture;
import com.project.web.mapper.TNewspaperClassOutDepartureMapper;
import com.project.web.service.ITNewspaperClassOutDepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 报班未出站车辆 服务层实现
 *
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TNewspaperClassOutDepartureServiceImpl implements ITNewspaperClassOutDepartureService {
    @Autowired
    private TNewspaperClassOutDepartureMapper tNewspaperClassOutDepartureMapper;

    /**
     * 查询报班未出站车辆信息
     *
     * @param id 报班未出站车辆ID
     * @return 报班未出站车辆信息
     */
    @Override
    public TNewspaperClassOutDeparture selectTNewspaperClassOutDepartureById(String id) {
        return tNewspaperClassOutDepartureMapper.selectTNewspaperClassOutDepartureById(id);
    }

    /**
     * 查询报班未出站车辆列表
     *
     * @param tNewspaperClassOutDeparture 报班未出站车辆信息
     * @return 报班未出站车辆集合
     */
    @Override
    public List<TNewspaperClassOutDeparture> selectTNewspaperClassOutDepartureList(TNewspaperClassOutDeparture tNewspaperClassOutDeparture) {
        return tNewspaperClassOutDepartureMapper.selectTNewspaperClassOutDepartureList(tNewspaperClassOutDeparture);
    }

    /**
     * 新增报班未出站车辆
     *
     * @param tNewspaperClassOutDeparture 报班未出站车辆信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTNewspaperClassOutDeparture(TNewspaperClassOutDeparture tNewspaperClassOutDeparture) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传 //没有
        //insert公共
        tNewspaperClassOutDeparture.setId(uuid);
        tNewspaperClassOutDeparture.setCreateTime(new Date());
        tNewspaperClassOutDeparture.setUserId(ShiroUtils.getUserId());
        return tNewspaperClassOutDepartureMapper.insertTNewspaperClassOutDeparture(tNewspaperClassOutDeparture) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改报班未出站车辆
     *
     * @param tNewspaperClassOutDeparture 报班未出站车辆信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTNewspaperClassOutDeparture(TNewspaperClassOutDeparture tNewspaperClassOutDeparture) {
        //校验
        //文件上传 //没有
        //update公共
        tNewspaperClassOutDeparture.setUpdateTime(new Date());
        tNewspaperClassOutDeparture.setUpdateUserId(ShiroUtils.getUserId());
        return tNewspaperClassOutDepartureMapper.updateTNewspaperClassOutDeparture(tNewspaperClassOutDeparture) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除报班未出站车辆对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTNewspaperClassOutDepartureByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tNewspaperClassOutDepartureMapper.deleteTNewspaperClassOutDepartureByIds(Convert.toStrArray(ids));
        }
        return 0;
    }

}
