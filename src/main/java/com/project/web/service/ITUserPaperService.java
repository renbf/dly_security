package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TUserPaper;
import java.util.List;

/**
 * 用户考试安排 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITUserPaperService 
{
	/**
     * 查询用户考试安排信息
     * 
     * @param id 用户考试安排ID
     * @return 用户考试安排信息
     */
	public TUserPaper selectTUserPaperById(String id);
	
	/**
     * 查询用户考试安排列表
     * 
     * @param tUserPaper 用户考试安排信息
     * @return 用户考试安排集合
     */
	public List<TUserPaper> selectTUserPaperList(TUserPaper tUserPaper);
	
	/**
     * 新增用户考试安排
     * 
     * @param tUserPaper 用户考试安排信息
     * @return 结果
     */
	public int insertTUserPaper(TUserPaper tUserPaper);
	
	/**
     * 修改用户考试安排
     * 
     * @param tUserPaper 用户考试安排信息
     * @return 结果
     */
	public int updateTUserPaper(TUserPaper tUserPaper);
		
	/**
     * 删除用户考试安排信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserPaperByIds(String ids);
	//以上自动生成的尽量别动


	/**
	 * 提醒
	 * @param userPaperId
	 * @return
	 */
	public AjaxResult remind(String userPaperId);


	/**
	 * 重新考试,   其实就是修改下状态.
	 * @param userPaperId
	 * @return
	 */
	public AjaxResult repaper(String userPaperId);
}
