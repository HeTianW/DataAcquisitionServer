package com.dao.impl;
import com.bean.User;
import com.dao.UserDao;
import com.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    private Connection con;
    private PreparedStatement pStmt;
    private ResultSet rs;
    private String sql;

    public User getUserByTel(String tel)
    {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        User user = null;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "SELECT * FROM user u WHERE u_tel = ?";
            pStmt = con.prepareStatement(sql);

            pStmt.setString(1, tel);
            rs = pStmt.executeQuery();

            if (rs.next())
            {
                user = new User();
                user.setU_id(rs.getInt("u_id"));
                user.setU_tel(rs.getString("u_tel"));
                user.setU_pwd(rs.getString("u_pwd"));
                user.setU_name(rs.getString("u_name"));
                user.setU_gender(rs.getString("u_gender"));
                user.setU_age(rs.getInt("u_age"));
                user.setU_height(rs.getInt("u_height"));
                user.setU_weight(rs.getFloat("u_weight"));
                user.setU_bloodtype(rs.getString("u_bloodtype"));
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
        return user;
    }

    public int login(String u_tel,String u_pwd){
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        int flag = 0;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "SELECT * FROM user u WHERE u_tel = ? AND u_pwd = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setString(1, u_tel);
            pStmt.setString(2, u_pwd);
            rs = pStmt.executeQuery();
            if(rs.next()) flag = 1;
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

    public int registerUser(User user)
    {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        int flag = 0;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "INSERT INTO user(u_id, u_tel, u_pwd, u_name,u_gender, u_age, u_height, u_weight, u_bloodtype) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
            pStmt = con.prepareStatement(sql);

            pStmt.setInt(1, user.getU_id());
            pStmt.setString(2, user.getU_tel());
            pStmt.setString(3, user.getU_pwd());
            pStmt.setString(4, user.getU_name());
            pStmt.setString(5, user.getU_gender());
            pStmt.setInt(6, user.getU_age());
            pStmt.setInt(7, user.getU_height());
            pStmt.setDouble(8, user.getU_weight());
            pStmt.setString(9, user.getU_bloodtype());
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

    public int setUserPwd(String u_tel, String u_pwd)
    {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        int flag = 0;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "UPDATE user SET u_pwd = ? WHERE u_tel = ?";
            pStmt = con.prepareStatement(sql);

            pStmt.setString(1, u_pwd);
            pStmt.setString(2, u_tel);
            flag = pStmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.closeAll(rs, pStmt, con);
        }
        return flag;
    }


    public int setUserName(String u_tel, String u_name)
    {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        int flag = 0;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "UPDATE user SET u_name = ? WHERE u_tel = ?";
            pStmt = con.prepareStatement(sql);

            pStmt.setString(1, u_name);
            pStmt.setString(2, u_tel);
            flag = pStmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.closeAll(rs, pStmt, con);
        }
        return flag;
    }

    public int setUserGender(String u_tel, String u_gender)
    {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        int flag = 0;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "UPDATE user SET u_gender = ? WHERE u_tel = ?";
            pStmt = con.prepareStatement(sql);

            pStmt.setString(1, u_gender);
            pStmt.setString(2, u_tel);
            flag = pStmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.closeAll(rs, pStmt, con);
        }
        return flag;
    }

    public int setUserTel(String u_tel, String u_newtel)
    {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        int flag = 0;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "UPDATE user SET u_tel = ? WHERE u_tel = ?";
            pStmt = con.prepareStatement(sql);

            pStmt.setString(1, u_newtel);
            pStmt.setString(2, u_tel);
            flag = pStmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.closeAll(rs, pStmt, con);
        }
        return flag;
    }

    public int setUserAge(String u_tel, int u_age)
    {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        int flag = 0;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "UPDATE user SET u_age = ? WHERE u_tel = ?";
            pStmt = con.prepareStatement(sql);

            pStmt.setInt(1, u_age);
            pStmt.setString(2, u_tel);
            flag = pStmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.closeAll(rs, pStmt, con);
        }
        return flag;
    }

    public int setUserHeight(String u_tel, int u_height)
    {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        int flag = 0;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "UPDATE user SET u_height = ? WHERE u_tel = ?";
            pStmt = con.prepareStatement(sql);

            pStmt.setInt(1, u_height);
            pStmt.setString(2, u_tel);
            flag = pStmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.closeAll(rs, pStmt, con);
        }
        return flag;
    }

    public int setUserWeight(String u_tel, double u_weight) {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        int flag = 0;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "UPDATE user SET u_weight = ? WHERE u_tel = ?";
            pStmt = con.prepareStatement(sql);

            pStmt.setDouble(1,  u_weight);
            pStmt.setString(2, u_tel);
            flag = pStmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.closeAll(rs, pStmt, con);
        }
        return flag;
    }

    public int setUserBloodtype(String u_tel, String u_bloodtype)
    {
        //初始化
        con = null;
        pStmt = null;
        rs = null;

        int flag = 0;
        try
        {
            con = JDBCUtils.getConnection();
            sql = "UPDATE user SET u_bloodtype = ? WHERE u_tel = ?";
            pStmt = con.prepareStatement(sql);

            pStmt.setString(1, u_bloodtype);
            pStmt.setString(2, u_tel);
            flag = pStmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JDBCUtils.closeAll(rs, pStmt, con);
        }
        return flag;
    }
}
