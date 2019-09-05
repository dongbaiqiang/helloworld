package b_myDecoder;

public class MyMessage {

	private MessageHeader header;
	
	private String content;

	public MyMessage(MessageHeader header,String content){
		this.header = header;
		this.content = content;
	}
	
	public MessageHeader getHeader() {
		return header;
	}

	public void setHeader(MessageHeader header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
