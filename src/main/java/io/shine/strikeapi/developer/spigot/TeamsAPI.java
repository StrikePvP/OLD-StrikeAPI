package io.shine.strikeapi.developer.spigot;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import io.shine.strikeapi.developer.enums.Rank;

public class TeamsAPI {
	private static HashMap<Integer, String> rankteams = new HashMap<Integer, String>();
	
	public static void registerRankTeams(Scoreboard sb) {
		String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		for(Rank r : Rank.values()) {
			Team t = sb.registerNewTeam(alphabet[(25-r.getID())]+"-"+r.getPrefix().replaceAll("§", "").replaceAll("\\+", "").toLowerCase().substring(0, 3));
			t.setPrefix(r.getPrefixName());
			rankteams.put(r.getID(), alphabet[(25-r.getID())]+"-"+r.getPrefix().replaceAll("§", "").replaceAll("\\+", "").toLowerCase().substring(0, 3));
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void joinTeam(Player p, Rank r, Scoreboard sb) {
		Team t = sb.getTeam(rankteams.get(r.getID()));
		t.addPlayer(p);
	}
}
