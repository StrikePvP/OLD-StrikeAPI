package io.shine.strikeapi.player;

public interface IPlayerManager {
    StrikePlayer getPlayer(String uuid);

    StrikePlayer loadPlayer(String uuid);

    void unloadPlayer(String uuid);
}
