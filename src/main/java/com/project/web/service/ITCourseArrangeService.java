package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TCourseArrange;

import java.util.List;

/**
 * 课程安排 服务层
 *
 * @author rbf
 * @date 2019-04-30
 */
public interface ITCourseArrangeService {
    /**
     * 查询课程安排信息
     *
     * @param id 课程安排ID
     * @return 课程安排信息
     */
    public TCourseArrange selectTCourseArrangeById(String id);

    /**
     * 查询课程安排列表
     *
     * @param tCourseArrange 课程安排信息
     * @return 课程安排集合
     */
    public List<TCourseArrange> selectTCourseArrangeList(TCourseArrange tCourseArrange);

    /**
     * 新增课程安排
     *
     * @param tCourseArrange 课程安排信息
     * @return 结果
     */
    public AjaxResult insertTCourseArrange(TCourseArrange tCourseArrange);

    /**
     * 修改课程安排
     *
     * @param tCourseArrange 课程安排信息
     * @return 结果
     */
    public AjaxResult updateTCourseArrange(TCourseArrange tCourseArrange);

    /**
     * 删除课程安排信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTCourseArrangeByIds(String ids);

}
