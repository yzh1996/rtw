package server;

import handler.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName: NettyServer
 * @Author: yzh
 * @Description: netty服务器
 * @Date: 2021/12/9 19:56
 * @Version: 1.0
 */
public class NettyServer {

    public static void main(String[] args) {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss,worker)
                .channel(NioServerSocketChannel.class)
                 .childHandler(new ChannelInitializer<SocketChannel>() {
                     @Override
                     protected void initChannel(SocketChannel ch) throws Exception {
                         ch.pipeline().addLast(new NettyServerHandler());
                     }

                 })
                .option(ChannelOption.SO_BACKLOG,2)
                .childOption(ChannelOption.SO_KEEPALIVE,false);
        try {
            ChannelFuture channelFuture = serverBootstrap.bind("192.168.158.1",9999).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
         }

    }

}
