/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tehbeard.beardach.minequest.js;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import me.tehbeard.BeardAch.BeardAch;
import me.tehbeard.BeardAch.achievement.AchievementManager;
import me.tehbeard.BeardAch.achievement.AchievementPlayerLink;

/**
 * Recommended API for MineQuest 3 Javascript access.
 * to use:
 * <pre>
 * importPackage(Packages.com.tehbeard.beardach.minequest.js)
 * api = new AchievementAPI();
 * api.hasAchievement(plrName,achId)
 * </pre>
 * @author James
 */
public class AchievementAPI {

    private final AchievementManager manager;

    public AchievementAPI() {
        manager = BeardAch.self.getAchievementManager();
    }

    /**
     * Checks if a player has an achievement
     *
     * @param player
     * @param achievementId
     * @return
     */
    public boolean hasAchievement(String player, String achievementId) {
        List<AchievementPlayerLink> list = manager.getAchievements(player);
        for (AchievementPlayerLink ach : list) {
            if (ach.getSlug().equals(achievementId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a player has an achievement
     *
     * @param player
     * @param achievementId
     * @return
     */
    public Date getAchievementUnlockDate(String player, String achievementId) {
        List<AchievementPlayerLink> list = manager.getAchievements(player);
        for (AchievementPlayerLink ach : list) {
            if (ach.getSlug().equals(achievementId)) {
                Timestamp date = ach.getDate();
                return new Date(date.getTime());
            }
        }
        return null;
    }
}
