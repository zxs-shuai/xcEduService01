package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsTemplateRepository extends MongoRepository<CmsTemplate,String> {
//    //根据页面名称查询
//    CmsPage findByPageName(String pageName);
//
//    //根据页面名称，站点id，页面webpath查询
//    CmsPage findByPageNameAndPageWebPath(String pageName,String siteId,String pageWebPath)
}
