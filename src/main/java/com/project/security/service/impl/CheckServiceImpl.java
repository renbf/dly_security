package com.project.security.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.framework.util.FileUploadUtils;
import com.project.security.domain.Dept;
import com.project.security.domain.TDanger;
import com.project.security.domain.TDict;
import com.project.security.domain.TInspectPlan;
import com.project.security.domain.TInspectRecord;
import com.project.security.domain.TInspectTeamProject;
import com.project.security.domain.vo.TDangerVo;
import com.project.security.domain.vo.TDictNode;
import com.project.security.domain.vo.TDictView;
import com.project.security.domain.vo.TInspectPlanVo;
import com.project.security.domain.vo.TInspectTeamProjectVo;
import com.project.security.mapper.DeptMapper;
import com.project.security.mapper.TDangerMapper;
import com.project.security.mapper.TDictMapper;
import com.project.security.mapper.TInspectPlanMapper;
import com.project.security.mapper.TInspectRecordMapper;
import com.project.security.mapper.TInspectTeamProjectMapper;
import com.project.security.mapper.TRiskLevelControlMapper;
import com.project.security.service.ICheckService;
import com.project.security.service.IFileSystemService;
import com.project.security.utils.page.PageInfoUtil;
import com.project.security.utils.page.TableDataView;
import com.project.util.UUIDUtil;
/**
 * 
 * @author rbf
 *
 */
@Service
public class CheckServiceImpl implements ICheckService {
	private static final Logger log = LoggerFactory.getLogger(CheckServiceImpl.class);
	@Autowired
	private IFileSystemService fileSystemService;
	@Autowired
	@Qualifier("inspectPlanMapper")
	private TInspectPlanMapper inspectPlanMapper;
	@Autowired
	@Qualifier("inspectTeamProjectMapper")
	private TInspectTeamProjectMapper inspectTeamProjectMapper;
	@Autowired
	@Qualifier("deptMapper")
	private DeptMapper deptMapper;
	@Autowired
	@Qualifier("inspectRecordMapper")
	private TInspectRecordMapper inspectRecordMapper;
	@Autowired
	@Qualifier("dangerMapper")
	private TDangerMapper dangerMapper;
	@Autowired
	@Qualifier("dictMapper")
	private TDictMapper dictMapper;
	@Autowired
	@Qualifier("riskLevelControlMapper")
	private TRiskLevelControlMapper riskLevelControlMapper;
	
	@Override
	public DataResult checkPlan(String userId,Integer pageNumber,Long total) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
        	List<TInspectPlanVo> inspectPlanList = inspectPlanMapper.selectTInspectPlanListByUserId(userId);
        	List<TInspectPlanVo> inspectPlanListNew = new ArrayList<TInspectPlanVo>();
        	if(CollectionUtils.isNotEmpty(inspectPlanList)) {
        		Set<String> distinctSet = new HashSet<String>();
        		for(TInspectPlanVo bean:inspectPlanList) {
        			String titleId = bean.getTitleId();
        			if(!distinctSet.contains(titleId)) {
        				List<Map<String,Object>> checkProjects = new ArrayList<Map<String,Object>>();
        				Map<String,Object> map = new HashMap<String, Object>();
        				map.put("checkTeam", bean.getCheckTeam());
        				map.put("checkTeamName", bean.getCheckTeamName());
        				checkProjects.add(map);
        				bean.setCheckProjects(checkProjects);
        				bean.setCheckTeam(null);
        				bean.setCheckTeamName(null);
        				inspectPlanListNew.add(bean);
        				distinctSet.add(titleId);
        			}else {
        				TInspectPlanVo bean2 = inspectPlanListNew.get(inspectPlanListNew.size() -1);
        				List<Map<String,Object>> checkProjects = bean2.getCheckProjects();
        				Map<String,Object> map = new HashMap<String, Object>();
        				map.put("checkTeam", bean.getCheckTeam());
        				map.put("checkTeamName", bean.getCheckTeamName());
        				checkProjects.add(map);
        			}
        		}
        	}
        	TableDataView<TInspectPlanVo> tableDataView = PageInfoUtil.addPageInfo(inspectPlanListNew);
			result.setResult(tableDataView);
			result.setMessage("检查计划成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("检查计划接口异常",e);
			throw new RuntimeException("检查计划接口异常");
		}
	}
	
	@Override
	public DataResult queryCheckProject(String inspectPlanId, String projectId) {
		DataResult result = new DataResult();
        try {
        	List<TInspectTeamProjectVo> inspectTeamProjects = inspectTeamProjectMapper.selectTInspectTeamProjects(inspectPlanId,projectId);
        	result.setResult(inspectTeamProjects);
			result.setMessage("查询检查项成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询检查项接口异常",e);
			throw new RuntimeException("查询检查项接口异常");
		}
	}
	
	
	@Override
	@Transactional
	public DataResult saveCheckProject(String inspectTeamProjectJson) {
		DataResult result = new DataResult();
        try {
        	List<TInspectTeamProject> tInspectTeamProjects = JSONArray.parseArray(inspectTeamProjectJson, TInspectTeamProject.class);
        	if(CollectionUtils.isNotEmpty(tInspectTeamProjects)) {
        		String inspectPlanId = tInspectTeamProjects.get(0).getInspectPlanId();
        		String checkTeamId = tInspectTeamProjects.get(0).getCheckTeamId();
        		inspectTeamProjectMapper.deleteTInspectTeamProjectByTeamId(inspectPlanId, checkTeamId);
        		inspectTeamProjectMapper.addBatchTInspectTeamProjects(tInspectTeamProjects);
        	}
			result.setMessage("保存检查项成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("保存检查项接口异常",e);
			throw new RuntimeException("保存检查项接口异常");
		}
	}
	
	
	@Override
	@Transactional
	public DataResult completeCheck(String inspectRecordJson,MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	TInspectRecord tInspectRecord = JSON.parseObject(inspectRecordJson, TInspectRecord.class);
        	if(tInspectRecord == null) {
        		result.setMessage("完成检查计划参数错误");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	String userSignUrl = null;
        	if(file != null) {
        		boolean fileType = FileUploadUtils.checkImgFile(file);
    			if(!fileType) {
    				result.setMessage("上传图片类型错误");
    				result.setStatus(Result.FAILED);
    				return result;
    			}
            	userSignUrl = fileSystemService.uploadFile(file);
    			if(StringUtils.isEmpty(userSignUrl)) {
    				result.setMessage("上传图片失败");
    				result.setStatus(Result.FAILED);
    				return result;
    			}
        	}
			tInspectRecord.setUserSignUrl(userSignUrl);
        	TInspectPlan tInspectPlan = new TInspectPlan();
        	tInspectPlan.setId(tInspectRecord.getInspectPlanId());
        	tInspectPlan.setCheckStatus("1");
        	inspectPlanMapper.updateTInspectPlan(tInspectPlan);
        	inspectRecordMapper.insertTInspectRecord(tInspectRecord);
			result.setMessage("完成检查计划成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("完成检查计划接口异常",e);
			throw new RuntimeException("完成检查计划接口异常");
		}
	}
	
	
	@Override
	public DataResult queryHiddenDanger(String businessId) {
		DataResult result = new DataResult();
        try {
        	//部门
        	Dept dept = new Dept();
        	dept.setBusinessId(businessId);
        	List<Dept> deptList = deptMapper.selectDeptList(dept);
        	
        	//检查类型
        	List<TDictView> checkTypes = dictMapper.selectTDictListBybusinessId("4",businessId);
        	//隐患类型
        	List<TDictNode> dangerTypes = dictMapper.selectTDictNodesBybusinessId("107",businessId);
        	if(CollectionUtils.isNotEmpty(dangerTypes)) {
        		for(TDictNode dict:dangerTypes) {
        			List<TDictNode> children = dictMapper.selectTDictNodesByParentId(dict.getId());
        			dict.setChildren(children);
        		}
        	}
        	//隐患等级
        	List<TDictView> dangerLevels = dictMapper.selectTDictListByParentId("100");
        	//可能后果
        	List<TDictView> maybeResults = dictMapper.selectTDictListByParentId("103");
        	//对应风险源
        	List<TDictView> hiddenDangersFrom = dictMapper.selectTRiskLevelControlDict(businessId);
        	Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("deptList", deptList);
			mapResult.put("checkTypes", checkTypes);
			mapResult.put("dangerTypes", dangerTypes);
			mapResult.put("dangerLevels", dangerLevels);
			mapResult.put("maybeResults", maybeResults);
			mapResult.put("hiddenDangersFrom", hiddenDangersFrom);
        	result.setResult(mapResult);
			result.setMessage("上传隐患——查询部门等成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("上传隐患——查询部门等接口异常",e);
			throw new RuntimeException("上传隐患——查询部门等接口异常");
		}
	}
	
	@Override
	public DataResult queryHiddenDangerDetail(String dangerId) {
		DataResult result = new DataResult();
        try {
        	TDangerVo tDangerVo = dangerMapper.selectTDangerVoByDangerId(dangerId);
        	result.setResult(tDangerVo);
			result.setMessage("隐患详情成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("隐患详情接口异常",e);
			throw new RuntimeException("隐患详情接口异常");
		}
	}
	
	@Override
	@Transactional
	public DataResult uploadHiddenDanger(String dangerJson, MultipartFile[] file,String inspectPlanId) {
		DataResult result = new DataResult();
        try {
        	String dangerUrl = null;
        	if(file != null) {
        		boolean fileType = FileUploadUtils.checkImgFiles(file);
    			if(!fileType) {
    				result.setMessage("上传图片类型错误");
    				result.setStatus(Result.FAILED);
    				return result;
    			}
            	dangerUrl = fileSystemService.uploadFiles(file);
    			if(StringUtils.isEmpty(dangerUrl)) {
    				result.setMessage("上传图片失败");
    				result.setStatus(Result.FAILED);
    				return result;
    			}
        	}
        	TDanger danger = JSON.parseObject(dangerJson, TDanger.class);
        	danger.setId(UUIDUtil.getUUID());
        	danger.setCreateDate(new Date());
        	danger.setDangerUrl(dangerUrl);
        	danger.setStatus("0");
        	dangerMapper.insertTDanger(danger);
        	TInspectPlan tInspectPlan = new TInspectPlan();
        	if(StringUtils.isNotEmpty(inspectPlanId)) {
        		tInspectPlan.setId(inspectPlanId);
            	tInspectPlan.setCheckStatus("2");
            	inspectPlanMapper.updateTInspectPlan(tInspectPlan);
        	}
			result.setMessage("上报隐患成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("上报隐患接口异常",e);
			throw new RuntimeException("上报隐患接口异常");
		}
	}
	
	@Override
	public DataResult rectification(Integer pageNumber,Long total,String userId) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
        	TDanger tDanger = new TDanger();
        	tDanger.setDochangeUserId(userId);
        	tDanger.setStatus("1");
        	List<TDanger> dangerList = dangerMapper.selectTDangerList(tDanger);
    		TableDataView<TDanger> tableDataView = PageInfoUtil.addPageInfo(dangerList);
			result.setResult(tableDataView);
			result.setMessage("隐患整改成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("隐患整改接口异常",e);
			throw new RuntimeException("隐患整改接口异常");
		}
	}
	
	@Override
	public DataResult rectificationDetail(String dangerJson, MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	String dochangePicture = null;
        	if(file != null) {
        		boolean fileType = FileUploadUtils.checkImgFile(file);
    			if(!fileType) {
    				result.setMessage("上传图片类型错误");
    				result.setStatus(Result.FAILED);
    				return result;
    			}
            	dochangePicture = fileSystemService.uploadFile(file);
    			if(StringUtils.isEmpty(dochangePicture)) {
    				result.setMessage("上传图片失败");
    				result.setStatus(Result.FAILED);
    				return result;
    			}
        	}
        	TDanger danger = JSON.parseObject(dangerJson, TDanger.class);
        	danger.setStatus("2");
        	danger.setDochangePicture(dochangePicture);
        	dangerMapper.updateTDanger(danger);
			result.setMessage("隐患整改提交成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("隐患整改提交接口异常",e);
			throw new RuntimeException("隐患整改提交接口异常");
		}
	}
	
	@Override
	public DataResult refuseDochange(String dangerId, String refuseText) {
		DataResult result = new DataResult();
        try {
        	TDanger danger = new TDanger();
        	danger.setId(dangerId);
        	danger.setStatus("0");
        	danger.setRefuseText(refuseText);
        	dangerMapper.updateTDanger(danger);
			result.setMessage("拒绝整改成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("拒绝整改接口异常",e);
			throw new RuntimeException("拒绝整改接口异常");
		}
	}
	
	@Override
	public DataResult rectificationCheck(Integer pageNumber,Long total, String userId) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
        	TDanger tDanger = new TDanger();
        	tDanger.setCheckAcceptUserId(userId);
        	tDanger.setStatus("2");
        	List<TDanger> dangerList = dangerMapper.selectTDangerList(tDanger);
    		TableDataView<TDanger> tableDataView = PageInfoUtil.addPageInfo(dangerList);
			result.setResult(tableDataView);
			result.setMessage("隐患验收成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("隐患验收接口异常",e);
			throw new RuntimeException("隐患验收接口异常");
		}
	}
	
	@Override
	public DataResult rectificationClose(String dangerJson, MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	String checkAcceptUrl = null;
        	if(file != null) {
        		boolean fileType = FileUploadUtils.checkImgFile(file);
    			if(!fileType) {
    				result.setMessage("上传图片类型错误");
    				result.setStatus(Result.FAILED);
    				return result;
    			}
            	checkAcceptUrl = fileSystemService.uploadFile(file);
    			if(StringUtils.isEmpty(checkAcceptUrl)) {
    				result.setMessage("上传图片失败");
    				result.setStatus(Result.FAILED);
    				return result;
    			}
        	}
        	TDanger danger = JSON.parseObject(dangerJson, TDanger.class);
        	danger.setStatus("3");
        	danger.setCheckAcceptUrl(checkAcceptUrl);
        	dangerMapper.updateTDanger(danger);
			result.setMessage("提交隐患验收成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("提交隐患验收接口异常",e);
			throw new RuntimeException("提交隐患验收接口异常");
		}
	}
}
