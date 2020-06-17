package com.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.Msg;
import com.bean.Questionnaire;
import com.bean.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientUtils {
    private static final String hostname = "diker.xyz";
    private static final int port = 2020;
    private static Socket socket;
    private static String readline;
    private static BufferedReader bufferedReader;
    private static PrintStream printStream;

    /**
     * 登录验证
     * @param account 账号（邮箱地址）
     * @param password 密码
     * @return  0 操作成功
     *          1 账号不存在
     *          2 密码错误
     *         -1 连接失败
     *         -2 异常
     *         -3 参数不正确
     * */
    public static int login(String account, String password) {
        return exe(account,password,"501");
    }

    /**
     * 获取用户实例
     * @param tel 账号（用户电话号码）
     * @return  user实例
     * */
    public static User getUser(String tel){
        if(!connect(hostname,port)) return null;
        printStream.println("502");
        printStream.println(tel);
        try {
            readline = bufferedReader.readLine();
            disconnect();
            return JSONObject.parseObject(readline,User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 注册新用户
     * @param tel 账号（用户电话号码）
     * @param pwd 密码
     * @return  0 操作成功
     *          1 用户已存在
     *          2 操作失败
     *         -1 连接失败
     *         -2 异常
     *         -3 参数不正确
     * */
    public static int register(String tel,String pwd){
        return exe(tel,pwd,"503");
    }

    /**
     * 修改用户名
     * @param tel 账号（用户电话号码）
     * @param name 用户名
     * @return  0 操作成功
     *          1 操作失败
     *         -1 连接失败
     *         -2 异常
     *         -3 参数不正确
     * */
    public static int setName(String tel,String name){
        return exe(tel,name,"504");
    }

    /**
     * 修改密码
     * @param tel 账号（用户电话号码）
     * @param pwd 密码
     * @return  0 操作成功
     *          1 操作失败
     *         -1 连接失败
     *         -2 异常
     *         -3 参数不正确
     * */
    public static int setPwd(String tel,String pwd){
        return exe(tel,pwd,"505");
    }

    /**
     * 修改性别
     * @param tel 账号（用户电话号码）
     * @param gender 性别
     * @return  0 操作成功
     *          1 操作失败
     *         -1 连接失败
     *         -2 异常
     *         -3 参数不正确
     * */
    public static int setGender(String tel,String gender){
        return exe(tel,gender,"506");
    }

    /**
     * 修改年龄
     * @param tel 账号（用户电话号码）
     * @param age 年龄
     * @return  0 操作成功
     *          1 操作失败
     *         -1 连接失败
     *         -2 异常
     *         -3 参数不正确
     * */
    public static int setAge(String tel,int age){
        return exe(tel,Integer.toString(age),"507");
    }

    /**
     * 修改身高
     * @param tel 账号（用户电话号码）
     * @param height 身高
     * @return  0 操作成功
     *          1 操作失败
     *         -1 连接失败
     *         -2 异常
     *         -3 参数不正确
     * */
    public static int setHeight(String tel,int height){
        return exe(tel,Integer.toString(height),"508");
    }

    /**
     * 修改体重
     * @param tel 账号（用户电话号码）
     * @param weight 体重
     * @return  0 操作成功
     *          1 操作失败
     *         -1 连接失败
     *         -2 异常
     *         -3 参数不正确
     * */
    public static int setWeight(String tel,double weight){
        return exe(tel,Double.toString(weight),"509");
    }

    /**
     * 修改血型
     * @param tel 账号（用户电话号码）
     * @param bloodType 血型
     * @return  0 操作成功
     *          1 操作失败
     *         -1 连接失败
     *         -2 异常
     *         -3 参数不正确
     * */
    public static int setBloodType(String tel,String bloodType){
        return exe(tel,bloodType,"510");
    }

    /**
     * 上传调查问卷
     * @param questionnaire 调查问卷
     * @return  0 操作成功
     *          1 操作失败
     *         -1 连接失败
     *         -2 异常
     * */
    public static int updateQuestionnaire(Questionnaire questionnaire){
        if(!connect(hostname,port)) return -1;
        printStream.println("511");
        printStream.println(JSONObject.toJSON(questionnaire).toString());
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            return -2;
        }
    }

    /**
     * 获取消息列表
     * @param tel 账号（用户电话号码）
     * @return  消息列表
     * */
    public static List<Msg> getMsgList(String tel){
        if(!connect(hostname,port)) return null;
        printStream.println("512");
        printStream.println(tel);
        try {
            readline = bufferedReader.readLine();
            disconnect();
            //System.out.println(readline);
            return JSONArray.parseArray(readline,Msg.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取最新的调查问卷
     * @param tel 账号（用户电话号码）
     * @return  调查问卷
     * */
    public static Questionnaire getQuestionnaire(String tel){
        if(!connect(hostname,port)) return null;
        printStream.println("513");
        printStream.println(tel);
        try {
            readline = bufferedReader.readLine();
            disconnect();
            //System.out.println(readline);
            return JSONObject.parseObject(readline,Questionnaire.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int exe(String account, String password,String code) {
        if(account.length()==0||password.length()==0) return -3;
        if(!connect(hostname,port)) return -1;
        printStream.println(code);
        printStream.println(account);
        printStream.println(password);
        try {
            readline = bufferedReader.readLine();
            disconnect();
            return Integer.parseInt(readline);
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
    }

    //建立连接
    private static boolean connect(String address,int port){
        socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(address, port), 5000);
            if (!socket.isConnected()) {
                System.out.println("Connected failed.");
                return false;
            }
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        assert bufferedReader != null;
        return true;
    }

    //断开连接
    private static void disconnect() throws IOException {
        bufferedReader.close();
        printStream.close();
        socket.close();
    }
}
