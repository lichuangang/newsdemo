package com.msxf.tool.controller;

import com.msxf.tool.entity.R;
import com.msxf.tool.entity.SysMenuQuery;
import com.msxf.tool.model.*;
import com.msxf.tool.service.SysMenuService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("sys/menu")
public class SysMenuController {

    @Autowired
    SysMenuService service;

    @RequestMapping(value = "sysMenu", method = RequestMethod.GET)
    public R sysMenu(SysMenuQuery query) {
        return service.getPage(query);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public R list(SysMenuQuery query) {
        return service.getPage(query);
    }

    /**
     * 选择菜单(添加、修改菜单)
     */
    @RequestMapping(value = "select", method = RequestMethod.GET)
    public R select() {
        //查询列表数据
        List<SysMenu> menuList = service.getNotButtonMenu();

        //添加顶级菜单
        SysMenu root = new SysMenu();
        root.setMenuId(0L);
        root.setName("一级菜单");
        root.setParentId(-1L);
        root.setOpen(true);
        menuList.add(root);

        return R.ok().put("menuList", menuList);
    }

    @RequestMapping("/info/{menuId}")
    public R info(@PathVariable("menuId") Long menuId) {
        SysMenu menu = service.findById(menuId);
        return R.ok().put("menu", menu);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SysMenu menu) {
        //数据校验
        try {
            verifyForm(menu);
            service.save(menu);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysMenu menu) {
        //数据校验
        try {
            verifyForm(menu);
            service.save(menu);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody List<Long> menuIds) {
        for (Long menuId : menuIds) {
            if (menuId.longValue() <= 28) {
                return R.error("系统菜单，不能删除");
            }
        }
        List<SysMenu> menus = service.findAll(menuIds);
        service.deleteAll(menus);
        return R.ok();
    }

    /**
     * 验证参数是否正确
     */
    private void verifyForm(SysMenu menu) throws Exception {
        if (StringUtils.isBlank(menu.getName())) {
            throw new Exception("菜单名称不能为空");
        }

        if (menu.getParentId() == null) {
            throw new Exception("上级菜单不能为空");
        }

        //菜单
        if (menu.getType() == 1) {
            if (StringUtils.isBlank(menu.getUrl())) {
                throw new Exception("菜单URL不能为空");
            }
        }

        //上级菜单类型
        int parentType = 0;
        if (menu.getParentId() != 0) {
            SysMenu parentMenu = service.findById(menu.getParentId());
            parentType = parentMenu.getType();
        }

        //目录、菜单
        if (menu.getType() == 0 ||
                menu.getType() == 1) {
            if (parentType != 0) {
                throw new Exception("上级菜单只能为目录类型");
            }
            return;
        }

        //按钮
        if (menu.getType() == 2) {
            if (parentType != 1) {
                throw new Exception("上级菜单只能为菜单类型");
            }
            return;
        }
    }


    /**
     * 角色授权菜单
     */
    @RequestMapping("/perms")
    public R perms() {
        //查询列表数据
        List<SysMenu> menuList = service.getAll();

        return R.ok().put("menuList", menuList);
    }

}
