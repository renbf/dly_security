package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TThreeProducts;
import com.project.web.mapper.TThreeProductsMapper;
import com.project.web.service.ITThreeProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 三品查处记录 服务层实现
 *
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TThreeProductsServiceImpl implements ITThreeProductsService {
    @Autowired
    private TThreeProductsMapper tThreeProductsMapper;

    /**
     * 查询三品查处记录信息
     *
     * @param id 三品查处记录ID
     * @return 三品查处记录信息
     */
    @Override
    public TThreeProducts selectTThreeProductsById(Long id) {
        return tThreeProductsMapper.selectTThreeProductsById(id);
    }

    /**
     * 查询三品查处记录列表
     *
     * @param tThreeProducts 三品查处记录信息
     * @return 三品查处记录集合
     */
    @Override
    public List<TThreeProducts> selectTThreeProductsList(TThreeProducts tThreeProducts) {
        return tThreeProductsMapper.selectTThreeProductsList(tThreeProducts);
    }

    /**
     * 新增三品查处记录
     *
     * @param tThreeProducts 三品查处记录信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTThreeProducts(TThreeProducts tThreeProducts) {
        //校验
        AjaxResult result = this.insertValidation(tThreeProducts);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传 ///没有
        //insert公共属性添加
        tThreeProducts.setId(uuid);
        tThreeProducts.setCreateTime(new Date());
        tThreeProducts.setUserId(ShiroUtils.getUserId());
        return tThreeProductsMapper.insertTThreeProducts(tThreeProducts) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改三品查处记录
     *
     * @param tThreeProducts 三品查处记录信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTThreeProducts(TThreeProducts tThreeProducts) {
        //校验
        AjaxResult result = this.insertValidation(tThreeProducts);
        if (result != null) {
            return result;
        }
        //文件上传 ///没有
        //update公共属性添加
        tThreeProducts.setUpdateTime(new Date());
        tThreeProducts.setUpdateUserId(ShiroUtils.getUserId());
        return tThreeProductsMapper.updateTThreeProducts(tThreeProducts) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除三品查处记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTThreeProductsByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tThreeProductsMapper.deleteTThreeProductsByIds(Convert.toStrArray(ids));
        }
        return 0;
    }


    /**
     * insert非空字段校验
     * @param tThreeProducts
     * @return
     */
    private AjaxResult insertValidation(TThreeProducts tThreeProducts) {
        if (ValidationUtils.objIsNull(tThreeProducts.getCheckDate())) {
            return AjaxResult.error(2, "检查时间不能为空");
        }
        if (ValidationUtils.objIsNull(tThreeProducts.getGoodsName())) {
            return AjaxResult.error(2, "物品名称不能为空");
        }
        if (ValidationUtils.objIsNull(tThreeProducts.getGoodsType())) {
            return AjaxResult.error(2, "物品类型不能为空");
        }
        if (ValidationUtils.objIsNull(tThreeProducts.getCheckPersonnel())) {
            return AjaxResult.error(2, "检查人不能为空");
        }
        if (ValidationUtils.objIsNull(tThreeProducts.getResultInfo())) {
            return AjaxResult.error(2, "检查结果不能为空");
        }
        return null;
    }




}
