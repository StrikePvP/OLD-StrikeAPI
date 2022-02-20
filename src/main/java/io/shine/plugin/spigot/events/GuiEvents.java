package io.shine.plugin.spigot.events;

import io.shine.tools.spigot.gui.GUIManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiEvents implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(!(e.getWhoClicked() instanceof Player) || e.getCurrentItem() == null || e.getInventory() == null) return;
        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getInventory();
        ItemStack it = e.getCurrentItem();
        GUIManager.getPlayerGUI().computeIfPresent(p.getName(), (k, v) -> {
            e.setCancelled(true);
            v.onClick(p, inv, it);
            return v;
        });
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e){
        if(!(e.getPlayer() instanceof Player) || e.getInventory() == null) return;
        GUIManager.getPlayerGUI().computeIfPresent(e.getPlayer().getName(), (k,v) ->  {
            v.onClose((Player) e.getPlayer());
            GUIManager.getPlayerGUI().remove(e.getPlayer().getName());
            return v;
        });
    }
}
