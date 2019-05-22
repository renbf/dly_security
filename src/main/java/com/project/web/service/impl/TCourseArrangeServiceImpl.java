package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCourseArrange;
import com.project.web.domian.TUserCourse;
import com.project.web.mapper.TCourseArrangeMapper;
import com.project.web.mapper.TUserCourseMapper;
import com.project.web.service.ITCourseArrangeService;
import com.project.web.service.ITUserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 课程安排 服务层实现
 *
 * @author rbf
 * @date 2019-04-30
 */
@Service
public class TCourseArrangeServiceImpl implements ITCourseArrangeService {
    @Autowired
    private TCourseArrangeMapper tCourseArrangeMapper;
    @Autowired
    private ITUserCourseService userCourseService;

    @Autowired
    private TUserCourseMapper userCourseMapper;

    /**
     * 查询课程安排信息
     *
     * @param id 课程安排ID
     * @return 课程安排信息
     */
    @Override
    public TCourseArrange selectTCourseArrangeById(String id) {
        return tCourseArrangeMapper.selectTCourseArrangeById(id);
    }

    /**
     * 查询课程安排列表
     *
     * @param tCourseArrange 课程安排信息
     * @return 课程安排集合
     */
    @Override
    public List<TCourseArrange> selectTCourseArrangeList(TCourseArrange tCourseArrange) {
        List<TCourseArrange> courseArranges = tCourseArrangeMapper.selectTCourseArrangeList(tCourseArrange);
        if (courseArranges.isEmpty()) {
            return courseArranges;
        }
        /*使用in关键字查询附属表*/
        ArrayList<String> courseArrangeIds = new ArrayList<>();
        courseArranges.forEach(e -> courseArrangeIds.add(e.getId()));
        TUserCourse userCourse = new TUserCourse().setCourseArrangeIds(courseArrangeIds);
        List<TUserCourse> userCourses = this.userCourseMapper.selectTUserCourseList(userCourse);
        /*将查出的内容进行关联到主表*/
        courseArranges.forEach(ca -> {
            userCourses.forEach(uc -> {
                if (ca.getId().trim().equals(uc.getCourseArrangeId().trim())) {
                    if (ca.getUserCourses() == null) {
                        ca.setUserCourses(new ArrayList<TUserCourse>());
                    }
                    ca.getUserCourses().add(uc);
                }
            });
        });
        /*计算各种人数*/
        courseArranges.forEach(e -> {
            e.setNotStudyNum(new Long(e.getUserCourses().stream().filter(uc -> uc.getStatus().trim().equals("0")).count()).intValue());
            e.setStudyingNum(new Long(e.getUserCourses().stream().filter(uc -> uc.getStatus().trim().equals("1")).count()).intValue());
            e.setFinishStudyNum(new Long(e.getUserCourses().stream().filter(uc -> uc.getStatus().trim().equals("2")).count()).intValue());
        });
        return courseArranges;
    }

    /**
     * 新增课程安排
     *
     * @param tCourseArrange 课程安排信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult insertTCourseArrange(TCourseArrange tCourseArrange) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传 //没有
        //insert公共
        tCourseArrange.setId(uuid);
        tCourseArrange.setCreateTime(new Date());
        tCourseArrange.setAddUserId(ShiroUtils.getUserId().toString());
        int i = tCourseArrangeMapper.insertTCourseArrange(tCourseArrange);
        if (i <= 0) {
            throw new RuntimeException();
        }
        /*存储详情表*/
        if (tCourseArrange.getUserIds() != null) {
            tCourseArrange.getUserIds().forEach(e -> {
                TUserCourse userCourse = new TUserCourse();
                userCourse.setCourseArrangeId(uuid);
                userCourse.setUserId(e);
                if (this.userCourseService.insertTUserCourse(userCourse) <= 0) {
                    throw new RuntimeException();
                }
            });
        }
        return AjaxResult.success();
    }

    /**
     * 修改课程安排
     *
     * @param tCourseArrange 课程安排信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult updateTCourseArrange(TCourseArrange tCourseArrange) {
        //tCourseArrangeMapper.updateTCourseArrange(tCourseArrange);
        /*修改主表*/
        int i = tCourseArrangeMapper.updateTCourseArrange(tCourseArrange);
        /*修改详情表*/
        /*由于详情表有其他数据,所以需要精确比对之后决定删除项和新增项.而不能采用全部删除之后重新新增的方式*/
        //查询旧详情表
        TUserCourse userCourse = new TUserCourse();
        userCourse.setCourseArrangeId(tCourseArrange.getId());
        List<TUserCourse> userCourses = this.userCourseService.selectTUserCourseList(userCourse);
        //新增项
        if (tCourseArrange.getUserIds() != null) {
            tCourseArrange.getUserIds().forEach(u -> {
                boolean temp = false;
                for (TUserCourse uc : userCourses) {
                    if (u.trim().equals(uc.getUserId().trim())) {
                        temp = true;
                    }
                }
                if (!temp) {
                    TUserCourse userCourse1 = new TUserCourse();
                    userCourse1.setCourseArrangeId(tCourseArrange.getId());
                    userCourse1.setUserId(u);
                    if (this.userCourseService.insertTUserCourse(userCourse1) <= 0) {
                        throw new RuntimeException();
                    }
                }
            });
        }
        //删除项
        StringBuffer deleteIds = new StringBuffer();
        if (tCourseArrange.getUserIds() == null || tCourseArrange.getUserIds().isEmpty()) {
            //全删
            userCourses.forEach(e -> deleteIds.append(e.getId()).append(","));
        } else {
            userCourses.forEach(uc -> {
                boolean temp = false;
                for (String userId : tCourseArrange.getUserIds()) {
                    if (userId.trim().equals(uc.getUserId().trim())) {
                        temp = true;
                    }
                }
                if (!temp) {
                    //添加一个删除项
                    deleteIds.append(uc.getId()).append(",");
                }
            });
        }
        if (deleteIds.length() > 0) {
            this.userCourseService.deleteTUserCourseByIds(deleteIds.substring(0, deleteIds.length() - 1));
        }
        return AjaxResult.success();
    }

    /**
     * 删除课程安排对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteTCourseArrangeByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            int i = tCourseArrangeMapper.deleteTCourseArrangeByIds(Convert.toStrArray(ids));
            if (i <= 0) {
                return i;
            }
            this.userCourseMapper.deleteTUserCourseByCourseArrangeId(Convert.toStrArray(ids));
            return i;
        }
        return 0;
    }

}
