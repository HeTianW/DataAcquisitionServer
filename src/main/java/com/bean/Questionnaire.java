package com.bean;

import java.util.Date;

/*
 * @Description: 问卷填写具体信息
 */
public class Questionnaire {
    private int u_id;
    private Date q_date;
    private String q_drugfreq;
    private String q_training;
    private String q_onsettimes;

    /*
     * @Description: 问卷信息构造函数
     * @Param  m_id,  u_id,  m_subject, m_content
     * @Return: null
     */

    public Questionnaire(int u_id, Date q_date,String q_drugfreq, String q_training,String q_onsettimes)
    {
        this.u_id = u_id;
        this.q_date = q_date;
        this.q_drugfreq = q_drugfreq;
        this.q_training = q_training;
        this.q_onsettimes = q_onsettimes;
    }

    public Questionnaire()
    {
    }

    public int getU_id()
    {
        return u_id;
    }

    public void setU_id(int u_id)
    {
        this.u_id= u_id;
    }

    public Date getQ_date()
    {
        return q_date;
    }

    public void setQ_date(Date q_date)
    {
        this.q_date= q_date;
    }

    public String getQ_drugfreq()
    {
        return q_drugfreq;
    }

    public void setQ_drugfreqt(String q_drugfreq)
    {
        this.q_drugfreq= q_drugfreq;
    }

    public String getQ_training()
    {
        return q_training;
    }

    public void setQ_training(String q_training)
    {
        this.q_training= q_training;
    }

    public String getQ_onsettimes()
    {
        return q_onsettimes;
    }

    public void setQ_onsettimes(String q_onsettimes)
    {
        this.q_onsettimes= q_onsettimes;
    }
}
