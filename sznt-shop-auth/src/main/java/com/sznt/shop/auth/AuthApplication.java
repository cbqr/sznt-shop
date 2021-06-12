package com.sznt.shop.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * 认证授权中心
 *
 * @author S Mr.L 
 * @since 2021-06-12
 */
@Slf4j
@SpringBootApplication
public class AuthApplication {

    private static final String RUN_TAG = "认证授权中心";

    public static void main(String[] args) {
        boolean logFlag = log.isDebugEnabled();
        log.info("=== {}开始启动 ===", RUN_TAG);
        ConfigurableApplicationContext run = new SpringApplicationBuilder(AuthApplication.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
        if (logFlag) {
            int counts = run.getBeanDefinitionCount();
            log.debug("{}IOC容器一共加载了 [{}] 个组件, 名字分别为: ", RUN_TAG, counts);
            Arrays.stream(run.getBeanDefinitionNames()).forEach(System.out::println);
        }
        log.info("=== {}启动完成 ===", RUN_TAG);
    }

}
