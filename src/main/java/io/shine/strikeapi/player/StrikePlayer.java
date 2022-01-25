package io.shine.strikeapi.player;

import io.shine.strikeapi.rank.Rank;
import io.shine.strikeapi.settings.SettingsState;

import java.util.List;

public abstract class StrikePlayer {
    private String uuid, name;
    private List<Integer> achievement;
    private int coins;
    private Rank rank;

    public StrikePlayer(String name, String uuid) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Rank getRank() {
        return rank;
    }

    public int getCoins() {
        return coins;
    }

    public List<Integer> getAchievements() {
        return achievement;
    }

    public String getUUID() {
        return uuid;
    }

    public abstract void addAchievement(int id);

    public abstract void setCoins(int coins);

    public abstract void setRank(Rank rank);

    public abstract SettingsState getSettings(String settings, SettingsState defaultstate);

    public abstract SettingsState getSettings(String settings);

}
