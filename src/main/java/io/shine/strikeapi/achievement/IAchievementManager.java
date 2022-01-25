package io.shine.strikeapi.achievement;

import io.shine.strikeapi.achievement.category.AchievementCategory;

import java.util.List;

public interface IAchievementManager {
    /**
     * Getting achievement by hit id
     * @param id Achievement's ID
     * @return Achievement
     */
    Achievement getAchievement(int id);

    /**
     * Register achievement into mongodb and cache
     * @param id Achievement's ID
     * @param name Achievement's name
     * @param category Achievement's category
     */
    void registerAchievement(int id, String name, AchievementCategory category);

    /**
     * Remove achievement from mongodb and cache
     * @param id Achievement's ID
     */
    void unRegisterAchievement(int id);

    /**
     * Get all achievements registered in cache
     * @return Achievements Cache List
     */
    List<Achievement> getAchievements();

    /**
     * Get all achievements by category
     * @param category Achievement's Categort
     * @return
     */
    List<Achievement> getAchievements(AchievementCategory category);

    /**
     * Load all Achievements
     */
    void loadAllAchievements();
}