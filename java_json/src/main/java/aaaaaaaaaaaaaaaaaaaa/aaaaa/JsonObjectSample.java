package aaaaaaaaaaaaaaaaaaaa.aaaaa;

import org.json.JSONException;
import org.json.JSONObject;
public class JsonObjectSample{

    public static void main(String[] args){
        jSONObject();
    }

	private static void jSONObject(){
	    JSONObject wangxiaoer = new JSONObject();//new一个JSONObject对象，命名为wangxiaoer
	    Object nullObj = null; //解决put中因二义性引起的编译错误
	    try{
	        wangxiaoer.put("name","王小二");
	        wangxiaoer.put("age",25.2);
	        wangxiaoer.put("birthday","1990-01-01");
	        wangxiaoer.put("school","蓝翔");
	        wangxiaoer.put("major",new String[] {"理发","挖掘机"});
	        wangxiaoer.put("has_girlfriend",false);
	        wangxiaoer.put("car",nullObj);
	        wangxiaoer.put("house",nullObj);
	        System.out.println(wangxiaoer.toString());//输出JSON格式的wangxiaoer数据
	    }catch(JSONException e){
	        e.printStackTrace();
	    }
	}
	
}
