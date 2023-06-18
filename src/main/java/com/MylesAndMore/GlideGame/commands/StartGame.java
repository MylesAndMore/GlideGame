package com.MylesAndMore.GlideGame.commands;

import com.MylesAndMore.GlideGame.game.Game;
import com.MylesAndMore.GlideGame.plugin.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/** Force starts a GlideGame with an optional world */
public class StartGame implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender.hasPermission("GlideGame.start")) {
            if (Constants.lobby() != null) {
                // Get a world to start in, either from config or from player
                World world = null;
                if (args.length == 0) {
                    // If no arguments were entered, check how many worlds are present in the config
                    List<World> worlds = new ArrayList<>();
                    if (Bukkit.getWorld(Constants.game0()) != null) { worlds.add(Bukkit.getWorld(Constants.game0())); }
                    if (Bukkit.getWorld(Constants.game1()) != null) { worlds.add(Bukkit.getWorld(Constants.game1())); }
                    if (Bukkit.getWorld(Constants.game2()) != null) { worlds.add(Bukkit.getWorld(Constants.game2())); }
                    if (worlds.size() == 0) {
                        sender.sendMessage(ChatColor.RED + "We couldn't find any valid worlds to load. Check the configuration file?");
                    }
                    else {
                        Collections.shuffle(worlds);
                        world = worlds.get(0);
                    }
                } else if (args.length == 1) {
                    // If an argument was entered, check if it's a real world
                    if (Bukkit.getWorld(args[0]) != null) {
                        world = Bukkit.getWorld(args[0]);
                    }
                } else {
                    // Unsupported # of args
                    return false;
                }
                // TODO: Make sure that world does not already have a game running in it
                if (world != null) {
                    // Create a new Game object and start it
                    if (new Game().start(Objects.requireNonNull(Bukkit.getServer().getWorld(Constants.lobby())).getPlayers(), world) == null) {
                        sender.sendMessage(ChatColor.RED + "An error occurred while creating your game. Please try again later.");
                    }
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + Constants.permissionMessage());
        }
        return true;
    }
}
