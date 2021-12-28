package dev.leojacon.starwarsforce.command;

import dev.leojacon.starwarsforce.StarWarsForce;
import dev.leojacon.starwarsforce.manager.Manager;
import dev.leojacon.starwarsforce.util.Messages;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TheForceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(isPlayer(sender)) {
            Player player = (Player) sender;
            if(hasPermission(player)) {
                if(Manager.getForce(player)) {
                    Manager.setForce(player, false);
                    player.sendMessage(Messages.FORCE_DISABLED);
                } else {
                    Manager.setForce(player, true);
                    player.sendMessage(Messages.FORCE_ENABLED);
                }
            } else {
                player.sendMessage(Messages.NO_PERMISSION);
            }

        } else {
            sender.sendMessage(ChatColor.RED + "Only players are allowed to use this command!");
        }

        return false;
    }

    protected boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(StarWarsForce.PERMISSION);
    }

    protected boolean isPlayer(CommandSender sender) {
        return (sender instanceof Player);
    }

}
