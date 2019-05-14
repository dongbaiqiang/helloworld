package messagefactory;
/**
 * 客户端超时断开连接服务器返回的信息
 */
import mydecoder.MyHeader;
import mydecoder.MyMessage;

public class CloseMessage implements CreateMessage{
	private String content = "断开连接" ;
	
	public void setContent(String content){
		this.content = content;
	}
	public MyMessage getMessage() {
		
		MyHeader header = new MyHeader(content.length(), 0);	
		MyMessage message = new MyMessage(header, content);
		return message;
	}

}
