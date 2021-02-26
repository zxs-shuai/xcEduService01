package com.xuecheng.manage_cms;


import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTemplateTe {
    @Autowired
    RestTemplate restTemplate;



    //
    @Test
    public void testRestTemplate(){
       ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f\n", Map.class);
       Map body  = forEntity.getBody();
       System.out.println(body);
    }

}
