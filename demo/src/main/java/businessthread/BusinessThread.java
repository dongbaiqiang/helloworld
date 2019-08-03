package businessthread;

/**
 * 服务器的业务线程
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;
import messagefactory.CreateMessage;
import messagefactory.MessageFactory;
import mydecoder.MyMessage;
import server.Server;


public class BusinessThread {
	
	public static Logger log = LoggerFactory.getLogger(BusinessThread.class);			//建立日志
	//构建业务线程
	private static ExecutorService pool = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(100000));

	public static void doBusiness(final ChannelHandlerContext arg0, final MyMessage arg1, final ChannelGroup group, final int n,final float num) {
		
		//创建数据库连接项
		final MongoDBJDBC a = new MongoDBJDBC();
		
		pool.submit(new Runnable() {
			public void run() {	
		 
				if(n == 2){
					if(arg1.getHeader().getCmdId() == 1000){
						log.info("Client login request");
						//a.setaccount(arg1.getContent());
						MessageFactory MF = new MessageFactory();
						CreateMessage msg = null;
						int st = 1;
						//int st = a.run();
						if(st == 0){
							msg = MF.getMessage("账号错误");
						}
						else if(st == 1){
							msg = MF.getMessage("密码错误");
						}
						else if(st == 2){
						     msg = MF.getMessage("登录成功");
						}
						arg0.writeAndFlush(msg.getMessage());
					}
				} else if(n == 1){
					
					a.run2(arg1.getContent(), num);
				}		
			}
		});	
	}
}
