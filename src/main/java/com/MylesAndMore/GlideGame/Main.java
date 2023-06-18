package com.MylesAndMore.GlideGame;

import com.MylesAndMore.GlideGame.plugin.EventListener;
import com.MylesAndMore.GlideGame.commands.StartGame;

import org.bstats.bukkit.Metrics;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    @Override
    public void onEnable() {
        // Register event listener, commands, and bStats data collection
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        this.getCommand("start").setExecutor(new StartGame());
        new Metrics(this, 17736);
        this.saveDefaultConfig(); // Save the default config file (packaged in the JAR)

        // TODO: add the update checker (already included in Gradle) once I have a spigot page set up

        Bukkit.getServer().getLogger().info("[GlideGame] GlideGame successfully enabled!");
    }
}
