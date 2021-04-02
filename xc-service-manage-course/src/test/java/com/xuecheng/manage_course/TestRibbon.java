package com.xuecheng.manage_course;


import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRibbon {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void  testRibbon(){
        //确定要获取的服务名
        String serviceId = "XC-SERVICE-MANAGE-CMS";
        //ribbon客户端从eurekaServer中获取服务列表  localhost:31001 根据服务名获取服务列表 被服务名替换了
        for (int i=0;i<10;i++){
            ResponseEntity<Map> forEn = restTemplate.getForEntity("http://"+serviceId+"/cms/page/get/5a7be667d019f14d90a1fb1c", Map.class);
            Map body = forEn.getBody();
            System.out.println(body);
        }





    }
}
