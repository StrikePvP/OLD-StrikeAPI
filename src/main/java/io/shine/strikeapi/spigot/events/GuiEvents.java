package io.shine.strikeapi.spigot.events;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import io.shine.strikeapi.developer.spigot.GuiBuilder;

public class GuiEvents implements Listener {
	public static HashMap<String, GuiBuilder> guicache = new HashMap<String, GuiBuilder>();
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(p == null) return;
		if(e.getCurrentItem() == null) return;
		if(e.getInventory() == null) return;
		if(e.getCurrentItem().getType() == Material.AIR) return;
		if(!guicache.containsKey(p.getName())) return;
		guicache.get(p.getName()).onExecute(e);
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		if(p == null) return;
		if(e.getInventory() == null) return;
		if(!guicache.containsKey(p.getName())) return;
		guicache.remove(p.getName());
	}
}
