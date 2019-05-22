package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TCarSpecialUse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 压力容器和罐式专用车辆的罐体检测报告 服务层
 *
 * @author rbf
 * @date 2019-04-23
 */
public interface ITCarSpecialUseService {
    /**
     * 查询压力容器和罐式专用车辆的罐体检测报告信息
     *
     * @param id 压力容器和罐式专用车辆的罐体检测报告ID
     * @return 压力容器和罐式专用车辆的罐体检测报告信息
     */
    public TCarSpecialUse selectTCarSpecialUseById(String id);

    /**
     * 查询压力容器和罐式专用车辆的罐体检测报告列表
     *
     * @param tCarSpecialUse 压力容器和罐式专用车辆的罐体检测报告信息
     * @return 压力容器和罐式专用车辆的罐体检测报告集合
     */
    public List<TCarSpecialUse> selectTCarSpecialUseList(TCarSpecialUse tCarSpecialUse);

    /**
     * 新增压力容器和罐式专用车辆的罐体检测报告
     *
     * @param tCarSpecialUse 压力容器和罐式专用车辆的罐体检测报告信息
     * @return 结果
     */
    public AjaxResult insertTCarSpecialUse(TCarSpecialUse tCarSpecialUse, MultipartFile file);

    /**
     * 修改压力容器和罐式专用车辆的罐体检测报告
     *
     * @param tCarSpecialUse 压力容器和罐式专用车辆的罐体检测报告信息
     * @return 结果
     */
    public AjaxResult updateTCarSpecialUse(TCarSpecialUse tCarSpecialUse,MultipartFile file);

    /**
     * 删除压力容器和罐式专用车辆的罐体检测报告信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTCarSpecialUseByIds(String ids);
    //以上自动生成的尽量别动
}
