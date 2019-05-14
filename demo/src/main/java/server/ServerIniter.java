package server;

/**
 * 设置通道的类，通过它向管道中加入相应的过滤器，例如心跳，解码器编码器等。
 */

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import mydecoder.MyDecoder;
import mydecoder.MyEncoder;





public class ServerIniter extends ChannelInitializer<SocketChannel>{
	
		@Override
		protected void initChannel(SocketChannel arg0) throws Exception {
			
			
			

			
			//导入自定义的编解码
			arg0.pipeline().addLast(new MyDecoder());					
			arg0.pipeline().addLast(new MyEncoder());	
			
			//心跳
			arg0.pipeline().addLast(new IdleStateHandler(5, 5, 10));
			
			//业务handler
			arg0.pipeline().addLast(new ServerHandler());					
			
			

			
		}	
}

