package com.sky.config;

import com.sky.constant.JwtClaimsConstant;
import com.sky.context.BaseContext;
import com.sky.properties.AuthPathProperties;
import com.sky.properties.JwtProperties;
import com.sky.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @ClassName GatewayConfig
 * @Author 26483
 * @Date 2023/12/6 23:49
 * @Version 1.0
 * @Description 登录的网关鉴权
 */
@Component
@Slf4j
public class LoginGlobalFilter implements GlobalFilter, Ordered {

    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private AuthPathProperties authPathProperties;
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 1、获取request
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().toString();
        // 2、判断是否不需要拦截
        if (isExclude(path)) {
            // 无需拦截，直接放行
            return chain.filter(exchange);
        }

        // 3.获取请求头中的token
        String token = null;
         token = request.getHeaders()
                .getFirst(jwtProperties.getAdminTokenName());
        // 放行
        if (token != null) {
            try {
                log.info("jwt校验：{}", token);

                Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(), token);
                Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
                log.info("jwt empId:{}", empId);

                BaseContext.setCurrentId(empId);

                return chain.filter(exchange);
            } catch (Exception e) {
                log.error("JWT验证失败：{}", e.getMessage());
            }

            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // 拦截
        ServerHttpResponse response = exchange.getResponse();
        response.setRawStatusCode(401);
        return response.setComplete();
    }

    private boolean isExclude(String antPath) {
        for (String pathPattern : authPathProperties.getExcludePaths()) {
            if (antPathMatcher.match(pathPattern, antPath)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public int getOrder() {
        // 过滤器执行顺序，值越小，优先级越高
        return 0;
    }
}
