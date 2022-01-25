package io.shine.strikeapi.party;

import java.util.ArrayList;
import java.util.List;

public abstract class Party {
    private int id;
    private List<String> members;
    private String owner;

    public Party(int id, String owner){
        this.id = id;
        this.owner = owner;
        this.members = new ArrayList<>();
    }

    /**
     * Get Members of the Party
     * @return Party's Members (UUID)
     */
    public List<String> getMembers() {
        return members;
    }

    /**
     * Get Party's Owner UUID
     * @return Party's Owner UUID
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Get ID of the Party
     * @return Party's ID
     */
    public int getID() {
        return id;
    }

    /**
     * Teleport All Players to a specific server
     * @param server Server's name
     */
    public abstract void teleportAllPlayers(String server);

    /**
     * Send message to Party's chat
     * @param player Player's Name
     * @param msg Message
     */
    public abstract void sendMessage(String player, String msg);

    /**
     * If Player is Member of the Party
     * @param player Player's UUID
     * @return Is Member of the Party
     */
    public abstract boolean isInParty(String player);

    /**
     * Add Player to Party
     * @param player Player's UUID
     */
    public abstract void addPlayer(String player);

    /**
     * Remove player to Party
     * @param player Player's UUID
     */
    public abstract void removePlayer(String player);

    /**
     * Set new Owner to the Party
     * @param owner Owner's UUID
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
}
