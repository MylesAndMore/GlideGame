package com.MylesAndMore.GlideGame;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * GlideGame event listener for all plugin and game-related events.
 */
public class EventListener implements Listener {
    // A crude representation of how the speed boosts will work
    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent event) {
        // if player is in a speed zone:
        event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().multiply(10));
        // if player touches the GROUND (not the walls!)
        // d i e

        // if a player touches a wall or ceiling
        // take away one "life"
    }
}