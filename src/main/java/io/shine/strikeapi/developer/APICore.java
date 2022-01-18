package io.shine.strikeapi.developer;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

import io.shine.strikeapi.developer.enums.Rank;
import io.shine.strikeapi.developer.spigot.FileBuilder;
import io.shine.strikeapi.mongodb.MongoDBManager;
import io.shine.strikeapi.objects.PlayerProfile;
import io.shine.strikeapi.redis.Redis;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class APICore {
	private static APICore instance;
	private SERVERTYPE stype;
	private HashMap<String, PlayerProfile> users;
	private MongoDBManager mongodb;
	private ArrayList<String> staffs;
	
	public APICore(SERVERTYPE s, FileBuilder fb) {
		instance = this;
		this.stype = s;
		String mongourl = fb.getString("mongodb");
		mongodb = new MongoDBManager();
		mongodb.initConnection(mongourl);
		this.users = new HashMap<String, PlayerProfile>();
		this.staffs = new ArrayList<>();
	}
	
	public APICore(SERVERTYPE s, String redisadd, String redispass, String mongourl) {
		instance = this;
		this.stype = s;
		Redis.initRedis(redisadd, redispass);
		mongodb = new MongoDBManager();
		mongodb.initConnection(mongourl);
		this.users = new HashMap<String, PlayerProfile>();
		this.staffs = new ArrayList<>();
	}
	
	public MongoDBManager getMongoDB() {
		return mongodb;
	}
	
	public static APICore getInstance() {
		return instance;
	}
	
	public enum SERVERTYPE {
		BUNGEECORD, SPIGOT;
	}
	
	public SERVERTYPE getServerType() {
		return stype;
	}
	
	public ArrayList<String> getStaffs() {
		return staffs;
	}
	
	public void saveUser(Object o) {
		if(stype == SERVERTYPE.BUNGEECORD) {
			ProxiedPlayer p = (ProxiedPlayer) o;
			PlayerProfile pp = users.get(p.getName());
			mongodb.saveUser(pp);
			Redis.removeAllKeys(p.getUniqueId().toString());
			users.remove(p.getName());
			if(staffs.contains(p.getName())) {
				staffs.remove(p.getName());
			}
			return;
		}else {
			Player p = (Player) o;
			if(staffs.contains(p.getName())) {
				staffs.remove(p.getName());
			}
			users.remove(p.getName());
		}
	}
	
	public void loadProfile(Object o) {
		if(stype == SERVERTYPE.BUNGEECORD) {
			ProxiedPlayer p = (ProxiedPlayer) o;
			PlayerProfile pp = mongodb.getPlayerProfile(p.getUniqueId().toString(), p.getName());
			users.put(p.getName(), pp);
			if(pp.getRank().getPower() >= Rank.ASSISTANT.getPower()) {
				staffs.add(p.getName());
			}
			return;
		}
	}
	
	public void loadProfile(String name, String uuid) {
		if(Redis.isExist(uuid, "coins")) {
			PlayerProfile pp = new PlayerProfile(uuid, name);
			pp.setRank(Integer.parseInt(Redis.getData(uuid, "rank")));
			if(pp.getRank().getPower() >= Rank.ASSISTANT.getPower()) {
				staffs.add(name);
			}
			users.put(name, pp);
			return;
		}else {
			PlayerProfile pp = mongodb.getPlayerProfile(uuid, name);
			if(pp.getRank().getPower() >= Rank.ASSISTANT.getPower()) {
				staffs.add(name);
			}
			users.put(name, pp);
		}
	}
	
	public PlayerProfile getProfile(String name) {
		if(users.containsKey(name)) {
			return users.get(name);
		}else {
			return null;
		}
	}
}
