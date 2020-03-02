package com.yinshenghao.beans;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:Student
 * Package:com.yinshenghao.beans
 * Description:
 *
 * @Date:2020/2/27 6:10
 * @Author:ysh0806@sina.com
 */
public class Student implements Serializable {
    private int sid;
    private int sno;
    private String spwd;
    private String sname;
    private String sphone;
    private int sclassid;
    private String className;
    private List<Teacher> teachers;
    private List<Course> courses;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sno=" + sno +
                ", spwd='" + spwd + '\'' +
                ", sname='" + sname + '\'' +
                ", sphone='" + sphone + '\'' +
                ", sclassid=" + sclassid +
                ", className='" + className + '\'' +
                ", courses=" + courses +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public int getSclassid() {
        return sclassid;
    }

    public void setSclassid(int sclassid) {
        this.sclassid = sclassid;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
