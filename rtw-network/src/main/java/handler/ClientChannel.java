package handler;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * @ClassName: ClientChannel
 * @Author: yzh
 * @Description:
 * @Date: 2021/12/9 20:39
 * @Version: 1.0
 */
public class ClientChannel  extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        String s = buf.toString(Charset.forName("UTF-8"));
        System.out.println("接收到的服务器信息是" + s);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
         ctx.writeAndFlush(Unpooled.copiedBuffer("hello 服务器！", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
