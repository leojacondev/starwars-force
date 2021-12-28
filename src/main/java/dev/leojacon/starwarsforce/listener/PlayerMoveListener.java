package dev.leojacon.starwarsforce.listener;

import dev.leojacon.starwarsforce.event.ForcePlayerEvent;
import dev.leojacon.starwarsforce.manager.Manager;
import lombok.var;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void handlePlayerWithForce(PlayerMoveEvent event) {
        var player = event.getPlayer();
        var hasForce = Manager.getForce(player);
        if(hasForce) {
            Bukkit.getServer().getPluginManager().callEvent(new ForcePlayerEvent(player));
        }
    }

}
