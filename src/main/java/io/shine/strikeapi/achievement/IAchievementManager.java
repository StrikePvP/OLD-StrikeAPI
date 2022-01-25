package io.shine.strikeapi.achievement;

import io.shine.strikeapi.achievement.category.AchievementCategory;

import java.util.List;

public interface IAchievementManager {
    Achievement getAchievement(int id);

    void registerAchievement(int id, String name);

    void unRegisterAchievement(int id);

    List<Achievement> getAchievements();

    List<Achievement> getAchievements(AchievementCategory category);

    void loadAllAchievements();
}
