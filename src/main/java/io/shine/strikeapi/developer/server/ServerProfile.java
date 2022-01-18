package io.shine.strikeapi.developer.server;

public class ServerProfile {
	private String name;
	private int players;
	private boolean status, isprivate, bungee;
	
	public ServerProfile(String name, int players, boolean status, boolean isprivate, boolean isbungeecord) {
		this.name = name;
		this.players = players;
		this.status = status;
		this.isprivate = isprivate;
		this.bungee = isbungeecord;
	}
	
	public String getName() {
		return name;
	}

	public int getPlayers() {
		return players;
	}
	
	public boolean isOnline() {
		return status;
	}
	
	public boolean isPrivate() {
		return isprivate;
	}
	
	public boolean isBungeeCord() {
		return bungee;
	}
	
}
