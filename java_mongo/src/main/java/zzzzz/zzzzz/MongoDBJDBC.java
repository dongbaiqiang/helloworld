package zzzzz.zzzzz;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import static com.mongodb.client.model.Filters.*;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
public class MongoDBJDBC{
   public static void main( String args[] ){
      try{   
		  Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		  mongoLogger.setLevel(Level.SEVERE);
		  	// 连接到 mongodb 服务
		  MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		   
		  	// 连接到数据库
		  MongoDatabase mongoDatabase = mongoClient.getDatabase("User");  
		  System.out.println("Connect to database successfully");
		   
		   
		  	//创建集合
		  /*
		  mongoDatabase.createCollection("Account");
		  System.out.println("集合创建成功");
		  */
		   
		  	//获取集合
		  MongoCollection<Document> collection = mongoDatabase.getCollection("Account");
		  System.out.println("集合选择成功");
		   
		  	//插入
		  /*
		  Document document1 = new Document("account", 1).append("password", 1).append("name", "lili");  
		  Document document2 = new Document("account", 2).append("password", 2).append("name", "lilei");
		  List<Document> documents = new ArrayList<Document>();  
		  documents.add(document1); 
		  documents.add(document2); 
		  //插一个：collection.insertOne(document1);
		  collection.insertMany(documents);  
		  System.out.println("文档插入成功");
		  */
		  /* 
		  for(int i=0;i<10;i++){
			  collection.deleteMany(Filters.eq("account",i));
		  }
		  */
		  /*
		  for(int i=0;i<10;i++){
			  Document document1 = new Document("account", i).append("password", i).append("name", "lili" + i);
			  collection.insertOne(document1);
		  }
		  */
		  	//更新文档   将文档中likes=100的文档修改为likes=200   
		  //collection.updateMany(Filters.eq("account", 3), new Document("$set",new Document("account",1)));  
		  
		  	//删除符合条件的第一个文档  
		  //collection.deleteOne(Filters.eq("account",2));  
		  
		  	//删除所有符合条件的文档  
		  //collection.deleteMany (Filters.eq("likes", 200)); 
		  
		  	//检索所有文档
		  /*
		  FindIterable<Document> findIterable = collection.find();  
		  MongoCursor<Document> mongoCursor = findIterable.iterator();  
		 
		  while(mongoCursor.hasNext()){
			  
			  System.out.println(mongoCursor.next().get("account"));  
		  }  
		  */
		  
		  //查找符合条件的文档
		  //Document myDoc = collection.find(eq("account", 3)).projection;
		  //String a = myDoc.toJson();
		  //System.out.println(a);  
		  
		  BasicDBObject exclude = new BasicDBObject();  
	      exclude.append("_id", 0);  
	      exclude.append("name", 0);  
	      exclude.append("password", 0); 
	       
	      
          Document myDoc2 = collection.find(eq("password", "11111111")).projection(exclude).first(); 
          String a = myDoc2.toJson();
          System.out.println(a);
          
		  //查询文档数量
		  System.out.println(collection.count());
      }catch(Exception e){
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     }
   }
}
