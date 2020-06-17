package com.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/*
 * @Description: 用户信息
 */
public class User {
    private int u_id;
    private String u_tel;
    private String u_pwd;
    private String u_name;
    private String u_gender;
    private int u_age;
    private int u_height;
    private double u_weight;
    private String u_bloodtype;

    /*
     * @Description: 用户构造函数
     * @Param u_id, u_tel, u_pwd, u_name, u_age, u_height, u_weight,u_bloodtype
     * @Return: null
     */

    public User(String u_tel, String u_pwd, String u_name, String u_gender,int u_age, int u_height,double u_weight,String u_bloodtype)
    {
        //this.u_id = u_id;
        this.u_tel = u_tel;
        this.u_pwd = u_pwd;
        this.u_name = u_name;
        this.u_gender = u_gender;
        this.u_age = u_age;
        this.u_height = u_height;
        this.u_weight = u_weight;
        this.u_bloodtype = u_bloodtype;
    }

    public User(String u_tel, String u_pwd, String u_name) {
        this.u_tel = u_tel;
        this.u_pwd = u_pwd;
        this.u_name = u_name;
    }

    public User() {

    }

    public int getU_id()
    {
        return u_id;
    }

    public void setU_id(int u_id)
    {
        this.u_id= u_id;
    }

    public String getU_tel()
    {
        return u_tel;
    }

    public void setU_tel(String u_tel)
    {
        this.u_tel= u_tel;
    }

    public String getU_pwd()
    {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd)
    {
        this.u_pwd= u_pwd;
    }

    public String getU_name()
    {
        return u_name;
    }

    public void setU_name(String u_name)
    {
        this.u_name= u_name;
    }

    public String getU_gender()
    {
        return u_gender;
    }

    public void setU_gender(String u_gender)
    {
        this.u_gender= u_gender;
    }

    public int getU_age()
    {
        return u_age;
    }

    public void setU_age(int u_age)
    {
        this.u_age= u_age;
    }

    public int getU_height()
    {
        return u_height;
    }

    public void setU_height(int u_height)
    {
        this.u_height= u_height;
    }

    public double getU_weight()
    {
        return u_weight;
    }

    public void setU_weight(double u_weight)
    {
        this.u_weight= u_weight;
    }

    public String getU_bloodtype()
    {
        return u_bloodtype;
    }

    public void setU_bloodtype(String u_bloodtype)
    {
        this.u_bloodtype= u_bloodtype;
    }

    public String toJsonString(){
        return JSONObject.toJSON(this).toString();
    }
}
