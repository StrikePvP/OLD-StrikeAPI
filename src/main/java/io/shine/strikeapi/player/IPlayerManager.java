package io.shine.strikeapi.player;

public interface IPlayerManager {
    /**
     * Get player from cache
     * @param uuid Player's uuid
     * @return StrikePlayer
     */
    StrikePlayer getPlayer(String uuid);

    /**
     * Load player data into cache
     * @param uuid Player's uuid
     * @return StrikePlayer
     */
    StrikePlayer loadPlayer(String uuid);

    /**
     * Unload Player from cache and save it on redis or mongodb
     * @param uuid Player's uuid
     */
    void unloadPlayer(String uuid);

    /**
     * Update player to redis cache or mongodb
     * @param uuid Player's uuid
     */
    void updatePlayer(String uuid);
}
