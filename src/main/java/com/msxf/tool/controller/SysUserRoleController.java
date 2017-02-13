package com.msxf.tool.controller;

import com.msxf.tool.entity.SysUserRoleQuery;
import com.msxf.tool.entity.MsxfResult;
import com.msxf.tool.model.*;
import org.springframework.stereotype.Service;
import com.msxf.tool.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysUserRoleController{

    @Autowired
    SysUserRoleService service;

    @RequestMapping(value = "sysUserRole", method = RequestMethod.GET)
    public MsxfResult sysUserRole(SysUserRoleQuery query) {
        return service.getPage(query);
    }

}
