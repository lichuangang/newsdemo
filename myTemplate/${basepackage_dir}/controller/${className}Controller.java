<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.controller;

import com.msxf.tool.entity.${className}Query;
import com.msxf.tool.entity.MsxfResult;
import com.msxf.tool.model.*;
import org.springframework.stereotype.Service;
import com.msxf.tool.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ${className}Controller{

    @Autowired
    ${className}Service service;

    @RequestMapping(value = "${classNameLower}", method = RequestMethod.GET)
    public MsxfResult ${classNameLower}(${className}Query query) {
        return service.getPage(query);
    }

}
