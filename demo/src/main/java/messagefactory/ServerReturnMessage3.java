package messagefactory;

/**
 * 密码错误服务器返回的信息
 */

import mydecoder.MyHeader;
import mydecoder.MyMessage;

public class ServerReturnMessage3 implements CreateMessage{
	private String content = "密码错误" ;
	public MyMessage getMessage() {
		
		MyHeader header = new MyHeader(content.length(), 103);	
		MyMessage message = new MyMessage(header, content);
		return message;
	}

	public void setContent(String content) {
		this.content = content;
		
	}

}
