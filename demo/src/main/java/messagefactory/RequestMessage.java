package messagefactory;

import mydecoder.MyHeader;
import mydecoder.MyMessage;

public class RequestMessage implements CreateMessage {

	private String content = "请求数据" ;
	public MyMessage getMessage() {
		
		MyHeader header = new MyHeader(content.length(), 1001);	
		MyMessage message = new MyMessage(header, content);
		return message;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
