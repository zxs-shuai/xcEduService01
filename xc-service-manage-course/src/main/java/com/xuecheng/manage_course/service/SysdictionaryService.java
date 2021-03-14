package com.xuecheng.manage_course.service;

import com.xuecheng.framework.domain.course.SysDictionary;
import com.xuecheng.manage_course.dao.SysDictionaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysdictionaryService {

    @Autowired
    SysDictionaryDao sysDictionaryDao;
    //根据字典分类type查询字典信息

    public SysDictionary findDictionaryByType(String type){
        return sysDictionaryDao.findBydType(type);
    }

}
