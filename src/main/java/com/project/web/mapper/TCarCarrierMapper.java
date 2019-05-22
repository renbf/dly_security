package com.project.web.mapper;

import com.project.web.domian.TCarCarrier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 承运人责任险 数据层
 *
 * @author rbf
 * @date 2019-04-23
 */
@Repository("tCarCarrierMapper")
public interface TCarCarrierMapper {
    /**
     * 查询承运人责任险信息
     *
     * @param id 承运人责任险ID
     * @return 承运人责任险信息
     */
    public TCarCarrier selectTCarCarrierById(String id);

    /**
     * 查询承运人责任险列表
     *
     * @param tCarCarrier 承运人责任险信息
     * @return 承运人责任险集合
     */
    public List<TCarCarrier> selectTCarCarrierList(TCarCarrier tCarCarrier);

    /**
     * 新增承运人责任险
     *
     * @param tCarCarrier 承运人责任险信息
     * @return 结果
     */
    public int insertTCarCarrier(TCarCarrier tCarCarrier);

    /**
     * 修改承运人责任险
     *
     * @param tCarCarrier 承运人责任险信息
     * @return 结果
     */
    public int updateTCarCarrier(TCarCarrier tCarCarrier);

    /**
     * 删除承运人责任险
     *
     * @param id 承运人责任险ID
     * @return 结果
     */
    public int deleteTCarCarrierById(String id);

    /**
     * 批量删除承运人责任险
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTCarCarrierByIds(String[] ids);
    //以上自动生成的尽量别动
    /**
     * 批量删除  根据车辆信息id
     * @param ids
     * @return
     */
    public int deleteByCarInfoId(String[] ids);
}