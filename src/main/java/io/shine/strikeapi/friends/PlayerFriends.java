package io.shine.strikeapi.friends;

import java.util.List;
import java.util.UUID;

public abstract class PlayerFriends {
    private List<String> friends,requests;
    private UUID player;

    /**
     * Get Player's Friends
     * @return Player Friends
     */
    public List<String> getFriends() {
        return friends;
    }

    /**
     * Get Player's friends requests
     * @return Friends Requests
     */
    public List<String> getRequests() {
        return requests;
    }

    /**
     * Get Player UUID
     * @return Player's UUID
     */
    public UUID getPlayer() {
        return player;
    }

    /**
     * Check if two players are friends
     * @param uuid Player's UUID
     * @return If there are friends
     */
    public boolean areFriends(String uuid){
        return friends.contains(uuid);
    }

    /**
     * Check if the player receive a request from player
     * @param name Player's Name
     * @return If got request from
     */
    public boolean gotRequestFrom(String name){
        return requests.contains(name);
    }

    /**
     * Send request to player from another player
     * @param name Player's Name
     */
    public abstract void sendRequest(String name);

    /**
     * Add friend to player
     * @param uuid Player's UUID
     */
    public abstract void addFriend(String uuid);

    /**
     * Remove friend to player
     * @param uuid Player's UUID
     */
    public abstract void removeFriend(String uuid);
}
