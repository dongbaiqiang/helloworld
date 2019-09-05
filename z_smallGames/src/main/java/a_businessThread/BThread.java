package a_businessThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;

import b_myDecoder.MessageHeader;
import b_myDecoder.MyMessage;
import c_myServer.Type;
import d_rpc.AddFun;
import d_rpc.MyProxy;
import e_cache.LocalPlayCache;
import io.netty.channel.ChannelHandlerContext;





public class BThread {
	
	static BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(100);
	static ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 7, 2, TimeUnit.SECONDS, queue);
	public static void doSomething(ChannelHandlerContext arg0,MyMessage arg1){
		pool.submit(new MyThread(arg0,arg1));
	}
}





class MyThread extends Thread{
	private ChannelHandlerContext ctx;
	private MyMessage msg;

	public MyThread(ChannelHandlerContext ctx,MyMessage msg){
		this.ctx = ctx;
		this.msg = msg;
	}
	
	public void run(){

		switch(msg.getHeader().getMsgId()){
		
		case 0 : //Type.ECHO.getValue()
			System.out.println("响应");
			ctx.writeAndFlush(new MyMessage(new MessageHeader(Type.ECHO.getValue(),"Hello".length()),"Hello"));
			break;
			
		case 1 : //Type.ADD.getValue()
			AddFun service = null;
			try {
				service = MyProxy.refer(AddFun.class, "10.2.144.18", 9000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
			String result = service.add(msg.getContent());
		    ctx.writeAndFlush(new MyMessage(new MessageHeader(1,result.length()),result));
			break;
			
		case 1001://SIGNIN
			JSONObject param = JSONObject.parseObject(msg.getContent());
			String id = param.getString("id");
			String password = param.getString("passWord");
			
			try {
				if(LocalPlayCache.getPlayers().get(id) == null){
					ctx.writeAndFlush(new MyMessage(new MessageHeader(Type.SIGNIN.getValue(),"error".length()),"error"));
					break;
				}
				if(!LocalPlayCache.getPlayers().get(id).getId().equals(password)){
					ctx.writeAndFlush(new MyMessage(new MessageHeader(Type.SIGNIN.getValue(),"password is error".length()),"password is error"));
					break;
				}
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			LocalPlayCache.getOnlinePlayerChannel().put(id, ctx);
			ctx.writeAndFlush(new MyMessage(new MessageHeader(Type.SIGNIN.getValue(),"welcome".length()),"welcome"));
			break;
		
		}
	}
}





















