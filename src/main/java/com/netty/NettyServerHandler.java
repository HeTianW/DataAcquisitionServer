package com.netty;


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

        System.out.println("msg.getFEV1() = " + msg.getFEV1());
        System.out.println("msg.getFVC() = " + msg.getFVC());
        System.out.println("msg.getPEF() = " + msg.getPEF());
        System.out.println("msg.getPM() = " + msg.getPM());
        System.out.println("msg.getRH() = " + msg.getRH());
        System.out.println("msg.getSAO2() = " + msg.getSAO2());
        System.out.println("msg.getVT() = " + msg.getVT());
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        //writeAndFlash ： write+flash
        //将数据写入到缓存并刷新
        //一般我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello,客户端~汪1", CharsetUtil.UTF_8));
    }

    //处理异常，一般是需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
