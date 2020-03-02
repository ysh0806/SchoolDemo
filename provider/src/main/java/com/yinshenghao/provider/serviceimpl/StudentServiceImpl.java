package com.yinshenghao.provider.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yinshenghao.beans.Course;
import com.yinshenghao.beans.Student;
import com.yinshenghao.provider.dao.StudentDao;
import com.yinshenghao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * ClassName:StudentServiceImpl
 * Package:com.yinshenghao.provider.serviceimpl
 * Description:
 *
 * @Date:2020/2/28 0:26
 * @Author:ysh0806@sina.com
 */
@Component
@Service(version = "1.0.0", timeout = 10000, interfaceName = "com.yinshenghao.service.StudentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student findStudent(Student student) {
        return studentDao.selectStudent(student);
    }

    @Transactional
    @Override
    public int modifySpwd(Student student) {
        return studentDao.updateSpwd(student);
    }

    @Override
    public List<Course> findCourseByPage(Map<String, Object> paramMap) {
        return studentDao.selectCourseByPage(paramMap);
    }

    @Override
    public int getCourseTotal(Student student) {
        return studentDao.selectCourseTotal(student);
    }

}
