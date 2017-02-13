package com.msxf.tool.controller;

import com.msxf.tool.entity.R;
import com.msxf.tool.entity.SysMenuQuery;
import com.msxf.tool.entity.MsxfResult;
import com.msxf.tool.model.*;
import org.springframework.stereotype.Service;
import com.msxf.tool.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sys/menu")
public class SysMenuController{

    @Autowired
    SysMenuService service;

    @RequestMapping(value = "sysMenu", method = RequestMethod.GET)
    public MsxfResult sysMenu(SysMenuQuery query) {
        return service.getPage(query);
    }
}
