package com.yinshenghao.provider.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yinshenghao.beans.*;
import com.yinshenghao.beans.Class;
import com.yinshenghao.provider.dao.AdminDao;
import com.yinshenghao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * ClassName:AdminServiceImpl
 * Package:com.yinshenghao.provider.serviceimpl
 * Description:
 *
 * @Date:2020/2/28 4:52
 * @Author:ysh0806@sina.com
 */
@Component
@Service(version = "1.0.0", timeout = 10000, interfaceName = "com.yinshenghao.service.AdminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Transactional
    @Override
    public int addStudent(Student student) {
        return adminDao.insertStudent(student);
    }

    @Transactional
    @Override
    public int removeStudent(Student student) {
        return adminDao.deleteStudent(student);
    }

    @Transactional
    @Override
    public int modifyStudent(Student student) {
        return adminDao.updateStudent(student);
    }

    @Override
    public Student findStudent(Student student) {
        return adminDao.selectStudent(student);
    }

    @Override
    public List<Student> findStudentsByPage(Map<String, Object> paramMap) {
        return adminDao.selectStudentsByPage(paramMap);
    }

    @Override
    public int getStudentsTotal() {
        return adminDao.selectStudentsTotal();
    }

    @Transactional
    @Override
    public int addTeacher(Teacher teacher) {
        return adminDao.insertTeacher(teacher);
    }

    @Transactional
    @Override
    public int removeTeacher(Teacher teacher) {
        return adminDao.deleteTeacher(teacher);
    }

    @Transactional
    @Override
    public int modifyTeacher(Teacher teacher) {
        return adminDao.updateTeacher(teacher);
    }

    @Override
    public Teacher findTeacher(Teacher teacher) {
        return adminDao.selectTeacher(teacher);
    }

    @Override
    public List<Teacher> findTeachersByPage(Map<String, Object> paramMap) {
        return adminDao.selectTeachersByPage(paramMap);
    }

    @Override
    public int getTeachersTotal() {
        return adminDao.selectTeachersTotal();
    }

    @Transactional
    @Override
    public int addAdmin(Admin admin) {
        return adminDao.insertAdmin(admin);
    }

    @Transactional
    @Override
    public int removeAdmin(Admin admin) {
        return adminDao.deleteAdmin(admin);
    }

    @Transactional
    @Override
    public int modifyAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public Admin findAdmin(Admin admin) {
        return adminDao.selectAdmin(admin);
    }

    @Override
    public List<Admin> findAdminsByPage(Map<String, Object> paramMap) {
        return adminDao.selectAdminsByPage(paramMap);
    }

    @Override
    public int getAdminsTotal() {
        return adminDao.selectAdminsTotal();
    }

    @Transactional
    @Override
    public int addClass(Class classs) {
        return adminDao.insertClass(classs);
    }

    @Transactional
    @Override
    public int removeClass(Class classs) {
        return adminDao.deleteClass(classs);
    }

    @Transactional
    @Override
    public int modifyClass(Class classs) {
        return adminDao.updateClass(classs);
    }

    @Override
    public Class findClass(Class classs) {
        return adminDao.selectClass(classs);
    }

    @Override
    public List<Class> findClassesByPage(Map<String, Object> paramMap) {
        return adminDao.selectClassesByPage(paramMap);
    }

    @Override
    public int getClassesTotal() {
        return adminDao.selectClassesTotal();
    }

    @Transactional
    @Override
    public int addCourse(Course course) {
        return adminDao.insertCourse(course);
    }

    @Transactional
    @Override
    public int removeCourse(Course course) {
        return adminDao.deleteCourse(course);
    }

    @Transactional
    @Override
    public int modifyCourse(Course course) {
        return adminDao.updateCourse(course);
    }

    @Override
    public Course findCourse(Course course) {
        return adminDao.selectCourse(course);
    }

    @Override
    public List<Course> findCoursesByPage(Map<String, Object> paramMap) {
        return adminDao.selectCoursesByPage(paramMap);
    }

    @Override
    public int getCoursesTotal() {
        return adminDao.selectCoursesTotal();
    }
}
