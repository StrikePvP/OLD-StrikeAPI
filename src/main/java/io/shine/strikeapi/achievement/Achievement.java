package io.shine.strikeapi.achievement;

import io.shine.strikeapi.achievement.category.AchievementCategory;

public class Achievement {
    private int id;
    private String name;
    private AchievementCategory category;

    public Achievement(int id, String name, AchievementCategory category){
        this.id = id;
        this.name = name;
        this.category = category;
    }

    /**
     * Get the ID of the Achievement
     * @return Achievement's ID
     */
    public int getID() {
        return id;
    }

    /**
     * Get name of the Achievement
     * @return Achievement's Name
     */
    public String getName() {
        return name;
    }

    /**
     * Get category of the Achievement
     * @return Achievement's Category
     */
    public AchievementCategory getCategory() {
        return category;
    }
}
