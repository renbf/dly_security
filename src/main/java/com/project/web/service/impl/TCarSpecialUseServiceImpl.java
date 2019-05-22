package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCarSpecialUse;
import com.project.web.mapper.TCarSpecialUseMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITCarSpecialUseService;
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
 * 压力容器和罐式专用车辆的罐体检测报告 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarSpecialUseServiceImpl implements ITCarSpecialUseService {
    private static final Logger log = LoggerFactory.getLogger(TCarSpecialUseServiceImpl.class);
    @Autowired
    @Qualifier("tCarSpecialUseMapper")
    private TCarSpecialUseMapper tCarSpecialUseMapper;

    @Autowired
    private IFileService fileService;
    /**
     * 查询压力容器和罐式专用车辆的罐体检测报告信息
     *
     * @param id 压力容器和罐式专用车辆的罐体检测报告ID
     * @return 压力容器和罐式专用车辆的罐体检测报告信息
     */
    @Override
    public TCarSpecialUse selectTCarSpecialUseById(String id) {
        return tCarSpecialUseMapper.selectTCarSpecialUseById(id);
    }

    /**
     * 查询压力容器和罐式专用车辆的罐体检测报告列表
     *
     * @param tCarSpecialUse 压力容器和罐式专用车辆的罐体检测报告信息
     * @return 压力容器和罐式专用车辆的罐体检测报告集合
     */
    @Override
    public List<TCarSpecialUse> selectTCarSpecialUseList(TCarSpecialUse tCarSpecialUse) {
        return tCarSpecialUseMapper.selectTCarSpecialUseList(tCarSpecialUse);
    }

    /**
     * 新增压力容器和罐式专用车辆的罐体检测报告
     *
     * @param tCarSpecialUse 压力容器和罐式专用车辆的罐体检测报告信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTCarSpecialUse(TCarSpecialUse tCarSpecialUse, MultipartFile file) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("yalirongqiheguanshizhuanyongcheliangdeguantijiancebaogao", uuid, "压力容器和罐式专用车辆的罐体检测报告附件文件", file, 0,tCarSpecialUse.getBusinessId());
                tCarSpecialUse.setFileUrl(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共
        tCarSpecialUse.setId(uuid);
        tCarSpecialUse.setCreateTime(new Date());
        tCarSpecialUse.setAddUserId(ShiroUtils.getUserId().toString());
        return tCarSpecialUseMapper.insertTCarSpecialUse(tCarSpecialUse) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改压力容器和罐式专用车辆的罐体检测报告
     *
     * @param tCarSpecialUse 压力容器和罐式专用车辆的罐体检测报告信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTCarSpecialUse(TCarSpecialUse tCarSpecialUse,MultipartFile file) {
        //校验
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("yalirongqiheguanshizhuanyongcheliangdeguantijiancebaogao", tCarSpecialUse.getId(), "压力容器和罐式专用车辆的罐体检测报告附件文件", file, 0,tCarSpecialUse.getBusinessId());
                tCarSpecialUse.setFileUrl(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共
        tCarSpecialUse.setUpdateTime(new Date());
        tCarSpecialUse.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tCarSpecialUseMapper.updateTCarSpecialUse(tCarSpecialUse) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除压力容器和罐式专用车辆的罐体检测报告对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTCarSpecialUseByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tCarSpecialUseMapper.deleteTCarSpecialUseByIds(Convert.toStrArray(ids));
        }
        return 0;
    }
    //以上自动生成的尽量别动
}
