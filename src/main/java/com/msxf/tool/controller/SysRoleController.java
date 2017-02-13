package com.msxf.tool.controller;

import com.msxf.tool.entity.SysRoleQuery;
import com.msxf.tool.entity.MsxfResult;
import com.msxf.tool.model.*;
import org.springframework.stereotype.Service;
import com.msxf.tool.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysRoleController{

    @Autowired
    SysRoleService service;

    @RequestMapping(value = "sysRole", method = RequestMethod.GET)
    public MsxfResult sysRole(SysRoleQuery query) {
        return service.getPage(query);
    }

}
