package com.msxf.tool.service;

import com.msxf.tool.entity.SysRoleQuery;
import com.msxf.tool.model.*;
import com.msxf.tool.repository.SysRoleMenuRepository;
import com.msxf.tool.repository.SysUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.msxf.tool.repository.SysRoleRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SysRoleService extends BaseService<SysRoleRepository, SysRoleQuery> {

    @Autowired
    SysRoleMenuService roleMenuService;

    @Autowired
    SysUserRoleRepository userRoleRepository;
    @Autowired
    SysRoleMenuRepository roleMenuRepository;

    @Transactional
    public SysRole save(SysRole role) {
        repository.save(role);

        roleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
        return role;
    }

    @Transactional
    public void deleteBatch(List<Long> roleIds) {
        //删权限
        repository.deleteByRoleIdIn(roleIds);
        //删关系
        userRoleRepository.deleteByRoleIdIn(roleIds);
        roleMenuRepository.deleteByRoleIdIn(roleIds);
    }
}
