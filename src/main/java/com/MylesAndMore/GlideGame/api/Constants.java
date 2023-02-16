package com.MylesAndMore.GlideGame.api;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/** Constants package for commonly referenced methods. */
public class Constants {
    public static final Plugin getPlugin() {
        return Bukkit.getServer().getPluginManager().getPlugin("GlideGame");
    }
}
