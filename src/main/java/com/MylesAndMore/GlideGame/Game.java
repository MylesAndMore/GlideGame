package com.MylesAndMore.GlideGame;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.MylesAndMore.GlideGame.api.Constants;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

/** Game class containing all methods modifying the GlideGame and its elements.  */
public class Game {
    private static Game game;
    /**
     * @return the Game object.
     */
    public static Game game() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    private String state;
    /**
     * @return The game's current state as a String ("waiting", "starting", "running", "complete")
     * Can also be null if not initialized.
     */
    public String state() { return state; }

    /**
     * Creates a new GlideGame.
     * @param players The players to create the game with
     * @param world The world to create the game in
     * @return true if the game succeeds creation, and false if not
     */
    public boolean start(List<Player> players, World world) {
        state = "starting";
        // Teleport players
        // List<Location> spawnLocations = new ArrayList<>(List.of(
        //     // TODO: make actual locations for each map
        //     new Location(Constants.game0(), 0, 0, 0)
        // ));
        // for (Player player : players) {
        //     player.teleport();
        // }

        // TODO: Game countdown
        // ...
        // TODO: Save timestamp of game starting
        // ...

        // TODO: make a sort of parallel list (I think hashmap?) that associates each game's player w/ their respective timer Bukkit task,
        // and save it in the game object to cancel later when they finish
        for (Player player : players) {
            BukkitTask pTimer = new BukkitRunnable() {
                int total;
                int ms;
                int s;
                int min;
                String format = String.format("%02d:%02d:%d", min, s, ms);

                @Override
                public void run() {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(format));
                    total++;
                    ms = total % 10;
                    s = (total / 10) % 60;
                    min = total / 600;
                    format = String.format("%02d:%02d:%d", min, s, ms);
                }
            }.runTaskTimer(Constants.plugin(), 0, 2);
        }
        state = "running";
        return true;
    }

    private Object Location(World world, int i, int j, int k) {
        return null;
    }
}
