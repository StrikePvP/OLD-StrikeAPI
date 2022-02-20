package io.shine.plugin.spigot;

import io.shine.plugin.spigot.events.GuiEvents;
import org.bukkit.plugin.java.JavaPlugin;

public class APIPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GuiEvents(), this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }
}
