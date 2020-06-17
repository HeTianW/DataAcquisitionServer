package com.service;

import com.alibaba.fastjson.JSONObject;
import com.bean.Msg;
import com.bean.Questionnaire;
import com.bean.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

public class Connection implements  Runnable{

    private String account;
    private BufferedReader bufferedReader = null;
    private PrintStream printStream = null;
    private final Socket socket;
    private final mySQL mysql = new mySQL();

    public Connection(Socket socket) throws SQLException, ClassNotFoundException {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert bufferedReader != null;
        assert printStream != null;

        try {
            String readline = bufferedReader.readLine();
            if(readline.equals("501")){ //登陆
                String u_tel = bufferedReader.readLine();
                String u_pwd = bufferedReader.readLine();
                if(null==mysql.getUser(u_tel)) printStream.println("1");
                else if(0==mysql.login(u_tel,u_pwd)){
                    printStream.println("2");
                }
                else{
                    printStream.println("0");
                }
            }
            else if(readline.equals("502")){ //获取用户信息
                String u_tel = bufferedReader.readLine();
                User user = mysql.getUser(u_tel);
                printStream.println(user.toJsonString());
            }
            else if(readline.equals("503")){ //注册
                String u_tel = bufferedReader.readLine();
                String u_pwd = bufferedReader.readLine();
                User user = new User(u_tel,u_pwd,"未命名");
                if(null!=mysql.getUser(u_tel)){
                    printStream.println("1");
                }
                else if(mysql.register(user)>0){
                    printStream.println("0");
                }
                else{
                    printStream.println("2");
                }
            }
            else if(readline.equals("504")){ //修改用户名
                String u_tel = bufferedReader.readLine();
                String u_name = bufferedReader.readLine();
                if(mysql.setName(u_tel,u_name)>0){
                    printStream.println("0");
                }
                else{
                    printStream.println("1");
                }
            }
            else if(readline.equals("505")){ //修改密码
                String u_tel = bufferedReader.readLine();
                String pwd = bufferedReader.readLine();
                if(mysql.setPwd(u_tel,pwd)>0){
                    printStream.println("0");
                }
                else{
                    printStream.println("1");
                }
            }
            else if(readline.equals("506")){ //修改性别
                String u_tel = bufferedReader.readLine();
                String gender = bufferedReader.readLine();
                if(mysql.setGender(u_tel,gender)>0){
                    printStream.println("0");
                }
                else{
                    printStream.println("1");
                }
            }
            else if(readline.equals("507")){ //修改年龄
                String tel = bufferedReader.readLine();
                String age = bufferedReader.readLine();
                if(mysql.setAge(tel,Integer.parseInt(age))>0){
                    printStream.println("0");
                }
                else{
                    printStream.println("1");
                }
            }
            else if(readline.equals("508")){ //修改身高
                String tel = bufferedReader.readLine();
                String height = bufferedReader.readLine();
                if(mysql.setHeight(tel,Integer.parseInt(height))>0){
                    printStream.println("0");
                }
                else{
                    printStream.println("1");
                }
            }
            else if(readline.equals("509")){ //修改体重
                String tel = bufferedReader.readLine();
                String weight = bufferedReader.readLine();
                if(mysql.setWeight(tel,Double.parseDouble(weight))>0){
                    printStream.println("0");
                }
                else{
                    printStream.println("1");
                }
            }
            else if(readline.equals("510")){ //修改血型
                String tel = bufferedReader.readLine();
                String bloodType = bufferedReader.readLine();
                if(mysql.setBloodtype(tel,bloodType)>0){
                    printStream.println("0");
                }
                else{
                    printStream.println("1");
                }
            }
            else if(readline.equals("511")){ //上传调查问卷
                String qJson = bufferedReader.readLine();
                if(mysql.updateQuestionnaire(JSONObject.parseObject(qJson, Questionnaire.class))>0){
                    printStream.println("0");
                }
                else{
                    printStream.println("1");
                }
            }
            else if(readline.equals("512")){ //获取消息列表
                String tel = bufferedReader.readLine();
                List<Msg> list = mysql.getMsgList(tel);
                printStream.println(JSONObject.toJSON(list).toString());
            }
            else if(readline.equals("513")){ //获取最新的调查问卷
                String tel = bufferedReader.readLine();
                printStream.println(JSONObject.toJSON(mysql.getQuestionnaire(tel)).toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
