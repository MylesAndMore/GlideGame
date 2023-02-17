package com.MylesAndMore.GlideGame;

import com.MylesAndMore.GlideGame.api.Metrics;
import com.MylesAndMore.GlideGame.commands.StartGame;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    @Override
    public void onEnable() {
        // Register event listener, commands, and bStats data collection
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        this.getCommand("start").setExecutor(new StartGame());
        new Metrics(this, 17736);
        // Save the default config file (packaged in the JAR)
        this.saveDefaultConfig();
        // Init message
        Bukkit.getServer().getLogger().info("[GlideGame] GlideGame successfully enabled!");
    }
}