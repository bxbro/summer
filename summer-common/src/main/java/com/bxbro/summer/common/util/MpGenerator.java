package com.bxbro.summer.common.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Scanner;

/**
 * @Description Mybatis Plus 代码生成器
 * @Author dong
 * @Date 2020/11/27
 */
public class MpGenerator {

    /**
     * 表前缀，不需要则写空
     */
    private static String tablePrefix="t_";
    /**
     * 数据库用户名密码
     */
    private static String username="root";
    private static String password="1234";
    /**
     * 数据库驱动
     */
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    /**
     * 数据库连接url
     */
    private static String dbUrl="jdbc:mysql://localhost:3306/summer?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";


    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + ":");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if(!StringUtils.isEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    /**
     * 如要使用该代码生成工具，请将该jar包添加到 pom文件中，
     * 否则会出现：java.lang.NoClassDefFoundError: org/apache/velocity/context/Context
     * (生成完之后也建议把该jar包去掉，工程代码瘦身)
     *    <dependency>
     *         <groupId>org.apache.velocity</groupId>
     *         <artifactId>velocity-engine-core</artifactId>
     *    </dependency>
     * @param args
     */
    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();

        String outPut="F:\\output";

        if(StringUtils.isEmpty(outPut)){
            throw new RuntimeException("输出目录不能为空！");
        }
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/summer-web/src/main/java");
        gc.setFileOverride(true);
        // 不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(false);
        gc.setAuthor("auto-generator");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setUrl(dbUrl);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.bxbro.summer");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意

        // 此处可以修改为您的表前缀
        strategy.setTablePrefix(new String[] {tablePrefix});
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityColumnConstant(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        mpg.setStrategy(strategy);


        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
//        tc.setController(null);
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
//         tc.setService("...");
        // tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);

        mpg.setConfig(new ConfigBuilder(pc,dsc,strategy,tc,gc));

        ConfigBuilder config = mpg.getConfig();
        Map<String, String> pathInfo = config.getPathInfo();

        //目录设置修改
        pathInfo.put(ConstVal.XML_PATH, projectPath + "/summer-web/src/main/resources/mapper/");
        mpg.execute();
    }
}
