package io.shine.strikeapi.developer.spigot;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import io.shine.strikeapi.developer.spigot.items.GuiItem;
import io.shine.strikeapi.spigot.events.GuiEvents;

public class GuiBuilder {
	private String[] items;
	private HashMap<String, GuiItem> itemscode;
	private String name;
	
	public GuiBuilder(String name, String[] items) {
		this.name = name;
		this.items = items;
		this.itemscode = new HashMap<>();
	}
	
	public void build(Player p) {
		Inventory inv = Bukkit.createInventory(null, items.length, name);
		int i = 0;
		for(String s : items) {
			if(s == "") {
				i++;
				continue;
			}
			inv.setItem(i, itemscode.get(s).getItemStack());
			i++;
		}
		GuiEvents.guicache.put(p.getName(), this);
		p.openInventory(inv);
	}
	
	public void addItem(String code, GuiItem it) {
		itemscode.put(code, it);
	}
	
	public void onExecute(InventoryClickEvent e) {
		GuiItem clickeditem = itemscode.get(items[e.getSlot()]);
		if(clickeditem == null) return;
		clickeditem.run(e);
	}
}
