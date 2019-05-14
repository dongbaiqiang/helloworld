package messagefactory;

/**
 * 客户段心跳信息
 */

import mydecoder.MyHeader;
import mydecoder.MyMessage;

public class HeartMessage implements CreateMessage{
	private String content = "心跳信息";
	public void setContent(String content){
		this.content = content;
	}
	public MyMessage getMessage() {
		 
		MyHeader header = new MyHeader(content.length(), 1);	
		MyMessage message = new MyMessage(header, content);
		return message;
	}

}
