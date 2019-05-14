package mydecoder;

public class MyHeader {
	
    // 信息长度
    private int contentLength;
    // 服务名称
    private int cmdId;
 

    public MyHeader(int contentLength, int id) {
        
    	this.contentLength = contentLength;
        this.cmdId = id;
        
        
    }
 
    public int getContentLength() {
        return contentLength;
    }
 
    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }
 
    public int getCmdId() {
        return cmdId;
    }
 
    public void setCmdId(int id) {
        this.cmdId = id;
    }
}
