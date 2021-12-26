package dev.leojacon.starwarsforce.manager.model;

import lombok.Data;
import org.bukkit.entity.Player;

@Data
public class PlayerModel {

    public final Player player;
    public boolean hasForce;

}
