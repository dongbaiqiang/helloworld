package client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import messagefactory.CreateMessage;
import messagefactory.MessageFactory;

public class Heart extends Thread{
	public static Logger log = LoggerFactory.getLogger(Heart.class);			//建立日志
	private Channel channel = null;
	
	public Heart(Channel channel){
		this.channel=channel;
	}
	
	public void run(){
		try {
			log.info("Send heart Message");	
			while(true){
				Thread.sleep(1000);
				MessageFactory MF = new MessageFactory();
		        CreateMessage msg = MF.getMessage("心跳信息");
		        msg.setContent("11111111");
				channel.writeAndFlush(msg.getMessage()); 
			}
		} catch (InterruptedException e) {
			log.error("异常",e);
		}
		
	}
}
