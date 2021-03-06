package com.xuecheng.manage_course.dao;

import com.github.pagehelper.PageHelper;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.SysDictionary;
import com.xuecheng.framework.domain.course.ext.CategoryNode;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDao {
    @Autowired
    CourseBaseRepository courseBaseRepository;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeachplanMapper teachplanMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    SysDictionaryDao sysDictionaryDao;

    @Test
    public void testCourseBaseRepository(){
        Optional<CourseBase> optional = courseBaseRepository.findById("402885816240d276016240f7e5000002");
        if(optional.isPresent()){
            CourseBase courseBase = optional.get();
            System.out.println(courseBase);
        }

    }

    @Test
    public void testCourseMapper(){
        CourseBase courseBase = courseMapper.findCourseBaseById("402885816240d276016240f7e5000002");
        System.out.println(courseBase);

    }
    @Test
    public void testTeachPlanMapper(){
        TeachplanNode ss =  teachplanMapper.selectList("4028e58161bd22e60161bd23672a0001");
       System.out.println(ss);
    }


    @Test
    public void testCourseListMapper(){
        PageHelper.startPage(1,10);
        CourseListRequest courseListRequest = new CourseListRequest();
        List<CourseInfo> courseBase = (List<CourseInfo>) courseMapper.findCourseList();
        System.out.println(courseBase);

    }

    @Test
    public void testCategoreMapper(){

        CategoryNode categoryNode1 =  categoryMapper.selectList();
        System.out.println(categoryNode1);

    }

    @Test
    public void testSys(){

        SysDictionary sysDictionary =  sysDictionaryDao.findBydType("200");
        System.out.println(sysDictionary);

    }
}
