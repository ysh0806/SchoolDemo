package com.yinshenghao.service;

import com.yinshenghao.beans.*;
import com.yinshenghao.beans.Class;

import java.util.List;
import java.util.Map;

/**
 * ClassName:AdminService
 * Package:com.yinshenghao.service
 * Description:
 *
 * @Date:2020/2/27 21:06
 * @Author:ysh0806@sina.com
 */
public interface AdminService {

    public int addStudent(Student student);
    public int removeStudent(Student student);
    public int modifyStudent(Student student);
    public Student findStudent(Student student);
    public List<Student> findStudentsByPage(Map<String, Object> paramMap);
    public int getStudentsTotal();

    public int addTeacher(Teacher teacher);
    public int removeTeacher(Teacher teacher);
    public int modifyTeacher(Teacher teacher);
    public Teacher findTeacher(Teacher teacher);
    public List<Teacher> findTeachersByPage(Map<String, Object> paramMap);
    public int getTeachersTotal();

    public int addAdmin(Admin admin);
    public int removeAdmin(Admin admin);
    public int modifyAdmin(Admin admin);
    public Admin findAdmin(Admin admin);
    public List<Admin> findAdminsByPage(Map<String, Object> paramMap);
    public int getAdminsTotal();

    public int addClass(Class classs);
    public int removeClass(Class classs);
    public int modifyClass(Class classs);
    public Class findClass(Class classs);
    public List<Class> findClassesByPage(Map<String, Object> paramMap);
    public int getClassesTotal();

    public int addCourse(Course course);
    public int removeCourse(Course course);
    public int modifyCourse(Course course);
    public Course findCourse(Course course);
    public List<Course> findCoursesByPage(Map<String, Object> paramMap);
    public int getCoursesTotal();

}
