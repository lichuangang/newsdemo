package com.msxf.tool.controller;

import com.msxf.tool.entity.SysRoleMenuQuery;
import com.msxf.tool.entity.MsxfResult;
import com.msxf.tool.model.*;
import org.springframework.stereotype.Service;
import com.msxf.tool.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysRoleMenuController{

    @Autowired
    SysRoleMenuService service;

    @RequestMapping(value = "sysRoleMenu", method = RequestMethod.GET)
    public MsxfResult sysRoleMenu(SysRoleMenuQuery query) {
        return service.getPage(query);
    }

}
