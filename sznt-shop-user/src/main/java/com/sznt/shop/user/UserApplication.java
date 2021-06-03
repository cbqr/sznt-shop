package com.sznt.shop.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 用户中心
 *
 * @author S Mr.L 
 * @since 2021-05-31
 */
@Slf4j
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        log.info("=== [sznt-shop] 用户中心开始启动 ===");
        boolean logFlag = log.isDebugEnabled();
        ConfigurableApplicationContext run = new SpringApplicationBuilder(UserApplication.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
        if (logFlag) {
            int counts = run.getBeanDefinitionCount();
            String[] names = run.getBeanDefinitionNames();
            log.debug("[sznt-shop] 用户中心IOC容器一共加载了 [{}] 个组件, 组件的名字分别为: [{}]", counts, names);
        }
        log.info("=== [sznt-shop] 用户中心启动完成 ===");
    }
}
