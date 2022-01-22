package io.shine.strikeapi.developer.server;

import io.shine.strikeapi.redis.Redis;

public class ServerManager {
	public static ServerProfile getServer(String name) {
		if(Redis.isExist("server."+name, "players")) {
			int players = Integer.parseInt(Redis.getData("server."+name, "players"));
			boolean bungee = StringToBoolean(Redis.getData("server."+name, "bungeecord"));
			boolean status = StringToBoolean(Redis.getData("server."+name, "status"));
			boolean priv = StringToBoolean(Redis.getData("server."+name, "private"));
			return new ServerProfile(name, players, status, priv, bungee);
		}else {
			return new ServerProfile(name, 0, false, false, false);
		}
	}
	
	private static boolean StringToBoolean(String i) {
		if(i.equalsIgnoreCase("1")) {
			return true;
		}else {
			return false;
		}
	}
}
