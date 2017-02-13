package ${basepackage}.service;

import ${basepackage}.entity.BaseQuery;
import ${basepackage}.entity.MsxfResult;
import ${basepackage}.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.io.Serializable;
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
    public <S> MsxfResult getPage(Q query) {
        PageResult<S> pageResult =new PageResult<>();

        Page<S> page = null;
        if (query.where() == null) {
            page = repository.findAll(query.getPageReq());
        }else {
            page = repository.findAll(query.where(), query.getPageReq());
        }

        pageResult.setPageCount(page.getTotalPages());
        pageResult.setTotal(page.getTotalElements());
        pageResult.setPageList(page.getContent());

        MsxfResult result = new MsxfResult();
        result.setData(pageResult);

        return result;
    }

    public <S> List<S> getAll() {
        return repository.findAll();
    }

    public <S> S findById(Serializable id) {
        return (S) repository.findOne(id);
    }

    public void deleteById(Serializable id) {
        repository.delete(id);
    }

    public <S> void deleteById(S entity) {
        repository.delete(entity);
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
