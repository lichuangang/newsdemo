package com.msxf.tool.service;

import com.msxf.tool.entity.SysUserRoleQuery;
import com.msxf.tool.model.*;
import org.springframework.stereotype.Service;
import com.msxf.tool.repository.SysUserRoleRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserRoleService extends BaseService<SysUserRoleRepository, SysUserRoleQuery> {

    @Transactional
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        if (roleIdList.size() == 0) {
            return;
        }
        //先删除用户与角色关系
        repository.deleteByUserId(userId);

        //建立新关系
        for (Long roleId : roleIdList) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(roleId);
            sysUserRole.setUserId(userId);
            repository.save(sysUserRole);
        }
    }

    public List<Long> findRoleIds(Long userid) {
        List<Long> result = new ArrayList<>();
        for (SysUserRole userRole : repository.findByUserId(userid)) {
            result.add(userRole.getRoleId());
        }
        return result;
    }
}
