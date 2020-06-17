package com.service;

import com.alibaba.fastjson.JSONObject;
import com.bean.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

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
            if(readline.equals("501")){
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
