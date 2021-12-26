package dev.leojacon.starwarsforce.manager;

import dev.leojacon.starwarsforce.data.Cache;
import dev.leojacon.starwarsforce.manager.model.PlayerModel;
import org.bukkit.entity.Player;

public class Manager {

    public static PlayerModel getModel(Player player) {
        return Cache.getModelStorage().get(player);
    }

    public static boolean getForce(Player player) {
        return getModel(player).isHasForce();
    }

    public static void setForce(Player player, boolean force) {
        getModel(player).setHasForce(force);
    }

}
