package me.theigoro;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(new Comandos(), this);
        Bukkit.getPluginManager().registerEvents(new Admin(), this);

        getCommand("admin").setExecutor(new Comandos());
        getCommand("warn").setExecutor(new Comandos());

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "TheIStaff foi inciado corretamente.");
    }


}
