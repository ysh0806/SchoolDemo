package com.yinshenghao.beans;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:Course
 * Package:com.yinshenghao.beans
 * Description:
 *
 * @Date:2020/2/27 6:23
 * @Author:ysh0806@sina.com
 */
public class Course implements Serializable {
    private int coid;
    private String coname;
    private int teacherid;
    private int cclassid;
    private String teacherName;
    private String className;
    private List<Student> students;

    @Override
    public String toString() {
        return "Course{" +
                "coid=" + coid +
                ", coname='" + coname + '\'' +
                ", teacherid=" + teacherid +
                ", cclassid=" + cclassid +
                ", teacherName='" + teacherName + '\'' +
                ", className=" + className +
                '}';
    }

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public int getCclassid() {
        return cclassid;
    }

    public void setCclassid(int cclassid) {
        this.cclassid = cclassid;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
