package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TDrillRecord;
import com.project.web.mapper.TDrillRecordMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITDrillRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 演练记录 服务层实现
 *
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TDrillRecordServiceImpl implements ITDrillRecordService {
    @Autowired
    private TDrillRecordMapper tDrillRecordMapper;
    @Autowired
    private IFileService fileService;

    /**
     * 查询演练记录信息
     *
     * @param id 演练记录ID
     * @return 演练记录信息
     */
    @Override
    public TDrillRecord selectTDrillRecordById(String id) {
        return tDrillRecordMapper.selectTDrillRecordById(id);
    }

    /**
     * 查询演练记录列表
     *
     * @param tDrillRecord 演练记录信息
     * @return 演练记录集合
     */
    @Override
    public List<TDrillRecord> selectTDrillRecordList(TDrillRecord tDrillRecord) {
        return tDrillRecordMapper.selectTDrillRecordList(tDrillRecord);
    }

    /**
     * 新增演练记录
     *
     * @param tDrillRecord 演练记录信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTDrillRecord(TDrillRecord tDrillRecord, MultipartFile photoFile) {
        //校验
        AjaxResult result = this.insertValidation(tDrillRecord);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(photoFile) && StringUtils.isNotEmpty(photoFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("yanlianjilu", uuid, "演练记录附件文件", photoFile, 0);
                tDrillRecord.setExerciseFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共
        tDrillRecord.setId(uuid);
        tDrillRecord.setCreateTime(new Date());
        tDrillRecord.setUserId(ShiroUtils.getUserId());
        return tDrillRecordMapper.insertTDrillRecord(tDrillRecord) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改演练记录
     *
     * @param tDrillRecord 演练记录信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTDrillRecord(TDrillRecord tDrillRecord, MultipartFile photoFile) {
        //校验
        AjaxResult result = this.insertValidation(tDrillRecord);
        if (result != null) {
            return result;
        }
        //文件上传
        try {
            if (Objects.nonNull(photoFile) && StringUtils.isNotEmpty(photoFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("yanlianjilu", tDrillRecord.getId(), "演练记录附件文件", photoFile, 0);
                tDrillRecord.setExerciseFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共
        tDrillRecord.setUpdateTime(new Date());
        tDrillRecord.setUpdateUserId(ShiroUtils.getUserId());
        return tDrillRecordMapper.updateTDrillRecord(tDrillRecord) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除演练记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTDrillRecordByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tDrillRecordMapper.deleteTDrillRecordByIds(Convert.toStrArray(ids));
        }
        return 0;
    }


    private AjaxResult insertValidation(TDrillRecord tDrillRecord) {
        //演练记录：演练名称    演练时间   演练地点  指挥人
        // 演练地点  演练类型  演练级别   演练过程 //没有  演练方案  //没有
        if (ValidationUtils.objIsNull(tDrillRecord.getExerciseName())) {
            return AjaxResult.error(2, "演练名称不能为空");
        }
        if (ValidationUtils.objIsNull(tDrillRecord.getExerciseDate())) {
            return AjaxResult.error(2, "演练时间不能为空");
        }
        if (ValidationUtils.objIsNull(tDrillRecord.getExercisePlace())) {
            return AjaxResult.error(2, "演练地点不能为空");
        }
        if (ValidationUtils.objIsNull(tDrillRecord.getCommandingOfficer())) {
            return AjaxResult.error(2, "指挥人不能为空");
        }
        if (ValidationUtils.objIsNull(tDrillRecord.getExerciseType())) {
            return AjaxResult.error(2, "演练类型不能为空");
        }
        if (ValidationUtils.objIsNull(tDrillRecord.getParticipantsLevl())) {
            return AjaxResult.error(2, "演练级别不能为空");
        }
        return null;
    }

}
