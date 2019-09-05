package z_myClient;


import b_myDecoder.MyDecoder;
import b_myDecoder.MyEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;


public class ClientIniter extends ChannelInitializer<SocketChannel> {
	
	
@Override
protected void initChannel(SocketChannel arg0) throws Exception {
		
	
	
	
    ChannelPipeline pipeline = arg0.pipeline();
    pipeline.addLast(new MyEncoder());
    pipeline.addLast(new MyDecoder());
    
    pipeline.addLast( new ClientHandler());
}

}