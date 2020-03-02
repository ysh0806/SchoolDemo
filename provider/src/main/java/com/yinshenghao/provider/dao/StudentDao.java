package com.yinshenghao.provider.dao;

import com.yinshenghao.beans.Course;
import com.yinshenghao.beans.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * ClassName:StudentDao
 * Package:com.yinshenghao.provider.dao
 * Description:
 *
 * @Date:2020/2/27 22:36
 * @Author:ysh0806@sina.com
 */
@Mapper
public interface StudentDao {
    public Student selectStudent(Student student);
    public int updateSpwd(Student student);
    public List<Course> selectCourseByPage(Map<String, Object> paramMap);
    public int selectCourseTotal(Student student);
}
