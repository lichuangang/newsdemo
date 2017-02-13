package com.msxf.tool.repository;

import com.msxf.tool.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

@Repository
public interface SysRoleMenuRepository extends JpaRepository<SysRoleMenu, Long>, JpaSpecificationExecutor<SysRoleMenu> {

    List<SysRoleMenu> findByRoleIdIn(List<Long> ids);
}
