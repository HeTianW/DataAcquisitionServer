package com.service;

import com.bean.Msg;
import com.bean.Questionnaire;
import com.bean.User;
import com.dao.MsgDao;
import com.dao.QuestionDao;
import com.dao.UserDao;
import com.dao.impl.MsgDaoImpl;
import com.dao.impl.QuestionDaoImpl;
import com.dao.impl.UserDaoImpl;

import java.util.Date;
import java.util.List;

public class mySQL {
    private UserDao ud=new UserDaoImpl();
    private QuestionDao qd=new QuestionDaoImpl();
    private MsgDao md=new MsgDaoImpl();

    /*User user=new User();
    Questionnaire questionnaire=new Questionnaire();
    Msg msg=new Msg();*/

    public User getUser(String tel){
        return ud.getUserByTel(tel);
    }
    public int login(String tel,String pwd){
        return ud.login(tel,pwd);
    }
    public int register(User u){
        return ud.registerUser(u);
    }
    public int setPwd(String tel, String pwd){
        return ud.setUserPwd(tel,pwd);
    }
    public int setName(String tel, String name){
        return ud.setUserName(tel,name);
    }
    public int setGender(String tel, String gender){
        return ud.setUserGender(tel,gender);
    }
    public int setTel(String tel, String newtel){
        return ud.setUserTel(tel,newtel);
    }
    public int setAge(String tel, int age){
        return ud.setUserAge(tel,age);
    }
    public int setHeight(String tel, int height){
        return ud.setUserHeight(tel,height);
    }
    public int setWeight(String tel, double weight){
        return ud.setUserWeight(tel,weight);
    }
    public int setBloodtype(String tel, String btype){
        return ud.setUserBloodtype(tel,btype);
    }

    public int insertQsnaire(String tel, Date date,String drugfreq,String training,String onset){
        return qd.newQuestionnaire(tel,date,drugfreq,training,onset);
    }
    public int updateQuestionnaire(Questionnaire q){
        return qd.newQuestionnaire(q);
    }

    public int insertMsg(String tel,java.util.Date date, String subject, String content){
        return md.newMsg(tel,date,subject,content);
    }

    public List<Msg> getMsgList(String tel){
        return md.getMsgList(tel);
    }

    public Questionnaire getQuestionnaire(String tel) {
        return qd.getLatestQs(tel);
    }
}
