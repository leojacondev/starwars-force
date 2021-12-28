package dev.leojacon.starwarsforce.listener;

import dev.leojacon.starwarsforce.StarWarsForce;
import dev.leojacon.starwarsforce.event.ForcePlayerEvent;
import lombok.var;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class ForceListener implements Listener {

    @EventHandler
    public void onMove(ForcePlayerEvent event) {
        var p = event.getPlayer();
        var range = StarWarsForce.FORCE_RANGE;
        var attackedPlayer = getPlayerInSight(p, range);

        if(attackedPlayer != null) {
            attackedPlayer.setVelocity(p.getLocation().getDirection().multiply(StarWarsForce.FORCE_POWER * 0.1));
        }

    }

    public Player getPlayerInSight(Player player, int range) {
        List<Entity> nearbyEntities = player.getNearbyEntities(range, range, range);
        List<Block> bSight = player.getLineOfSight(null, range);
        ArrayList<Location> sightLocs = new ArrayList<>();

        //Filtering Players
        nearbyEntities.removeIf(entity -> (!(entity instanceof Player)));

        //Populate Sight Locations
        bSight.forEach(block -> sightLocs.add(block.getLocation()));

        return detectPlayer(nearbyEntities, sightLocs);
    }

    public Player detectPlayer(List<Entity> entities, List<Location> locations) {
        for (Location sight : locations) {
            for (Entity entity : entities) {
                if (Math.abs(entity.getLocation().getX() - sight.getX()) < 1.3) {
                    if (Math.abs(entity.getLocation().getY() - sight.getY()) < 1.5) {
                        if (Math.abs(entity.getLocation().getZ() - sight.getZ()) < 1.3) {
                            return (Player) entity;
                        }
                    }
                }
            }
        }
        return null;
    }
}
