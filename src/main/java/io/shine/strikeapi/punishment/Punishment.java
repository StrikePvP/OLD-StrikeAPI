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

    /**
     * Get Type of Punishment
     * @return Type of Punishment
     */
    public PunishmentType getType() {
        return type;
    }

    /**
     * Get Reason of the Punishment
     * @return Reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Get Moderator who apply this Punishment
     * @return Moderator's UUID
     */
    public String getModerator() {
        return moderator;
    }

    /**
     * Get Started Time of the Punishment
     * @return Started Time
     */
    public long getStartedTime() {
        return starttime;
    }

    /**
     * If Punishment is permanent
     * @return Punishment is permanent or not
     */
    public boolean isPermanent() {
        return permanent;
    }

    /***
     * Set permanent or not
     */
    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    /***
     * Set Expire Time
     * @param expiretime Expire Time
     */
    public void setExpireTime(long expiretime) {
        this.expiretime = expiretime;
    }

    /***
     * Set reason of the Punishment
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /***
     * Get the UUID of the Punishment
     * @return UUID
     */
    public UUID getPunishmentUUID() {
        return punishmentuuid;
    }

    /***
     * Get the UUID of the person who get punish
     * @return Player's UUID
     */
    public UUID getPlayerUUID() {
        return playeruuid;
    }

    /***
     * Get Expire Time of the Punishment
     * @return Expire Time
     */
    public long getExpireTime() {
        return expiretime;
    }

    /***
     * Get Started Time of the Punishment
     * @return Started Time
     */
    public long getStartTime() {
        return starttime;
    }
}
