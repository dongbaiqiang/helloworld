package mydecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class MyMessage {
	 
    private MyHeader Header;
    private String content;
 
    public MyMessage(MyHeader Header, String content) {
        this.Header = Header;
        this.content = content;
    }
 
    public MyHeader getHeader() {
        return Header;
    }
 
    public void setHeader(MyHeader Header) {
        this.Header = Header;
    }
 
    public String getContent() {
        return content;
    }
 
    public void setContent(String content) {
        this.content = content;
    }
 
    @Override
    public String toString() {
    	JSONObject wangxiaoer = new JSONObject();//new一个JSONObject对象，命名为wangxiaoer
 	    Object nullObj = null; //解决put中因二义性引起的编译错误
    	
 	   try {
 		   wangxiaoer.put("contentLength",Header.getContentLength());
 		   wangxiaoer.put("cmdId",Header.getCmdId());
 		   wangxiaoer.put("content",content);
 		   
 		   
		} catch (JSONException e) {
			e.printStackTrace();
		}
 	   return wangxiaoer.toString();
    }
}
