package com.bean;

import java.sql.Time;
import java.util.Date;

/*
 * @Description: 警告消息具体信息
 */
public class Msg {
    private int m_id;
    private Date m_time;
    private int u_id;
    private String m_subject;
    private String m_content;

    /*
     * @Description: 警告消息构造函数
     * @Param  m_id,  u_id,  m_subject, m_content
     * @Return: null
     */

    public Msg(int u_id, Date m_time,String m_subject,String m_content)
    {
        // this.m_id = m_id;
        this.u_id = u_id;
        this.m_time = m_time;
        this.m_subject = m_subject;
        this.m_content = m_content;
    }

    public Msg(int m_id)
    {
        this.m_id = m_id;
    }
    public Msg()
    {
    }

    public int getM_id()
    {
        return m_id;
    }

    public void setM_id(int t_id)
    {
        this.m_id= m_id;
    }

    public Date getM_time()
    {
        return m_time;
    }

    public void setM_time(Date m_time)
    {
        this.m_time= m_time;
    }

    public int getU_id()
    {
        return u_id;
    }

    public void setU_id(int u_id)
    {
        this.u_id= u_id;
    }

    public String getM_subject()
    {
        return m_subject;
    }

    public void setM_subject(String m_subject)
    {
        this.m_subject= m_subject;
    }

    public String getM_content()
    {
        return m_content;
    }

    public void setM_content(String m_content)
    {
        this.m_content= m_content;
    }
}
