package dev.leojacon.starwarsforce.schedule;

import dev.leojacon.starwarsforce.data.Cache;
import dev.leojacon.starwarsforce.event.ForcePlayerEvent;
import dev.leojacon.starwarsforce.manager.Manager;
import lombok.var;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ServerTickTask implements Runnable{

    //private long lastSecond = Long.MIN_VALUE;

    @Override
    public void run() {
            for(Player player : Cache.getModelStorage().keySet()) {
                var hasForce = Manager.getForce(player);
                if(hasForce) {
                    Bukkit.getServer().getPluginManager().callEvent(new ForcePlayerEvent(player));
                }
            }
    }

}
