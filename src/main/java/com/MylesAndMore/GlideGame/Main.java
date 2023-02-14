package com.MylesAndMore.GlideGame;

import com.MylesAndMore.GlideGame.api.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    @Override
    public void onEnable() {
        // Register the event listener
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        // Register commands
        // *crickets*

        // Save the default config file (packaged in the JAR)
        this.saveDefaultConfig();

        // Register bStats
        int pluginId = 17736;
        Metrics metrics = new Metrics(this, 17736);

        // Init message
        Bukkit.getServer().getLogger().info("[GlideGame] GlideGame successfully enabled!");
    }
}