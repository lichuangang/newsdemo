package com.msxf.tool.model;

import com.msxf.tool.utils.DataTypeUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * @表名 sys_menu
 * Database Table:sys_menu to ClassName:SysMenu
 */
@Entity
@Table(name = "sys_menu")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 5454155825314635342L;

    public static final String TABLE_NAME = "sys_menu";

    @Id
    @Column(name = "menu_id", nullable = false, length = 19)
    private Long menuId;

    @Column(name = "parent_id", nullable = true, length = 19)
    private Long parentId;

    @Column(name = "name", nullable = true, length = 50)
    private String name;

    @Column(name = "url", nullable = true, length = 200)
    private String url;

    @Column(name = "perms", nullable = true, length = 500)
    private String perms;

    @Column(name = "type", nullable = true, length = 10)
    private Integer type;

    @Column(name = "icon", nullable = true, length = 50)
    private String icon;

    @Column(name = "order_num", nullable = true, length = 10)
    private Integer orderNum;

    @Transient
    private List<SysMenu> list;


    public List<SysMenu> getList() {
        return list;
    }

    public void setList(List<SysMenu> list) {
        this.list = list;
    }

    /*
         * <p>menuId</p>
         */
    public void setMenuId(Long value) {
        this.menuId = value;
    }

    /*
     * <p>menuId</p>
     */
    public Long getMenuId() {
        return this.menuId;
    }

    /*
     * <p>父菜单ID，一级菜单为0</p>
     */
    public void setParentId(Long value) {
        this.parentId = value;
    }

    /*
     * <p>父菜单ID，一级菜单为0</p>
     */
    public Long getParentId() {
        return this.parentId;
    }

    /*
     * <p>菜单名称</p>
     */
    public void setName(String value) {
        this.name = value;
    }

    /*
     * <p>菜单名称</p>
     */
    public String getName() {
        return this.name;
    }

    /*
     * <p>菜单URL</p>
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /*
     * <p>菜单URL</p>
     */
    public String getUrl() {
        return this.url;
    }

    /*
     * <p>授权(多个用逗号分隔，如：user:list,user:create)</p>
     */
    public void setPerms(String value) {
        this.perms = value;
    }

    /*
     * <p>授权(多个用逗号分隔，如：user:list,user:create)</p>
     */
    public String getPerms() {
        return this.perms;
    }

    /*
     * <p>类型   0：目录   1：菜单   2：按钮</p>
     */
    public void setType(Integer value) {
        this.type = value;
    }

    /*
     * @类型   0：目录   1：菜单   2：按钮</p>
     */
    public Integer getType() {
        return this.type;
    }

    /*
     * <p>菜单图标</p>
     */
    public void setIcon(String value) {
        this.icon = value;
    }

    /*
     * <p>菜单图标</p>
     */
    public String getIcon() {
        return this.icon;
    }

    /*
     * <p>排序</p>
     */
    public void setOrderNum(Integer value) {
        this.orderNum = value;
    }

    /*
     * <p>排序</p>
     */
    public Integer getOrderNum() {
        return this.orderNum;
    }


    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
        map.put("menuId", menuId);
        map.put("parentId", parentId);
        map.put("name", name);
        map.put("url", url);
        map.put("perms", perms);
        map.put("type", type);
        map.put("icon", icon);
        map.put("orderNum", orderNum);
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
        if (map.containsKey("menuId")) this.setMenuId(DataTypeUtils.getLongValue(map.get("menuId")));
        if (map.containsKey("parentId")) this.setParentId(DataTypeUtils.getLongValue(map.get("parentId")));
        if (map.containsKey("name")) this.setName(DataTypeUtils.getStringValue(map.get("name")));
        if (map.containsKey("url")) this.setUrl(DataTypeUtils.getStringValue(map.get("url")));
        if (map.containsKey("perms")) this.setPerms(DataTypeUtils.getStringValue(map.get("perms")));
        if (map.containsKey("type")) this.setType(DataTypeUtils.getIntegerValue(map.get("type")));
        if (map.containsKey("icon")) this.setIcon(DataTypeUtils.getStringValue(map.get("icon")));
        if (map.containsKey("orderNum")) this.setOrderNum(DataTypeUtils.getIntegerValue(map.get("orderNum")));
    }

}
