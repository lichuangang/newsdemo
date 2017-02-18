package com.msxf.tool.model;

import com.msxf.tool.utils.DataTypeUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/**
 * @表名 sys_config
 * Database Table:sys_config to ClassName:SysConfig
 */
@Entity
@Table(name = "sys_config")
public class SysConfig implements Serializable {

    private static final long serialVersionUID = 5454155825314635342L;

    public static final String TABLE_NAME = "sys_config";

    @Id
    @Column(name = "id", nullable = false, length = 19)
    @GeneratedValue
    private Long id;

    @Column(name = "t_key", nullable = true, length = 50)
    private String key;

    @Column(name = "t_value", nullable = true, length = 2000)
    private String value;

    @Column(name = "status", nullable = true, length = 3)
    private Integer status = 0;

    @Column(name = "remark", nullable = true, length = 500)
    private String remark;


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
     * <p>key</p>
     */
    public void setKey(String value) {
        this.key = value;
    }

    /*
     * <p>key</p>
     */
    public String getKey() {
        return this.key;
    }

    /*
     * <p>value</p>
     */
    public void setValue(String value) {
        this.value = value;
    }

    /*
     * <p>value</p>
     */
    public String getValue() {
        return this.value;
    }

    /*
     * <p>状态   0：隐藏   1：显示</p>
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

    /*
     * <p>状态   0：隐藏   1：显示</p>
     */
    public Integer getStatus() {
        return this.status;
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


    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
        map.put("id", id);
        map.put("key", key);
        map.put("value", value);
        map.put("status", status);
        map.put("remark", remark);
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
        if (map.containsKey("id")) this.setId(DataTypeUtils.getLongValue(map.get("id")));
        if (map.containsKey("key")) this.setKey(DataTypeUtils.getStringValue(map.get("key")));
        if (map.containsKey("value")) this.setValue(DataTypeUtils.getStringValue(map.get("value")));
        if (map.containsKey("status")) this.setStatus(DataTypeUtils.getIntegerValue(map.get("status")));
        if (map.containsKey("remark")) this.setRemark(DataTypeUtils.getStringValue(map.get("remark")));
    }

}
