package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCarCarrier;
import com.project.web.mapper.TCarCarrierMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITCarCarrierService;
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
 * 承运人责任险 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarCarrierServiceImpl implements ITCarCarrierService {
    private static final Logger log = LoggerFactory.getLogger(TCarCarrierServiceImpl.class);
    @Autowired
    @Qualifier("tCarCarrierMapper")
    private TCarCarrierMapper tCarCarrierMapper;

    @Autowired
    private IFileService fileService;
    /**
     * 查询承运人责任险信息
     *
     * @param id 承运人责任险ID
     * @return 承运人责任险信息
     */
    @Override
    public TCarCarrier selectTCarCarrierById(String id) {
        return tCarCarrierMapper.selectTCarCarrierById(id);
    }

    /**
     * 查询承运人责任险列表
     *
     * @param tCarCarrier 承运人责任险信息
     * @return 承运人责任险集合
     */
    @Override
    public List<TCarCarrier> selectTCarCarrierList(TCarCarrier tCarCarrier) {
        return tCarCarrierMapper.selectTCarCarrierList(tCarCarrier);
    }

    /**
     * 新增承运人责任险
     *
     * @param tCarCarrier 承运人责任险信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTCarCarrier(TCarCarrier tCarCarrier, MultipartFile file) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("chengyunrenzerenxian", uuid, "承运人责任险附件文件", file, 0,tCarCarrier.getBusinessId());
                tCarCarrier.setFileUrl(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共
        tCarCarrier.setId(uuid);
        tCarCarrier.setCreateTime(new Date());
        tCarCarrier.setAddUserId(ShiroUtils.getUserId().toString());
        return tCarCarrierMapper.insertTCarCarrier(tCarCarrier) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改承运人责任险
     *
     * @param tCarCarrier 承运人责任险信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTCarCarrier(TCarCarrier tCarCarrier, MultipartFile file) {
        //校验
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("chengyunrenzerenxian", tCarCarrier.getId(), "承运人责任险附件文件", file, 0,tCarCarrier.getBusinessId());
                tCarCarrier.setFileUrl(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共
        tCarCarrier.setUpdateTime(new Date());
        tCarCarrier.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tCarCarrierMapper.updateTCarCarrier(tCarCarrier) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除承运人责任险对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTCarCarrierByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tCarCarrierMapper.deleteTCarCarrierByIds(Convert.toStrArray(ids));
        }
        return 0;
    }
    //以上自动生成的尽量别动
}
