package com.yinshenghao.beans;

import java.io.Serializable;

/**
 * ClassName:Admin
 * Package:com.yinshenghao.beans
 * Description:
 *
 * @Date:2020/2/27 20:53
 * @Author:ysh0806@sina.com
 */
public class Admin implements Serializable {
    private int aid;
    private int ano;
    private String apwd;
    private String aname;
    private String aphone;

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", ano=" + ano +
                ", apwd='" + apwd + '\'' +
                ", aname='" + aname + '\'' +
                ", aphone='" + aphone + '\'' +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }
}
