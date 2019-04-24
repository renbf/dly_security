package com.project.web.controller;

import com.github.pagehelper.PageInfo;
import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.config.Global;
import com.project.common.enums.BusinessType;
import com.project.common.utils.StringUtils;
import com.project.framework.manager.AsyncManager;
import com.project.framework.manager.factory.AsyncFactory;
import com.project.framework.util.ShiroUtils;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.system.domain.SysDept;
import com.project.system.domain.SysRole;
import com.project.system.service.ISysDeptService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 部门信息
 *
 * @author lws
 */
@Controller
@RequestMapping("/system/BusinessDept")
public class BusinessDeptController extends BaseController {

	
    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询部门父级或子级列表
     * @param  deptId 部门ID
     * @param type 1-父级列表，2-子级列表，3-平级列表
     */
    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list(@RequestParam(name="deptId",defaultValue = "0") String deptId,@RequestParam(name="type",defaultValue = "2") Integer type)
    {
        AjaxResult ajaxResult=AjaxResult.success();
        ajaxResult.put("data",deptService.childrensMap(Long.valueOf(deptId),type));
        return ajaxResult;
    }



    /**
     * 新增保存部门
     */
    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult addSave(SysDept dept) {
        if(Objects.isNull(dept.getDeptId())||dept.getDeptId()==0){
//            AjaxResult ar = checkDeptCanAdd(dept.getParentId());
//            if(ar!=null){
//                return ar;
//            }
            return toAjax(deptService.insertDept(dept));
        }else{
            dept.setUpdateBy(ShiroUtils.getLoginName());
            return toAjax(deptService.updateDept(dept));
        }
    }




    /**
     * 删除
     */
    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove( Long deptId) {
//        if (deptService.selectDeptCount(null,deptId,"0") > 0) {
//            return error(1, "存在下级部门,不允许删除");
//        }
//        if (deptService.checkDeptExistUser(deptId)) {
//            return error(1, "部门存在用户,不允许删除");
//        }
        return toAjax(deptService.deleteDeptById(deptId));
    }
    @Log(title = "部门管理-修改上级", businessType = BusinessType.UPDATE)
    @PostMapping("/editParent/{deptId}/{parentId}")
    @ResponseBody
    public AjaxResult editParent(@PathVariable("deptId")Long deptId,@PathVariable("parentId")Long parentId) {
        AjaxResult ar = checkDeptCanAdd(parentId);
        if(ar!=null){
            return ar;
        }
        return toAjax(deptService.updateParent(deptId,parentId));
    }
    /**
     * 校验部门名称
     */
    @PostMapping("/checkDeptNameUnique")
    @ResponseBody
    public String checkDeptNameUnique(SysDept dept) {
        return deptService.checkDeptNameUnique(dept.getDeptName(),dept.getDeptId());
    }

//    /**
//     * 选择部门树
//     */
//    @GetMapping("/selectDeptTree")
//    public String selectDeptTree(Long deptId,String notUnderJbdm, ModelMap mmap) {
//        if(deptId==null){
//            deptId= Global.ROOT_DEPT_ID;
//        }
//        if(notUnderJbdm!=null){
//            mmap.put("notUnderJbdm",notUnderJbdm);
//        }
//        mmap.put("dept", deptService.selectDeptById(deptId));
//        return prefix + "/tree";
//    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Map<String, Object>> treeData(String notUnderJbdm) {
        List<Map<String, Object>> tree = deptService.selectDeptTree(notUnderJbdm);
        return tree;
    }

    /**
     * 加载角色部门（数据权限）列表树
     */
    @GetMapping("/roleDeptTreeData")
    @ResponseBody
    public List<Map<String, Object>> deptTreeData(SysRole role) {
        List<Map<String, Object>> tree = deptService.roleDeptTreeData(role);
        return tree;
    }

    private AjaxResult checkDeptCanAdd(Long parentId){
        int code = deptService.checkDeptCanAdd(parentId);
        if(code==2){
            if(deptService.selectDeptCount(null,parentId,null)>1000){
                //数据量过大时异步处理
                AsyncManager.me().execute(AsyncFactory.adjustDeptJbdmTask(parentId));
                return error(1, "同级部门数量已接近上限，后台正在释放空间，请稍候重新登录重试并慎重添加！");
            }else{
                //数据量少同步处理
                deptService.adjustDeptJbdm(parentId);
                return null;
            }
        }else if(code==3){
            return error(1, "同级部门数量达到上限，不能继续添加，请选择其它上级！");
        }
        return null;
    }
    
    /**
       * 查询  企业下面所有的部门
     */
    @GetMapping("/DeptGroupBy")
    @ResponseBody
    public List<SysDept> DeptGroupBy(String businessId) {
    	List<SysDept> list = deptService.queryDeptByBusinessId(businessId);
        return list;
    }
    
    /**
     * 查询  企业下面所有的部门  (分页查询)
   */
  @GetMapping("/deptByPage")
  @ResponseBody
  public TableDataInfo deptByPage(SysDept dept) {
	  startPage();
      List<SysDept> list = deptService.queryDeptListByDate(dept);
	return getDataTable(list);
  }
  
  @Log(title = "部门管理-修改", businessType = BusinessType.UPDATE)
  @PostMapping("/updateDept")
  @ResponseBody
  public AjaxResult editParent(SysDept dept) {

      
     return toAjax(deptService.updateDeptName(dept));
  } 
  
  
}
