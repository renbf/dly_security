package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TPaperArrange;
import com.project.web.domian.TUserPaper;
import com.project.web.mapper.TPaperArrangeMapper;
import com.project.web.mapper.TUserPaperMapper;
import com.project.web.service.ITPaperArrangeService;
import com.project.web.service.ITUserPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 考试安排 服务层实现
 *
 * @author rbf
 * @date 2019-05-06
 */
@Service
public class TPaperArrangeServiceImpl implements ITPaperArrangeService {
    @Autowired
    private TPaperArrangeMapper tPaperArrangeMapper;


    @Autowired
    private ITUserPaperService userPaperService;

    @Autowired
    private TUserPaperMapper userPaperMapper;


    /**
     * 查询考试安排信息
     *
     * @param id 考试安排ID
     * @return 考试安排信息
     */
    @Override
    public TPaperArrange selectTPaperArrangeById(String id) {
        return tPaperArrangeMapper.selectTPaperArrangeById(id);
    }

     /**
     * 查询考试安排列表
     *
     * @param tPaperArrange 考试安排信息
     * @return 考试安排集合
     */
    @Override
    public List<TPaperArrange> selectTPaperArrangeList(TPaperArrange tPaperArrange) {
        List<TPaperArrange> paperArranges = tPaperArrangeMapper.selectTPaperArrangeList(tPaperArrange);
        if (paperArranges.isEmpty()) {
            return paperArranges;
        }
        /*使用in关键字查询附属表*/
        ArrayList<String> paperArrangeIds = new ArrayList<>();
        paperArranges.forEach(e -> paperArrangeIds.add(e.getId()));
        TUserPaper userPaper = new TUserPaper().setPaperArrangeIds(paperArrangeIds);
        List<TUserPaper> userPapers = this.userPaperMapper.selectTUserPaperList(userPaper);
        /*将查出的内容进行关联到主表*/
        paperArranges.forEach(ca -> {
            userPapers.forEach(uc -> {
                if (ca.getId().trim().equals(uc.getPaperArrangeId().trim())) {
                    if (ca.getUserPapers() == null) {
                        ca.setUserPapers(new ArrayList<TUserPaper>());
                    }
                    ca.getUserPapers().add(uc);
                }
            });
        });
        /*计算各种人数*/
        paperArranges.forEach(e -> {
            e.setNotPaperNum(new Long(e.getUserPapers().stream().filter(uc -> uc.getStatus().trim().equals("0")).count()).intValue());
            e.setFinishPaperNum(new Long(e.getUserPapers().stream().filter(uc -> uc.getStatus().trim().equals("2")).count()).intValue());
        });
        return paperArranges;
    }

    /**
     * 新增考试安排
     *
     * @param tPaperArrange 考试安排信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult insertTPaperArrange(TPaperArrange tPaperArrange) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传 //没有
        //insert公共
        tPaperArrange.setId(uuid);
        tPaperArrange.setCreateTime(new Date());
        tPaperArrange.setAddUserId(ShiroUtils.getUserId().toString());
        int i = tPaperArrangeMapper.insertTPaperArrange(tPaperArrange);
        if (i <= 0) {
            throw new RuntimeException();
        }
        /*存储详情表*/
        if (tPaperArrange.getUserIds() != null) {
            tPaperArrange.getUserIds().forEach(e -> {
                TUserPaper userPaper = new TUserPaper();
                //添加附属表not null项和默认项
                userPaper.setPaperArrangeId(uuid);
                userPaper.setUserId(e);
                userPaper.setPaperId(tPaperArrange.getPaperId());
                userPaper.setBeginDate(tPaperArrange.getStartDate());
                userPaper.setEndDate(tPaperArrange.getEndDate());
                userPaper.setStatus("0");
                if (this.userPaperService.insertTUserPaper(userPaper) <= 0) {
                    throw new RuntimeException();
                }
            });
        }
        return AjaxResult.success();
    }

    /**
     * 修改考试安排
     *
     * @param tPaperArrange 考试安排信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult updateTPaperArrange(TPaperArrange tPaperArrange) {
        /*修改主表*/
        int i = tPaperArrangeMapper.updateTPaperArrange(tPaperArrange);
        /*修改详情表*/
        /*由于详情表有其他数据,所以需要精确比对之后决定删除项和新增项.而不能采用全部删除之后重新新增的方式*/
        //查询旧详情表
        TUserPaper userPaper = new TUserPaper();
        userPaper.setPaperArrangeId(tPaperArrange.getId());
        List<TUserPaper> userPapers = this.userPaperService.selectTUserPaperList(userPaper);
        //新增项
        if (tPaperArrange.getUserIds() != null) {
            tPaperArrange.getUserIds().forEach(u -> {
                boolean temp = false;
                for (TUserPaper uc : userPapers) {
                    if (u.trim().equals(uc.getUserId().trim())) {
                        temp = true;
                    }
                }
                if (!temp) {
                    TUserPaper userCourse1 = new TUserPaper();
                    userCourse1.setPaperArrangeId(tPaperArrange.getId());
                    userCourse1.setUserId(u);
                    userCourse1.setPaperId(tPaperArrange.getPaperId());
                    userCourse1.setBeginDate(tPaperArrange.getStartDate());
                    userCourse1.setEndDate(tPaperArrange.getEndDate());
                    userCourse1.setStatus("0");
                    if (this.userPaperService.insertTUserPaper(userCourse1) <= 0) {
                        throw new RuntimeException();
                        //课程安排中检查这里,,中午写到这里了!!!!!!!
                    }
                }
            });
        }
        //删除项
        StringBuffer deleteIds = new StringBuffer();
        if (tPaperArrange.getUserIds() == null || tPaperArrange.getUserIds().isEmpty()) {
            //全删
            userPapers.forEach(e -> deleteIds.append(e.getId()).append(","));
        } else {
            userPapers.forEach(uc -> {
                boolean temp = false;
                for (String userId : tPaperArrange.getUserIds()) {
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
            this.userPaperService.deleteTUserPaperByIds(deleteIds.substring(0, deleteIds.length() - 1));
        }
        return AjaxResult.success();
    }

    /**
     * 删除考试安排对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteTPaperArrangeByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            int i = tPaperArrangeMapper.deleteTPaperArrangeByIds(Convert.toStrArray(ids));
            if (i <= 0) {
                return i;
            }
            this.userPaperMapper.deleteTUserPaperByPaperArrangeId(Convert.toStrArray(ids));
            return i;
        }
        return 0;
    }

}
