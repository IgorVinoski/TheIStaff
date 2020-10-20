package me.theigoro;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;

import static me.theigoro.Comandos.AdminMode;

public class Admin implements Listener {
    public static Player player;



    @EventHandler
    public static void AdminModeON(Player p){
    p.setFoodLevel(20);
    p.setHealth(20);
    p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000000, 10));
    p.sendMessage(ChatColor.WHITE + "Modo ADMIN ativado.");
    p.setAllowFlight(true);
    p.setFlying(true);
    p.hidePlayer(p);
    p.sendTitle("","§aVocê ativou o modo §cADMIN",1,20,1);

    if(!(p.hasPermission("theistaff.viewinadmin"))) {
        for (int EmAdmin = 1; EmAdmin < AdminMode.size(); EmAdmin++) {

            p.sendTitle("", "" + EmAdmin + " staff estão com o modo Admin ativo.", 1, 20, 1);
        }
        p.showPlayer((Player) AdminMode);

    }


    }
    @EventHandler
public static void AdminModeOFF(Player p){
    p.sendMessage("Removido");
    p.setFlying(false);
    p.setAllowFlight(false);
    p.removePotionEffect(PotionEffectType.INVISIBILITY);
    p.showPlayer(p);

}


    @EventHandler
public static  void OnQuit(PlayerQuitEvent e){
        Player p = player;
        if(AdminMode.contains(e.getPlayer().getName()))
        AdminModeOFF(p);
        AdminMode.remove(e.getPlayer().getName());
}

}
