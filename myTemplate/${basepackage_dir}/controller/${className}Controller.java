<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.controller;

import com.msxf.tool.entity.${className}Query;
import com.msxf.tool.entity.R;
import com.msxf.tool.model.*;
import com.msxf.tool.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${classNameLower}")
public class ${className}Controller{

    @Autowired
    ${className}Service service;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public R ${classNameLower}(${className}Query query) {
        return service.getPage(query);
    }

}
