package f_getTable;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.common.collect.Maps;

import f_getTable.table.LevelConfig;
import f_getTable.table.PlayerInfo;

public class ConfigService {
	
	public static Map<String,ConfigTable> tabs = Maps.newHashMap();
	
	//得到表中Id列表
	public static List<String> getConfigList(Class<?> cla){
		String tableName = cla.getName();
		ConfigTable t = getConfigTableByName(tableName);
		if(t == null) return null;
		
		return t.getIds();
	}
	
	//得到表中某一条
	@SuppressWarnings("unchecked")
	public static <T> T getConfigById(Class<T> cla,String id) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory f = mapper.getTypeFactory();
        f = f.withModifier(null);
        mapper.setTypeFactory(f);

        String s = getConfigTableByName(cla.getCanonicalName()).getContent().get(id).toString();
        
		return (T) mapper.readValue(s,cla);
	}
	
	//得到表的全部内容
	private static ConfigTable getConfigTableByName(String name){
		name = name.substring(name.lastIndexOf(".") + 1, name.length());
		if(tabs.containsKey(name)){
			return tabs.get(name);
		}
		
		ConfigTable c = GetTableValue.getConfigTable(name);
		if(c == null) return null;
		tabs.put(name, c);
		return c;
	}
}
