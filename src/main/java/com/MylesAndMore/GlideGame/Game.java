package com.MylesAndMore.GlideGame;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.MylesAndMore.GlideGame.api.Constants;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Game {
    public void onGameStart(List<Player> players) {
        // for (Player player : players) {
        //     Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Constants.getPlugin(), () -> {
        //         int timer = 0;
        //         player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.toPlainText(timer));
        //         timer++;
        //     }, 0, 1);     
        // }

        // new BukkitRunnable() {
        //     public void run() {
                
        //     }
        // };
    }
}
