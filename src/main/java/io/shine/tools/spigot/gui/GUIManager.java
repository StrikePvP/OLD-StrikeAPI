package io.shine.tools.spigot.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class GUIManager {
    private static Map<String, AbstractGui> GUIS = new HashMap<>();
    private static Map<String, AbstractGui> playerGUI = new HashMap<>();

    public static void registerGUI(String ID, AbstractGui gui){
        GUIS.put(ID, gui);
    }

    public static void open(String id, Player p){
        AbstractGui gui = GUIS.get(id);
        Inventory inventory = Bukkit.createInventory(null, gui.getSlots(), gui.getName());
        gui.onOpen(inventory, p);
        p.openInventory(inventory);
        playerGUI.put(p.getName(), gui);
    }

    public static Map<String, AbstractGui> getGUIS() {
        return GUIS;
    }

    public static Map<String, AbstractGui> getPlayerGUI() {
        return playerGUI;
    }
}
