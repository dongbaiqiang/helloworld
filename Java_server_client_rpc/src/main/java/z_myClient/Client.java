
package z_myClient;

import java.io.IOException;
import java.util.Scanner;

import b_myDecoder.*;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


public class Client {

	private String host;
	private int port=10101;
	
	public String clientName;
	
	public Client(String host, int port) {
	    this.host = host;
	    this.port = port;
	}
	
	public static void main(String[] args) throws IOException {
	    new Client("10.2.144.18", 10101).run();
	}
	
	public void run() throws IOException {
	    EventLoopGroup worker = new NioEventLoopGroup();
	    
	    
	
	    try {
	    	Bootstrap bootstrap = new Bootstrap();
	        bootstrap.group(worker);
	        bootstrap.channel(NioSocketChannel.class);
	        bootstrap.handler(new ClientIniter());
	
	        Channel channel = bootstrap.connect(host, port).sync().channel();
	        
	        
	        Scanner in=new Scanner(System.in);
	       
	        while(true){
	        	
	        	String name=in.nextLine();
	        	if(name.equals("NO")){
//	        		channel.close();
	        		break;
	        	}
	        	MyMessage msg = new MyMessage(new MessageHeader(1,name.length()),name);
	        	if(name.equals("add")){
	        		String a=in.nextLine();
	        		String b=in.nextLine();
	        		msg = new MyMessage(new MessageHeader(1,name.length()),a + " " + b);
	        	}
	        	
	        	
		        
		        
				channel.writeAndFlush(msg); 
	        }

			channel.closeFuture().sync();
			
	        
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	        System.exit(1);
	    }
	}
	
	
	

}
