package com.msxf.tool.model;

import com.msxf.tool.utils.DataTypeUtils;
import javax.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/**
 * @表名 sys_role_menu
 * Database Table:sys_role_menu to ClassName:SysRoleMenu
 */
@Entity
@Table(name = "sys_role_menu")
public class SysRoleMenu implements Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	public static final String TABLE_NAME = "sys_role_menu";

	@Id
    @GeneratedValue
	@Column(name="id", nullable=false, length = 19)
	private Long id;

	@Column(name="role_id", nullable=true, length = 19)
	private Long roleId;

	@Column(name="menu_id", nullable=true, length = 19)
	private Long menuId;


    /*
     * <p>id</p>
     */
    public void setId(Long value){
        this.id = value;
    }

    /*
     * <p>id</p>
     */
    public Long getId() {
        return this.id;
    }

    /*
     * <p>角色ID</p>
     */
    public void setRoleId(Long value){
        this.roleId = value;
    }

    /*
     * <p>角色ID</p>
     */
    public Long getRoleId() {
        return this.roleId;
    }

    /*
     * <p>菜单ID</p>
     */
    public void setMenuId(Long value){
        this.menuId = value;
    }

    /*
     * <p>菜单ID</p>
     */
    public Long getMenuId() {
        return this.menuId;
    }


    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
        map.put("id", id);
        map.put("roleId", roleId);
        map.put("menuId", menuId);
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
        if(map.containsKey("id")) this.setId(DataTypeUtils.getLongValue(map.get("id")));
        if(map.containsKey("roleId")) this.setRoleId(DataTypeUtils.getLongValue(map.get("roleId")));
        if(map.containsKey("menuId")) this.setMenuId(DataTypeUtils.getLongValue(map.get("menuId")));
    }

}
