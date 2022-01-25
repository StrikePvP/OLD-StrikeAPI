package io.shine.strikeapi;

import io.shine.strikeapi.achievement.IAchievementManager;
import io.shine.strikeapi.enums.SERVER;
import io.shine.strikeapi.party.IPartyManager;
import io.shine.strikeapi.player.IPlayerManager;
import io.shine.strikeapi.punishment.IPunishmentManager;
import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.ScheduledExecutorService;

public abstract class StrikeAPI {
    private JavaPlugin plugin;
    private static StrikeAPI api;

    public StrikeAPI(JavaPlugin plugin){
        this.plugin = plugin;
    }

    public static StrikeAPI get() {
        return api;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public abstract SERVER getType();

    public abstract JedisPool getUserPool();

    public abstract JedisPool getPartyPool();

    public abstract IAchievementManager getAchievementManager();

    public abstract IPartyManager getPartyManager();

    public abstract IPlayerManager getPlayerManager();

    public abstract ScheduledExecutorService getExecutor();

    public abstract String getServerName();

    public abstract IPunishmentManager getPunishmentManager();
}
