package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCarKm;
import com.project.web.mapper.TCarKmMapper;
import com.project.web.service.ITCarKmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 车辆行驶里程登记 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarKmServiceImpl implements ITCarKmService {
    private static final Logger log = LoggerFactory.getLogger(TCarKmServiceImpl.class);
    @Autowired
    @Qualifier("tCarKmMapper")
    private TCarKmMapper tCarKmMapper;

    /**
     * 查询车辆行驶里程登记信息
     *
     * @param id 车辆行驶里程登记ID
     * @return 车辆行驶里程登记信息
     */
    @Override
    public TCarKm selectTCarKmById(String id) {
        return tCarKmMapper.selectTCarKmById(id);
    }

    /**
     * 查询车辆行驶里程登记列表
     *
     * @param tCarKm 车辆行驶里程登记信息
     * @return 车辆行驶里程登记集合
     */
    @Override
    public List<TCarKm> selectTCarKmList(TCarKm tCarKm) {
        return tCarKmMapper.selectTCarKmList(tCarKm);
    }

    /**
     * 新增车辆行驶里程登记
     *
     * @param tCarKm 车辆行驶里程登记信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTCarKm(TCarKm tCarKm) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传 //没有
        //insert公共
        tCarKm.setId(uuid);
        tCarKm.setCreateDate(new Date());
        tCarKm.setAddUserId(ShiroUtils.getUserId().toString());
        return tCarKmMapper.insertTCarKm(tCarKm) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改车辆行驶里程登记
     *
     * @param tCarKm 车辆行驶里程登记信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTCarKm(TCarKm tCarKm) {
        //校验
        //文件上传 //没有
        //update公共
        tCarKm.setUpdateTime(new Date());
        tCarKm.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tCarKmMapper.updateTCarKm(tCarKm) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除车辆行驶里程登记对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTCarKmByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tCarKmMapper.deleteTCarKmByIds(Convert.toStrArray(ids));
        }
        return 0;
    }
    //以上自动生成的尽量别动
}
