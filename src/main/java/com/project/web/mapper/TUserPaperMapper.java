package com.project.web.mapper;

import com.project.web.domian.TUserPaper;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 用户考试安排 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tUserPaperMapper")
public interface TUserPaperMapper 
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
     * 删除用户考试安排
     * 
     * @param id 用户考试安排ID
     * @return 结果
     */
	public int deleteTUserPaperById(String id);
	
	/**
     * 批量删除用户考试安排
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserPaperByIds(String[] ids);
	//以上自动生成的尽量别动


	/**
	 * 批量删除用户考试安排根据主表id
	 * @param ids
	 * @return
	 */
	public int deleteTUserPaperByPaperArrangeId(String[] ids);

}