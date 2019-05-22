package com.project.web.mapper;

import com.project.web.domian.TPaperArrange;

import java.util.List;

/**
 * 考试安排 数据层
 *
 * @author rbf
 * @date 2019-05-06
 */
public interface TPaperArrangeMapper {
    /**
     * 查询考试安排信息
     *
     * @param id 考试安排ID
     * @return 考试安排信息
     */
    public TPaperArrange selectTPaperArrangeById(String id);

    /**
     * 查询考试安排列表
     *
     * @param tPaperArrange 考试安排信息
     * @return 考试安排集合
     */
    public List<TPaperArrange> selectTPaperArrangeList(TPaperArrange tPaperArrange);

    /**
     * 新增考试安排
     *
     * @param tPaperArrange 考试安排信息
     * @return 结果
     */
    public int insertTPaperArrange(TPaperArrange tPaperArrange);

    /**
     * 修改考试安排
     *
     * @param tPaperArrange 考试安排信息
     * @return 结果
     */
    public int updateTPaperArrange(TPaperArrange tPaperArrange);

    /**
     * 删除考试安排
     *
     * @param id 考试安排ID
     * @return 结果
     */
    public int deleteTPaperArrangeById(String id);

    /**
     * 批量删除考试安排
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTPaperArrangeByIds(String[] ids);




}