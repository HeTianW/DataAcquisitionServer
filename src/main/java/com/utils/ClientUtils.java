package com.utils;

import com.alibaba.fastjson.JSONObject;
import com.bean.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientUtils {
    private static final String hostname = "127.0.0.1";
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
            return JSONObject.parseObject(JSONObject.parseObject(readline).getString("User"),User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 注册新用户
     * @param account 账号（邮箱地址）
     * @param password 密码
     * @return  0 操作成功
     *          1 账号不存在
     *          2 密码错误
     *         -1 连接失败
     *         -2 异常
     *         -3 参数不正确
     * */

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
