package server;

/**
 * 启动服务器的类，为服务器设置基本属性：线程，连接的端口，socket等
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;



public class Server
{
	public static Logger log = LoggerFactory.getLogger(Server.class);			//建立日志
	public static ServerBootstrap bootstrap = new ServerBootstrap();			//建立服务类
    public static EventLoopGroup boss = new NioEventLoopGroup();				//建立boss监听端口请求类似线程池
    public static EventLoopGroup worker = new NioEventLoopGroup();			//建立worker用来处理事件
    private static int port=10101;
	public static void main(String[] args){
        try{
        	bootstrap.group(boss,worker);							//设置线程池，将建好的线程数池传入服务类
        	bootstrap.channel(NioServerSocketChannel.class);		//设置socket工厂
        	bootstrap.childHandler(new ServerIniter());				//为处理accept客户端的channel中的pipeline添加自定义处理函数
        	
        	bootstrap.option(ChannelOption.SO_BACKLOG, 2048);		//serverSocketchannel的设置，链接缓冲池的大小
			bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);//socketchannel的设置,维持链接的活跃，清除死链接
			bootstrap.childOption(ChannelOption.TCP_NODELAY, true);	//socketchannel的设置,关闭延迟发送
        	
			ChannelFuture future = bootstrap.bind(port);			//绑定端口
			log.info("server started sucessfully.");				
			future.channel().closeFuture().sync();    				//等待服务器关闭
        }catch(Exception e){
        	log.error("异常", e);
        }finally{
        	boss.shutdownGracefully();								//释放资源
        	worker.shutdownGracefully();	
        }  
    }
}
