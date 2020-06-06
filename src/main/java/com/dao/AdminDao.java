package com.dao;

import bean.Admin;

public interface AdminDao
{
    //通过微信号获取管理员
    Admin getAdminByWechatID(String wechatID);

}
