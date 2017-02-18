package com.msxf.tool.service;

import com.msxf.tool.entity.SysRoleMenuQuery;
import com.msxf.tool.model.*;
import org.springframework.stereotype.Service;
import com.msxf.tool.repository.SysRoleMenuRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleMenuService extends BaseService<SysRoleMenuRepository, SysRoleMenuQuery> {

    public List<Long> findMenuIds(Long roleId) {
        List<Long> result = new ArrayList<>();
        for (SysRoleMenu item : repository.findByRoleId(roleId)) {
            result.add(item.getMenuId());
        }
        return result;
    }

    @Transactional
    public void saveOrUpdate(long roleId, List<Long> menuIdList) {
        if (menuIdList == null || menuIdList.size() == 0)
            return;
        //删除原来关系
        repository.deleteByRoleId(roleId);
        //建立新关系
        for (Long menuId : menuIdList) {
            SysRoleMenu rm = new SysRoleMenu();
            rm.setMenuId(menuId);
            rm.setRoleId(roleId);
            repository.save(rm);
        }
    }
}
