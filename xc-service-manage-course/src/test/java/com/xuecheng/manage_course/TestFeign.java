package com.xuecheng.manage_course;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_course.client.CmsPageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class TestFeign {
    @Autowired
    CmsPageClient cmsPageClient;


    @Test
    public void testFeign(){
        CmsPage cmsPage = cmsPageClient.findCmsPageById("5a7be667d019f14d90a1fb1c");
        System.out.println(cmsPage);

    }

  
}
