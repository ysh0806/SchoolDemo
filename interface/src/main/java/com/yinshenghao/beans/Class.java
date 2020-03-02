package com.yinshenghao.beans;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:Class
 * Package:com.yinshenghao.beans
 * Description:
 *
 * @Date:2020/2/27 6:21
 * @Author:ysh0806@sina.com
 */
public class Class implements Serializable {
    private int clid;
    private String clname;
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;

    @Override
    public String toString() {
        return "Class{" +
                "clid=" + clid +
                ", clname='" + clname + '\'' +
                ", courses=" + courses +
                '}';
    }

    public int getClid() {
        return clid;
    }

    public void setClid(int clid) {
        this.clid = clid;
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
