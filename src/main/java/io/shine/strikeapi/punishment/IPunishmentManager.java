package io.shine.strikeapi.punishment;

import java.util.List;

public interface IPunishmentManager {
    /**
     * Get Punishment by hit UUID
     * @param uuid Punishment UUID
     * @return Punishment
     */
    Punishment getPunishment(String uuid);

    /**
     * Get all Punishments by Player's UUID
     * @param player Player's UUID
     * @return List of Punishment
     */
    List<Punishment> getPunishments(String player);

    /**
     * Create and save Punishment
     * @param punishment Punishment
     */
    void createPunishment(Punishment punishment);

    /**
     * Remove Punishment by UUID
     * @param uuid Punishment UUID
     */
    void removePunishment(String uuid);
}
