package com.sznt.shop;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * 代码生成器</br>
 * <p>使用velocity模板生成</p>
 *
 * @author S Mr.L 
 * @since 2021-05-31
 */
public class CodeGenerator {

    public static final String AUTHOR = "S Mr.L";
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sznt_shop_user?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "123456";
    public static final String PACKAGE_PARENT = "com.sznt.shop";
    public static final String MODULE = "user";
    public static final String DB_PREFIX = "";
    public static final String[] INCLUDE = {"user", "address"};

    public static void main(String[] args) {
        System.out.println("=== 开始生成 " + MODULE + " 模块的代码 ===");
        genCode();
        System.out.println("=== " + MODULE + " 模块的代码生成完毕 ===");
    }

    public static void genCode() {

        // 1、创建代码生成器
        AutoGenerator generator = new AutoGenerator();

        // 2、全局配置
        GlobalConfig config = new GlobalConfig();
        config.setOutputDir(System.getProperty("user.dir") + "/sznt-shop-gen/src/main/java")
                // 作者
                .setAuthor(AUTHOR)
                // 生成后是否打开资源管理器
                .setOpen(false)
                // 重新生成时文件是否覆盖
                .setFileOverride(true)
                // 主键策略
                .setIdType(IdType.ASSIGN_ID)
                // 定义生成的实体类中日期类型
                .setDateType(DateType.ONLY_DATE)
                // 去掉Service接口的首字母I
                .setServiceName("%sService")
                // 实体类结尾名称
                .setEntityName("%sDO")
                // 生成基本的resultMap
                .setBaseResultMap(true)
                // 不使用AR模式
                .setActiveRecord(false)
                // 生成基本的SQL片段
                .setBaseColumnList(true);
        // 开启Swagger2模式
        config.setSwagger2(false);
        generator.setGlobalConfig(config);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DB_URL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername(DB_USERNAME)
                .setPassword(DB_PASSWORD)
                .setDbType(DbType.MYSQL);
        generator.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE_PARENT + "." + MODULE)
                .setController("controller")
                .setService("service")
                .setMapper("mapper")
                .setEntity("model")
                .setXml("mapper.xml");
        generator.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true)
                // 数据库表映射到实体的命名策略,驼峰
                .setNaming(NamingStrategy.underline_to_camel)
                // 生成的表
                .setInclude(INCLUDE)
                // 设置表前缀不生成
                .setTablePrefix(DB_PREFIX)
                // 数据库表字段映射到实体的命名策略
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // lombok 模型 @Accessors(chain = true) setter链式操作
                .setEntityLombokModel(true)
                // 逻辑删除字段名
                //.setLogicDeleteFieldName("is_deleted")
                // 去掉布尔值的is_前缀
                .setEntityBooleanColumnRemoveIsPrefix(true)
                // 自动填充
                .setTableFillList(getTableFills())
                // restful api风格控制器
                .setRestControllerStyle(true)
                // url中驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                // 设置BaseEntity
                .setSuperEntityClass("com.sznt.shop.common.base.BaseDO")
                // 填写BaseEntity中的公共字段
                .setSuperEntityColumns("id", "create_time", "update_time");

        generator.setStrategy(strategy);

        // 6、执行
        generator.execute();
    }

    private static ArrayList<TableFill> getTableFills() {
        TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        return tableFills;
    }

}
