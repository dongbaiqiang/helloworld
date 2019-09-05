package e_cache;

import java.util.ArrayList;
import java.util.List;

import f_getTable.table.PlayerInfo;

public class PlayerRole {
	
	public String Id;
	public String passWord;
	public String name;
	public String level;
	public String nowExp;
	public String lastSignTime;
	
	PlayerRole(PlayerInfo info){
		this.Id = info.Id;
		this.passWord = info.passWord;
		this.name = info.name;
		this.level = info.level;
		this.nowExp = info.nowExp;
		this.lastSignTime = info.lastSignTime;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getNowExp() {
		return nowExp;
	}
	public void setNowExp(String nowExp) {
		this.nowExp = nowExp;
	}
	public String getLastSignTime() {
		return lastSignTime;
	}
	public void setLastSignTime(String lastSignTime) {
		this.lastSignTime = lastSignTime;
	}
	

	
}
