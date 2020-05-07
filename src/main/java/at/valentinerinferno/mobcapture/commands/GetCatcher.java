package at.valentinerinferno.mobcapture.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

public class GetCatcher implements CommandExecutor {

    String catcher;
    String catcherName;
    ArrayList<String> catcherLore;

    public GetCatcher(String catcher, String catcherName, ArrayList catcherLore) {
        this.catcher = catcher;
        this.catcherName = catcherName;
        this.catcherLore = catcherLore;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ItemStack catcherItem = new ItemStack(Material.STICK);
        ItemMeta itemMeta = catcherItem.getItemMeta();
        Objects.requireNonNull(itemMeta).setDisplayName(catcherName);
        itemMeta.setLore(catcherLore);
        catcherItem.setItemMeta(itemMeta);

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("mobcapture.give.catcher")) {
                player.getInventory().addItem(catcherItem);
                player.sendMessage(ChatColor.GREEN + "You got a Mob Catcher!");
            } else {
                player.sendMessage(ChatColor.RED + "You don't have permission!");
            }
        }

        return true;
    }
}
