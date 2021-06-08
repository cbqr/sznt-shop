package com.sznt.shop.user;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * 用户中心服务
 *
 * @author S Mr.L 
 * @since 2021-05-31
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.sznt.shop.user.mapper")
public class UserApplication {

    private static final String RUN_MESSAGE = "SZNT-SHOP用户中心服务";

    public static void main(String[] args) {
        log.info("=== {}开始启动 ===", RUN_MESSAGE);
        boolean logFlag = log.isDebugEnabled();
        ConfigurableApplicationContext run = new SpringApplicationBuilder(UserApplication.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
        if (logFlag) {
            int counts = run.getBeanDefinitionCount();
            String[] names = run.getBeanDefinitionNames();
            log.debug("{}IOC容器一共加载了 [{}] 个组件, 名字分别为: ", RUN_MESSAGE, counts);
            Arrays.stream(names).forEach(System.out::println);
        }
        log.info("=== {}启动完成 ===", RUN_MESSAGE);
    }
}
