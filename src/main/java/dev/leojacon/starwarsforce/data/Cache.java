package dev.leojacon.starwarsforce.data;

import dev.leojacon.starwarsforce.manager.model.PlayerModel;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.LinkedHashMap;

public class Cache {

    @Getter
    public static LinkedHashMap<Player, PlayerModel> modelStorage = new LinkedHashMap<>();

}
