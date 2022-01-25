package io.shine.strikeapi.punishment;

import java.util.UUID;

public class Punishment {
    private boolean permanent;
    private UUID punishmentuuid, playeruuid;
    private String moderator, reason;
    private long starttime, expiretime;
    private PunishmentType type;

    public Punishment(UUID punishmentuuid, UUID playeruuid, String moderator, PunishmentType type, long starttime){
        this.playeruuid = playeruuid;
        this.punishmentuuid = punishmentuuid;
        this.moderator = moderator;
        this.type = type;
        this.permanent = false;
        this.starttime = starttime;
        this.reason = "Aucune raison";
    }

    public PunishmentType getType() {
        return type;
    }

    public String getReason() {
        return reason;
    }

    public String getModerator() {
        return moderator;
    }

    public long getStartedTime() {
        return starttime;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public void setExpireTime(long expiretime) {
        this.expiretime = expiretime;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public UUID getPunishmentUUID() {
        return punishmentuuid;
    }

    public UUID getPlayerUUID() {
        return playeruuid;
    }

    public long getExpireTime() {
        return expiretime;
    }

    public long getStartTime() {
        return starttime;
    }

}
