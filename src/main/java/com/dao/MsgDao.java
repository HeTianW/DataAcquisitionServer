package com.dao;

import com.bean.Msg;
import com.bean.Questionnaire;

import java.util.List;

public interface MsgDao
{
    /*插入新消息*/
    int newMsg(Msg m);
    int newMsg(String tel, java.util.Date date, String subject, String content);
    /*通过用户手机号获取消息列表*/
    List<Msg> getMsgList(String u_tel);
}