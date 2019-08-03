package c_myServer;

import b_myDecoder.MyDecoder;
import b_myDecoder.MyEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;


public class ServerInitializer extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// TODO Auto-generated method stub
		ch.pipeline().addFirst(new MyDecoder());
		ch.pipeline().addFirst(new MyEncoder());
		ch.pipeline().addLast(new ServerHandler());
	}

}
