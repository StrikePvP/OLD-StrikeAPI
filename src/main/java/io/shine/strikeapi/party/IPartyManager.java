package io.shine.strikeapi.party;

import java.util.List;

public interface IPartyManager {
    /**
     * Get Party By ID
     * @param id Party's ID
     * @return Party
     */
    Party getParty(int id);

    /**
     * Create Party with id and owner
     * @param owner Player's UUID
     */
    void createParty(String owner);

    /**
     * Get party by the uuid of the owner or a member
     * @param player UUID of the Owner or a member
     * @return Party
     */
    Party getParty(String player);

    /**
     * If party exist by id
     * @param id Party's ID
     * @return Party exist or not
     */
    boolean isPartyExist(int id);

    /**
     * If player is in a party
     * @param player Player UUID
     * @return Player is in a party or not
     */
    boolean isInParty(String player);

    /**
     * Get all registered party
     * @return List of parties
     */
    List<Party> getParties();

}
