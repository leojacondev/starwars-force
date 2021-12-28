package dev.leojacon.starwarsforce.event;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ForcePlayerEvent extends Event {

    @Getter
    public Player player;

    public ForcePlayerEvent(Player player) {
        this.player = player;
    }

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
