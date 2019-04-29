package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TTrainingRecord;
import com.project.web.domian.TTrainingRecordDetails;
import com.project.web.mapper.TTrainingRecordDetailsMapper;
import com.project.web.mapper.TTrainingRecordMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITTrainingRecordService;
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
 * 培训记录 服务层实现
 *
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TTrainingRecordServiceImpl implements ITTrainingRecordService {
    @Autowired
    private TTrainingRecordMapper tTrainingRecordMapper;
    @Autowired
    private TTrainingRecordDetailsMapper trainingRecordDetailsMapper;
    @Autowired
    private IFileService fileService;

    /**
     * 查询培训记录信息
     *
     * @param id 培训记录ID
     * @return 培训记录信息
     */
    @Override
    public TTrainingRecord selectTTrainingRecordById(String id) {
        return tTrainingRecordMapper.selectTTrainingRecordById(id);
    }

    /**
     * 查询培训记录列表
     *
     * @param tTrainingRecord 培训记录信息
     * @return 培训记录集合
     */
    @Override
    public List<TTrainingRecord> selectTTrainingRecordList(TTrainingRecord tTrainingRecord) {
        /*查询主表*/
        List<TTrainingRecord> trainingRecords = tTrainingRecordMapper.selectTTrainingRecordList(tTrainingRecord);
        if (trainingRecords == null || trainingRecords.isEmpty()) {
            return trainingRecords;
        }
        /*查询从表*/
        ArrayList<String> ids = new ArrayList<>(trainingRecords.size());
        trainingRecords.forEach(e -> ids.add(e.getId()));
        List<TTrainingRecordDetails> details = this.trainingRecordDetailsMapper.selectTTrainingRecordDetailsByTrainingIds(ids);
        /*融合*/
        trainingRecords.forEach(e -> {
            details.forEach(e1 -> {
                if (e.getId().equals(e1.getTrainingId())) {
                    if (e.getTrainingRecordDetails() == null) {
                        e.setTrainingRecordDetails(new ArrayList<>());
                    }
                    e.getTrainingRecordDetails().add(e1);
                }
            });
        });
        return trainingRecords;
    }

    /**
     * 新增培训记录
     *
     * @param tTrainingRecord 培训记录信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult insertTTrainingRecord(TTrainingRecord tTrainingRecord, MultipartFile trainFile) {
        /*校验*/
        AjaxResult result = this.insertValidation(tTrainingRecord);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        Long userId = ShiroUtils.getUserId();
        Date nowDate = new Date();
        /*文件上传*/
        try {
            if (Objects.nonNull(trainFile) && StringUtils.isNotEmpty(trainFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("peixunjilu", uuid, "培训记录附件文件", trainFile, 0);
                tTrainingRecord.setTrainFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*设置公共属性*/
        tTrainingRecord.setId(uuid);
        tTrainingRecord.setCreateTime(nowDate);
        tTrainingRecord.setUserId(userId);
        tTrainingRecord.getTrainingRecordDetails().forEach(e -> {
            e.setId(UUIDUtil.getUUID());
            e.setCreateTime(nowDate);
            e.setUserId(userId);
            //这只主表id
            e.setTrainingId(uuid);
        });
        /*开始存储数据库*/
        //主表
        if (this.tTrainingRecordMapper.insertTTrainingRecord(tTrainingRecord) <= 0) {
            return AjaxResult.error(2, "操作失败");
        }
        //详情表
        for (TTrainingRecordDetails detail : tTrainingRecord.getTrainingRecordDetails()) {
            if (this.trainingRecordDetailsMapper.insertTTrainingRecordDetails(detail) <= 0) {
                throw new RuntimeException();
            }
        }
        return AjaxResult.success();
    }

    /**
     * 修改培训记录
     *
     * @param tTrainingRecord 培训记录信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult updateTTrainingRecord(TTrainingRecord tTrainingRecord, MultipartFile trainFile) {
        //校验
        AjaxResult result = this.insertValidation(tTrainingRecord);
        if (result != null) {
            return result;
        }
        //文件上传
        try {
            if (Objects.nonNull(trainFile) && StringUtils.isNotEmpty(trainFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("peixunjilu", tTrainingRecord.getId(), "培训记录附件文件", trainFile, 0);
                tTrainingRecord.setTrainFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置公共
        Date nowDate = new Date();
        Long userId = ShiroUtils.getUserId();
        tTrainingRecord.setUpdateTime(nowDate);
        tTrainingRecord.setUpdateUserId(userId);
        /*修改主表*/
        if (this.tTrainingRecordMapper.updateTTrainingRecord(tTrainingRecord) <= 0) {
            throw new RuntimeException();
        }
        /*修改详情表*/
        //先删除
        this.trainingRecordDetailsMapper.deleteTTrainingRecordDetailsByTrainingIds(Convert.toStrArray(tTrainingRecord.getId()));
        //后新增
        for (TTrainingRecordDetails detail : tTrainingRecord.getTrainingRecordDetails()) {
            detail.setTrainingId(tTrainingRecord.getId());
            detail.setId(UUIDUtil.getUUID());
            detail.setCreateTime(nowDate);
            detail.setUserId(userId);
            if (this.trainingRecordDetailsMapper.insertTTrainingRecordDetails(detail) <= 0) {
                throw new RuntimeException();
            }
        }
        return AjaxResult.success();
    }

    /**
     * 删除培训记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteTTrainingRecordByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            int i = tTrainingRecordMapper.deleteTTrainingRecordByIds(Convert.toStrArray(ids));
            if (i <= 0) {
                return i;
            }
            this.trainingRecordDetailsMapper.deleteTTrainingRecordDetailsByTrainingIds(Convert.toStrArray(ids));
        }
        return 0;
    }


    private AjaxResult insertValidation(TTrainingRecord tTrainingRecord) {
        //培训记录：培训日期、 培训课程（公司级、部门级、岗位级）、培训主题
        if (ValidationUtils.objIsNull(tTrainingRecord.getTrainDate())) {
            return AjaxResult.error(2, "培训日期不能为空");
        }
        if (ValidationUtils.objIsNull(tTrainingRecord.getTrainLevel())) {
            return AjaxResult.error(2, "培训级别不能为空");
        }
        if (ValidationUtils.objIsNull(tTrainingRecord.getTrainingRecordDetails())) {
            return AjaxResult.error(2, "培训人员不能为空");
        }
        if (ValidationUtils.objIsNull(tTrainingRecord.getTrainTheme())) {
            return AjaxResult.error(2, "培训主题不能为空");
        }
        return null;
    }


}

