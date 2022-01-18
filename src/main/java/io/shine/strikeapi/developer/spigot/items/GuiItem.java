package io.shine.strikeapi.developer.spigot.items;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GuiItem {
	
	private ItemStack it;
	private ItemCallBack ac;
	
	public GuiItem(ItemStack it) {
		this.it = it;
		this.ac = null;
	}
	
	public GuiItem(ItemStack it, ItemCallBack itc) {
		this.it = it;
		this.ac = itc;
	}
	
	public void run(InventoryClickEvent e) {
		if(ac == null) {
			e.setCancelled(true);
			return;
		}else {
			ac.run(e);
		}
	}
	
	public ItemStack getItemStack() {
		return it;
	}

}
