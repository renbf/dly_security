package com.project.web.service.impl;

import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyTarget;
import com.project.web.mapper.TSafetyTargetMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITSafetyTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 安全目标 服务层实现
 *
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TSafetyTargetServiceImpl implements ITSafetyTargetService {
    @Autowired
    private TSafetyTargetMapper tSafetyTargetMapper;

    @Autowired
    private IFileService fileService;

    /**
     * 查询安全目标信息
     *
     * @param id 安全目标ID
     * @return 安全目标信息
     */
    @Override
    public TSafetyTarget selectTSafetyTargetById(String id) {
        return tSafetyTargetMapper.selectTSafetyTargetById(id);
    }

    /**
     * 查询安全目标列表
     *
     * @param tSafetyTarget 安全目标信息
     * @return 安全目标集合
     */
    @Override
    public List<TSafetyTarget> selectTSafetyTargetList(TSafetyTarget tSafetyTarget) {
        return tSafetyTargetMapper.selectTSafetyTargetList(tSafetyTarget);
    }

    /**
     * 新增安全目标
     *
     * @param tSafetyTarget 安全目标信息
     * @return 结果
     */
    @Override
    public int insertTSafetyTarget(TSafetyTarget tSafetyTarget, MultipartFile targetFile) {
        String uuid = UUIDUtil.getUUID();
        //校验
        //目标文件上传和保存
        try {
            if (Objects.nonNull(targetFile) && StringUtils.isNotEmpty(targetFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquanmubiao", uuid, "安全目标附件文件", targetFile, 0);
                tSafetyTarget.setTargetFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tSafetyTarget.setId(uuid);
        tSafetyTarget.setCreateTime(new Date());
        tSafetyTarget.setUserId(ShiroUtils.getUserId());
        return tSafetyTargetMapper.insertTSafetyTarget(tSafetyTarget);
    }

    /**
     * 修改安全目标
     *
     * @param tSafetyTarget 安全目标信息
     * @return 结果
     */
    @Override
    public int updateTSafetyTarget(TSafetyTarget tSafetyTarget, MultipartFile targetFile) {
        if (tSafetyTarget.getId() == null || tSafetyTarget.getId().equals("")) {
            return 0;
        }
        //校验
        //目标文件上传和保存
        try {
            if (Objects.nonNull(targetFile) && StringUtils.isNotEmpty(targetFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquanmubiao", tSafetyTarget.getId(), "安全目标附件文件", targetFile, 0);
                tSafetyTarget.setTargetFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tSafetyTarget.setUpdateTime(new Date());
        tSafetyTarget.setUpdateUserId(ShiroUtils.getUserId());
        return tSafetyTargetMapper.updateTSafetyTarget(tSafetyTarget);
    }

    /**
     * 删除安全目标对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTSafetyTargetByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tSafetyTargetMapper.deleteTSafetyTargetByIds(Convert.toStrArray(ids));
        }
        return 0;
    }

}
