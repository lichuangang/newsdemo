package com.msxf.tool.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msxf.tool.utils.DataTypeUtils;
import com.msxf.tool.utils.DateUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * @表名 sys_role
 * Database Table:sys_role to ClassName:SysRole
 */
@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 5454155825314635342L;

    public static final String TABLE_NAME = "sys_role";

    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false, length = 19)
    private Long roleId;

    @Column(name = "role_name", nullable = true, length = 100)
    private String roleName;

    @Column(name = "remark", nullable = true, length = 100)
    private String remark;

    @JsonFormat(timezone = "GMT+8", pattern = DateUtils.DATE_TIME_PATTERN)
    @Column(name = "create_time", nullable = true, length = 19)
    private Date createTime;

    @Transient
    private List<Long> menuIdList;

    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }

    /*
         * <p>roleId</p>
         */
    public void setRoleId(Long value) {
        this.roleId = value;
    }

    /*
     * <p>roleId</p>
     */
    public Long getRoleId() {
        return this.roleId;
    }

    /*
     * <p>角色名称</p>
     */
    public void setRoleName(String value) {
        this.roleName = value;
    }

    /*
     * <p>角色名称</p>
     */
    public String getRoleName() {
        return this.roleName;
    }

    /*
     * <p>备注</p>
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /*
     * <p>备注</p>
     */
    public String getRemark() {
        return this.remark;
    }

    /*
     * <p>创建时间</p>
     */
    public void setCreateTime(Date value) {
        this.createTime = value;
    }

    /*
     * <p>创建时间</p>
     */
    public Date getCreateTime() {
        return this.createTime;
    }


    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
        map.put("roleId", roleId);
        map.put("roleName", roleName);
        map.put("remark", remark);
        map.put("createTime", createTime);
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
        if (map.containsKey("roleId")) this.setRoleId(DataTypeUtils.getLongValue(map.get("roleId")));
        if (map.containsKey("roleName")) this.setRoleName(DataTypeUtils.getStringValue(map.get("roleName")));
        if (map.containsKey("remark")) this.setRemark(DataTypeUtils.getStringValue(map.get("remark")));
        if (map.containsKey("createTime")) this.setCreateTime(DataTypeUtils.getDateValue(map.get("createTime")));
    }

}
