package io.shine.strikeapi.spigot;

import org.bukkit.plugin.java.JavaPlugin;

import io.shine.strikeapi.developer.APICore;
import io.shine.strikeapi.developer.spigot.FileBuilder;
import io.shine.strikeapi.redis.Redis;
import io.shine.strikeapi.spigot.events.ConnectionEvents;
import io.shine.strikeapi.spigot.events.GuiEvents;

public class StrikeAPISpigot extends JavaPlugin{
	
	private static APICore core;
	private FileBuilder fb;
	private static StrikeAPISpigot instance;
	private String name, priv;
	
	@Override
	public void onEnable() {
		fb = new FileBuilder("config.yml", this);
		if(!fb.isExists()) {
			fb.create();
			fb.setValue("redis.address", "localhost");
			fb.setValue("redis.password", "123456789");
			fb.setValue("server_name", "SpigotLOL");
			fb.setValue("server_isprivate", "0");
			fb.setValue("mongodb", "url");
		}
		core = new APICore(APICore.SERVERTYPE.SPIGOT, fb);
		Redis.initRedis(fb);
		getServer().getPluginManager().registerEvents(new ConnectionEvents(), this);
		getServer().getPluginManager().registerEvents(new GuiEvents(), this);
		name = fb.getString("server_name");
		priv = fb.getString("server_isprivate");
		updateServerRedis(0);
		instance = this;
	}
	
	public static StrikeAPISpigot getInstance() {
		return instance;
	}
	
	public void updateServerRedis(int players) {
		Redis.setData("server."+name, "players", String.valueOf(players));
		Redis.setData("server."+name, "status", "1");
		Redis.setData("server."+name, "bungeecord", "0");
		Redis.setData("server."+name, "private", priv);
	}
	
	public static APICore getCore() {
		return core;
	}
	
	@Override
	public void onDisable() {
		Redis.removeAllKeys("server"+name);
		core.getMongoDB().disconnect();
		Redis.disconnect();
	}

}
