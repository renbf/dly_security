package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCarRepair;
import com.project.web.mapper.TCarRepairMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITCarRepairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 车辆维护和修理登记 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarRepairServiceImpl implements ITCarRepairService {
    private static final Logger log = LoggerFactory.getLogger(TCarRepairServiceImpl.class);
    @Autowired
    @Qualifier("tCarRepairMapper")
    private TCarRepairMapper tCarRepairMapper;
    @Autowired
    private IFileService fileService;

    /**
     * 查询车辆维护和修理登记信息
     *
     * @param id 车辆维护和修理登记ID
     * @return 车辆维护和修理登记信息
     */
    @Override
    public TCarRepair selectTCarRepairById(String id) {
        return tCarRepairMapper.selectTCarRepairById(id);
    }

    /**
     * 查询车辆维护和修理登记列表
     *
     * @param tCarRepair 车辆维护和修理登记信息
     * @return 车辆维护和修理登记集合
     */
    @Override
    public List<TCarRepair> selectTCarRepairList(TCarRepair tCarRepair) {
        return tCarRepairMapper.selectTCarRepairList(tCarRepair);
    }

    /**
     * 新增车辆维护和修理登记
     *
     * @param tCarRepair 车辆维护和修理登记信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTCarRepair(TCarRepair tCarRepair, MultipartFile file) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("cheliangweihuheweixiudengji", uuid, "车辆维护和修理登记附件文件", file, 0,tCarRepair.getBusinessId());
                tCarRepair.setFileUrl(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共
        tCarRepair.setId(uuid);
        tCarRepair.setCreateTime(new Date());
        tCarRepair.setAddUserId(ShiroUtils.getUserId().toString());
        return tCarRepairMapper.insertTCarRepair(tCarRepair) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改车辆维护和修理登记
     *
     * @param tCarRepair 车辆维护和修理登记信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTCarRepair(TCarRepair tCarRepair, MultipartFile file) {
        //校验
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("cheliangweihuheweixiudengji", tCarRepair.getId(), "车辆维护和修理登记附件文件", file, 0,tCarRepair.getBusinessId());
                tCarRepair.setFileUrl(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共
        tCarRepair.setUpdateTime(new Date());
        tCarRepair.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tCarRepairMapper.updateTCarRepair(tCarRepair) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除车辆维护和修理登记对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTCarRepairByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tCarRepairMapper.deleteTCarRepairByIds(Convert.toStrArray(ids));
        }
        return 0;
    }
    //以上自动生成的尽量别动
}
