package org.eilish.arcade.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.eilish.arcade.Arcade;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.eilish.arcade.Arcade;
import org.jetbrains.annotations.NotNull;

public class bwAdmin implements CommandExecutor {
    public bwAdmin(Arcade plugin){
        plugin.getCommand("bwa").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)){
            System.out.println("Данную команду нельзя использовать в консоли");
            return true;
        }

        Player player = (Player) commandSender;
        // /bws create Name
        // args = [0: create, 1: Name]
        if (player.isOp()){
            if (args[0].equalsIgnoreCase("create")){
                player.sendMessage(ChatColor.GREEN + "Арена создана!");
                player.playSound(player.getLocation(), Sound.AMBIENT_CAVE, 10, 10);
            }
        }
        else{
            System.out.println("ST > " + ChatColor.RED + "Данная команда недоступна.");
            return true;
        }
        return false;
    }
}
