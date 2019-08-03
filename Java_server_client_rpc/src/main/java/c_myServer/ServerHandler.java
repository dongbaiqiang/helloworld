package c_myServer;

import a_businessThread.BThread;
import b_myDecoder.MessageHeader;
import b_myDecoder.MyMessage;
import d_rpc.AddFun;
import d_rpc.MyProxy;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ServerHandler extends SimpleChannelInboundHandler<MyMessage> {
	public static final ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	//当有信息传入时自动调用
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, MyMessage msg) throws Exception {
		// TODO Auto-generated method stub
		if(msg.getHeader().getMsgId() == 1){
			BThread.doSomething(ctx, msg);
			System.out.println(msg.getContent());
		}
		if(msg.getHeader().getMsgId() == 1){
			  AddFun service = MyProxy.refer(AddFun.class, "10.2.144.18", 9000);
		        String result = service.add(msg.getContent());
		        ctx.writeAndFlush(new MyMessage(new MessageHeader(1,result.length()),result));
		}
		
	}


	//若出现异常自动调用此方法
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close().sync();
		//cause.printStackTrace();
	}
	//新客户端链接自动调用
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("客户端连接");
		group.add(ctx.channel());	
	}
	
	//客户端断开自动调用
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("客户端断开");
		group.remove(ctx.channel());
	    
	}
}
