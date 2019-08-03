package a_businessThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import b_myDecoder.MessageHeader;
import b_myDecoder.MyMessage;
import io.netty.channel.ChannelHandlerContext;





public class BThread {
	
	static BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(100);
	static ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 7, 2, TimeUnit.SECONDS, queue);
	public static void doSomething(ChannelHandlerContext arg0,MyMessage arg1){
		pool.submit(new MyThread(arg0,arg1));
	}
}





class MyThread extends Thread{
	private ChannelHandlerContext arg0;
	private MyMessage arg1;

	public MyThread(ChannelHandlerContext arg0,MyMessage arg1){
		this.arg0 = arg0;
		this.arg1 = arg1;
	}
	
	public void run(){
		if(arg1.getHeader().getMsgId() == 1){
			
			arg0.writeAndFlush(new MyMessage(new MessageHeader(1,"Hello".length()),"Hello"));
		}
	}
}
