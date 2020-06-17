package com.dao;

import com.bean.Questionnaire;
import com.bean.User;

public interface QuestionDao
{
    /*User getUserByTel(String tel);
    int registerUser(User user);

    int setUserPwd(String u_id, String u_pwd);
    int setUserName(String u_id, String u_name);
    int setUserGender(String u_id, String u_gender);
    int setUserTel(String u_id, String u_tel);
    int setUserAge(String u_id, int u_age);
    int setUserHeight(String u_id, int u_height);
    int setUserWeight(String u_id, double u_weight);
    int setUserBloodtype(String u_id, String u_bloodtype);*/

    int newQuestionnaire(Questionnaire q);
    int newQuestionnaire(String tel, java.util.Date date, String drugfreq, String training, String onset);
}