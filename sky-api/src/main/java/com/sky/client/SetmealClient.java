package com.sky.client;

import com.sky.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName SetmealClient
 * @Author 26483
 * @Date 2023/12/5 23:41
 * @Version 1.0
 * @Description TODO
 */
@FeignClient("sky-setmeal")
public interface SetmealClient {

    @GetMapping("/admin/setmeal/client/countByCategoryId")
    Result<Integer> countByCategoryId(@RequestParam("id") Long id);

    @GetMapping("/admin/setmeal/client/countByDishId")
    Result<Integer> countByDishId(@RequestParam("id") Long id);

}
