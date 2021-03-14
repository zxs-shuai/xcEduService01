package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SysDictionaryDao extends MongoRepository<SysDictionary, String> {
    //根据字典分类查询字典信息
    SysDictionary findBydType(String dType);
}
