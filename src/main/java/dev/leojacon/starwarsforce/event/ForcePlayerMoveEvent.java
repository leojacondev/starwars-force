package dev.leojacon.starwarsforce.event;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerMoveEvent;

public class ForcePlayerMoveEvent extends PlayerMoveEvent {

    public ForcePlayerMoveEvent(Player player, Location from, Location to) {
        super(player, from, to);
    }

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
