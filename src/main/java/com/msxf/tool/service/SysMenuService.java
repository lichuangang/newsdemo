package com.msxf.tool.service;

import com.msxf.tool.entity.SysMenuQuery;
import com.msxf.tool.model.*;
import org.springframework.stereotype.Service;
import com.msxf.tool.repository.SysMenuRepository;

import java.util.List;

@Service
public class SysMenuService extends BaseService<SysMenuRepository, SysMenuQuery> {

    public List<SysMenu> getNotButtonMenu() {
        return repository.findByTypeNot(2);
    }

}
