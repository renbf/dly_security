package com.project.web.service;

import com.project.web.domian.TNotice;
import java.util.List;

/**
 * 公告管理 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITNoticeService 
{
	/**
     * 查询公告管理信息
     * 
     * @param id 公告管理ID
     * @return 公告管理信息
     */
	public TNotice selectTNoticeById(String id);
	
	/**
     * 查询公告管理列表
     * 
     * @param tNotice 公告管理信息
     * @return 公告管理集合
     */
	public List<TNotice> selectTNoticeList(TNotice tNotice);
	
	/**
     * 新增公告管理
     * 
     * @param tNotice 公告管理信息
     * @return 结果
     */
	public int insertTNotice(TNotice tNotice);
	
	/**
     * 修改公告管理
     * 
     * @param tNotice 公告管理信息
     * @return 结果
     */
	public int updateTNotice(TNotice tNotice);
		
	/**
     * 删除公告管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTNoticeByIds(String ids);
	//以上自动生成的尽量别动
}
