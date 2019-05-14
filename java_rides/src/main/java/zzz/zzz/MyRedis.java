package zzz.zzz;

import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class MyRedis 
{
	public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost",6379);
        jedis.auth("123456");
        jedis.select(0);
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        
        jedis.set("nnn", "nnnnnnn");
        
		jedis.hset("mmm", "a", "aaa");
		jedis.hset("mmm", "b", "bbb");
		jedis.hset("mmm", "c", "ccc");
		jedis.hset("mmm", "d", "ddd");
        
		jedis.lpush("lll", "1");
		jedis.lpush("lll", "2");
		jedis.lpush("lll", "3");
		jedis.lpush("lll", "1");
		
		jedis.sadd("sss", "1");
		jedis.sadd("sss", "2");
		jedis.sadd("sss", "3");
		jedis.sadd("sss", "3");
		
		
		jedis.zadd("zzz", 1, "aa");
		jedis.zadd("zzz", 2, "bb");
		jedis.zadd("zzz", 3, "cc");
    }
}
