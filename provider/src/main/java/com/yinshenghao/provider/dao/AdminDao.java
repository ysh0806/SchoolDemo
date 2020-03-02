package com.yinshenghao.provider.dao;

import com.yinshenghao.beans.*;
import com.yinshenghao.beans.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * ClassName:AdminDao
 * Package:com.yinshenghao.provider.dao
 * Description:
 *
 * @Date:2020/2/27 22:31
 * @Author:ysh0806@sina.com
 */
@Mapper
public interface AdminDao {

    public int insertStudent(Student student);
    public int deleteStudent(Student student);
    public int updateStudent(Student student);
    public Student selectStudent(Student student);
    public List<Student> selectStudentsByPage(Map<String, Object> paramMap);
    public int selectStudentsTotal();

    public int insertTeacher(Teacher teacher);
    public int deleteTeacher(Teacher teacher);
    public int updateTeacher(Teacher teacher);
    public Teacher selectTeacher(Teacher teacher);
    public List<Teacher> selectTeachersByPage(Map<String, Object> paramMap);
    public int selectTeachersTotal();

    public int insertAdmin(Admin admin);
    public int deleteAdmin(Admin admin);
    public int updateAdmin(Admin admin);
    public Admin selectAdmin(Admin admin);
    public List<Admin> selectAdminsByPage(Map<String, Object> paramMap);
    public int selectAdminsTotal();

    public int insertClass(Class classs);
    public int deleteClass(Class classs);
    public int updateClass(Class classs);
    public Class selectClass(Class classs);
    public List<Class> selectClassesByPage(Map<String, Object> paramMap);
    public int selectClassesTotal();

    public int insertCourse(Course course);
    public int deleteCourse(Course course);
    public int updateCourse(Course course);
    public Course selectCourse(Course course);
    public List<Course> selectCoursesByPage(Map<String, Object> paramMap);
    public int selectCoursesTotal();
    
}
