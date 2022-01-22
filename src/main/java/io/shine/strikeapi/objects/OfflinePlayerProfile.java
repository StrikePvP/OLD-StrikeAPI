package io.shine.strikeapi.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.shine.strikeapi.developer.OptionAPI;
import io.shine.strikeapi.developer.enums.OptionState;
import io.shine.strikeapi.developer.enums.Rank;

public class OfflinePlayerProfile {
	private String name, uuid;
	private int coins, discordid;
	private Rank rank;
	private Map<String, Integer> options;
	private ArrayList<String> friends;
	
	
	public OfflinePlayerProfile(String name, String uuid, int coins, int discordid, int rank) {
		this.name = name;
		this.uuid = uuid;
		this.discordid = discordid;
		this.coins = coins;
		this.options = new HashMap<String, Integer>();
		this.friends = new ArrayList<>();
		for(Rank r : Rank.values()) {
			if(r.getID() == rank) {
				this.rank = r;
				break;
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getUUID() {
		return uuid;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public int getDiscordID() {
		return discordid;
	}
	
	public Map<String, Integer> getOptions() {
		return options;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	public void setDiscordID(int discordid) {
		this.discordid = discordid;
	}
	
	public void setOption(String name, int status) {
		options.put(name, status);
	}
	
	public OptionState getOption(String name) {
		if(options.containsKey(name)) {
			return OptionAPI.getStateFromInt(options.get(name));
		}else {
			return OptionState.ENABLE;
		}
	}
	
	public void addFriend(String name) {
		if(friends.contains(name)) return;
		friends.add(name);
	}
	
	public void setFriends(String s) {
		friends.clear();
		for(String f : s.split(",")) {
			friends.add(f);
		}
	}
	
	public void removeFriend(String name) {
		if(!friends.contains(name)) return;
		friends.remove(name);
	}
	
	public ArrayList<String> getFriends() {
		return friends;
	}
}
