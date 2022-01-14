package me.theigoro;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
               for (int i = 0; i < args.length; i++ ) {
                   message = message +" "+ args[i];
               }


               for (Player player : Bukkit.getOnlinePlayers()){
                   if (player.hasPermission("theistaff.chat")) {
                       player.sendMessage(message);
                   }
               }
           }



        }//comando /s
        return false;
    }
}
