package io.shine.strikeapi.spigot.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import io.shine.strikeapi.spigot.StrikeAPISpigot;

public class ConnectionEvents implements Listener {
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onJoin(AsyncPlayerPreLoginEvent e) {
		StrikeAPISpigot.getCore().loadProfile(e.getName(), e.getUniqueId().toString());
		StrikeAPISpigot.getInstance().updateServerRedis(Bukkit.getOnlinePlayers().size());
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		StrikeAPISpigot.getCore().saveUser(p);
		StrikeAPISpigot.getInstance().updateServerRedis(Bukkit.getOnlinePlayers().size());
	}

}
