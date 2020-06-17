package com.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bean.User;
import com.utils.ClientUtils;
import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMain {

    public static void main(String args[]){
        int ret = ClientUtils.login("333","000");
        System.out.println("登陆结果："+ret);
        User user = ClientUtils.getUser("333");
        assert user != null;
        System.out.println("用户名："+user.getU_name());
    }
}
