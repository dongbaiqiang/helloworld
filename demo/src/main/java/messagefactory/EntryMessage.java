package messagefactory;

/**
 * 客户段请求输入时创建的信息
 */

import mydecoder.MyHeader;
import mydecoder.MyMessage;

public class EntryMessage implements CreateMessage{
	private String content = "A1P1E" ;
	
	public void setContent(String content){
		this.content = content;
	}
	public MyMessage getMessage() {
		
		MyHeader header = new MyHeader(content.length(), 1000);	
		MyMessage message = new MyMessage(header, content);
		return message;
	}

}
