package com.msxf.tool.entity;

import com.msxf.tool.model.SysUser;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SysUserQuery extends BaseQuery<SysUser> {
    /**
     * 自定义查询字段
     */
    private String username;

    public Specification<SysUser> where() {
        return new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate where = null;
                if (!StringUtils.isEmpty(username)) {
                    where = criteriaBuilder.like(root.get("username").as(String.class), "%" + username + "%");
                }
                return where == null ? null : criteriaQuery.where(where).getRestriction();
            }
        };
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
