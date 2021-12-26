package dev.leojacon.starwarsforce.listener;

import dev.leojacon.starwarsforce.data.Cache;
import dev.leojacon.starwarsforce.manager.model.PlayerModel;
import lombok.var;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {

    @EventHandler
    public void createPlayerModel(PlayerJoinEvent event) {
        var model = new PlayerModel(event.getPlayer());
        Cache.getModelStorage().put(event.getPlayer(), model);
    }

    @EventHandler
    public void deletePlayerModel(PlayerQuitEvent event) {
        Cache.getModelStorage().remove(event.getPlayer());
    }

}
