package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.DateUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TEarlyWarningReport;
import com.project.web.mapper.TEarlyWarningReportMapper;
import com.project.web.mapper.TEarlyWarningSettingsMapper;
import com.project.web.service.ITEarlyWarningReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 预警统计 服务层实现
 *
 * @author rbf
 * @date 2019-05-14
 */
@Service
public class TEarlyWarningReportServiceImpl implements ITEarlyWarningReportService {
    private static final Logger log = LoggerFactory.getLogger(TEarlyWarningReportServiceImpl.class);
    @Autowired
    @Qualifier("tEarlyWarningReportMapper")
    private TEarlyWarningReportMapper tEarlyWarningReportMapper;
    @Autowired
    private TEarlyWarningSettingsMapper tEarlyWarningSettingsMapper;

    /**
     * 查询预警统计信息
     *
     * @param id 预警统计ID
     * @return 预警统计信息
     */
    @Override
    public TEarlyWarningReport selectTEarlyWarningReportById(String id) {
        return tEarlyWarningReportMapper.selectTEarlyWarningReportById(id);
    }

    /**
     * 查询预警统计列表
     *
     * @param tEarlyWarningReport 预警统计信息
     * @return 预警统计集合
     */
    @Override
    public List<TEarlyWarningReport> selectTEarlyWarningReportList(TEarlyWarningReport tEarlyWarningReport) {
        return tEarlyWarningReportMapper.selectTEarlyWarningReportList(tEarlyWarningReport);
    }

    /**
     * 新增预警统计
     *
     * @param tEarlyWarningReport 预警统计信息
     * @return 结果
     */
    @Override
    public int insertTEarlyWarningReport(TEarlyWarningReport tEarlyWarningReport) {
        tEarlyWarningReport.setId(UUIDUtil.getUUID());
        tEarlyWarningReport.setCreateDate(new Date());
        tEarlyWarningReport.setAddUserId(ShiroUtils.getUserId().toString());
        return tEarlyWarningReportMapper.insertTEarlyWarningReport(tEarlyWarningReport);
    }

    /**
     * 修改预警统计
     *
     * @param tEarlyWarningReport 预警统计信息
     * @return 结果
     */
    @Override
    public int updateTEarlyWarningReport(TEarlyWarningReport tEarlyWarningReport) {
        return tEarlyWarningReportMapper.updateTEarlyWarningReport(tEarlyWarningReport);
    }

    /**
     * 删除预警统计对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTEarlyWarningReportByIds(String ids) {
        return tEarlyWarningReportMapper.deleteTEarlyWarningReportByIds(Convert.toStrArray(ids));
    }
    //以上自动生成的尽量别动


    /**
     * 任务:
     * 负责定时任务的业务方法
     * 查询出当前的安全预警,
     * <p>
     * 业务分析:
     * 该方法注册定时任务,每天运行一次
     * 1:查询可以预警的数据
     * 2:查询预警表已经存在的正在报警的数据
     * 3:查询出集合:查询规则(按照报警类型和报警ID分类比较)
     * --3.1:新的报警信息集合(新查询有,报警表没有)
     * --3.2:继续报警的信息集合(新查询有,报警表有)
     * --3.3:报警可能已解除的信息集合(新查询没有,报警表有)(这种情况不做处理,理论上存在几率极低,会在解决定时任务中处理)
     * 4:新的报警信息处理:设置新增参数,insert到表中
     * 5:继续报警的信息集合处理:更新持续天数!!
     * 6:报警可能已解除的信息集合处理:这个暂时不做处理........
     */
    @Override
    @Transactional
    public void task() {
        /*1:调用sql查询数据库中所有安全预警*/
        List<TEarlyWarningReport> selectWarning = this.tEarlyWarningReportMapper.selectEarlyWarningTask();

        /*2:查询已经存在的正在报警的安全预警*/
        TEarlyWarningReport tempEarlyWarningReport = new TEarlyWarningReport();
        tempEarlyWarningReport.setStatus("0");//设置正在报警的
        tempEarlyWarningReport.setEarlyWarningType("1");//设置只查询安全预警的.
        List<TEarlyWarningReport> oldWarning = this.tEarlyWarningReportMapper.selectTEarlyWarningReportList(tempEarlyWarningReport);

        /*3:筛选出集合*/
        //新的预警初始化
        List<TEarlyWarningReport> newWarning = new ArrayList<>();
        //正在存在的预警
        List<TEarlyWarningReport> warning = null;
        //可能已解除的预警初始化
        List<TEarlyWarningReport> overWarning = new ArrayList<>();
        /*3.1,查询新的预警*/
        selectWarning.forEach(w -> {
            //临时布尔值
            AtomicReference<Boolean> temp = new AtomicReference<>(false);
            oldWarning.forEach(o -> {
                //比较报警类型和报警条目的数据库表id
                //理论上全走程序,真的不会空指针
                if (w.getAlarmType().trim().equals(o.getAlarmType().trim()) && w.getAlarmId().trim().equals(o.getAlarmId().trim())) {
                    temp.set(true);
                }
            });
            if (!temp.get()) {
                newWarning.add(w);
            }
        });
        /*3.2,已经存在的预警*/
        warning = oldWarning.stream().filter(s ->
                selectWarning.stream().anyMatch(o ->
                        s.getAlarmType().trim().equals(o.getAlarmType().trim()) && s.getAlarmId().trim().equals(o.getAlarmId().trim()))
        ).collect(Collectors.toList());
        /*3.3,已解除的预警*/
        //暂时用不到,,先这样吧
        /*4.新的报警信息处理:设置新增参数,insert到表中*/
        Date nowDate = new Date();
        newWarning.forEach(e -> {
            e.setFirstAlarmDate(nowDate);
            e.setNumbers(1);
            e.setCreateDate(nowDate);
            this.tEarlyWarningReportMapper.insertTEarlyWarningReport(e);
        });
        /*5:继续报警的信息集合处理:!!*/
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String nowDateStr = dateFormat.format(nowDate);
        //Date nowDay = null;
        //try {
        //    nowDay = dateFormat.parse(nowDateStr);
        //} catch (ParseException e) {
        //    e.printStackTrace();
        //}
        //warning.forEach(e->{
        //    dateFormat.parse()
        //    e.setNumbers();
        //});
        /*6:报警可能已解除的信息集合处理:这个暂时不做处理........*/
    }

    @Transactional
    public void taskOver() {
        try {
            /*1:调用sql查询数据库中所有风险预警*/
            List<TEarlyWarningReport> selectWarning = this.tEarlyWarningReportMapper.selectEarlyWarningOverTask();
            //标记改成0
            tEarlyWarningReportMapper.updateTEarlyWarningReportByFactor();
            Date nowDate = new Date();
            selectWarning.forEach(s -> {
                String earlyWarningType = s.getEarlyWarningType();
                //安全预警
                if ("1".equals(earlyWarningType)) {
                    s.setMeno(null);
                } else {
                    String meno = s.getMeno();
                    s.setNumbers(Integer.valueOf(meno));
                    s.setMeno(null);
                }
                Integer factor = s.getFactor();
                if (factor.intValue() == 1) {
                    s.setId(UUIDUtil.getUUID());
                    s.setFirstAlarmDate(nowDate);
                    s.setCreateDate(nowDate);
                    this.tEarlyWarningReportMapper.insertTEarlyWarningReport(s);
                } else {
                    TEarlyWarningReport earlyWarningReport = new TEarlyWarningReport();
                    earlyWarningReport.setId(s.getId());
                    earlyWarningReport.setNumbers(s.getNumbers());
                    earlyWarningReport.setFactor(factor);
                    earlyWarningReport.setUpdateDate(nowDate);
                    this.tEarlyWarningReportMapper.updateTEarlyWarningReport(earlyWarningReport);
                }
            });
            List<TEarlyWarningReport> selectSolveWarning = this.tEarlyWarningReportMapper.selectEarlyWarningSolveInfo();
            selectSolveWarning.forEach(s -> {
                this.tEarlyWarningReportMapper.updateTEarlyWarningReport(s);
            });
        } catch (Exception e) {
            log.error("安全预警跑批异常", e);
            throw new RuntimeException("安全预警跑批异常");
        }
    }

    /**
     * 累计风险预警和累计风险因子预警数显示的是按照时间搜索的,按照时间右侧的值统计,
     * 如果右侧时间无值,则默认为当前值,
     * 如果左侧时间无值,则默认为右侧时间减去7天
     * 校验: 左侧时间和右侧时间 中间的差距不能大于30天
     * <p>
     * 下方的折线图数据为时间段内每天的正在预警的数量(未解除的)
     * 即每天最后一秒统计之前的未解除的条数
     *
     * @return
     */
    @Override
    public AjaxResult selectDangerWarningSum(TEarlyWarningReport tEarlyWarningReport) {
        /*填充默认时间值*/
        if (tEarlyWarningReport.getRightDate() == null) {
            tEarlyWarningReport.setRightDate(new Date());
        }
        if (tEarlyWarningReport.getLeftDate() == null) {
            tEarlyWarningReport.setLeftDate(DateUtils.addDays(tEarlyWarningReport.getRightDate(), -6));
        }
        /*校验*/
        if (tEarlyWarningReport.getBusinessId() == null) {
            return AjaxResult.error(2, "企业ID不能为空!!");
        }
        int intervalDays = DateUtils.getIntervalDays(tEarlyWarningReport.getRightDate(), tEarlyWarningReport.getLeftDate());
        if (intervalDays >= 30 || intervalDays < 0) {
            return AjaxResult.error(2, "左侧输入框的时间不能大于右侧输入框的时间并且两者不能超过30天");
        }
        /*查询风险预警,且时间在本次统计返回内的*/
        //设置查询出的内容为右侧时间以前的时间段的
        tEarlyWarningReport.setFirstAlarmDate1(tEarlyWarningReport.getRightDate());
        tEarlyWarningReport.setEarlyWarningType("2");
        List<TEarlyWarningReport> earlyWarningReports = this.tEarlyWarningReportMapper.selectTEarlyWarningReportList(tEarlyWarningReport);
        HashMap<String, Object> data = new HashMap<>();
        /*累计预警和累计风险因子*/
        data.put("warningSum", earlyWarningReports.size());
        data.put("warningFactorSum", earlyWarningReports.size() == 0 ?
                0 : earlyWarningReports.stream().map(TEarlyWarningReport::getNumbers).reduce(Integer::sum).get());
        /*统计折线图中每天的预警数量和风险因子数量*/
        Date dayDate = new Date(tEarlyWarningReport.getLeftDate().getTime());
        ArrayList<Map> returnMap = new ArrayList<>();
        while (DateUtils.dateCompareByYMD(dayDate, tEarlyWarningReport.getRightDate()) <= 0) {
            //初次报警时间在本天之前或者本天的,并且,(未解除,或,(已解除,并且,解除时间为本天之后))
            Date finalDayDate = dayDate;
            List<TEarlyWarningReport> tempList = earlyWarningReports.stream().filter(e -> DateUtils.dateCompareByYMD(e.getFirstAlarmDate(), finalDayDate) <= 0 &&
                    (e.getStatus().trim().equals("0") || e.getStatus().trim().equals("1") && DateUtils.dateCompareByYMD(e.getSolveDate(), finalDayDate) > 0))
                    .collect(Collectors.toList());
            HashMap<String, Object> tempMap = new HashMap<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("y/M/d");
            tempMap.put("date", dayDate);
            tempMap.put("dateStr", dateFormat.format(dayDate));
            tempMap.put("warningSum", tempList.size());
            tempMap.put("warningFactorSum", tempList.size() == 0 ?
                    0 : tempList.stream().map(TEarlyWarningReport::getNumbers).reduce(Integer::sum).get());
            returnMap.add(tempMap);
            //日期自增
            dayDate = org.apache.commons.lang3.time.DateUtils.addDays(dayDate, 1);
        }
        data.put("dayData", returnMap);
        AjaxResult success = AjaxResult.success();
        success.put("data", data);
        return success;
    }


}
