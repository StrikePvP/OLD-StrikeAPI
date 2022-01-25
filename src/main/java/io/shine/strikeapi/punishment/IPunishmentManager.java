package io.shine.strikeapi.punishment;

import java.util.List;
import java.util.UUID;

public interface IPunishmentManager {

    Punishment getPunishment(String uuid);

    List<Punishment> getPunishments(String uuid);

    void createPunishment(Punishment punishment);

    void removePunishment(UUID uuid);
}
