package com.netty;


import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;


/**
 * 说明
 * 1、我们自定义一个Handler，需要继承netty绑定好的某个HandlerAdapter（规范）
 * 2、这时我们自定义一个Handler
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<SensorsDataPOJO.Data> {

    /**
     * ChannelHandlerContext:读取客户端发送的消息
     * @param ctx:上下对象，含有管道pipeline，通道channel，地址
     * @param msg：客户端发送的数据，默认Object
     * @throws Exception
     */
    @Override
    public void channelRead0(ChannelHandlerContext ctx, SensorsDataPOJO.Data msg) throws Exception {

        System.out.println("当前传感器为：" + ctx.channel().hashCode());
        System.out.println("肺功能仪数据：");
        System.out.println("PEF(呼气流量峰值) = " + msg.getPEF() + "U/min");
        System.out.println("FEV1(1秒用力呼气容积) = " + msg.getFEV1() + "L");
        System.out.println("FVC(用力肺活量) = " + msg.getFVC() + "L");
        System.out.println("血氧仪数据：");
        System.out.println("SAO2(血氧饱和度) = " + msg.getSAO2() + "%");
        System.out.println("PR(脉率) = " + msg.getPR() + "BPM");
        System.out.println("空气净化器数据：");
        System.out.println("PM2.5 = " + msg.getPM());
        System.out.println("RH(湿度) = " + msg.getRH() + "%");
        System.out.println("呼吸机数据：");
        System.out.println("VT(潮气量) = " + msg.getVT() + "ml");
        System.out.println();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PEF",msg.getPEF());
        jsonObject.put("FEV1",msg.getFEV1());
        jsonObject.put("FVC",msg.getFVC());
        jsonObject.put("SAO2",msg.getSAO2());
        jsonObject.put("PR",msg.getPR());
        jsonObject.put("PM",msg.getPM());
        jsonObject.put("RH",msg.getRH());
        jsonObject.put("VT",msg.getVT());
        MQTTClient mqttClient = new MQTTClient(jsonObject);
        mqttClient.setVisible(true);
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        //writeAndFlash ： write+flash
        //将数据写入到缓存并刷新
        //一般我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello,sensor", CharsetUtil.UTF_8));
    }

    //处理异常，一般是需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
