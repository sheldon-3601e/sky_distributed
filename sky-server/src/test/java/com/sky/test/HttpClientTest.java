package com.sky.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @ClassName HttpClientTest
 * @Author 26483
 * @Date 2023/11/12 16:03
 * @Version 1.0
 * @Description HttpClientTest
 */
//@SpringBootTest
public class HttpClientTest {

    @Test
    public void testGet() throws IOException {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建请求对象
        HttpGet httpGet = new HttpGet("http://localhost:8080/user/shop/status");

        //发送请求，并且接受响应结果
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //服务端返回的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("服务端返回的状态码:" + statusCode);

        //服务端返回的数据
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        System.out.println("服务端返回的数据" + body);

        //关闭资源
        response.close();
        httpClient.close();
    }

    @Test
    public void testPost() throws IOException {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建请求对象
        HttpPost httpPost = new HttpPost("http://localhost:8080/admin/employee/login");


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "admin");
        jsonObject.put("password", "123456");

        StringEntity entity = new StringEntity(jsonObject.toString());
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/json");

        //设置请求参数
        httpPost.setEntity(entity);

        //发送请求，并且接受响应结果
        CloseableHttpResponse response = httpClient.execute(httpPost);

        //服务端返回的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("服务端返回的状态码:" + statusCode);

        //服务端返回的数据
        HttpEntity entity1 = response.getEntity();
        String body = EntityUtils.toString(entity1);
        System.out.println("服务端返回的数据" + body);

        //关闭资源
        response.close();
        httpClient.close();
    }

    @Test
    public void testPut() throws IOException {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建请求对象
        HttpPut httpPut = new HttpPut("http://localhost:8080/admin/shop/0");
        httpPut.setHeader("token", "eyJhbGciOiJIUzI1NiJ9.eyJlbXBJZCI6MSwiZXhwIjoxNjk5NzgzODM3fQ.uCms8ErgsfeV7yBcxKFG340_aYOmnawzjfIVlxBinK4");

        //发送请求，并且接受响应结果
        CloseableHttpResponse response = httpClient.execute(httpPut);

        //服务端返回的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("服务端返回的状态码:" + statusCode);

        //服务端返回的数据
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        System.out.println("服务端返回的数据" + body);

        //关闭资源
        response.close();
        httpClient.close();
    }

}
