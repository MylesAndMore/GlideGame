package com.MylesAndMore.GlideGame.api;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/** Constants package for commonly referenced methods. */
public class Constants {
    public static final Plugin plugin() { return Bukkit.getServer().getPluginManager().getPlugin("GlideGame"); }
    public static final String permissionMessage() { return Constants.plugin().getConfig().getString("permissionMessage"); }
    public static final String lobby() { return Constants.plugin().getConfig().getString("lobby"); }
    public static final String game0() { return Constants.plugin().getConfig().getString("game0"); }
    public static final String game1() { return Constants.plugin().getConfig().getString("game1"); }
    public static final String game2() { return Constants.plugin().getConfig().getString("game2"); }
    public static final MultiverseCore mv() { return (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core"); }
    public static final MVWorldManager mvWorldManager() { return mv().getMVWorldManager(); }
}
