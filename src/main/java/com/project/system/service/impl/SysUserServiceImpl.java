package com.project.system.service.impl;

import java.util.*;

import com.project.common.utils.TimeUuidUtil;
import com.project.finals.RedisKeys;
import com.project.system.domain.*;
import com.project.system.mapper.*;
import com.project.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.annotation.DataScope;
import com.project.common.constant.UserConstants;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.system.service.ISysUserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户 业务层处理
 *
 * @author lws
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private SysPostMapper postMapper;
    @Autowired
    private SysUserPostMapper userPostMapper;
    @Autowired
    private SysUserRoleMapper userRoleMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    RedisUtil redisUtil;
    /**
     * 根据条件分页查询用户对象
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @Override
//    @DataScope(tableAlias = "d")
    public List<SysUser> selectUserList(SysUser user) {
        List<SysUser> list= userMapper.selectUserList(user);
//        list.forEach(obj->{
//            obj.setDept(sysDeptMapper.selectDeptById(obj.getDeptId()));
//        });
        return list;
    }

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Set<Map.Entry<Object,Object>> set  = properties.entrySet();
        System.out.println(set.size());
        for (Map.Entry<Object,Object> entry : set){
            System.out.println(entry.getKey()+"===="+entry.getValue());
        }
    }
    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByLoginName(String userName) {
        return userMapper.selectUserByLoginName(userName);
    }

    /**
     * 通过手机号码查询用户
     *
     * @param phoneNumber 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByPhoneNumber(String phoneNumber) {
        return userMapper.selectUserByPhoneNumber(phoneNumber);
    }

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email);
    }

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserById(Long userId) {

        SysUser sysUser= redisUtil.hget(RedisKeys.YH,userId.toString(),SysUser.class);
        if(Objects.nonNull(sysUser)){
            return sysUser;
        }else{
            sysUser =userMapper.selectUserById(userId);
            //查询用户角色
            List<SysUserRole> sysUserRoleList= userRoleMapper.selectByUserId(userId);
            for (SysUserRole sysUserRole : sysUserRoleList) {
                sysUser.setRoleIds((StringUtils.isEmpty(sysUser.getRoleIds())?"":sysUser.getRoleIds())+sysUserRole.getRoleId()+",");
            }
            //查询用户部门及父级部门列表
            List<SysDept> sysDeptList=sysDeptMapper.selectDeptList(new SysDept());
            long pid=sysUser.getDeptId();
            while(pid>0){
                for (SysDept sysDept : sysDeptList) {
                    if(sysDept.getDeptId()==pid){
                        sysUser.setDeptIds((StringUtils.isEmpty(sysUser.getDeptIds())?"":sysUser.getDeptIds())+sysDept.getDeptId().toString()+",");
                        pid=sysDept.getParentId();
                        break;
                    }
                }
            }
            redisUtil.hput(RedisKeys.YH,userId.toString(),sysUser);
        }

        return sysUser;
    }

    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public int deleteUserById(Long userId) {
        redisUtil.opsHash().delete(RedisKeys.YH,userId.toString());
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(userId);
        // 删除用户与岗位表
        userPostMapper.deleteUserPostByUserId(userId);
        return userMapper.deleteUserById(userId);
    }

    /**
     * 批量删除用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserByIds(String ids) throws Exception {
        Long[] userIds = Convert.toLongArray(ids);
        for (Long userId : userIds) {
            if (SysUser.isAdmin(userId)) {
                throw new Exception("不允许删除超级管理员用户");
            }
            redisUtil.opsHash().delete(RedisKeys.YH,userId.toString());
        }
        return userMapper.deleteUserByIds(userIds);
    }

    /**
     * 新增保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertUser(SysUser user) {
        // 新增用户信息
        user.setUserId(TimeUuidUtil.get16UUID());
        int rows = userMapper.insertUser(user);
//        // 新增用户岗位关联
//        insertUserPost(user);
//        // 新增用户与角色管理
        insertUserRole(user);
        return rows;
    }

    /**
     * 修改保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUser(SysUser user) {
        Long userId = user.getUserId();
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(userId);
        // 新增用户与角色管理
        insertUserRole(user);
        // 删除用户与岗位关联
       // userPostMapper.deleteUserPostByUserId(userId);
        // 新增用户与岗位管理
      //  insertUserPost(user);
        redisUtil.opsHash().delete(RedisKeys.YH,userId.toString());
        return userMapper.updateUser(user);
    }

    /**
     * 修改用户个人详细信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUserInfo(SysUser user) {

        redisUtil.opsHash().delete(RedisKeys.YH,user.getUserId().toString());
        return userMapper.updateUser(user);
    }

    /**
     * 修改用户密码
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int resetUserPwd(SysUser user) {
        return updateUserInfo(user);
    }

    /**
     * 新增用户角色信息
     *
     * @param user 用户对象
     */
    public void insertUserRole(SysUser user) {
        if(StringUtils.isNotEmpty(user.getRoleIds())){
            // 新增用户与角色管理
            List<SysUserRole> list = new ArrayList<SysUserRole>();
            for (String roleId : user.getRoleIds().split(",")) {
                SysUserRole ur = new SysUserRole();
                ur.setUserId(user.getUserId());
                ur.setRoleId(Long.valueOf(roleId));
                list.add(ur);
            }
            if (list.size() > 0) {
                userRoleMapper.batchUserRole(list);
            }
        }

    }

    /**
     * 新增用户岗位信息
     *
     * @param user 用户对象
     */
    public void insertUserPost(SysUser user) {
        // 新增用户与岗位管理
        List<SysUserPost> list = new ArrayList<SysUserPost>();
        for (Long postId : user.getPostIds()) {
            SysUserPost up = new SysUserPost();
            up.setUserId(user.getUserId());
            up.setPostId(postId);
            list.add(up);
        }
        if (list.size() > 0) {
            userPostMapper.batchUserPost(list);
        }
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param loginName 用户名
     * @return
     */
    @Override
    public String checkLoginNameUnique(String loginName) {
        int count = userMapper.checkLoginNameUnique(loginName);
        if (count > 0) {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param user 用户名
     * @return
     */
    @Override
    public String checkPhoneUnique(SysUser user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkPhoneUnique(user.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }

    /**
     * 校验email是否唯一
     *
     * @param user 用户名
     * @return
     */
    @Override
    public String checkEmailUnique(SysUser user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkEmailUnique(user.getEmail());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return UserConstants.USER_EMAIL_NOT_UNIQUE;
        }
        return UserConstants.USER_EMAIL_UNIQUE;
    }

    /**
     * 查询用户所属角色组
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public String selectUserRoleGroup(Long userId) {
        List<SysRole> list = roleMapper.selectRolesByUserId(userId);
        StringBuffer idsStr = new StringBuffer();
        for (SysRole role : list) {
            idsStr.append(role.getRoleName()).append(",");
        }
        if (StringUtils.isNotEmpty(idsStr.toString())) {
            return idsStr.substring(0, idsStr.length() - 1);
        }
        return idsStr.toString();
    }

    /**
     * 查询用户所属岗位组
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public String selectUserPostGroup(Long userId) {
        List<SysPost> list = postMapper.selectPostsByUserId(userId);
        StringBuffer idsStr = new StringBuffer();
        for (SysPost post : list) {
            idsStr.append(post.getPostName()).append(",");
        }
        if (StringUtils.isNotEmpty(idsStr.toString())) {
            return idsStr.substring(0, idsStr.length() - 1);
        }
        return idsStr.toString();
    }

	@Override
    @Transactional
	public int insertUserByManagement(SysUser user, long uuid) {
	     // 新增用户信息
        user.setUserId(uuid);
        int rows = userMapper.insertUser(user);
//        // 新增用户岗位关联
//        insertUserPost(user);
//        // 新增用户与角色管理
        insertUserRole(user);
        return rows;
	}
}
