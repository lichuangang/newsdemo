package com.msxf.tool.controller;

import com.msxf.tool.entity.SysConfigQuery;
import com.msxf.tool.entity.R;
import com.msxf.tool.model.*;
import com.msxf.tool.service.SysConfigService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/config")
public class SysConfigController {

    @Autowired
    SysConfigService service;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public R sysConfig(SysConfigQuery query) {
        return service.getPage(query);
    }

    /**
     * 保存配置
     */
    @RequestMapping("/save")
    public R save(@RequestBody SysConfig config) {
        //参数校验
        try {
            verifyForm(config);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }

        service.save(config);
        return R.ok();
    }

    /**
     * 配置信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        SysConfig config = service.findById(id);
        return R.ok().put("config", config);
    }


    /**
     * 修改配置
     */
    @RequestMapping("/update")
    public R update(@RequestBody SysConfig config) {
        //参数校验
        try {
            verifyForm(config);
            service.save(config);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
        return R.ok();
    }


    /**
     * 删除配置
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody List<Long> ids) {
        service.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 验证参数是否正确
     */
    private void verifyForm(SysConfig config) throws Exception {
        if (StringUtils.isBlank(config.getKey())) {
            throw new Exception("参数名不能为空");
        }

        if (StringUtils.isBlank(config.getValue())) {
            throw new Exception("参数值不能为空");
        }
    }
}
