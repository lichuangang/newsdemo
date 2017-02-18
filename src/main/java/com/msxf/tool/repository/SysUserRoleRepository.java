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
public interface SysUserRoleRepository extends JpaRepository<SysUserRole, Long>, JpaSpecificationExecutor<SysUserRole> {

    List<SysUserRole> findByUserId(long userid);

    @Modifying
    @Transactional
    @Query(value="delete from SysUserRole t where t.userId = ?1")
    void deleteByUserId(Long userid);

    @Modifying
    @Query("DELETE FROM SysUserRole t WHERE t.userId in (?1)")
    void deleteByUserIdIn(List<Long> ids);

    @Modifying
    @Query("DELETE FROM SysUserRole t WHERE t.roleId in (?1)")
    void deleteByRoleIdIn(List<Long> ids);


    List<SysUserRole> findByUserId(Long userid);


}
