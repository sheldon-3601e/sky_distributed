package com.sky.test;

import com.github.pagehelper.Page;
import com.sky.context.BaseContext;
import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import com.sky.vo.OrderVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName OrderMapperTest
 * @Author 26483
 * @Date 2023/11/16 23:06
 * @Version 1.0
 * @Description TODO
 */
//@SpringBootTest
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test02() {
        orderMapper.setPayStatus(18L, Orders.REFUND);

    }

}
