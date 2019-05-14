package businessthread;

/**
 * 负责对数据库进行操作的类
 */

import java.util.logging.Level;
//import java.util.logging.Logger;

import org.bson.Document;
//import org.slf4j.LoggerFactory;

import static com.mongodb.client.model.Filters.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDBJDBC{
	
	public String useraccount;
	public String userpassword;
	public static Logger log = LoggerFactory.getLogger(BusinessThread.class);			//建立日志
	
	public void setaccount(String s){
		useraccount = s.substring(s.indexOf("A")+1, s.indexOf("P"));
		userpassword = s.substring(s.indexOf("P") + 1,s.indexOf("E"));
	}
	
   public int run(){
	   
	   int a = 0;
      try{   
		  //Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		  //mongoLogger.setLevel(Level.SEVERE);
		  	// 连接到 mongodb 服务
		  MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		   
		  	// 连接到数据库
		  MongoDatabase mongoDatabase = mongoClient.getDatabase("User");  
		  if(mongoDatabase == null){
			  log.error("Connect to database unsuccessfully.");
		  }else{
			  log.info("Connect to database successfully.");
		  }	
		  	//获取集合
		  MongoCollection<Document> collection = mongoDatabase.getCollection("Account");
		  
		  	//查询想要的材料
		  BasicDBObject exclude = new BasicDBObject();  
	      exclude.append("_id", 0);  
	      exclude.append("name", 0);  
	      exclude.append("account", 0); 
	      
          Document myDoc2 = collection.find(eq("account", useraccount)).projection(exclude).first();
          
          String Mpassword = new String(); 
          for(int i=0;i<8;i++){
        	  Mpassword = Mpassword + myDoc2.toJson().charAt(16+i);
          } 
          
          if(myDoc2.toJson()==null){
        	  a = 0;
          }
          else if(userpassword.equals(Mpassword)){
        	  a = 2; 
          }
          else {
        	  a = 1;
          }
          
      }catch(Exception e){
        log.error(e.getClass().getName() + ": " + e.getMessage());
     }
	return a;
	
   }

public void run2(String name,float n) {
	 //Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
	  //mongoLogger.setLevel(Level.SEVERE);
	  	// 连接到 mongodb 服务
	  MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	   
	  // 连接到数据库
	  MongoDatabase mongoDatabase = mongoClient.getDatabase("User");  
	  if(mongoDatabase == null){
		  log.error("Connect to database unsuccessfully.");
	  }else{
		  log.info("Connect to database successfully.");
	  }

	  //获取集合
	  MongoCollection<Document> collection = mongoDatabase.getCollection("Account");
	  
	  
	  BasicDBObject exclude = new BasicDBObject();  
      exclude.append("_id", 0);  
      exclude.append("name", 0);  
      exclude.append("password", 0); 
      exclude.append("account", 0); 
      
      Document myDoc2 = collection.find(eq("account", name)).projection(exclude).first(); 
      String a = myDoc2.toJson();
      String b = a.substring(a.indexOf(":")+2, a.indexOf("}")-1);
      float num = Float.parseFloat(b);	  
	  collection.updateMany(Filters.eq("account", name), new Document("$set",new Document("experience",num + n)));
	
}
}
