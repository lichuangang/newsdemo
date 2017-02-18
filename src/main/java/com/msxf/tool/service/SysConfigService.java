package com.msxf.tool.service;

import com.msxf.tool.entity.SysConfigQuery;
import com.msxf.tool.model.*;
import org.springframework.stereotype.Service;
import com.msxf.tool.repository.SysConfigRepository;

import java.util.List;

@Service
public class SysConfigService extends BaseService<SysConfigRepository, SysConfigQuery> {


    public void deleteBatch(List<Long> ids) {
        repository.delete(repository.findAll(ids));
    }
}
