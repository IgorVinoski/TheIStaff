package me.theigoro;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

import static me.theigoro.Admin.player;


public class Comandos implements CommandExecutor, Listener {
    public static ArrayList<Player> AdminMode = new ArrayList<Player>();
    public static ArrayList<String> WarnPlayer = new ArrayList<String>();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("admin")) {
            if (!(sender instanceof Player)) {
                Bukkit.getConsoleSender().sendMessage("Apenas JOGADORES podem executar esse comando.");
            } else {
                Player p = (Player) sender;
                if (!(sender.hasPermission("theistaff.admin"))) {
                    sender.sendMessage(ChatColor.RED + "Você precisa ser Admin ou superior para executar esse comando.");
                } else {
                    if (AdminMode.contains(p)) {
                        AdminMode.remove(p);
                        Admin.AdminModeOFF(p);

                    } else {
                        AdminMode.add(p);
                        Admin.AdminModeON(p);
                    }
                }

            }
        }//comando /admin
        if (command.getName().equalsIgnoreCase("warn")) {
            if (args.length <= 0) {
                sender.sendMessage("§cUtilize /warn <jogador> <motivo>");
                return true;
            }

            Player p = (Player) sender;
            if (!(sender.hasPermission("theistaff.warn"))) {
                sender.sendMessage("§cVocê não tem permissão para executar esse comando.");
                return true;
            } else {
                String motivo = "";
                for (int i = 1; i < args.length; i++) {
                    motivo = motivo + " " + args[i];
                    p.sendMessage("Você avisou o: " + Bukkit.getPlayer(args[0]).getName() + " por: " + motivo);
                    Bukkit.getPlayer(args[0]).sendTitle("§cVocê foi avisado por: " + sender.getName(), "Motivo: " + motivo, 1, 100, 1);
                    Bukkit.getPlayer(args[0]).sendMessage("§cVocê foi avisado por: " + sender.getName() + " Motivo: " + motivo);

                }
            }


        }//comando /warn

        if (command.getName().equalsIgnoreCase("caminhao")) {
            if (!(sender instanceof Player)) {
                Bukkit.getConsoleSender().sendMessage("Apenas JOGADORES podem executar esse comando.");
            }
        }




        return false;
    }
}





