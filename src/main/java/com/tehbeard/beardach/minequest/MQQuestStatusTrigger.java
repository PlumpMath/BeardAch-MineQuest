package com.tehbeard.beardach.minequest;

import com.google.gson.annotations.Expose;
import com.theminequest.api.Managers;
import com.theminequest.api.statistic.LogStatistic;
import com.theminequest.api.statistic.LogStatus;
import me.tehbeard.BeardAch.achievement.Achievement;
import me.tehbeard.BeardAch.achievement.triggers.ITrigger;
import me.tehbeard.BeardAch.dataSource.configurable.Configurable;
import me.tehbeard.BeardAch.dataSource.json.editor.EditorField;
import me.tehbeard.BeardAch.dataSource.json.editor.EditorFieldType;
import org.bukkit.entity.Player;

/**
 * 
 * @author James
 */
@Configurable(tag="MQQuestStatus",name="MineQuest quest status")
public class MQQuestStatusTrigger implements ITrigger{
    
    @Expose
    @EditorField(alias="quest Id",type=EditorFieldType.text)
    private String questId;
    
    @Expose
    @EditorField(alias = "Quest status",type = EditorFieldType.selection,options = "com.theminequest.api.statistic.LogStatus")
    private LogStatus status;
    

    public boolean checkAchievement(Player player) {
        LogStatistic questLog = Managers.getQuestStatisticManager().getQuestStatistic(player.getName(), questId, LogStatistic.class);
        if(questLog == null){return false;}
        return questLog.getStatus() == status;
    }

    public void configure(Achievement ach, String config) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void configure(Achievement ach) {
        
    }

    
}
