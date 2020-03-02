package com.yinshenghao.service;

import com.yinshenghao.beans.Course;
import com.yinshenghao.beans.Student;

import java.util.List;
import java.util.Map;

/**
 * ClassName:StudentService
 * Package:com.yinshenghao.service
 * Description:
 *
 * @Date:2020/2/27 21:53
 * @Author:ysh0806@sina.com
 */
public interface StudentService {
    public Student findStudent(Student student);
    public int modifySpwd(Student student);
    public List<Course> findCourseByPage(Map<String, Object> paramMap);
    public int getCourseTotal(Student student);
}