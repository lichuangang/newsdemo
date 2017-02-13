package com.msxf.tool.controller;

import com.msxf.tool.entity.SysConfigQuery;
import com.msxf.tool.entity.MsxfResult;
import com.msxf.tool.model.*;
import org.springframework.stereotype.Service;
import com.msxf.tool.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysConfigController{

    @Autowired
    SysConfigService service;

    @RequestMapping(value = "sysConfig", method = RequestMethod.GET)
    public MsxfResult sysConfig(SysConfigQuery query) {
        return service.getPage(query);
    }

}
