package io.shine.strikeapi.bungee;

import java.io.File;
import java.io.IOException;

import io.shine.strikeapi.bungee.events.ConnectionEvents;
import io.shine.strikeapi.developer.APICore;
import io.shine.strikeapi.redis.Redis;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class StrikeAPIBungee extends Plugin{
	
	private static APICore core;
	private static StrikeAPIBungee instance;
	private String name, priv;
	
	@Override
	public void onEnable() {
		createFile();
		getProxy().getPluginManager().registerListener(this, new ConnectionEvents());
		core = new APICore(APICore.SERVERTYPE.BUNGEECORD, getConfig().getString("redis.address"), getConfig().getString("redis.password"), getConfig().getString("mongodb.url"));
		instance = this;
		name = getConfig().getString("server_name");
		priv = getConfig().getString("server_isprivate");
		updateServerRedis(0);
	}
	
	public static APICore getCore() {
		return core;
	}
	
	public void updateServerRedis(int players) {
		Redis.setData("server."+name, "players", String.valueOf(players));
		Redis.setData("server."+name, "status", "1");
		Redis.setData("server."+name, "bungeecord", "1");
		Redis.setData("server."+name, "private", priv);
	}
	
	public static StrikeAPIBungee getInstance() {
		return instance;
	}
	
	private void createFile() {
		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}
		File f = new File(getDataFolder(), "config.yml");
		if(!f.exists()) {
			try {
				f.createNewFile();
				Configuration config = getConfig();
				config.set("redis.address", "localhost");
				config.set("redis.password", "123");
				config.set("mongodb.url", "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false");
				config.set("server_name", "Proxy");
				config.set("server_isprivate", "0");
				saveConfig(config);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void onDisable() {
		Redis.removeAllKeys("server"+name);
		Redis.disconnect();
		core.getMongoDB().disconnect();
	}

  public Configuration getConfig() {
        try {
            return ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	    
    public void saveConfig(final Configuration config) {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, new File(getDataFolder(), "config.yml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
