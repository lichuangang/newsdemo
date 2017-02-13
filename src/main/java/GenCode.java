import cn.org.rapid_framework.generator.GeneratorFacade;

/**
 * Created by chuangang.li on 2017/1/20.
 */
public class GenCode {
    public static void main(String[] args) throws Exception {
        String templatePath = ClassLoader.getSystemResource("myTemplate").toString();
        GeneratorFacade g = new GeneratorFacade();
        g.getGenerator().addTemplateRootDir(templatePath);
        //删除生成器的输出目录//
        //g.deleteOutRootDir();
        //通过数据库表生成文件
        g.generateByTable("sys_config", "sys_menu", "sys_role", "sys_role_menu", "sys_user", "sys_user_role");
    }
}
