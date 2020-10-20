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
        Bukkit.getPluginManager().registerEvents(new Warn(), this);

        getCommand("admin").setExecutor(new Comandos());

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "TheIStaff foi inciado corretamente.");
    }


}
