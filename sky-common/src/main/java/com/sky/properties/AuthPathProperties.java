package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName AuthPathProperties
 * @Author 26483
 * @Date 2023/12/7 0:54
 * @Version 1.0
 * @Description 设置jwt不需要验证的地址
 */
@Component
@ConfigurationProperties(prefix = "sky.auth")
@Data
public class AuthPathProperties {

    private String[] excludePaths;

}
