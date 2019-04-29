package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TGoodsNameType;
import com.project.web.mapper.TGoodsNameTypeMapper;
import com.project.web.service.ITGoodsNameTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 货物名称类项关系 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TGoodsNameTypeServiceImpl implements ITGoodsNameTypeService {
    private static final Logger log = LoggerFactory.getLogger(TGoodsNameTypeServiceImpl.class);
    @Autowired
    @Qualifier("tGoodsNameTypeMapper")
    private TGoodsNameTypeMapper tGoodsNameTypeMapper;

    /**
     * 查询货物名称类项关系信息
     *
     * @param id 货物名称类项关系ID
     * @return 货物名称类项关系信息
     */
    @Override
    public TGoodsNameType selectTGoodsNameTypeById(String id) {
        return tGoodsNameTypeMapper.selectTGoodsNameTypeById(id);
    }

    /**
     * 查询货物名称类项关系列表
     *
     * @param tGoodsNameType 货物名称类项关系信息
     * @return 货物名称类项关系集合
     */
    @Override
    public List<TGoodsNameType> selectTGoodsNameTypeList(TGoodsNameType tGoodsNameType) {
        return tGoodsNameTypeMapper.selectTGoodsNameTypeList(tGoodsNameType);
    }

    /**
     * 新增货物名称类项关系
     *
     * @param tGoodsNameType 货物名称类项关系信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTGoodsNameType(TGoodsNameType tGoodsNameType) {
        this.commonDataFormat(tGoodsNameType);
        //校验
        AjaxResult result = this.insertValidation(tGoodsNameType);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传 //没有
        //insert公共
        tGoodsNameType.setId(uuid);
        tGoodsNameType.setCreateDate(new Date());
        tGoodsNameType.setAddUserId(ShiroUtils.getUserId().toString());
        tGoodsNameType.setBusinessId(ShiroUtils.getBusinessId());
        return tGoodsNameTypeMapper.insertTGoodsNameType(tGoodsNameType) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改货物名称类项关系
     *
     * @param tGoodsNameType 货物名称类项关系信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTGoodsNameType(TGoodsNameType tGoodsNameType) {
        this.commonDataFormat(tGoodsNameType);
        //校验
        AjaxResult result = this.insertValidation(tGoodsNameType);
        if (result != null) {
            return result;
        }
        //文件上传 //没有
        //update公共
        tGoodsNameType.setUpdateTime(new Date());
        tGoodsNameType.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tGoodsNameTypeMapper.updateTGoodsNameType(tGoodsNameType) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除货物名称类项关系对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTGoodsNameTypeByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tGoodsNameTypeMapper.deleteTGoodsNameTypeByIds(Convert.toStrArray(ids));
        }
        return 0;
    }
    //以上自动生成的尽量别动


    private void commonDataFormat(TGoodsNameType tGoodsNameType) {
        if (tGoodsNameType.getGoodsName() != null) {
            tGoodsNameType.setGoodsName(tGoodsNameType.getGoodsName().trim());
        }
    }

    private AjaxResult insertValidation(TGoodsNameType tGoodsNameType) {
        if (ValidationUtils.objIsNull(tGoodsNameType.getGoodsName())) {
            return AjaxResult.error(2, "物品名称不能为空");
        }
        //重复校验
        TGoodsNameType nameType = new TGoodsNameType();
        nameType.setGoodsName(tGoodsNameType.getGoodsName());
        nameType.setBusinessId(ShiroUtils.getBusinessId());
        List<TGoodsNameType> tGoodsNameTypes = this.tGoodsNameTypeMapper.selectTGoodsNameTypeList(nameType);
        if (!tGoodsNameTypes.isEmpty()) {
            return AjaxResult.error(2, "物品名称已经存在");
        }
        return null;
    }


}
