package b_myDecoder;

public class MessageHeader {
	private int  msgId;
	
	private int msgLength;

	public MessageHeader(int msgId,int msgLength){
		this.msgId = msgId;
		this.msgLength = msgLength;
	}
	
	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public int getMsgLength() {
		return msgLength;
	}

	public void setMsgLength(int msgLength) {
		this.msgLength = msgLength;
	}
	
}
