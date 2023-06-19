package com.MylesAndMore.GlideGame.game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.MylesAndMore.GlideGame.plugin.Plugin;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

/** Contains all methods and elements relating to the GlideGame */
public class Game {
    private static List<Game> runningGames = new ArrayList<>();
    public static List<Game> getRunningGames() {
        return runningGames;
    }

    private String state;
    /**
     * @return The game's current state as a String ("waiting", "starting", "running", "complete")
     * Can also be null if not initialized.
     */
    public String getState() {
        return state;
    }

    /**
     * Creates a new GlideGame.
     * @param players The players to create the game with
     * @param world The world to create the game in
     * @return the new Game object if the game succeeds creation, and null if not
     */
    public Game start(List<Player> players, World world) {
        // TODO: Perform necessary game setup and initialization

        // TODO: Game countdown
        // ...

        // TODO: Save timestamp of game starting
        // ...

        // TODO: Make a sort of parallel list (e.g., HashMap) that associates each game's player
        // with their respective timer Bukkit task and save it in the game object to cancel later when they finish
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
            }.runTaskTimer(Plugin.plugin(), 0, 2);
        }

        state = "running";
        runningGames.add(this);
        return this;
    }
}
