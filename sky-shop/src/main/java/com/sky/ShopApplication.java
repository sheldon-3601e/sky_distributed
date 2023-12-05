package com.sky;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName SetmealApplication
 * @Author 26483
 * @Date 2023/12/4 21:25
 * @Version 1.0
 * @Description WorkSpaceApplication
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.sky.client")
@EnableTransactionManagement //开启注解方式的事务管理
@EnableCaching      // 开启redis缓存
@EnableScheduling   // 开启任务调度
@Slf4j
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
        log.info("server started");
    }

}
