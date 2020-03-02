package com.yinshenghao.provider.dao;

import com.yinshenghao.beans.Course;
import com.yinshenghao.beans.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * ClassName:TeacherDao
 * Package:com.yinshenghao.provider.dao
 * Description:
 *
 * @Date:2020/2/28 4:32
 * @Author:ysh0806@sina.com
 */
@Mapper
public interface TeacherDao {
    public Teacher selectTeacher(Teacher teacher);
    public int updateTpwd(Teacher teacher);
    public List<Course> selectCourseByPage(Map<String, Object> paramMap);
    public int selectCourseTotal(Teacher teacher);
}
