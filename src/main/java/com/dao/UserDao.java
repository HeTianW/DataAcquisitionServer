package com.dao;

import com.bean.User;

public interface UserDao
{
    User getUserByTel(String tel);
    int registerUser(User user);
    int login(String u_tel,String u_pwd);
    int setUserPwd(String u_tel, String u_pwd);
    int setUserName(String u_tel, String u_name);
    int setUserGender(String u_tel, String u_gender);
    int setUserTel(String u_tel, String u_newtel);
    int setUserAge(String u_tel, int u_age);
    int setUserHeight(String u_tel, int u_height);
    int setUserWeight(String u_tel, double u_weight);
    int setUserBloodtype(String u_tel, String u_bloodtype);
}