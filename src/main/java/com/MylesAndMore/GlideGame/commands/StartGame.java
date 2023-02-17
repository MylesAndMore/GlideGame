package com.MylesAndMore.GlideGame.commands;

import com.MylesAndMore.GlideGame.Game;
import com.MylesAndMore.GlideGame.api.Constants;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/** Force starts a GlideGame with an optional world. */
public class StartGame implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if sender has perms to run command
        if (sender.hasPermission("GlideGame.start")) {
            // check for a lobby world
            // check for args
            // if args, check if world exists
            // if not, check if there are worlds defined, randomize a world from list
            // check if game is starting already
            // if all checks pass,
            if (!Game.game().start(Bukkit.getServer().getWorld(Constants.lobby()).getPlayers())) {
                sender.sendMessage(ChatColor.RED + "An error occured while creating your game. Please try again later.");
            }
        } else {
            sender.sendMessage(ChatColor.RED + Constants.permissionMessage());
        }
        return true;
    }
}