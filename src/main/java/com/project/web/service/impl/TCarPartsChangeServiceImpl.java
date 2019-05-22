package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCarPartsChange;
import com.project.web.mapper.TCarPartsChangeMapper;
import com.project.web.service.ITCarPartsChangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 车辆主要部件更换登记 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarPartsChangeServiceImpl implements ITCarPartsChangeService {
    private static final Logger log = LoggerFactory.getLogger(TCarPartsChangeServiceImpl.class);
    @Autowired
    @Qualifier("tCarPartsChangeMapper")
    private TCarPartsChangeMapper tCarPartsChangeMapper;

    /**
     * 查询车辆主要部件更换登记信息
     *
     * @param id 车辆主要部件更换登记ID
     * @return 车辆主要部件更换登记信息
     */
    @Override
    public TCarPartsChange selectTCarPartsChangeById(String id) {
        return tCarPartsChangeMapper.selectTCarPartsChangeById(id);
    }

    /**
     * 查询车辆主要部件更换登记列表
     *
     * @param tCarPartsChange 车辆主要部件更换登记信息
     * @return 车辆主要部件更换登记集合
     */
    @Override
    public List<TCarPartsChange> selectTCarPartsChangeList(TCarPartsChange tCarPartsChange) {
        return tCarPartsChangeMapper.selectTCarPartsChangeList(tCarPartsChange);
    }

    /**
     * 新增车辆主要部件更换登记
     *
     * @param tCarPartsChange 车辆主要部件更换登记信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTCarPartsChange(TCarPartsChange tCarPartsChange) {
        tCarPartsChange.setId(UUIDUtil.getUUID());

        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传
        //insert公共
        tCarPartsChange.setId(uuid);
        tCarPartsChange.setCreateDate(new Date());
        tCarPartsChange.setAddUserId(ShiroUtils.getUserId().toString());
        return tCarPartsChangeMapper.insertTCarPartsChange(tCarPartsChange) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改车辆主要部件更换登记
     *
     * @param tCarPartsChange 车辆主要部件更换登记信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTCarPartsChange(TCarPartsChange tCarPartsChange) {
        //校验
        //文件上传
        //update公共
        tCarPartsChange.setUpdateTime(new Date());
        tCarPartsChange.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tCarPartsChangeMapper.updateTCarPartsChange(tCarPartsChange) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除车辆主要部件更换登记对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTCarPartsChangeByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tCarPartsChangeMapper.deleteTCarPartsChangeByIds(Convert.toStrArray(ids));
        }
        return 0;
    }
    //以上自动生成的尽量别动
}
