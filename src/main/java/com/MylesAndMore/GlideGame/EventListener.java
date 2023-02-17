package com.MylesAndMore.GlideGame;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * GlideGame event listener for all plugin and game-related events.
 */
public class EventListener implements Listener {
    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent event) {
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
    }

    // A crude representation of how the speed boosts will work
        // if player is in a speed zone:
        //event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().multiply(10));
        
        // if player touches the GROUND (not the walls!)
        // d i e

        // if a player touches a wall or ceiling
        // take away one "life"
}