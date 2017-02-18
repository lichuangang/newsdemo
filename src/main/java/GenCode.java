import cn.org.rapid_framework.generator.GeneratorFacade;

import java.io.File;

/**
 * Created by chuangang.li on 2017/1/20.
 */
public class GenCode {
    public static void main(String[] args) throws Exception {
        String templatePath = System.getProperty("user.dir") + File.separator + "myTemplate";
        GeneratorFacade g = new GeneratorFacade();
        g.getGenerator().addTemplateRootDir(templatePath);
        //删除生成器的输出目录//
        //g.deleteOutRootDir();
        //通过数据库表生成文件
        g.generateByTable("sys_config", "sys_role", "sys_role_menu", "sys_user", "sys_user_role");
    }
}
