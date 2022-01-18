package io.shine.strikeapi.bungee.events;

import io.shine.strikeapi.bungee.StrikeAPIBungee;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ConnectionEvents implements Listener {
	@EventHandler
	public void onJoin(PostLoginEvent e) {
		ProxiedPlayer p = e.getPlayer();
		StrikeAPIBungee.getCore().loadProfile(p);
		StrikeAPIBungee.getInstance().updateServerRedis(ProxyServer.getInstance().getPlayers().size());
		return;
	}
	
	@EventHandler
	public void onQuit(PlayerDisconnectEvent e) {
		ProxiedPlayer p = e.getPlayer();
		StrikeAPIBungee.getCore().saveUser(p);
		StrikeAPIBungee.getInstance().updateServerRedis(ProxyServer.getInstance().getPlayers().size());
	}
}
