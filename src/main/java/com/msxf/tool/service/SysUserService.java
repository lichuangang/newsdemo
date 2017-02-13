package com.msxf.tool.service;

import com.msxf.tool.entity.SysUserQuery;
import com.msxf.tool.model.*;
import com.msxf.tool.repository.SysMenuRepository;
import com.msxf.tool.repository.SysRoleMenuRepository;
import com.msxf.tool.repository.SysUserRoleRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.msxf.tool.repository.SysUserRepository;

import java.util.*;

@Service
public class SysUserService extends BaseService<SysUserRepository, SysUserQuery> {

    @Autowired
    SysUserRoleRepository sysUserRoleRepository;
    @Autowired
    SysMenuRepository sysMenuRepository;
    @Autowired
    SysRoleMenuRepository sysRoleMenuRepository;

    public SysUser findByUsername(String username) {
        return repository.findByUsername(username);
    }

    private List<Long> getRoleId(long userid) {
        List<Long> roleList = new ArrayList<>();
        for (SysUserRole item : sysUserRoleRepository.findByUserId(userid)) {
            roleList.add(item.getRoleId());
        }
        return roleList;
    }

    private List<Long> getMenuId(List<Long> roleList) {
        List<Long> menuIds = new ArrayList<>();
        for (SysRoleMenu item : sysRoleMenuRepository.findByRoleIdIn(roleList)) {
            menuIds.add(item.getMenuId());
        }
        return menuIds;
    }

    public List<SysMenu> getMenu(long userId) {
        //最大权限,查询所有菜单
        if (userId == 1) {
            return sysMenuRepository.findAll();
        }

        List<Long> roleList = getRoleId(userId);//角色
        List<Long> menuList = getMenuId(roleList);//菜单
        return sysMenuRepository.findAll(menuList);
    }

    public List<SysMenu> getTreeMenu(long userId) {
        List<SysMenu> list = getMenu(userId);
        List<SysMenu> root = queryListParentId(0l, list);
        return getMenuTreeList(root, list);
    }

    /**
     * 获取所有权限
     *
     * @param userId
     */
    public Set<String> getPermission(long userId) {
        List<SysMenu> menus = getMenu(userId);
        //权限去重
        Set<String> permsSet = new HashSet<String>();
        for (SysMenu item : menus) {
            if (StringUtils.isBlank(item.getPerms())) {
                continue;
            }
            permsSet.addAll(Arrays.asList(item.getPerms().trim().split(",")));
        }
        return permsSet;
    }

    /**
     * 递归
     */
    private List<SysMenu> getMenuTreeList(List<SysMenu> menuList, List<SysMenu> resource) {
        List<SysMenu> subMenuList = new ArrayList<SysMenu>();
        for (SysMenu entity : menuList) {
            if (entity.getType() == 0) {//目录
                entity.setList(queryListParentId(entity.getMenuId(), resource));
                //子菜单也执行一次目录加载
                getMenuTreeList(entity.getList(), resource);
            }
            subMenuList.add(entity);
        }
        return subMenuList;
    }

    public List<SysMenu> queryListParentId(Long parentId, List<SysMenu> sysMenus) {
        List<SysMenu> userMenuList = new ArrayList<>();
        for (SysMenu menu : sysMenus) {
            if (parentId.compareTo(menu.getParentId()) == 0) {
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    public int updatePassword(Long userId, String password, String newPassword) {
        SysUser user = repository.findOne(userId);
        if (password.equals(user.getPassword())) {
            user.setPassword(newPassword);
            repository.save(user);
            return 1;
        } else {
            return 0;
        }
    }
}
