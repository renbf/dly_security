package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TOutNewspaperClassVehicle;
import com.project.web.mapper.TOutNewspaperClassVehicleMapper;
import com.project.web.service.ITOutNewspaperClassVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 未报班车辆 服务层实现
 *
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TOutNewspaperClassVehicleServiceImpl implements ITOutNewspaperClassVehicleService {
    @Autowired
    private TOutNewspaperClassVehicleMapper tOutNewspaperClassVehicleMapper;

    /**
     * 查询未报班车辆信息
     *
     * @param id 未报班车辆ID
     * @return 未报班车辆信息
     */
    @Override
    public TOutNewspaperClassVehicle selectTOutNewspaperClassVehicleById(String id) {
        return tOutNewspaperClassVehicleMapper.selectTOutNewspaperClassVehicleById(id);
    }

    /**
     * 查询未报班车辆列表
     *
     * @param tOutNewspaperClassVehicle 未报班车辆信息
     * @return 未报班车辆集合
     */
    @Override
    public List<TOutNewspaperClassVehicle> selectTOutNewspaperClassVehicleList(TOutNewspaperClassVehicle tOutNewspaperClassVehicle) {
        return tOutNewspaperClassVehicleMapper.selectTOutNewspaperClassVehicleList(tOutNewspaperClassVehicle);
    }

    /**
     * 新增未报班车辆
     *
     * @param tOutNewspaperClassVehicle 未报班车辆信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTOutNewspaperClassVehicle(TOutNewspaperClassVehicle tOutNewspaperClassVehicle) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传 //没有
        //insert公共
        tOutNewspaperClassVehicle.setId(uuid);
        tOutNewspaperClassVehicle.setCreateTime(new Date());
        tOutNewspaperClassVehicle.setUserId(ShiroUtils.getUserId());
        return tOutNewspaperClassVehicleMapper.insertTOutNewspaperClassVehicle(tOutNewspaperClassVehicle) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改未报班车辆
     *
     * @param tOutNewspaperClassVehicle 未报班车辆信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTOutNewspaperClassVehicle(TOutNewspaperClassVehicle tOutNewspaperClassVehicle) {
        //校验
        //文件上传 //没有
        //update公共
        tOutNewspaperClassVehicle.setUpdateTime(new Date());
        tOutNewspaperClassVehicle.setUpdateUserId(ShiroUtils.getUserId());
        return tOutNewspaperClassVehicleMapper.updateTOutNewspaperClassVehicle(tOutNewspaperClassVehicle) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除未报班车辆对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTOutNewspaperClassVehicleByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tOutNewspaperClassVehicleMapper.deleteTOutNewspaperClassVehicleByIds(Convert.toStrArray(ids));
        }
        return 0;
    }

}