package com.msxf.tool.entity;

import com.msxf.tool.model.SysConfig;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SysConfigQuery extends BaseQuery<SysConfig> {
    /**
     * 自定义查询字段
     */
    private String key;

    public Specification<SysConfig> where() {
        return new Specification<SysConfig>() {
            @Override
            public Predicate toPredicate(Root<SysConfig> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate where = null;
                if (!StringUtils.isEmpty(key)) {
                    where = criteriaBuilder.like(root.get("key").as(String.class), "%" + key + "%");
                }
                return where == null ? null : criteriaQuery.where(where).getRestriction();
            }
        };
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
