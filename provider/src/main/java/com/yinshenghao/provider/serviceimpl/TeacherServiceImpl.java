package com.yinshenghao.provider.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yinshenghao.beans.Course;
import com.yinshenghao.beans.Teacher;
import com.yinshenghao.provider.dao.TeacherDao;
import com.yinshenghao.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * ClassName:TeacherServiceImpl
 * Package:com.yinshenghao.provider.serviceimpl
 * Description:
 *
 * @Date:2020/2/28 4:38
 * @Author:ysh0806@sina.com
 */
@Component
@Service(version = "1.0.0", timeout = 10000, interfaceName = "com.yinshenghao.service.TeacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public Teacher findTeacher(Teacher teacher) {
        return teacherDao.selectTeacher(teacher);
    }

    @Transactional
    @Override
    public int modifyTpwd(Teacher teacher) {
        return teacherDao.updateTpwd(teacher);
    }

    @Override
    public List<Course> findCourseByPage(Map<String, Object> paramMap) {
        return teacherDao.selectCourseByPage(paramMap);
    }

    @Override
    public int getCourseTotal(Teacher teacher) {
        return teacherDao.selectCourseTotal(teacher);
    }

}
