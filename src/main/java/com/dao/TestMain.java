package com.dao;

import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMain {

    public static void main(String args[]){
        Connection con;
        PreparedStatement pStmt;
        ResultSet rs;
        String sql;
        con = null;
        pStmt = null;
        rs = null;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "SELECT * FROM user u WHERE u_id = ? ";
            pStmt = con.prepareStatement(sql);

            //替换参数，从1开始
            pStmt.setString(1, "1");
            rs = pStmt.executeQuery();

            if (rs.next())
            {
                System.out.println(rs.getString("u_name"));
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

    }
}
