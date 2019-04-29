package com.project.web.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TSafetyFeeAccount;
import com.project.web.service.ITSafetyFeeAccountService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 安全费用台账 信息操作处理
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/tSafetyFeeAccount")
public class TSafetyFeeAccountController extends BaseController
{
	private String prefix = "security/tSafetyFeeAccount";

	@Autowired
	private ITSafetyFeeAccountService tSafetyFeeAccountService;

	@RequiresPermissions("system:tSafetyFeeAccount:view")
	@GetMapping()
	public String tSafetyFeeAccount()
	{
		return prefix + "/tSafetyFeeAccount";
	}

	/**
	 * 查询安全费用台账列表
	 */
	//@RequiresPermissions("system:tSafetyFeeAccount:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TSafetyFeeAccount tSafetyFeeAccount)
	{
		startPage();
		List<TSafetyFeeAccount> list = tSafetyFeeAccountService.selectTSafetyFeeAccountList(tSafetyFeeAccount);
		return getDataTable(list);
	}

	/**
	 * 新增安全费用台账
	 */
	@GetMapping("/add")
	public String add()
	{
		return prefix + "/add";
	}

	/**
	 * 新增保存安全费用台账
	 */
	//@RequiresPermissions("system:tSafetyFeeAccount:add")
	@Log(title = "安全费用台账", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TSafetyFeeAccount tSafetyFeeAccount, MultipartFile feeFile)
	{
		return tSafetyFeeAccountService.insertTSafetyFeeAccount(tSafetyFeeAccount,feeFile);
	}

	/**
	 * 修改安全费用台账
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap)
	{
		TSafetyFeeAccount tSafetyFeeAccount = tSafetyFeeAccountService.selectTSafetyFeeAccountById(id);
		mmap.put("tSafetyFeeAccount", tSafetyFeeAccount);
		return prefix + "/edit";
	}

	/**
	 * 修改保存安全费用台账
	 */
	//@RequiresPermissions("system:tSafetyFeeAccount:edit")
	@Log(title = "安全费用台账", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TSafetyFeeAccount tSafetyFeeAccount,MultipartFile feeFile)
	{
		return tSafetyFeeAccountService.updateTSafetyFeeAccount(tSafetyFeeAccount,feeFile);
	}

	/**
	 * 删除安全费用台账
	 */
	//@RequiresPermissions("system:tSafetyFeeAccount:remove")
	@Log(title = "安全费用台账", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(tSafetyFeeAccountService.deleteTSafetyFeeAccountByIds(ids));
	}

}