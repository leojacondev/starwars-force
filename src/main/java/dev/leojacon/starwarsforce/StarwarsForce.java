package dev.leojacon.starwarsforce;

import dev.leojacon.starwarsforce.command.TheForceCommand;
import dev.leojacon.starwarsforce.listener.ConnectionListener;
import dev.leojacon.starwarsforce.listener.ForceListener;
import dev.leojacon.starwarsforce.listener.PlayerMoveListener;
import lombok.Getter;
import lombok.var;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class StarwarsForce extends JavaPlugin {

    @Getter
    public static StarwarsForce instance;
    @Getter
    public static int FORCE_RANGE = 5;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
    }

    public void registerCommands() {
        Objects.requireNonNull(getCommand("theforce")).setExecutor(new TheForceCommand());
    }

    public void registerEvents() {
        var pm = getServer().getPluginManager();
        pm.registerEvents(new ConnectionListener(), this);
        pm.registerEvents(new ForceListener(), this);
        pm.registerEvents(new PlayerMoveListener(), this);
    }

}
