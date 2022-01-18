package io.shine.strikeapi.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.shine.strikeapi.developer.OptionAPI;
import io.shine.strikeapi.developer.enums.OptionState;
import io.shine.strikeapi.developer.enums.Rank;
import io.shine.strikeapi.redis.Redis;

public class PlayerProfile {
	
	private String uuid;
	private String username;
	private Rank rank;
	
	public PlayerProfile(String uuid, String name) {
		this.uuid = uuid;
		this.username = name;
		setUsername(name);
	}
	
	public boolean isHaveFriends() {
		return Redis.isExist(uuid, "friends");
	}
	
	public ArrayList<String> getFriends(){
		String s = Redis.getData(uuid, "friends");
		ArrayList<String> friends = new ArrayList<String>();
		for(String f : s.split(",")) {
			friends.add(f);
		}
		return friends;
	}
	
	public void setFriends(ArrayList<String> friends) {
		String f = String.join(",", friends);
		Redis.setData(uuid, "friends", f);
	}
	
	public void setFriends(String friends) {
		Redis.setData(uuid, "friends", friends);
	}
	
	public String getUsername() {
		return username;
	}
	
	
	public String getUUID() {
		return uuid;
	}
	
	public int getDiscordID() {
		return Integer.parseInt(Redis.getData(uuid, "discordid"));
	}
	
	public Rank getRank() {
		return rank;
	}
	
	
	public int getCoins() {
		return Integer.parseInt(Redis.getData(uuid, "coins"));
	}
	
	public void setCoins(int coins) {
		Redis.setData(uuid, "coins", Integer.toString(coins));
	}
	
	public void setUsername(String username) {
		Redis.setData(uuid, "username", username);
	}
	
	public void setDiscordID(int discordid) {
		Redis.setData(uuid, "discordid", Integer.toString(discordid));
	}
	
	public void setRank(int rankid) {
		Redis.setData(uuid, "rank", Integer.toString(rankid));
		for(Rank r : Rank.values()) {
			if(r.getID() == rankid) {
				this.rank = r;
				break;
			}
		}
	}
	
	public HashMap<String, OptionState> getOptions() {
		HashMap<String, OptionState> options = new HashMap<String, OptionState>();
		Map<String, String> hmap = Redis.getAllKeys(uuid);
		for(String s : hmap.keySet()) {
			if(!s.startsWith("option.")) {
				continue;
			}
			options.put(s.split(".")[1], OptionAPI.getStateFromInt(Integer.parseInt(hmap.get(s))));
		}
		return options;
	}
	
	public HashMap<String, Integer> getOptionsINT() {
		HashMap<String, Integer> options = new HashMap<String, Integer>();
		Map<String, String> hmap = Redis.getAllKeys(uuid);
		for(String s : hmap.keySet()) {
			if(!s.startsWith("option.")) {
				continue;
			}
			options.put(s.split(".")[1], Integer.parseInt(hmap.get(s)));
		}
		return options;
	}
	
	public OptionState getOption(String s) {
		if(!Redis.isExist(uuid, "option."+s)) {
			Redis.setData(uuid, "option."+s, "2");
			return OptionState.ENABLE;
		}else {
			int i = Integer.parseInt(Redis.getData(uuid, "option."+s));
			return OptionAPI.getStateFromInt(i);
		}
	}
	
	public void setOption(String s, OptionState os) {
		Redis.setData(uuid, "option."+s, Integer.toString(os.getState()));
	}

}
