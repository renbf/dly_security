package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TDrillRecord;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 演练记录 服务层
 *
 * @author rbf
 * @date 2019-04-17
 */
public interface ITDrillRecordService {
    /**
     * 查询演练记录信息
     *
     * @param id 演练记录ID
     * @return 演练记录信息
     */
    public TDrillRecord selectTDrillRecordById(String id);

    /**
     * 查询演练记录列表
     *
     * @param tDrillRecord 演练记录信息
     * @return 演练记录集合
     */
    public List<TDrillRecord> selectTDrillRecordList(TDrillRecord tDrillRecord);

    /**
     * 新增演练记录
     *
     * @param tDrillRecord 演练记录信息
     * @return 结果
     */
    public AjaxResult insertTDrillRecord(TDrillRecord tDrillRecord, MultipartFile photoFile);

    /**
     * 修改演练记录
     *
     * @param tDrillRecord 演练记录信息
     * @return 结果
     */
    public AjaxResult updateTDrillRecord(TDrillRecord tDrillRecord, MultipartFile photoFile);

    /**
     * 删除演练记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTDrillRecordByIds(String ids);

}
