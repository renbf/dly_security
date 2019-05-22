package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.getui.pushmessage.GetuiUtils;
import com.project.framework.util.ShiroUtils;
import com.project.security.domain.TUserClient;
import com.project.security.mapper.TUserClientMapper;
import com.project.util.UUIDUtil;
import com.project.web.domian.TMessage;
import com.project.web.domian.TUserPaper;
import com.project.web.domian.TUserSubject;
import com.project.web.mapper.TUserPaperMapper;
import com.project.web.mapper.TUserSubjectMapper;
import com.project.web.service.ITUserPaperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户考试安排 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TUserPaperServiceImpl implements ITUserPaperService {
    private static final Logger log = LoggerFactory.getLogger(TUserPaperServiceImpl.class);
    @Autowired
    @Qualifier("tUserPaperMapper")
    private TUserPaperMapper tUserPaperMapper;


    @Autowired
    private TUserClientMapper userClientMapper;

    @Autowired
    private TUserSubjectMapper userSubjectMapper;



    /**
     * 查询用户考试安排信息
     *
     * @param id 用户考试安排ID
     * @return 用户考试安排信息
     */
    @Override
    public TUserPaper selectTUserPaperById(String id) {
        return tUserPaperMapper.selectTUserPaperById(id);
    }

    /**
     * 查询用户考试安排列表
     *
     * @param tUserPaper 用户考试安排信息
     * @return 用户考试安排集合
     */
    @Override
    public List<TUserPaper> selectTUserPaperList(TUserPaper tUserPaper) {
        return tUserPaperMapper.selectTUserPaperList(tUserPaper);
    }

    /**
     * 新增用户考试安排
     *
     * @param tUserPaper 用户考试安排信息
     * @return 结果
     */
    @Override
    public int insertTUserPaper(TUserPaper tUserPaper) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传 //没有
        //insert公共
        tUserPaper.setId(uuid);
        tUserPaper.setCreateTime(new Date());
        tUserPaper.setAddUserId(ShiroUtils.getUserId().toString());
        return tUserPaperMapper.insertTUserPaper(tUserPaper);
    }

    /**
     * 修改用户考试安排
     *
     * @param tUserPaper 用户考试安排信息
     * @return 结果
     */
    @Override
    public int updateTUserPaper(TUserPaper tUserPaper) {
        return tUserPaperMapper.updateTUserPaper(tUserPaper);
    }

    /**
     * 删除用户考试安排对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTUserPaperByIds(String ids) {
        return tUserPaperMapper.deleteTUserPaperByIds(Convert.toStrArray(ids));
    }


    //以上自动生成的尽量别动

    /**
     * 提醒考试
     * @param userPaperId
     * @return
     */
    @Override
    public AjaxResult remind(String userPaperId) {
        TUserPaper userPaper = this.tUserPaperMapper.selectTUserPaperById(userPaperId);
        //查询用户手机识别码
        TUserClient userClient = this.userClientMapper.selectTUserClientById(new Long(userPaper.getUserId()));
        if (userClient == null) {
            return AjaxResult.error(2, "该用户未使用手机APP登录,提醒失败.");
        }
        //推送
        List<TUserClient> users = new ArrayList<TUserClient>();
        TUserClient tUserClient = new TUserClient();
        tUserClient.setClientId(userClient.getClientId());
        users.add(tUserClient);
        TMessage tmessage = new TMessage();
        tmessage.setTitle("您有新的考试!");
        tmessage.setContext("您有新的考试！考试名称："+userPaper.getPaperName());
        tmessage.setLinkUrl("");
        tmessage.setLogoUrl("");
        GetuiUtils.pushList(users, tmessage);
        return AjaxResult.success();
    }

    /**
     * 重新考试
     * @param userPaperId
     * @return
     */
    @Override
    @Transactional
    public AjaxResult repaper(String userPaperId) {
        /*修改状态*/
        TUserPaper userPaper = new TUserPaper();
        userPaper.setId(userPaperId);
        userPaper.setStatus("0");
        if (this.tUserPaperMapper.updateTUserPaper(userPaper) <= 0) {
            throw new RuntimeException();
        }
        /*清空subject表的考试信息*/
        this.userSubjectMapper.deleteTUserSubjectByUserPaperId(userPaperId);
        return AjaxResult.success();
    }
}
