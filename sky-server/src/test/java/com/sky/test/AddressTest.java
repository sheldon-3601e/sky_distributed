package com.sky.test;

import com.alibaba.fastjson.JSONObject;
import com.sky.utils.HttpClientUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName AddressTest
 * @Author 26483
 * @Date 2023/11/17 22:15
 * @Version 1.0
 * @Description TODO
 */
//@SpringBootTest
public class AddressTest {

//    @Autowired
//    private AddressProperties addressProperties;
//
//    @Test
//    public void testAddress() throws Exception {
//        String url = "https://api.map.baidu.com/geocoding/v3/";
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("address", addressProperties.getAddress());
//        hashMap.put("ak", addressProperties.getAk());
//        hashMap.put("output", addressProperties.getOutput());
//        String s = HttpClientUtil.doGet(url, hashMap);
//        System.out.println(s);
//        List list = new ArrayList();
//        list = JSONObject.parseArray(s, String.class);
//        System.out.println(list);
//    }

    public static void main(String[] args) {

        boolean loop = true;
        int target = 0;
        while (loop) {

            if (true) {
                loop = false;
            }

        }

    }

}
