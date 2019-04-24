package com.project.security.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.project.security.domain.TUserPaper;
import com.project.security.domain.vo.TUserPaperVo;
import com.project.security.domain.vo.UserPaperDetailVo;	

/**
 * 用户考试安排 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Repository("userPaperMapper")
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
	 * 查询考试试卷
	 * @param userId
	 * @return
	 */
	public List<TUserPaperVo> selectTUserPapersByUserId(String userId);
	/**
	 * 用户试卷详情
	 * @param userPaperId
	 * @return
	 */
	public List<UserPaperDetailVo> examPaperDetail(String userPaperId);
	/**
	 * 考卷列表
	 * @param tUserPaper
	 * @return
	 */
	public List<TUserPaperVo> selectTUserPapersByWhere(Map<String,Object> param);
	
	/**
     * 查询用户考试安排信息
     * 
     * @param id 用户考试安排ID
     * @return 用户考试安排信息
     */
	public TUserPaperVo selectTUserPaperByUserPaperId(String userPaperid);
}