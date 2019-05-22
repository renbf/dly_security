package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.getui.pushmessage.GetuiUtils;
import com.project.framework.util.ShiroUtils;
import com.project.security.domain.TUserClient;
import com.project.security.mapper.TUserClientMapper;
import com.project.util.UUIDUtil;
import com.project.web.domian.TMessage;
import com.project.web.domian.TUserCourse;
import com.project.web.mapper.TUserCourseMapper;
import com.project.web.service.ITUserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 课程安排 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TUserCourseServiceImpl implements ITUserCourseService {
    @Autowired
    private TUserCourseMapper tUserCourseMapper;

    @Autowired
    private TUserClientMapper userClientMapper;


    /**
     * 查询课程安排(详情)信息
     *
     * @param id 课程安排(详情)ID
     * @return 课程安排(详情)信息
     */
    @Override
    public TUserCourse selectTUserCourseById(String id) {
        return tUserCourseMapper.selectTUserCourseById(id);
    }

    /**
     * 查询课程安排(详情)列表
     *
     * @param tUserCourse 课程安排(详情)信息
     * @return 课程安排(详情)集合
     */
    @Override
    public List<TUserCourse> selectTUserCourseList(TUserCourse tUserCourse) {
        return tUserCourseMapper.selectTUserCourseList(tUserCourse);
    }

    /**
     * 新增课程安排(详情)
     *
     * @param tUserCourse 课程安排(详情)信息
     * @return 结果
     */
    @Override
    public int insertTUserCourse(TUserCourse tUserCourse) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传 //没有
        //insert公共
        tUserCourse.setId(uuid);
        tUserCourse.setCreateTime(new Date());
        tUserCourse.setAddUserId(ShiroUtils.getUserId().toString());
        return tUserCourseMapper.insertTUserCourse(tUserCourse);
    }

    /**
     * 修改课程安排(详情)
     *
     * @param tUserCourse 课程安排(详情)信息
     * @return 结果
     */
    @Override
    public int updateTUserCourse(TUserCourse tUserCourse) {
        return tUserCourseMapper.updateTUserCourse(tUserCourse);
    }

    /**
     * 删除课程安排(详情)对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTUserCourseByIds(String ids) {
        return tUserCourseMapper.deleteTUserCourseByIds(Convert.toStrArray(ids));
    }

    @Override
    public AjaxResult remind(String userCourseId) {
        TUserCourse userCourse = this.tUserCourseMapper.selectTUserCourseById(userCourseId);
        //查询用户手机识别码
        TUserClient userClient = this.userClientMapper.selectTUserClientById(new Long(userCourse.getUserId()));
        if (userClient == null) {
            return AjaxResult.error(2, "该用户未使用手机APP登录,提醒失败.");
        }

        //推送
        List<TUserClient> users = new ArrayList<TUserClient>();
        TUserClient tUserClient = new TUserClient();
        tUserClient.setClientId(userClient.getClientId());
        users.add(tUserClient);
        TMessage tmessage = new TMessage();
        tmessage.setTitle("您有新的课程!");
        tmessage.setContext("您有新的课程需要学习！课程名称："+userCourse.getCourseName());
        tmessage.setLinkUrl("");
        tmessage.setLogoUrl("");
        GetuiUtils.pushList(users, tmessage);
        return AjaxResult.success();
    }

}