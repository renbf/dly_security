package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TInspectPlan;
import com.project.web.domian.TInspectPlanMain;
import com.project.web.domian.TInspectTitleTeam;
import com.project.web.mapper.TInspectPlanMainMapper;
import com.project.web.mapper.TInspectPlanMapper;
import com.project.web.mapper.TInspectTitleTeamMapper;
import com.project.web.service.ITInspectPlanMainService;
import com.project.web.service.ITInspectPlanService;
import com.project.web.service.ITInspectTitleTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 检查计划主 服务层实现
 *
 * @author rbf
 * @date 2019-05-05
 */
@Service
public class TInspectPlanMainServiceImpl implements ITInspectPlanMainService {
    @Autowired
    private TInspectPlanMainMapper tInspectPlanMainMapper;

    @Autowired
    private ITInspectPlanService inspectPlanService;
    @Autowired
    private ITInspectTitleTeamService inspectTitleTeamService;


    @Autowired
    private TInspectPlanMapper inspectPlanMapper;
    @Autowired
    private TInspectTitleTeamMapper inspectTitleTeamMapper;

    /**
     * 查询检查计划主信息
     *
     * @param titleId 检查计划主ID
     * @return 检查计划主信息
     */
    @Override
    public TInspectPlanMain selectTInspectPlanMainById(String titleId) {
        return tInspectPlanMainMapper.selectTInspectPlanMainById(titleId);
    }

    /**
     * 查询检查计划主列表
     *
     * @param tInspectPlanMain 检查计划主信息
     * @return 检查计划主集合
     */
    @Override
    public List<TInspectPlanMain> selectTInspectPlanMainList(TInspectPlanMain tInspectPlanMain) {
        return tInspectPlanMainMapper.selectTInspectPlanMainList(tInspectPlanMain);
    }

    /**
     * 新增检查计划主
     *
     * @param tInspectPlanMain 检查计划主信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult insertTInspectPlanMain(TInspectPlanMain tInspectPlanMain) {
        //return tInspectPlanMainMapper.insertTInspectPlanMain(tInspectPlanMain);
        /*校验*/
        /*添加主表*/
        String uuid = UUIDUtil.getUUID();
        tInspectPlanMain.setTitleId(uuid);
        tInspectPlanMain.setCreateTime(new Date());
        tInspectPlanMain.setAddUserId(ShiroUtils.getUserId().toString());
        if (this.tInspectPlanMainMapper.insertTInspectPlanMain(tInspectPlanMain) <= 0) {
            throw new RuntimeException();
        }
        /*添加人员附表*/
        if (tInspectPlanMain.getInsertUserInfos() != null && !tInspectPlanMain.getInsertUserInfos().isEmpty()) {
            tInspectPlanMain.getInsertUserInfos().forEach(e -> {
                TInspectPlan inspectPlan = new TInspectPlan();
                inspectPlan.setTitleId(uuid);
                /*同步的参数内容*/
                inspectPlan.setCheckTitle(tInspectPlanMain.getCheckTitle());
                inspectPlan.setCheckYear(tInspectPlanMain.getCheckYear());
                inspectPlan.setCheckTime(tInspectPlanMain.getCheckTime());
                inspectPlan.setCheckType(tInspectPlanMain.getCheckType());
                inspectPlan.setBusinessId(tInspectPlanMain.getBusinessId());
                inspectPlan.setRemark(tInspectPlanMain.getRemark());
                //吐槽:我应该使用 BeanUtils.copyProperties 来完成以上内容的!!!
                /*初始化*/
                inspectPlan.setCheckStatus("0");
                /*用户和部门信息*/
                inspectPlan.setDeptId(Long.parseLong(e.getDeptId().trim()));
                inspectPlan.setUserId(e.getUserId().trim());
                if (this.inspectPlanService.insertTInspectPlan(inspectPlan) <= 0) {
                    throw new RuntimeException();
                }
            });
        }
        /*添加项目附表*/
        if (tInspectPlanMain.getProjects() != null && !tInspectPlanMain.getProjects().isEmpty()) {
            tInspectPlanMain.getProjects().forEach(e -> {
                TInspectTitleTeam inspectTitleTeam = new TInspectTitleTeam();
                inspectTitleTeam.setTitleId(uuid);
                inspectTitleTeam.setCheckTeam(e.trim());
                if (this.inspectTitleTeamService.insertTInspectTitleTeam(inspectTitleTeam) <= 0) {
                    throw new RuntimeException();
                }
            });
        }
        return AjaxResult.success();
    }


    /**
     * 修改检查计划主
     *
     * @param tInspectPlanMain 检查计划主信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult updateTInspectPlanMain(TInspectPlanMain tInspectPlanMain) {
        /*校验*/
        /*修改主表*/
        int i = this.tInspectPlanMainMapper.updateTInspectPlanMain(tInspectPlanMain);
        if (i <= 0) {
            throw new RuntimeException();
        }
        /*修改用户附属表*/
        TInspectPlan plan = new TInspectPlan();
        plan.setTitleId(tInspectPlanMain.getTitleId());
        List<TInspectPlan> databaseEntity = this.inspectPlanService.selectTInspectPlanList(plan);
        //分析:删除新数据没有但是数据库有的用户信息,新增 新数据有但是数据库没有的用户信息, 最后同步主附表信息.
        //计算需要新增的项
        if (tInspectPlanMain.getInsertUserInfos() != null) {
            tInspectPlanMain.getInsertUserInfos().forEach(u -> {
                boolean temp = false;
                for (TInspectPlan uc : databaseEntity) {
                    if (u.getUserId().trim().equals(uc.getUserId().trim())) {
                        temp = true;
                    }
                }
                if (!temp) {
                    //新增
                    TInspectPlan inspectPlan = new TInspectPlan();
                    inspectPlan.setTitleId(tInspectPlanMain.getTitleId());
                    /*同步的参数内容*/
                    inspectPlan.setCheckTitle(tInspectPlanMain.getCheckTitle());
                    inspectPlan.setCheckYear(tInspectPlanMain.getCheckYear());
                    inspectPlan.setCheckTime(tInspectPlanMain.getCheckTime());
                    inspectPlan.setCheckType(tInspectPlanMain.getCheckType());
                    inspectPlan.setBusinessId(tInspectPlanMain.getBusinessId());
                    inspectPlan.setRemark(tInspectPlanMain.getRemark());
                    /*初始化*/
                    inspectPlan.setCheckStatus("0");
                    /*用户和部门信息*/
                    inspectPlan.setDeptId(Long.parseLong(u.getDeptId().trim()));
                    inspectPlan.setUserId(u.getUserId().trim());
                    if (this.inspectPlanService.insertTInspectPlan(inspectPlan) <= 0) {
                        throw new RuntimeException();
                    }
                }
            });
        }
        //计算需要删除的项
        StringBuffer deleteIds = new StringBuffer();
        if (tInspectPlanMain.getInsertUserInfos() == null || tInspectPlanMain.getInsertUserInfos().isEmpty()) {
            //全删
            databaseEntity.forEach(e -> deleteIds.append(e.getId()).append(","));
        } else {
            databaseEntity.forEach(uc -> {
                boolean temp = false;
                for (TInspectPlanMain.InsertUserInfo insertUserInfo : tInspectPlanMain.getInsertUserInfos()) {
                    if (uc.getUserId().trim().equals(insertUserInfo.getUserId().trim())) {
                        temp = true;
                    }
                }
                if (!temp) {
                    //添加一个删除项
                    deleteIds.append(uc.getId()).append(",");
                }
            });
        }
        //删除
        if (deleteIds.length() > 0) {
            this.inspectPlanService.deleteTInspectPlanByIds(deleteIds.substring(0, deleteIds.length() - 1));
        }
        //执行同步主附表信息
        TInspectPlan inspectPlan = new TInspectPlan();
        inspectPlan.setTitleId(tInspectPlanMain.getTitleId());
        /*同步的参数内容*/
        inspectPlan.setCheckTitle(tInspectPlanMain.getCheckTitle());
        inspectPlan.setCheckYear(tInspectPlanMain.getCheckYear());
        inspectPlan.setCheckTime(tInspectPlanMain.getCheckTime());
        inspectPlan.setCheckType(tInspectPlanMain.getCheckType());
        inspectPlan.setBusinessId(tInspectPlanMain.getBusinessId());
        inspectPlan.setRemark(tInspectPlanMain.getRemark());
        this.inspectPlanMapper.updateTInspectPlanByTitleId(inspectPlan);
        /*修改项目附属表*/
        //全删
        this.inspectTitleTeamService.deleteTInspectTitleTeamByIds(tInspectPlanMain.getTitleId());
        //新增
        if (tInspectPlanMain.getProjects() != null && !tInspectPlanMain.getProjects().isEmpty()) {
            tInspectPlanMain.getProjects().forEach(e -> {
                TInspectTitleTeam inspectTitleTeam = new TInspectTitleTeam();
                inspectTitleTeam.setTitleId(tInspectPlanMain.getTitleId());
                inspectTitleTeam.setCheckTeam(e.trim());
                if (this.inspectTitleTeamService.insertTInspectTitleTeam(inspectTitleTeam) <= 0) {
                    throw new RuntimeException();
                }
            });
        }
        return AjaxResult.success();
    }

    /**
     * 删除检查计划主对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteTInspectPlanMainByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            /*删除主表*/
            this.tInspectPlanMainMapper.deleteTInspectPlanMainByIds(Convert.toStrArray(ids));
            /*删除人员附表*/
            this.inspectPlanMapper.deleteTInspectPlanByTitleId(Convert.toStrArray(ids));
            /*删除项目附表*/
            this.inspectTitleTeamService.deleteTInspectTitleTeamByIds(ids);
        }
        return 0;
    }

}
