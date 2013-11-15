/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tehbeard.beardach.minequest;

import com.tehbeard.beardach.minequest.js.AchievementAPI;
import com.theminequest.api.platform.entity.MQPlayer;
import com.theminequest.api.quest.QuestDetails;
import com.theminequest.api.requirement.QuestRequirement;

/**
 *
 * @author James
 */
public class AchUnlockedRequirement extends QuestRequirement{
    private String achId;
    private final AchievementAPI api;
    

    
    public AchUnlockedRequirement(){
        api = new AchievementAPI();
    }
    @Override
    public void parseDetails(String[] details) {
        if(details.length != 1){
            throw new IllegalArgumentException("Achievement unlock requirement should have 1 parameter, " + details.length + " found instead");
        }
        achId = details[0];
    }

    @Override
    public boolean isSatisfied(QuestDetails details, MQPlayer player) {
        return api.hasAchievement(player.getName(), achId);
    }
    
}
