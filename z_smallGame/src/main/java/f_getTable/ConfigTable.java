package f_getTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

public class ConfigTable {

	private String tableName;
	private Map<String,JSONObject> content = Maps.newHashMap();
	public Map<String, JSONObject> getContent() {
		return content;
	}
	private List<String> Ids = new ArrayList<String>();
	public List<String> getIds() {
		return Ids;
	}
	public void setIds(List<String> ids) {
		Ids = ids;
	}
	public void setContent(Map<String, JSONObject> content) {
		this.content = content;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
