package io.shine.strikeapi.player;

import io.shine.strikeapi.friends.PlayerFriends;
import io.shine.strikeapi.rank.Rank;
import io.shine.strikeapi.settings.SettingsState;

import java.util.ArrayList;
import java.util.List;

public abstract class StrikePlayer {
    private String uuid, name;
    private List<Integer> achievement, buyeditems;
    private int coins;
    private Rank rank;

    public StrikePlayer(String name, String uuid) {
        this.uuid = uuid;
        this.name = name;
        this.achievement = new ArrayList<>();
        this.buyeditems = new ArrayList<>();
    }

    /**
     * Get Player's Username
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get Player's Rank
     * @return Rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Get Player's Coins
     * @return
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Get Player's unlocked Achievements ID
     * @return
     */
    public List<Integer> getAchievements() {
        return achievement;
    }

    /**
     * Get Player's UUID
     * @return
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Unlock Achievement to Player
     * @param id
     */
    public abstract void addAchievement(int id);

    /**
     * Set Player's Coins
     * @param coins Coins
     */
    public abstract void setCoins(int coins);

    /**
     * Set Player's Rank
     * @param rank Rank
     */
    public abstract void setRank(Rank rank);

    /**
     * Get setting with default state
     * @param setting Setting ID
     * @param defaultstate Default State
     * @return
     */
    public abstract SettingsState getSetting(String setting, SettingsState defaultstate);

    /**
     * Get setting
     * @param setting Setting ID
     * @return
     */
    public abstract SettingsState getSetting(String setting);

    /**
     * Get player's friend
     * @return
     */
    public abstract PlayerFriends getFriends();

    /**
     * Get all buyed items
     * @return
     */
    public List<Integer> getBoughtItems() {
        return buyeditems;
    }

    /**
     * Add Buyed Item to Player by ID
     * @param items Item's ID
     */
    public abstract void addBuyedItem(int items);

    /**
     * Save player data
     * @param db Save in database ?
     */
    public abstract void save(boolean db);
}
