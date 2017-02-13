<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.model;

import com.msxf.tool.utils.DataTypeUtils;
import javax.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/**
 * @表名 ${table.sqlName}
 * ${table}
 */
@Entity
@Table(name = "${table.sqlName}")
<#if table.compositeId>
@IdClass(${className}Key.class)
</#if>
public class ${className} implements Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	public static final String TABLE_NAME = "${table.sqlName}";

	<#list table.columns as column>
	<#if column.pk>
	@Id
	</#if>
	@Column(name="${column.sqlName}", nullable=${column.nullable?string}, length = ${column.size})
	private ${column.javaType} ${column.columnNameLower};

	</#list>

<#list table.columns as column>
    /*
     * <p>${column.columnAlias}</p>
     */
    public void set${column.columnName}(${column.javaType} value){
        this.${column.columnNameLower} = value;
    }

    /*
     * <p>${column.columnAlias}</p>
     */
    public ${column.javaType} get${column.columnName}() {
        return this.${column.columnNameLower};
    }

</#list>

    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
<#list table.columns as column>
        map.put("${column.columnNameLower}", ${column.columnNameLower});
</#list>
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
<#list table.columns as column>
        if(map.containsKey("${column.columnNameLower}")) this.set${column.columnName}(DataTypeUtils.get${column.javaType}Value(map.get("${column.columnNameLower}")));
</#list>
    }

}
