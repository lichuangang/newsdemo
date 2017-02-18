package com.msxf.tool.service;

import com.msxf.tool.entity.BaseQuery;
import com.msxf.tool.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chuangang.li on 2017/1/19.
 */
public class BaseService<T extends JpaRepository & JpaSpecificationExecutor, Q extends BaseQuery> {
    @Autowired
    protected T repository;

    /***
     * 通用分页查询
     */
    public R getPage(Q query) {
        R result = R.ok();
        try {
            Page page = null;
            Specification<T> where = query.where();
            if (where == null) {
                page = repository.findAll(query.getPageReq());
            } else {
                page = repository.findAll(where, query.getPageReq());
            }
            HashMap<String, Object> pageResult = new HashMap<>();
            pageResult.put("currPage", query.getPage());
            pageResult.put("totalPage", page.getTotalPages());
            pageResult.put("totalCount", page.getTotalElements());
            pageResult.put("list", page.getContent());
            result.put("page", pageResult);

        } catch (Exception e) {
            return R.error(e.getMessage());
        }
        return result;
    }

    public <S> List<S> getAll() {
        return repository.findAll();
    }

    public <S> S findById(Serializable id) {
        return (S) repository.findOne(id);
    }

    public <S> List<S> findAll(List<?> ids) {
        return repository.findAll(ids);
    }

    public void deleteById(Serializable id) {
        repository.delete(id);
    }

    public <S> void deleteById(S entity) {
        repository.delete(entity);
    }

    public <S> void deleteAll(Iterable<S> list) {
        repository.delete(list);
    }

    public <S> S save(S entity) {
        return (S) repository.save(entity);
    }

    public <S> S saveAndFlush(S entity) {
        repository.saveAndFlush(entity);
        return entity;
    }

    public boolean exist(Serializable id) {
        return repository.exists(id);
    }
}
