package io.shine.strikeapi.mongodb;

import java.util.ArrayList;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import io.shine.strikeapi.developer.OptionAPI;
import io.shine.strikeapi.objects.OfflinePlayerProfile;
import io.shine.strikeapi.objects.PlayerProfile;

public class MongoDBManager {
	
	private MongoClient client;
	private MongoDatabase database;
	private MongoCollection<Document> users;
	
	public void initConnection(String url) {
		client = MongoClients.create(url);
		database = client.getDatabase("strikepvp");
		users = database.getCollection("players");
	}
	
	public void disconnect() {
		client.close();
	}
	
	public Document getDocumentFromPlayerUUID(String uuid) {
		return users.find(Filters.eq("uuid", uuid)).first();
	}
	
	public Document getDocumentFromPlayerName(String name) {
		return users.find(Filters.eq("name", name)).first();
	}
	
	public PlayerProfile getPlayerProfile(String uuid, String name) {
		PlayerProfile pp = new PlayerProfile(uuid, name);
		Document d = getDocumentFromPlayerUUID(uuid);
		if(d == null) {
			pp.setCoins(100);
			pp.setDiscordID(0);
			pp.setRank(0);
			Document nd = new Document().append("uuid", uuid)
					.append("name", name)
					.append("coins", 100)
					.append("rank", 0)
					.append("discordid", 0);
			users.insertOne(nd);
			return pp;
		}else {
			pp.setCoins(d.getInteger("coins"));
			pp.setDiscordID(d.getInteger("discordid"));
			pp.setRank(d.getInteger("rank"));
			if(d.containsKey("friends")) {
				pp.setFriends(d.getString("friends"));
			}
			if(d.containsKey("options")) {
				Document od = (Document) d.get("options");
				for(String k : od.keySet()) {
					int v = (Integer) od.get(k);
					pp.setOption(k, OptionAPI.getStateFromInt(v));
				}
			}
			
		}
		return pp;
	}
	
	public void saveUser(PlayerProfile pp) {
		Document d = new Document().append("uuid", pp.getUUID())
				.append("name", pp.getUsername())
				.append("coins", pp.getCoins())
				.append("rank", pp.getRank().getID())
				.append("discordid", pp.getDiscordID());
		Map<String, Integer> options = pp.getOptionsINT();
		if(!options.isEmpty()) {
			d.append("options", options);
		}
		if(pp.isHaveFriends()) {
			ArrayList<String> friends = pp.getFriends();
			if(!friends.isEmpty()) {
				d.append("friends", String.join(",", friends));
			}
		}
		users.replaceOne(Filters.eq("uuid", pp.getUUID()), d);
	}
	
	public void saveUser(OfflinePlayerProfile pp) {
		Document d = new Document().append("uuid", pp.getUUID())
				.append("name", pp.getName())
				.append("coins", pp.getCoins())
				.append("rank", pp.getRank().getID())
				.append("discordid", pp.getDiscordID());
		Map<String, Integer> options = pp.getOptions();
		if(!options.isEmpty()) {
			d.append("options", options);
		}
		if(!pp.getFriends().isEmpty()) {
			ArrayList<String> friends = pp.getFriends();
			if(!friends.isEmpty()) {
				d.append("friends", String.join(",", friends));
			}
		}
		users.replaceOne(Filters.eq("name", pp.getName()), d);
	}
	
	public MongoClient getClient() {
		return client;
	}
	
	public OfflinePlayerProfile getPlayerProfile(String name) {
		Document d = getDocumentFromPlayerName(name);
		if(d == null) {
			return null;
		}else {
			int coins = d.getInteger("coins");
			int discordid = d.getInteger("discordid");
			int rank = d.getInteger("rank");
			String uuid = d.getString("uuid");
			OfflinePlayerProfile pp = new OfflinePlayerProfile(name, uuid, coins, discordid, rank);
			if(d.containsKey("friends")) {
				pp.setFriends(d.getString("friends"));
			}
			if(d.containsKey("options")) {
				Document od = (Document) d.get("options");
				for(String k : od.keySet()) {
					int v = (Integer) od.get(k);
					pp.setOption(k, v);
				}
			}
			return pp;
			
		}
	}
	
}
