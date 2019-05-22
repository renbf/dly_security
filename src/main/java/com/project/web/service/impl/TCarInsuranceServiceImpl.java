package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCarInsurance;
import com.project.web.mapper.TCarInsuranceMapper;
import com.project.web.service.ITCarInsuranceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 车辆保险情况 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarInsuranceServiceImpl implements ITCarInsuranceService {
    private static final Logger log = LoggerFactory.getLogger(TCarInsuranceServiceImpl.class);
    @Autowired
    @Qualifier("tCarInsuranceMapper")
    private TCarInsuranceMapper tCarInsuranceMapper;

    /**
     * 查询车辆保险情况信息
     *
     * @param id 车辆保险情况ID
     * @return 车辆保险情况信息
     */
    @Override
    public TCarInsurance selectTCarInsuranceById(String id) {
        return tCarInsuranceMapper.selectTCarInsuranceById(id);
    }

    /**
     * 查询车辆保险情况列表
     *
     * @param tCarInsurance 车辆保险情况信息
     * @return 车辆保险情况集合
     */
    @Override
    public List<TCarInsurance> selectTCarInsuranceList(TCarInsurance tCarInsurance) {
        return tCarInsuranceMapper.selectTCarInsuranceList(tCarInsurance);
    }

    /**
     * 新增车辆保险情况
     *
     * @param tCarInsurance 车辆保险情况信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTCarInsurance(TCarInsurance tCarInsurance) {
        //校验
        String uuid = UUIDUtil.getUUID();
        //文件上传 //没有
        //insert公共
        tCarInsurance.setId(uuid);
        tCarInsurance.setCreateTime(new Date());
        tCarInsurance.setAddUserId(ShiroUtils.getUserId().toString());
        return tCarInsuranceMapper.insertTCarInsurance(tCarInsurance) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改车辆保险情况
     *
     * @param tCarInsurance 车辆保险情况信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTCarInsurance(TCarInsurance tCarInsurance) {
        //校验
        //文件上传 //没有
        //update公共
        tCarInsurance.setUpdateTime(new Date());
        tCarInsurance.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tCarInsuranceMapper.updateTCarInsurance(tCarInsurance) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除车辆保险情况对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTCarInsuranceByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tCarInsuranceMapper.deleteTCarInsuranceByIds(Convert.toStrArray(ids));
        }
        return 0;
    }
    //以上自动生成的尽量别动
}
