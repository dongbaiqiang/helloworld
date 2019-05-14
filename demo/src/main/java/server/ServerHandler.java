package server;

/**
 * 对链接进来的客户段进行管理，有信息进入，客户段链接、断开都会自动调用其中的方法
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import businessthread.BusinessThread;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.GlobalEventExecutor;
import messagefactory.CreateMessage;
import messagefactory.MessageFactory;
import mydecoder.MyMessage;

public class ServerHandler extends SimpleChannelInboundHandler<MyMessage> {

	public static Logger log = LoggerFactory.getLogger(ServerHandler.class);			//建立日志
	//建立group存储传进来的链接
	public static final ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	private float num = 0;
	
	//接受信息方法当有信息传入会自动调用
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, MyMessage msg) throws Exception {
	
		//调用业务线程
		if(msg.getHeader().getCmdId() == 1){
			
			num = num + 10;
			if(num>=100){
				log.info("Store information to the database in ten seconds");
				BusinessThread.doBusiness(ctx, msg, group,1,num);
				num = 0;
			}
		}else if(msg.getHeader().getCmdId() == 1000){
			log.info("Login request");
			BusinessThread.doBusiness(ctx, msg, group,2,0);	
		}
		
	}

	//若出现异常自动调用此方法
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		log.error("异常");
		ctx.close().sync();
		//cause.printStackTrace();
	}
	//新客户端链接自动调用
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		log.info("[" + ctx.channel().remoteAddress() + "] " + "Client connection");
		group.add(ctx.channel());	
	}
	
	@Override
	public void userEventTriggered(final ChannelHandlerContext ctx, Object evt) throws Exception {
		if(evt instanceof IdleStateEvent){
			IdleStateEvent event = (IdleStateEvent)evt;
			if(event.state() == IdleState.ALL_IDLE){
				MessageFactory MF = new MessageFactory();
				CreateMessage msg = MF.getMessage("关闭连接");
				ChannelFuture writeAndFlush = ctx.writeAndFlush(msg.getMessage());
				log.info("[" + ctx.channel().remoteAddress() + "] " + "Client disconnects");
				writeAndFlush.addListener(new ChannelFutureListener() {
					public void operationComplete(ChannelFuture future) throws Exception {
						ctx.channel().close();
					}
				});
			}
		}else{
			super.userEventTriggered(ctx, evt);
		}
	}
	
	//客户端断开自动调用
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		log.info("[" + ctx.channel().remoteAddress() + "] " + "Delete this from the group");
	    group.remove(ctx.channel());
	    
	}
	
}
