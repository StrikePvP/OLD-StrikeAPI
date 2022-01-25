package io.shine.strikeapi.achievement.category;

public enum AchievementCategory {
    HUB(0),
    SECRET(1),
    SKYBLOCK(2);

    private int id;

    AchievementCategory(int id){
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
