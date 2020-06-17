package com.bean;
/*
 * @Description: 检测数据项信息
 */
public class Testitem {
    private int t_id;
    private String t_name;
    private String t_device;
    private String t_unit;

    /*
     * @Description: 检测数据项构造函数
     * @Param t_id, t_name, t_device, t_unit
     * @Return: null
     */

    public Testitem(int t_id, String t_name, String t_device, String t_unit)
    {
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_device = t_device;
        this.t_unit = t_unit;
    }

    public Testitem(int t_id)
    {
        this.t_id = t_id;
    }

    public int getT_id()
    {
        return t_id;
    }

    public void setT_id(int t_id)
    {
        this.t_id= t_id;
    }

    public String getT_name()
    {
        return t_name;
    }

    public void setT_name(String t_name)
    {
        this.t_name= t_name;
    }

    public String getT_device()
    {
        return t_device;
    }

    public void setT_device(String t_device)
    {
        this.t_device= t_device;
    }

    public String getT_unit()
    {
        return t_unit;
    }

    public void setT_unit(String t_unit)
    {
        this.t_unit= t_unit;
    }
}
