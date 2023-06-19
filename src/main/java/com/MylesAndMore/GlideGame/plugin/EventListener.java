package com.MylesAndMore.GlideGame.plugin;

import com.MylesAndMore.GlideGame.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

/** GlideGame event listener for all plugin and game-related events */
public class EventListener implements Listener {
    // For hiding join messages & autostart
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        FileConfiguration config = Plugin.plugin().getConfig();
        // Hide/show join message accordingly
        if (!config.getBoolean("hideJoinLeaveMessages")) {
            event.setJoinMessage(null);
        }
        // Check if either of the worlds are not defined in config, if so, end to avoid any NPEs later on
        if (Plugin.game0() == null || Plugin.game1() == null || Plugin.game2() == null || Plugin.lobby() == null) {
            return;
        }

        Player player = event.getPlayer();
        World lobby = Bukkit.getWorld(Plugin.lobby());
        World game0 = Bukkit.getWorld(Plugin.game0());
        World game1 = Bukkit.getWorld(Plugin.game1());
        World game2 = Bukkit.getWorld(Plugin.game2());
        // Send the player back to the lobby if they try to join in the middle of a game
        if (player.getWorld().equals(game0) || player.getWorld().equals(game1) || player.getWorld().equals(game2)) {
            player.teleport(Objects.requireNonNull(lobby).getSpawnLocation());
        }
        // The autoStart should begin if it is already enabled and the amount of players is correct; pass this to the Game
        if (config.getBoolean("autoStart.enabled") && Objects.requireNonNull(Bukkit.getServer().getWorld(Plugin.lobby())).getPlayers().size() == config.getInt("autoStart.players")) {
            // TODO: autostart begins here when function complete
        }
    }

    // For autostart and cancel
    @EventHandler
    public void PlayerChangedWorldEvent(PlayerChangedWorldEvent event) {
        if (Plugin.game0() == null || Plugin.game1() == null || Plugin.game2() == null || Plugin.lobby() == null) {
            return;
        }
        if (event.getPlayer().getWorld() == Bukkit.getWorld(Plugin.lobby())) {
            if (Plugin.plugin().getConfig().getBoolean("autoStart.enabled")) {
                if (Objects.requireNonNull(Bukkit.getServer().getWorld(Plugin.lobby())).getPlayers().size() == Plugin.plugin().getConfig().getInt("autoStart.players")) {
                    // TODO: also autostart here
                }
            }
        }
        // Also check if the player left to another world and cancel autostart
        else if (event.getFrom() == Bukkit.getWorld(Plugin.lobby())) {
            // TODO: cancel autostart here
        }
    }

    // For hiding leave messages and autostart cancel
    @EventHandler
    public void PlayerQuitEvent(PlayerQuitEvent event) {
        // Hide/show leave message accordingly
        if (Plugin.plugin().getConfig().getBoolean("hideJoinLeaveMessages")) {
            event.setQuitMessage(null);
        }
        if (Plugin.lobby() == null) {
            return;
        }
        if (event.getPlayer().getWorld() == Bukkit.getWorld(Plugin.lobby())) {
            // TODO: also cancel autostart here
        }
    }

    // For game collision
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        for (Game game : Game.getRunningGames()) {
            if (Objects.equals(game.getState(), "running")) {
                if (event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
                    event.getPlayer().setHealth(0);
                } else if (event.getPlayer().getLocation().getBlock().getRelative(BlockFace.UP).getType() != Material.AIR) {
                    event.getPlayer().setHealth(0);
                } else if (event.getPlayer().getLocation().getBlock().getRelative(BlockFace.EAST).getType() != Material.AIR) {
                    event.getPlayer().setHealth(event.getPlayer().getHealth() - 1);
                } else if (event.getPlayer().getLocation().getBlock().getRelative(BlockFace.WEST).getType() != Material.AIR) {
                    event.getPlayer().setHealth(event.getPlayer().getHealth() - 1);
                } else if (event.getPlayer().getLocation().getBlock().getRelative(BlockFace.NORTH).getType() != Material.AIR) {
                    event.getPlayer().setHealth(event.getPlayer().getHealth() - 1);
                } else if (event.getPlayer().getLocation().getBlock().getRelative(BlockFace.SOUTH).getType() != Material.AIR) {
                    event.getPlayer().setHealth(event.getPlayer().getHealth() - 1);
                }
            } else if (Objects.equals(game.getState(), "starting")) {
                event.setCancelled(true);
            }
        }
    }
}
