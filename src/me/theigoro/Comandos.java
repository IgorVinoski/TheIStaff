package me.theigoro;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.Console;
import java.util.ArrayList;


public class Comandos implements CommandExecutor, Listener {
    public static ArrayList<Player> AdminMode = new ArrayList<Player>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("admin")) {
            if (!(sender instanceof Player)) {
                Bukkit.getConsoleSender().sendMessage("Apenas JOGADORES podem executar esse comando.");
            } else {
                Player p = (Player)sender;
                if (!(sender.hasPermission("theistaff.admin"))) {
                    sender.sendMessage(ChatColor.RED + "Você precisa ser Admin ou superior para executar esse comando.");
                } else {
                    if(AdminMode.contains(p)){
                        AdminMode.remove(p);
                        Admin.AdminModeOFF(p);

                    }else{
                            AdminMode.add(p);
                            Admin.AdminModeON(p);
                    }
                }

            }
        }//comando /admin

        return false;
    }
}



