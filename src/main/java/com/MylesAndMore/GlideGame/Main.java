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

        // TODO: add an update checker for future-proofing
        // Both of these look like good options?
        // https://github.com/JEFF-Media-GbR/Spigot-UpdateChecker/tree/master
        // https://www.spigotmc.org/threads/an-actually-decent-plugin-update-checker.344327/
        // If it works well possibly add it to Tumble as well along with the music if possible

        Bukkit.getServer().getLogger().info("[GlideGame] GlideGame successfully enabled!");
    }
}
