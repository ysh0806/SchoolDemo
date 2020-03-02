package com.yinshenghao.service;

import com.yinshenghao.beans.Course;
import com.yinshenghao.beans.Teacher;

import java.util.List;
import java.util.Map;

/**
 * ClassName:TeacherService
 * Package:com.yinshenghao.service
 * Description:
 *
 * @Date:2020/2/27 22:16
 * @Author:ysh0806@sina.com
 */
public interface TeacherService {
    public Teacher findTeacher(Teacher teacher);
    public int modifyTpwd(Teacher teacher);
    public List<Course> findCourseByPage(Map<String, Object> paramMap);
    public int getCourseTotal(Teacher teacher);
}
