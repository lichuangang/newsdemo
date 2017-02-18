package com.msxf.tool.controller;

import com.msxf.tool.entity.SysRoleQuery;
import com.msxf.tool.entity.R;
import com.msxf.tool.model.*;
import com.msxf.tool.service.SysRoleMenuService;
import com.msxf.tool.service.SysRoleService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ServiceConfigurationError;

@RestController
@RequestMapping("sys/role")
public class SysRoleController {

    @Autowired
    SysRoleService service;

    @Autowired
    SysRoleMenuService roleMenuService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public R sysRole(SysRoleQuery query) {
        return service.getPage(query);
    }


    /**
     * 保存角色
     */
    @RequestMapping("/save")
    public R save(@RequestBody SysRole role) {
        if (StringUtils.isBlank(role.getRoleName())) {
            return R.error("角色名称不能为空");
        }
        role.setCreateTime(new Date());
        service.save(role);

        return R.ok();
    }

    /**
     * 角色信息
     */
    @RequestMapping("/info/{roleId}")
    public R info(@PathVariable("roleId") Long roleId) {
        SysRole role = service.findById(roleId);

        //查询角色对应的菜单
        List<Long> menuIdList = roleMenuService.findMenuIds(roleId);
        role.setMenuIdList(menuIdList);

        return R.ok().put("role", role);
    }

    /**
     * 修改角色
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysRole role) {
        if (StringUtils.isBlank(role.getRoleName())) {
            return R.error("角色名称不能为空");
        }

        service.save(role);
        return R.ok();
    }


    /**
     * 删除角色
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody List<Long> roleIds) {
        service.deleteBatch(roleIds);

        return R.ok();
    }


    /**
     * 角色列表
     */
    @RequestMapping("/select")
    public R select(){
        //查询列表数据
        List<SysRole> list = service.getAll();

        return R.ok().put("list", list);
    }
}
