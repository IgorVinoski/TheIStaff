package me.theigoro;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.theigoro.Admin.player;

public class StaffChat implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (command.getName().equalsIgnoreCase("s")) {
           if(args.length < 1){
               sender.sendMessage("§cUtilize /s <mensagem>");
               return true;
           }
           Player p = (Player) sender;

           if(!(sender.hasPermission("theistaff.chat"))){
               sender.sendMessage("§cVocê não tem permissão para executar esse comando.");
               return true;
           }
           else{
               String message = "[S] " + p.getDisplayName() + ":";
               StringBuilder msg = new StringBuilder(message);
               for (int i = 0; i < args.length; i++ )
                   msg.append(" " + args[i]);

               for (Player player : Bukkit.getOnlinePlayers()) {
                   if (player.hasPermission("theistaff.staff")) {
                       player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg.toString()));
                   }
               }



           }



        }//comando /s
        return false;
    }
}
