package com.MylesAndMore.GlideGame;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.MylesAndMore.GlideGame.api.Constants;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Game {
    public void onGameStart(List<Player> players) {
         for (Player player : players) {
             new BukkitRunnable() {
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
             }.runTaskTimer(Constants.getPlugin(),0, 2);
         }
    }
}
