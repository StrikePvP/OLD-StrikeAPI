package io.shine.strikeapi.developer.enums;

public enum Rank {
	JOUEUR(0, "§7Joueur", 0, "§7[Joueur]"),
	VIP(1, "§aVIP", 5, "§7[§aVIP§7]"),
	EXPERT(2, "§bExpert", 10, "§7[§bExpert§7]"),
	ELITE(3, "§dElite", 15, "§7[§dElite§7]"),
	MASTER(4, "§cMaster", 20, "§7[§cMaster§7]"),
	YOUTUBEUR(5, "§6Youtubeur", 25, "§7[§6YTB§7]"),
	BUILDEUR(6, "§2Buildeur", 30, "§7[§2Buildeur§7]"),
	ASSISTANT(7, "§9Assistant", 35, "§7[§9Helper§7]"),
	ASSISTANTE(8, "§9Assistante", 35, "§7[§9Helper§7]"),
	MODERATEUR(9, "§9Modérateur", 40, "§7[§9MOD§7]"),
	MODERATRICE(10, "§9Modératrice", 40, "§7[§9MOD§7]"),
	SMODERATEUR(11, "§5Modérateur+", 45, "§7[§5MOD+§7]"),
	SMODERATRICE(12, "§5Modératrice+", 45, "§7[§5MOD+§7]"),
	DEVELOPPEUR(13, "§aDéveloppeur", 50, "§7[§aDev§7]"),
	RESPONSABLE(14, "§3Responsable", 55, "§7[§3Resp§7]"),
	ADMIN(15, "§cAdministrateur", 60, "§7[§cAdmin§7]");
	private int id, power;
	private String prefix, prefixname;
	
	private Rank(int id, String prefix, int power, String prefixname) {
		this.id = id;
		this.power = power;
		this.prefix = prefix;
		this.prefixname = prefixname;
	}

	public int getID() {
		return id;
	}
	
	public String getPrefixName() {
		return prefixname;
	}
	
	public int getPower() {
		return power;
	}
	
	public String getPrefix() {
		return prefix;
	}
}
