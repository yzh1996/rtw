package Client;

import handler.ClientChannel;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName: NettyClient
 * @Author: yzh
 * @Description:Netty客户端
 * @Date: 2021/12/9 20:35
 * @Version: 1.0
 */
public class NettyClient {
    public static void main(String[] args) {


        NioEventLoopGroup woker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(woker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ClientChannel());
                    }
                });

        ChannelFuture channelFuture = bootstrap.connect("192.168.158.1", 9999);

    }
}
