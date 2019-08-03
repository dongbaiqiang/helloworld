package z_myClient;



import b_myDecoder.MyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class ClientHandler extends SimpleChannelInboundHandler<MyMessage> {
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, MyMessage msg) throws Exception {
		// TODO Auto-generated method stub
		
		if(msg.getHeader().getMsgId() == 1){
			System.out.println(msg.getContent());
		}
	}
}
