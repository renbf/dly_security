package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCarTestingEvaluate;
import com.project.web.mapper.TCarTestingEvaluateMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITCarTestingEvaluateService;
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
 * 车辆检测和评定登记 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarTestingEvaluateServiceImpl implements ITCarTestingEvaluateService {
    private static final Logger log = LoggerFactory.getLogger(TCarTestingEvaluateServiceImpl.class);
    @Autowired
    @Qualifier("tCarTestingEvaluateMapper")
    private TCarTestingEvaluateMapper tCarTestingEvaluateMapper;
    @Autowired
    private IFileService fileService;

    /**
     * 查询车辆检测和评定登记信息
     *
     * @param id 车辆检测和评定登记ID
     * @return 车辆检测和评定登记信息
     */
    @Override
    public TCarTestingEvaluate selectTCarTestingEvaluateById(String id) {
        return tCarTestingEvaluateMapper.selectTCarTestingEvaluateById(id);
    }

    /**
     * 查询车辆检测和评定登记列表
     *
     * @param tCarTestingEvaluate 车辆检测和评定登记信息
     * @return 车辆检测和评定登记集合
     */
    @Override
    public List<TCarTestingEvaluate> selectTCarTestingEvaluateList(TCarTestingEvaluate tCarTestingEvaluate) {
        return tCarTestingEvaluateMapper.selectTCarTestingEvaluateList(tCarTestingEvaluate);
    }

    /**
     * 新增车辆检测和评定登记
     *
     * @param tCarTestingEvaluate 车辆检测和评定登记信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTCarTestingEvaluate(TCarTestingEvaluate tCarTestingEvaluate, MultipartFile file) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("cheliangjiancehepingdingdengji", uuid, "车辆检测和评定登记附件文件", file, 0,tCarTestingEvaluate.getBusinessId());
                tCarTestingEvaluate.setFileUrl(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共
        tCarTestingEvaluate.setId(uuid);
        tCarTestingEvaluate.setCreateTime(new Date());
        tCarTestingEvaluate.setAddUserId(ShiroUtils.getUserId().toString());
        return tCarTestingEvaluateMapper.insertTCarTestingEvaluate(tCarTestingEvaluate) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改车辆检测和评定登记
     *
     * @param tCarTestingEvaluate 车辆检测和评定登记信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTCarTestingEvaluate(TCarTestingEvaluate tCarTestingEvaluate, MultipartFile file) {
        //校验
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("cheliangjiancehepingdingdengji", tCarTestingEvaluate.getId(), "车辆检测和评定登记附件文件", file, 0,tCarTestingEvaluate.getBusinessId());
                tCarTestingEvaluate.setFileUrl(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共
        tCarTestingEvaluate.setUpdateTime(new Date());
        tCarTestingEvaluate.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tCarTestingEvaluateMapper.updateTCarTestingEvaluate(tCarTestingEvaluate) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除车辆检测和评定登记对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTCarTestingEvaluateByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tCarTestingEvaluateMapper.deleteTCarTestingEvaluateByIds(Convert.toStrArray(ids));
        }
        return 0;
    }
    //以上自动生成的尽量别动
}
