package com.msxf.tool.repository;

import com.msxf.tool.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SysRoleMenuRepository extends JpaRepository<SysRoleMenu, Long>, JpaSpecificationExecutor<SysRoleMenu> {

    List<SysRoleMenu> findByRoleIdIn(List<Long> ids);

    List<SysRoleMenu> findByRoleId(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from SysRoleMenu c where c.roleId = ?1")
    void deleteByRoleId(Long roleId);

    @Modifying
    @Query(value = "delete from SysRoleMenu c where c.roleId in ?1")
    void deleteByRoleIdIn(List<Long> roleIds);
}
