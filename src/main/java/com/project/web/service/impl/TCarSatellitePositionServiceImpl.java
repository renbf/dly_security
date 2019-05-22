package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCarSatellitePosition;
import com.project.web.mapper.TCarSatellitePositionMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITCarSatellitePositionService;
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
 * 卫星定位 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarSatellitePositionServiceImpl implements ITCarSatellitePositionService {
    private static final Logger log = LoggerFactory.getLogger(TCarSatellitePositionServiceImpl.class);
    @Autowired
    @Qualifier("tCarSatellitePositionMapper")
    private TCarSatellitePositionMapper tCarSatellitePositionMapper;


    @Autowired
    private IFileService fileService;

    /**
     * 查询卫星定位信息
     *
     * @param id 卫星定位ID
     * @return 卫星定位信息
     */
    @Override
    public TCarSatellitePosition selectTCarSatellitePositionById(String id) {
        return tCarSatellitePositionMapper.selectTCarSatellitePositionById(id);
    }

    /**
     * 查询卫星定位列表
     *
     * @param tCarSatellitePosition 卫星定位信息
     * @return 卫星定位集合
     */
    @Override
    public List<TCarSatellitePosition> selectTCarSatellitePositionList(TCarSatellitePosition tCarSatellitePosition) {
        return tCarSatellitePositionMapper.selectTCarSatellitePositionList(tCarSatellitePosition);
    }

    /**
     * 新增卫星定位
     *
     * @param tCarSatellitePosition 卫星定位信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTCarSatellitePosition(TCarSatellitePosition tCarSatellitePosition, MultipartFile file) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("weixingdingwei", uuid, "卫星定位附件文件", file, 0,tCarSatellitePosition.getBusinessId());
                tCarSatellitePosition.setFileUrl(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共
        tCarSatellitePosition.setId(uuid);
        tCarSatellitePosition.setCreateTime(new Date());
        tCarSatellitePosition.setAddUserId(ShiroUtils.getUserId().toString());
        return tCarSatellitePositionMapper.insertTCarSatellitePosition(tCarSatellitePosition) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改卫星定位
     *
     * @param tCarSatellitePosition 卫星定位信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTCarSatellitePosition(TCarSatellitePosition tCarSatellitePosition, MultipartFile file) {
        //校验
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("weixingdingwei", tCarSatellitePosition.getId(), "卫星定位附件文件", file, 0,tCarSatellitePosition.getBusinessId());
                tCarSatellitePosition.setFileUrl(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共
        tCarSatellitePosition.setUpdateTime(new Date());
        tCarSatellitePosition.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tCarSatellitePositionMapper.updateTCarSatellitePosition(tCarSatellitePosition) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除卫星定位对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTCarSatellitePositionByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tCarSatellitePositionMapper.deleteTCarSatellitePositionByIds(Convert.toStrArray(ids));
        }
        return 0;
    }
    //以上自动生成的尽量别动
}
