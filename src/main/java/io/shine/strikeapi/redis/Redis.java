package io.shine.strikeapi.redis;

import java.util.Map;

import io.shine.strikeapi.developer.spigot.FileBuilder;
import redis.clients.jedis.Jedis;

public class Redis {
	private static Jedis jedis;
	
	public static void initRedis(FileBuilder fb) {
		jedis = new Jedis(fb.getString("redis.address"), 6379, 5000);
		jedis.auth(fb.getString("redis.password"));
	}
	
	public static void initRedis(String address, String password) {
		jedis = new Jedis(address, 6379, 5000);
		jedis.auth(password);
	}
	
	public static void setData(String key, String subkey, String data) {
		jedis.hset(key, subkey, data);
	}
	
	public static String getData(String key, String subkey) {
		return jedis.hget(key, subkey);
	}
	
	public static void disconnect() {
		jedis.disconnect();
	}
	
	public static boolean isExist(String key, String subkey) {
		return jedis.hexists(key, subkey);
	}
	
	public static void removeKey(String key, String subkey) {
		jedis.hdel(key, subkey);
	}
	
	public static Map<String, String> getAllKeys(String key){
		return jedis.hgetAll(key);
	}
	
	public static void removeAllKeys(String key) {
		for(String s : jedis.hkeys(key)) {
			jedis.hdel(key, s);
		}
	}
	
}
