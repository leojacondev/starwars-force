package dev.leojacon.starwarsforce.util;

import dev.leojacon.starwarsforce.StarWarsForce;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Messages {

    public static FileConfiguration config = StarWarsForce.getInstance().getConfig();

    public static String NO_PERMISSION = t(config.getString("command-no-permission"));
    public static String FORCE_ENABLED = t(config.getString("command-force-enabled"));
    public static String FORCE_DISABLED = t(config.getString("command-force-disabled"));

    public static String t(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
