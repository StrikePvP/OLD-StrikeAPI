package io.shine.strikeapi.developer.spigot;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import io.shine.strikeapi.developer.spigot.items.GuiItem;
import io.shine.strikeapi.spigot.events.GuiEvents;

public abstract class GuiBuilder {
	private Inventory inv;
	private HashMap<Integer, GuiItem> items;
	private String name;
	private int rows;
	
	public GuiBuilder(String name, int rows) {
		this.name = name;
		this.items = new HashMap<>();
		this.rows = rows*9;
	}
	
	public void build(Player p) {
		inv = Bukkit.createInventory(null, rows, name);
		onBuild(p);
		GuiEvents.guicache.put(p.getName(), this);
		p.openInventory(inv);
	}
	
	public abstract void onBuild(Player p);
	
	public Inventory getInventort() {
		return inv;
	}
	
	public void setItem(int slot, GuiItem item) {
		inv.setItem(slot, item.getItemStack());
		items.put(slot, item);
	}
	
	public void onExecute(InventoryClickEvent e) {
		GuiItem clickeditem = items.get(e.getSlot());
		if(clickeditem == null) return;
		clickeditem.run(e);
	}
}
