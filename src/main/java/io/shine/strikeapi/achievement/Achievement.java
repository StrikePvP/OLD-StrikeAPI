package io.shine.strikeapi.achievement;

import io.shine.strikeapi.achievement.category.AchievementCategory;

public class Achievement {
    private int id;
    private String name;

    public Achievement(int id, String name, AchievementCategory category){
        this.id = id;
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }
}
