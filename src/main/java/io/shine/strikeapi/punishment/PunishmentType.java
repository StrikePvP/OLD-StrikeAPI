package io.shine.strikeapi.punishment;

public enum PunishmentType {
    MUTE(0),
    BAN(1),
    KICK(2);

    private int id;

    private PunishmentType(int id){
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
