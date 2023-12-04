package com.sky.test;

import com.sky.entity.ShoppingCart;
import com.sky.mapper.ShoppingCartMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @ClassName ShoppingCartMapperTest
 * @Author 26483
 * @Date 2023/11/15 21:30
 * @Version 1.0
 * @Description TODO
 */
//@SpringBootTest
public class ShoppingCartMapperTest {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Test
    public void test() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setDishId(15L);
        shoppingCart.setUserId(10L);
        List<ShoppingCart> list = shoppingCartMapper.list(shoppingCart);
        System.out.println(list);
    }

}
