package com.sky.client;

import com.sky.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @ClassName DishClient
 * @Author 26483
 * @Date 2023/12/5 22:59
 * @Version 1.0
 * @Description TODO
 */
@FeignClient("sky-dish")
public interface DishClient {

    @GetMapping("/admin/dish/client/countByCategoryId")
    Result<Integer> countByCategoryId(@RequestParam("id") Long id);

}