package io.shine.strikeapi.party;

import java.util.List;

public interface IPartyManager {
    Party getParty(int id);

    void createParty(String owner, int id);

    Party getParty(String player);

    boolean isPartyExist(int id);

    boolean isPartyExist(String player);

    List<Party> getParties();

}
