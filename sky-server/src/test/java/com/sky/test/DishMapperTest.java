package com.sky.test;

import com.sky.constant.StatusConstant;
import com.sky.entity.Dish;
import com.sky.mapper.DishMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @ClassName DishMapperTest
 * @Author 26483
 * @Date 2023/11/13 19:18
 * @Version 1.0
 * @Description DishMapperTest
 */
//@SpringBootTest
public class DishMapperTest {

    @Autowired
    private DishMapper dishMapper;

    @Test
    public void test01() {
        Dish dish = new Dish();
        dish.setCategoryId(11L);
        dish.setStatus(StatusConstant.ENABLE);//查询起售中的菜品

        List<Dish> dishList = dishMapper.list(dish);
        System.out.println(dishList);
    }

}
