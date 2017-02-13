package com.msxf.tool.controller;

import com.msxf.tool.entity.R;
import com.msxf.tool.entity.SysUserQuery;
import com.msxf.tool.entity.MsxfResult;
import com.msxf.tool.model.*;
import com.msxf.tool.utils.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;
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

    @RequestMapping(value = "sysUser", method = RequestMethod.GET)
    public MsxfResult sysUser(SysUserQuery query) {
        return service.getPage(query);
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
