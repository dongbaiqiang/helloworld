package client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import mydecoder.MyMessage;

public class ClientHandler extends SimpleChannelInboundHandler<MyMessage> {
	public static Logger log = LoggerFactory.getLogger(Client.class);			//建立日志
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, MyMessage msg) throws Exception {
		// TODO Auto-generated method stub
		
		if(msg.getHeader().getCmdId() == 101){
			log.info("Successful connection.");	
			Thread thread = new Heart(ctx.channel());
	        thread.start();
		}
	}
}