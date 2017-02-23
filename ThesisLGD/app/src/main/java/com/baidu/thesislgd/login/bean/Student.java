package com.baidu.thesislgd.login.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/2/22.
 */

public class Student extends BmobObject{
    private String username;
    private String password;

    public Student(){

    }
    public Student(String username,String password){

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
