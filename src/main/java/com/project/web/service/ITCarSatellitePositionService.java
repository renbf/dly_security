package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TCarSatellitePosition;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 卫星定位 服务层
 *
 * @author rbf
 * @date 2019-04-23
 */
public interface ITCarSatellitePositionService {
    /**
     * 查询卫星定位信息
     *
     * @param id 卫星定位ID
     * @return 卫星定位信息
     */
    public TCarSatellitePosition selectTCarSatellitePositionById(String id);

    /**
     * 查询卫星定位列表
     *
     * @param tCarSatellitePosition 卫星定位信息
     * @return 卫星定位集合
     */
    public List<TCarSatellitePosition> selectTCarSatellitePositionList(TCarSatellitePosition tCarSatellitePosition);

    /**
     * 新增卫星定位
     *
     * @param tCarSatellitePosition 卫星定位信息
     * @return 结果
     */
    public AjaxResult insertTCarSatellitePosition(TCarSatellitePosition tCarSatellitePosition, MultipartFile file);

    /**
     * 修改卫星定位
     *
     * @param tCarSatellitePosition 卫星定位信息
     * @return 结果
     */
    public AjaxResult updateTCarSatellitePosition(TCarSatellitePosition tCarSatellitePosition, MultipartFile file);

    /**
     * 删除卫星定位信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTCarSatellitePositionByIds(String ids);
    //以上自动生成的尽量别动
}
