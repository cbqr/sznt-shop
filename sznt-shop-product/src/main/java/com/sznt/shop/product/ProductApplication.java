package com.sznt.shop.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 商品服务
 *
 * @author S Mr.L 
 * @since 2021-06-01
 */
@Slf4j
@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args) {
        log.info("=== [sznt-shop] 商品服务开始启动 ===");
        new SpringApplicationBuilder(ProductApplication.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
        log.info("=== [sznt-shop] 商品服务启动完成 ===");
    }
}
