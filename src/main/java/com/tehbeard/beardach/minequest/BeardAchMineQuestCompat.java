package com.tehbeard.beardach.minequest;

import com.theminequest.api.Managers;
import me.tehbeard.BeardAch.dataSource.AchievementLoader;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author James
 */
public class BeardAchMineQuestCompat extends JavaPlugin{

    @Override
    public void onEnable() {
        getLogger().info("Installing MineQuest quest status trigger in BeardAch");
        AchievementLoader.triggerFactory.addProduct(MQQuestStatusTrigger.class);
        
        getLogger().info("Installing Achievement unlocked requirement in MineQuest");
        Managers.getRequirementManager().register("achunlock", AchUnlockedRequirement.class);
    }
    
    
    
}
