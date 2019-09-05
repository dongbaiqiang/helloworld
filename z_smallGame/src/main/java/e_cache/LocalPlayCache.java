package e_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import f_getTable.ConfigService;
import f_getTable.table.PlayerInfo;
import io.netty.channel.ChannelHandlerContext;

public class LocalPlayCache {

    private static LoadingCache<String,PlayerRole> players = CacheBuilder.newBuilder()
            .maximumSize(20)  //最多存放5000个数据
            .expireAfterWrite(2, TimeUnit.HOURS)  //缓存2小时
            .recordStats()   //开启 记录状态数据功能
            .build(new CacheLoader<String,PlayerRole>() {
                //数据加载
                @Override
                public PlayerRole load(String key) throws Exception {
                	PlayerInfo info = ConfigService.getConfigById(PlayerInfo.class,key);
                	if(info == null) return null;
                    return new PlayerRole(info);
                }
            });
    private static Map<String,ChannelHandlerContext> onlinePlayerChannel = new HashMap<String, ChannelHandlerContext>();

	public static Map<String,ChannelHandlerContext> getOnlinePlayerChannel() {
		return onlinePlayerChannel;
	}

	public static void setOnlinePlayerChannel(Map<String,ChannelHandlerContext> onlinePlayerChannel) {
		LocalPlayCache.onlinePlayerChannel = onlinePlayerChannel;
	}

	public static void removePlayer(String id) {
		players.invalidate(id);
		if(onlinePlayerChannel.containsKey(id))  onlinePlayerChannel.remove(id);
	}

	public static LoadingCache<String, PlayerRole> getPlayers() {
		return players;
	}

	public static void main(String[] arg){
		
	}
	
}
