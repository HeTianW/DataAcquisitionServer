package com.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;


public class SensorsHandler extends ChannelInboundHandlerAdapter {

    SensorsDataPOJO.Data Data=null;

    Label label1=new Label("PEF:");
    TextField PEF =new TextField("500",5);
    Label label2=new Label("FEV1:");
    TextField FEV1 =new TextField("2600",5);
    Label label3=new Label("FVC:");
    TextField FVC =new TextField("3000",5);
    Label label4=new Label("SAO2:");
    TextField SAO2 =new TextField("98",5);
    Label label5=new Label("PR:");
    TextField PR =new TextField("75",5);
    Label label6=new Label("VT:");
    TextField VT =new TextField("500",5);
    Label label7=new Label("PM2.5:");
    TextField PM =new TextField("30",5);
    Label label8=new Label("RH:");
    TextField RH =new TextField("20",5);
    Button button=new Button("send");

    //当通道就绪时就会触发该方法
    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {

        //发送数据
//        KTPOJO.KongTiao msg = KTPOJO.KongTiao.newBuilder().setPM(2.4f).setRH(5.8f).build();
//        ctx.writeAndFlush(msg);

        Frame frame=new Frame();
        frame.setLocation(400, 300);
        frame.setLayout(new GridLayout(4,6,10,10));
        frame.setSize(300, 200);
        frame.add(label1);
        frame.add(PEF);
        frame.add(label2);
        frame.add(FEV1);
        frame.add(label3);
        frame.add(FVC);
        frame.add(label4);
        frame.add(SAO2);
        frame.add(label5);
        frame.add(PR);
        frame.add(new Label());
        frame.add(new Label());
        frame.add(label6);
        frame.add(VT);
        frame.add(new Label());
        frame.add(new Label());
        frame.add(new Label());
        frame.add(new Label());
        frame.add(label7);
        frame.add(PM);
        frame.add(label8);
        frame.add(RH);
        frame.add(new Label());
        frame.add(button);

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent arg0) {
                System.exit(0);
            }

        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data=SensorsDataPOJO.Data.newBuilder().setPEF(Integer.parseInt(PEF.getText()))
                        .setFEV1(Integer.parseInt(FEV1.getText()))
                        .setFVC(Integer.parseInt(FVC.getText()))
                        .setSAO2(Integer.parseInt(SAO2.getText()))
                        .setPR(Integer.parseInt(PR.getText()))
                        .setVT(Integer.parseInt(VT.getText()))
                        .setPM(Integer.parseInt(PM.getText()))
                        .setRH(Integer.parseInt(RH.getText()))
                        .build();
                ctx.writeAndFlush(Data);
            }
        });

        frame.setVisible(true);

        sendHeartbeat(ctx);
    }

    //当通道有读取事件时，会触发
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf) msg;
        System.out.println("服务器回复的消息：" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("服务器的地址："+ ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 发送心跳包
     */
    public static void sendHeartbeat(final ChannelHandlerContext ctx) {
        try {
            final String heartbeat = "heart:alive";
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(10 * 1000);// 10s发送一次心跳
                            ctx.writeAndFlush(Unpooled.copiedBuffer(heartbeat, CharsetUtil.UTF_8));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
