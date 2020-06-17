package com.dao.impl;

import com.bean.Msg;
import com.dao.MsgDao;
import com.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MsgDaoImpl implements MsgDao {
    private Connection con;
    private PreparedStatement pStmt;
    private ResultSet rs;
    private String sql;


    /*插入新消息*/
    public int newMsg(Msg m)
    {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        int flag = 0;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "INSERT INTO msg(u_id,m_time, m_subject, m_content) VALUES (?, ?, ?,?)";
            pStmt = con.prepareStatement(sql);

            pStmt.setInt(1, m.getU_id());
            pStmt.setDate(2, (Date) m.getM_time());
            pStmt.setString(3, m.getM_subject());
            pStmt.setString(4, m.getM_content());

            flag = pStmt.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.closeAll(null, pStmt, con);
        }
        return flag;
    }
    public int newMsg(String tel, java.util.Date date, String subject, String content)
    {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        int flag = 0;
        try
        {
            int u_id=0;
            con = JDBCUtils.getConnection();
            sql="select u_id from user where u_tel=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setString(1,tel);
            rs = pStmt.executeQuery();
            if (rs.next()){
                u_id=rs.getInt("u_id");
            }


            sql = "INSERT INTO msg(u_id, m_time, m_subject, m_content) VALUES (?, ?, ?, ?)";
            pStmt = con.prepareStatement(sql);

            pStmt.setInt(1, u_id);
            pStmt.setDate(2, (Date) date);
            pStmt.setString(3, subject);
            pStmt.setString(4, content);

            flag = pStmt.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.closeAll(null, pStmt, con);
        }
        return flag;
    }


    /*通过用户手机号获取消息列表*/
    public List<Msg> getMsgList(String u_tel)
    {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        List<Msg> msgList = new ArrayList<Msg>();
        con = JDBCUtils.getConnection();
        sql = "SELECT * FROM msg WHERE u_id=(select u_id from user where u_tel=?)";
        try
        {
            pStmt = con.prepareStatement(sql);
            pStmt.setString(1, u_tel);
            rs = pStmt.executeQuery();

            //判断是否存在记录
            while (rs.next())
            {
                Msg msg = new Msg();
                msg.setM_id(rs.getInt("m_id"));
                msg.setM_time(rs.getDate("m_time"));
                msg.setU_id(rs.getInt("u_id"));
                msg.setM_subject(rs.getString("m_subject"));
                msg.setM_content(rs.getString("m_content"));

                msgList.add(msg);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.closeAll(rs, pStmt, con);
        }
        return msgList;
    }

}
