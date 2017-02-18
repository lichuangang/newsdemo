package com.msxf.tool.controller;

import com.msxf.tool.entity.R;
import com.msxf.tool.entity.SysUserQuery;
import com.msxf.tool.model.*;
import com.msxf.tool.service.SysUserRoleService;
import com.msxf.tool.utils.ShiroUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import com.msxf.tool.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    SysUserService service;
    @Autowired
    SysUserRoleService userRoleService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public R sysUser(SysUserQuery query) {
        return service.getPage(query);
    }


    /**
     * 保存用户
     */
    @RequestMapping("/save")
    public R save(@RequestBody SysUser user) {
        if (StringUtils.isBlank(user.getUsername())) {
            return R.error("用户名不能为空");
        }
        if (StringUtils.isBlank(user.getPassword())) {
            return R.error("密码不能为空");
        }

        service.save(user);

        return R.ok();
    }


    /**
     * 用户信息
     */
    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Long userId) {
        SysUser user = service.findById(userId);

        //获取用户所属的角色列表
        List<Long> roleIdList = userRoleService.findRoleIds(userId);
        user.setRoleIdList(roleIdList);

        return R.ok().put("user", user);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysUser user) {
        if (StringUtils.isBlank(user.getUsername())) {
            return R.error("用户名不能为空");
        }

        service.save(user);
        return R.ok();
    }


    /**
     * 删除用户
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody List<Long> userIds) {
        if (userIds.contains(1L)) {
            return R.error("系统管理员不能删除");
        }

        if (userIds.contains(ShiroUtils.getUserEntity().getUserId())) {
            return R.error("当前用户不能删除");
        }

        service.deleteBatch(userIds);

        return R.ok();
    }


    /**
     * 用户菜单列表
     * 获取登录的用户信息
     */
    @RequestMapping("/home")
    public R home() {
        Long userid = ShiroUtils.getUserEntity().getUserId();
        List<SysMenu> menuList = service.getTreeMenu(userid);
        Set<String> permissions = service.getPermission(userid);
        return R.ok().put("user", ShiroUtils.getUserEntity()).put("menuList", menuList).put("permission", permissions);
    }

    /**
     * 修改登录用户密码
     */
    @RequestMapping("/password")
    public R password(String password, String newPassword) {
        if (StringUtils.isBlank(newPassword)) {
            return R.error("新密码不为能空");
        }

        //sha256加密
        //password = new Sha256Hash(password).toHex();
        //sha256加密
        //newPassword = new Sha256Hash(newPassword).toHex();

        //更新密码
        int count = service.updatePassword(ShiroUtils.getUserEntity().getUserId(), password, newPassword);
        if (count == 0) {
            return R.error("原密码不正确");
        }

        //退出
        ShiroUtils.logout();
        return R.ok();
    }


}
