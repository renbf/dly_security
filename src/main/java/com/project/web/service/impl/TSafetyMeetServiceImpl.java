package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyMeet;
import com.project.web.domian.TSafetyMeetDetail;
import com.project.web.mapper.TSafetyMeetDetailMapper;
import com.project.web.mapper.TSafetyMeetMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITSafetyMeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 安全会议 服务层实现
 *
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TSafetyMeetServiceImpl implements ITSafetyMeetService {
    @Autowired
    private TSafetyMeetMapper tSafetyMeetMapper;
    @Autowired
    private TSafetyMeetDetailMapper safetyMeetDetailMapper;


    @Autowired
    private IFileService fileService;

    /**
     * 查询安全会议信息
     *
     * @param id 安全会议ID
     * @return 安全会议信息
     */
    @Override
    public TSafetyMeet selectTSafetyMeetById(String id) {
        return tSafetyMeetMapper.selectTSafetyMeetById(id);
    }

    /**
     * 查询安全会议列表
     *
     * @param tSafetyMeet 安全会议信息
     * @return 安全会议集合
     */
    @Override
    public List<TSafetyMeet> selectTSafetyMeetList(TSafetyMeet tSafetyMeet) {
        /*查询会议表*/
        List<TSafetyMeet> safetyMeets = tSafetyMeetMapper.selectTSafetyMeetList(tSafetyMeet);
        if (safetyMeets.isEmpty()) {
            return safetyMeets;
        }
        /*查询会议详情表*/
        ArrayList<String> meetIds = new ArrayList<>(safetyMeets.size());
        safetyMeets.forEach(e -> meetIds.add(e.getId()));
        List<TSafetyMeetDetail> safetyMeetDetails = this.safetyMeetDetailMapper.selectTSafetyMeetDetailListByMeetIds(meetIds);
        //融合
        safetyMeetDetails.forEach(e -> {
            safetyMeets.forEach(e1 -> {
                if (e1.getId().equals(e.getMeetId())) {
                    //如果没有list就创建
                    if (e1.getSafetyMeetDetails() == null) {
                        e1.setSafetyMeetDetails(new ArrayList<>());
                    }
                    e1.getSafetyMeetDetails().add(e);
                }
            });
        });
        return safetyMeets;
    }

    /**
     * 新增安全会议
     *
     * @param tSafetyMeet 安全会议信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult insertTSafetyMeet(TSafetyMeet tSafetyMeet, MultipartFile meetFile) {
        //校验
        AjaxResult result = this.insertValidation(tSafetyMeet);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        Long userId = ShiroUtils.getUserId();
        //文件上传
        try {
            if (Objects.nonNull(meetFile) && StringUtils.isNotEmpty(meetFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquanhuiyi", uuid, "安全会议附件文件", meetFile, 0,tSafetyMeet.getBusinessId());
                tSafetyMeet.setFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置公共属性
        Date nowDate = new Date();
        tSafetyMeet.setId(uuid);
        tSafetyMeet.setCreateTime(nowDate);
        tSafetyMeet.setUserId(userId);
        //设置详情表公共属性
        tSafetyMeet.getSafetyMeetDetails().forEach(e -> {
            e.setId(UUIDUtil.getUUID());
            e.setCreateTime(nowDate);
            e.setUserId(userId);
            //设置会议id
            e.setMeetId(uuid);
        });
        /*开始存储数据库*/
        //会议表
        if (this.tSafetyMeetMapper.insertTSafetyMeet(tSafetyMeet) <= 0) {
            return AjaxResult.error(2, "操作失败");
        }
        //会议详情表
        for (TSafetyMeetDetail safetyMeetDetail : tSafetyMeet.getSafetyMeetDetails()) {
            if (this.safetyMeetDetailMapper.insertTSafetyMeetDetail(safetyMeetDetail) <= 0) {
                throw new RuntimeException();
            }
        }
        return AjaxResult.success();
    }

    /**
     * 修改安全会议
     *
     * @param tSafetyMeet 安全会议信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult updateTSafetyMeet(TSafetyMeet tSafetyMeet, MultipartFile meetFile) {
        //校验
        AjaxResult result = this.insertValidation(tSafetyMeet);
        if (result != null) {
            return result;
        }
        //文件上传
        try {
            if (Objects.nonNull(meetFile) && StringUtils.isNotEmpty(meetFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquanhuiyi", tSafetyMeet.getId(), "安全会议附件文件", meetFile, 0,tSafetyMeet.getBusinessId());
                tSafetyMeet.setFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置会议表公共
        Date nowDate = new Date();
        Long userId = ShiroUtils.getUserId();
        tSafetyMeet.setUpdateTime(nowDate);
        tSafetyMeet.setUpdateUserId(userId);
        /*修改会议表*/
        if (tSafetyMeetMapper.updateTSafetyMeet(tSafetyMeet) <= 0) {
            throw new RuntimeException();
        }
        /*存储会议详情表*/
        //先删除
        this.safetyMeetDetailMapper.deleteTSafetyMeetDetailByMeetIds(Convert.toStrArray(tSafetyMeet.getId()));
        //再存储
        for (TSafetyMeetDetail safetyMeetDetail : tSafetyMeet.getSafetyMeetDetails()) {
            safetyMeetDetail.setMeetId(tSafetyMeet.getId());
            safetyMeetDetail.setId(UUIDUtil.getUUID());
            safetyMeetDetail.setCreateTime(nowDate);
            safetyMeetDetail.setUserId(userId);
            if (this.safetyMeetDetailMapper.insertTSafetyMeetDetail(safetyMeetDetail) <= 0) {
                throw new RuntimeException();
            }
        }
        return AjaxResult.success();
    }

    /**
     * 删除安全会议对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteTSafetyMeetByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            //删除会议表
            int i = tSafetyMeetMapper.deleteTSafetyMeetByIds(Convert.toStrArray(ids));
            if (i <= 0) {
                throw new RuntimeException();
            }
            //删除会议详情表
            safetyMeetDetailMapper.deleteTSafetyMeetDetailByMeetIds(Convert.toStrArray(ids));
            return i;
        }
        return 0;
    }


    //insert not null validation
    private AjaxResult insertValidation(TSafetyMeet tSafetyMeet) {
        //安全会议：会议名称  会议类型   会议形式  主持人   会议日期   会议内容
        if (ValidationUtils.objIsNull(tSafetyMeet.getMeetName())) {
            return AjaxResult.error(2, "会议名称不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyMeet.getMeetType())) {
            return AjaxResult.error(2, "会议类型不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyMeet.getMeetForm())) {
            return AjaxResult.error(2, "会议形式不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyMeet.getHostPer())) {
            return AjaxResult.error(2, "主持人不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyMeet.getMeetDate())) {
            return AjaxResult.error(2, "会议日期不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyMeet.getMeetInfo())) {
            return AjaxResult.error(2, "会议内容不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyMeet.getSafetyMeetDetails())) {
            return AjaxResult.error(2, "会议人员不能为空");
        }
        return null;
    }


}
