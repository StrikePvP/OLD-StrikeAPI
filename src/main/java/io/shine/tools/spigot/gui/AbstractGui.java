package io.shine.tools.spigot.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractGui {
    private int slots;
    private String name;

    public AbstractGui(String name, int rows){
        this.name = name;
        this.slots = rows*9;
    }

    public abstract void onOpen(Inventory inv, Player p);

    public abstract void onUpdate(Inventory inv, Player p);

    public abstract void onClose(Player p);

    public abstract void onClick(Player p, Inventory inv, ItemStack it);

    public String getName() {
        return name;
    }

    public int getSlots() {
        return slots;
    }
}
