package dev.leojacon.starwarsforce;

import dev.leojacon.starwarsforce.command.TheForceCommand;
import dev.leojacon.starwarsforce.listener.ConnectionListener;
import dev.leojacon.starwarsforce.listener.ForceListener;
import dev.leojacon.starwarsforce.schedule.ServerTickTask;
import lombok.Getter;
import lombok.var;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class StarWarsForce extends JavaPlugin {

    @Getter
    public static StarWarsForce instance;
    public static int FORCE_RANGE;
    public static int FORCE_POWER;
    public static String PERMISSION;

    @Override
    public void onLoad() {
        instance = this;
        saveDefaultConfig();
        FORCE_RANGE = getInstance().getConfig().getInt("force-range");
        FORCE_POWER = getInstance().getConfig().getInt("force-power");
        PERMISSION = getInstance().getConfig().getString("permission");
    }

    @Override
    public void onEnable() {
        registerCommands();
        registerEvents();
        getServer().getScheduler().runTaskTimer(this, new ServerTickTask(), 1L, 1L);
    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
    }

    public void registerCommands() {
        Objects.requireNonNull(getCommand("theforce")).setExecutor(new TheForceCommand());
    }

    public void registerEvents() {
        var pm = getServer().getPluginManager();
        pm.registerEvents(new ConnectionListener(), this);
        pm.registerEvents(new ForceListener(), this);
    }

}
