<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service;

import com.msxf.tool.entity.${className}Query;
import com.msxf.tool.model.*;
import org.springframework.stereotype.Service;
import com.msxf.tool.repository.${className}Repository;

@Service
public class ${className}Service extends BaseService<${className}Repository,${className}Query>{


}
