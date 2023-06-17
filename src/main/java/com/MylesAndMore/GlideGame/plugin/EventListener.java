package com.MylesAndMore.GlideGame.plugin;

import com.MylesAndMore.GlideGame.game.Game;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Objects;

/** GlideGame event listener for all plugin and game-related events */
public class EventListener implements Listener {
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
