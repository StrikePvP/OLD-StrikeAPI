package io.shine.strikeapi;

import io.shine.strikeapi.achievement.IAchievementManager;
import io.shine.strikeapi.enums.SERVER;
import io.shine.strikeapi.party.IPartyManager;
import io.shine.strikeapi.player.IPlayerManager;
import io.shine.strikeapi.punishment.IPunishmentManager;
import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class StrikeAPI {
    private JavaPlugin plugin;
    private static StrikeAPI api;
    private ScheduledExecutorService executor;

    public StrikeAPI(JavaPlugin plugin){
        this.plugin = plugin;
        this.executor = Executors.newScheduledThreadPool(32);
        api = this;
    }

    /**
     * Get instance loaded by core of the api
     * @return API instance
     */
    public static StrikeAPI get() {
        return api;
    }

    /**
     * Get plugin
     * @return Plugin
     */
    public JavaPlugin getPlugin() {
        return plugin;
    }

    /**
     * Get server type (BUNGEE OR SPIGOT)
     * @return BUNGEE OR SPIGOT
     */
    public abstract SERVER getType();

    /**
     * Get user pool
     * @return User Jedis Pool
     */
    public abstract JedisPool getUserPool();

    /**
     * Get party pool
     * @return Party Jedis Pool
     */
    public abstract JedisPool getPartyPool();

    /**
     * Get Achievement Manager
     * @return Achievement Manager
     */
    public abstract IAchievementManager getAchievementManager();

    /**
     * Get party manager
     * @return Party Manager
     */
    public abstract IPartyManager getPartyManager();

    /**
     * Get player manager
     * @return Player Manager
     */
    public abstract IPlayerManager getPlayerManager();

    /**
     * Get Scheduled Executor
     * @return Scheduled Executor
     */
    public ScheduledExecutorService getExecutor(){
        return executor;
    }

    /**
     * Get the name of the current server
     * @return Server Name
     */
    public abstract String getServerName();

    /**
     * Get punishement manager
     * @return Punishement Manager
     */
    public abstract IPunishmentManager getPunishmentManager();
}
