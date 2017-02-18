package com.msxf.tool.entity;

import com.msxf.tool.model.SysRole;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SysRoleQuery extends BaseQuery<SysRole> {
    /**
     * 自定义查询字段
     */
    private String roleName;


    public Specification<SysRole> where() {
        return new Specification<SysRole>() {
            @Override
            public Predicate toPredicate(Root<SysRole> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate where = null;
                if (!StringUtils.isEmpty(roleName)) {
                    where = criteriaBuilder.like(root.get("roleName").as(String.class), "%" + roleName + "%");
                }
                return where == null ? null : criteriaQuery.where(where).getRestriction();
            }
        };
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
