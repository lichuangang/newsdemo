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
 * @表名 sys_user
 * Database Table:sys_user to ClassName:SysUser
 */
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	public static final String TABLE_NAME = "sys_user";

	@Id
	@Column(name="user_id", nullable=false, length = 19)
    @GeneratedValue
	private Long userId;

	@Column(name="username", nullable=false, length = 50)
	private String username;

	@Column(name="password", nullable=true, length = 100)
	private String password;

	@Column(name="email", nullable=true, length = 100)
	private String email;

	@Column(name="mobile", nullable=true, length = 100)
	private String mobile;

	@Column(name="status", nullable=true, length = 3)
	private Integer status;

    @JsonFormat(timezone = "GMT+8", pattern = DateUtils.DATE_TIME_PATTERN)
	@Column(name="create_time", nullable=true, length = 19)
	private Date createTime;


    /**
     * 角色ID列表
     */
    @Transient
    private List<Long> roleIdList;


    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    /*
         * <p>userId</p>
         */
    public void setUserId(Long value){
        this.userId = value;
    }

    /*
     * <p>userId</p>
     */
    public Long getUserId() {
        return this.userId;
    }

    /*
     * <p>用户名</p>
     */
    public void setUsername(String value){
        this.username = value;
    }

    /*
     * <p>用户名</p>
     */
    public String getUsername() {
        return this.username;
    }

    /*
     * <p>密码</p>
     */
    public void setPassword(String value){
        this.password = value;
    }

    /*
     * <p>密码</p>
     */
    public String getPassword() {
        return this.password;
    }

    /*
     * <p>邮箱</p>
     */
    public void setEmail(String value){
        this.email = value;
    }

    /*
     * <p>邮箱</p>
     */
    public String getEmail() {
        return this.email;
    }

    /*
     * <p>手机号</p>
     */
    public void setMobile(String value){
        this.mobile = value;
    }

    /*
     * <p>手机号</p>
     */
    public String getMobile() {
        return this.mobile;
    }

    /*
     * <p>状态  0：禁用   1：正常</p>
     */
    public void setStatus(Integer value){
        this.status = value;
    }

    /*
     * <p>状态  0：禁用   1：正常</p>
     */
    public Integer getStatus() {
        return this.status;
    }

    /*
     * <p>创建时间</p>
     */
    public void setCreateTime(Date value){
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
        map.put("userId", userId);
        map.put("username", username);
        map.put("password", password);
        map.put("email", email);
        map.put("mobile", mobile);
        map.put("status", status);
        map.put("createTime", createTime);
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
        if(map.containsKey("userId")) this.setUserId(DataTypeUtils.getLongValue(map.get("userId")));
        if(map.containsKey("username")) this.setUsername(DataTypeUtils.getStringValue(map.get("username")));
        if(map.containsKey("password")) this.setPassword(DataTypeUtils.getStringValue(map.get("password")));
        if(map.containsKey("email")) this.setEmail(DataTypeUtils.getStringValue(map.get("email")));
        if(map.containsKey("mobile")) this.setMobile(DataTypeUtils.getStringValue(map.get("mobile")));
        if(map.containsKey("status")) this.setStatus(DataTypeUtils.getIntegerValue(map.get("status")));
        if(map.containsKey("createTime")) this.setCreateTime(DataTypeUtils.getDateValue(map.get("createTime")));
    }

}
