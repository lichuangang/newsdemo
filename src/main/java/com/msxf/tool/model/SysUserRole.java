package com.msxf.tool.model;

import com.msxf.tool.utils.DataTypeUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/**
 * @表名 sys_user_role
 * Database Table:sys_user_role to ClassName:SysUserRole
 */
@Entity
@Table(name = "sys_user_role")
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 5454155825314635342L;

    public static final String TABLE_NAME = "sys_user_role";

    @Id
    @Column(name = "id", nullable = false, length = 19)
    @GeneratedValue
    private Long id;

    @Column(name = "user_id", nullable = true, length = 19)
    private Long userId;

    @Column(name = "role_id", nullable = true, length = 19)
    private Long roleId;


    /*
     * <p>id</p>
     */
    public void setId(Long value) {
        this.id = value;
    }

    /*
     * <p>id</p>
     */
    public Long getId() {
        return this.id;
    }

    /*
     * <p>用户ID</p>
     */
    public void setUserId(Long value) {
        this.userId = value;
    }

    /*
     * <p>用户ID</p>
     */
    public Long getUserId() {
        return this.userId;
    }

    /*
     * <p>角色ID</p>
     */
    public void setRoleId(Long value) {
        this.roleId = value;
    }

    /*
     * <p>角色ID</p>
     */
    public Long getRoleId() {
        return this.roleId;
    }


    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
        map.put("id", id);
        map.put("userId", userId);
        map.put("roleId", roleId);
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
        if (map.containsKey("id")) this.setId(DataTypeUtils.getLongValue(map.get("id")));
        if (map.containsKey("userId")) this.setUserId(DataTypeUtils.getLongValue(map.get("userId")));
        if (map.containsKey("roleId")) this.setRoleId(DataTypeUtils.getLongValue(map.get("roleId")));
    }

}
