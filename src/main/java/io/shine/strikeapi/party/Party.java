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

    public List<String> getMembers() {
        return members;
    }

    public String getOwner() {
        return owner;
    }

    public int getID() {
        return id;
    }

    public abstract void teleportAllPlayer(String server);

    public abstract void sendMessage(String player, String msg);

    public abstract boolean isInParty(String player);

    public abstract void addPlayer(String player);

    public abstract void removePlayer(String player);

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
