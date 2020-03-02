package com.yinshenghao.beans;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:Teacher
 * Package:com.yinshenghao.beans
 * Description:
 *
 * @Date:2020/2/27 6:17
 * @Author:ysh0806@sina.com
 */
public class Teacher implements Serializable {
    private int tid;
    private int tno;
    private String tpwd;
    private String tname;
    private String tphone;
    private List<Student> students;
    private List<Class> classes;
    private List<Course> courses;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tno=" + tno +
                ", tpwd='" + tpwd + '\'' +
                ", tname='" + tname + '\'' +
                ", tphone='" + tphone + '\'' +
                ", courses=" + courses +
                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getTpwd() {
        return tpwd;
    }

    public void setTpwd(String tpwd) {
        this.tpwd = tpwd;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
