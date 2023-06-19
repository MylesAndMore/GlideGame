package com.MylesAndMore.GlideGame.plugin;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import org.bukkit.Bukkit;

/** Constants package for commonly referenced objects */
public class Plugin {
    public static org.bukkit.plugin.Plugin plugin() { return Bukkit.getServer().getPluginManager().getPlugin("GlideGame"); }
    public static String permissionMessage() { return Plugin.plugin().getConfig().getString("permissionMessage"); }
    public static String lobby() { return Plugin.plugin().getConfig().getString("lobby"); }
    public static String game0() { return Plugin.plugin().getConfig().getString("game0"); }
    public static String game1() { return Plugin.plugin().getConfig().getString("game1"); }
    public static String game2() { return Plugin.plugin().getConfig().getString("game2"); }

    public static MultiverseCore mv() { return (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core"); }
    public static MVWorldManager mvWorldManager() { return mv().getMVWorldManager(); }
}
