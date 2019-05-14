package messagefactory;

/**
 * 登录成功服务器返回的信息
 */

import mydecoder.MyHeader;
import mydecoder.MyMessage;

public class ServerReturnMessage1 implements CreateMessage{

	private String content = "登陆成功" ;
	public MyMessage getMessage() {
		
		MyHeader header = new MyHeader(content.length(), 101);	
		MyMessage message = new MyMessage(header, content);
		return message;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
