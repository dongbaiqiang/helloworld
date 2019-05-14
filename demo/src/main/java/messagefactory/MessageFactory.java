package messagefactory;

/**
 * 工厂
 */

public class MessageFactory {

	public CreateMessage getMessage(String type){
		if(type == null){
	         return null;
	      }        
	      if(type.equalsIgnoreCase("请求登录")){
	         return new EntryMessage();
	      } else if(type.equalsIgnoreCase("业务请求")){
	         return new RequestMessage();
	      } else if(type.equalsIgnoreCase("登录成功")){
	         return new ServerReturnMessage1();
	      } else if(type.equalsIgnoreCase("账号错误")){
		         return new ServerReturnMessage2();
		  } else if(type.equalsIgnoreCase("密码错误")){
		         return new ServerReturnMessage3();
		  } else if(type.equalsIgnoreCase("心跳信息")){
		         return new HeartMessage();
		  } else if(type.equalsIgnoreCase("关闭连接")){
		         return new CloseMessage();
		  }
	      return null;
	}
}
