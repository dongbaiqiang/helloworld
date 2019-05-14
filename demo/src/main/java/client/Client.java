package client;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import messagefactory.CreateMessage;
import messagefactory.MessageFactory;
import server.Server;

public class Client {
private String host;
private int port=10101;
public static Logger log = LoggerFactory.getLogger(Client.class);			//建立日志

public String clientName;

public Client(String host, int port) {
    this.host = host;
    this.port = port;
}

public static void main(String[] args) throws IOException {
    new Client("127.0.0.1", 10101).run();
}

public void run() throws IOException {
    EventLoopGroup worker = new NioEventLoopGroup();
    
    

    try {
    	Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ClientIniter());

        Channel channel = bootstrap.connect(host, port).sync().channel();
        
        
        MessageFactory MF = new MessageFactory();
        
        CreateMessage msg = MF.getMessage("请求登录");
        
        msg.setContent("A11111111P11111111E");
        
		channel.writeAndFlush(msg.getMessage()); 
		
		
		
		
		
		channel.closeFuture().sync();
		
        
    } catch (InterruptedException e) {
        e.printStackTrace();
        System.exit(1);
    }
}



}
