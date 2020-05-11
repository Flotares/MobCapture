package at.valentinerinferno.mobcapture.events;

import at.valentinerinferno.mobcapture.utils.Util;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

public class PlayerInteractEntity implements Listener {


    private String catcherName;
    private ArrayList<String> catcherLore;
    private ArrayList<String> mobs;

    public PlayerInteractEntity(String catcherName, ArrayList catcherLore, ArrayList<String> mobs) {
        this.catcherName = catcherName;
        this.catcherLore = catcherLore;
        this.mobs = mobs;
    }

    @EventHandler
    public void onPlayerEntityInteract(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        Entity entity = e.getRightClicked();

        ItemStack spawnegg = new ItemStack(getSpawnEggFromEntity(entity));
        ItemMeta spawnMeta = spawnegg.getItemMeta();
        spawnMeta.setDisplayName(ChatColor.AQUA + "Captured " + entity.getName());
        spawnegg.setItemMeta(spawnMeta);

        ItemStack captureItem = new ItemStack(Material.STICK);
        ItemMeta itemMeta = captureItem.getItemMeta();
        itemMeta.setLore(catcherLore);
        itemMeta.setDisplayName(catcherName);
        captureItem.setItemMeta(itemMeta);

        //Difference between left and right click
        if (e.getHand().equals(EquipmentSlot.OFF_HAND)) {
            //if the the main hand isn't null which means if the player holds some item
            if(player.getInventory().getItemInMainHand() != null){
                //If the player has the same item with the same name in the hand which is set in the config
                if (player.getInventory().getItemInMainHand().isSimilar(captureItem)
                        && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(catcherName)
                        && player.getInventory().getItemInMainHand().getItemMeta().getLore().equals(catcherLore)) {

                    player.getInventory().removeItem(captureItem);

                    if (Util.isPassive(entity)) {
                        if (player.hasPermission("mobcapture.passive")) {
                            if (mobs.contains(entity.getName().toLowerCase())) {
                                player.getInventory().addItem(spawnegg);
                                player.sendMessage(ChatColor.AQUA + "You just captured a(n): " + entity.getName());
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have permission!");
                        }
                    } else if (Util.isNeutral(entity)) {
                        if (player.hasPermission("mobcapture.neutral")) {
                            if (mobs.contains(entity.getName().toLowerCase())) {
                                player.getInventory().addItem(spawnegg);
                                player.sendMessage(ChatColor.AQUA + "You just captured a(n): " + entity.getName());
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have permission!");
                        }
                    } else if (Util.isHostile(entity)) {
                        if (player.hasPermission("mobcapture.hostile")) {
                            if (mobs.contains(entity.getName().toLowerCase())) {
                                player.getInventory().addItem(spawnegg);
                                player.sendMessage(ChatColor.AQUA + "You just captured a(n): " + entity.getName());
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have permission!");
                        }
                    }
                    makeEntitiyDisappear(entity, player);

                } else {
                    player.sendMessage(ChatColor.GRAY + "Wrong item");
                }
            }
        }
    }

    private void makeEntitiyDisappear(Entity e, Player p) {
        e.remove();
        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);

        p.getLocation().getWorld().playEffect(e.getLocation(), Effect.ENDER_SIGNAL, 1);

    }

    private Material getSpawnEggFromEntity(Entity e) {
        switch (e.getName()) {
            /*Passive Mobs*/
            case "Bat":
                return Material.BAT_SPAWN_EGG;
            case "Cat":
                return Material.CAT_SPAWN_EGG;
            case "Chicken":
                return Material.CHICKEN_SPAWN_EGG;
            case "Cod":
                return Material.COD_SPAWN_EGG;
            case "Cow":
                return Material.COW_SPAWN_EGG;
            case "Donkey":
                return Material.DONKEY_SPAWN_EGG;
            case "Fox":
                return Material.FOX_SPAWN_EGG;
            case "Horse":
                return Material.HORSE_SPAWN_EGG;
            case "Mooshroom":
                return Material.MOOSHROOM_SPAWN_EGG;
            case "Mule":
                return Material.MULE_SPAWN_EGG;
            case "Ocelot":
                return Material.OCELOT_SPAWN_EGG;
            case "Parrot":
                return Material.PARROT_SPAWN_EGG;
            case "Pig":
                return Material.PIG_SPAWN_EGG;
            case "Pufferfish":
                return Material.PUFFERFISH_SPAWN_EGG;
            case "Rabbit":
                return Material.RABBIT_SPAWN_EGG;
            case "Salmon":
                return Material.SALMON_SPAWN_EGG;
            case "Sheep":
                return Material.SHEEP_SPAWN_EGG;
            case "Skeleton Horse":
                return Material.SKELETON_HORSE_SPAWN_EGG;
            case "Squid":
                return Material.SQUID_SPAWN_EGG;
            case "Tropical Fish":
                return Material.TROPICAL_FISH_SPAWN_EGG;
            case "Turtle":
                return Material.TURTLE_SPAWN_EGG;
            case "Villager":
                return Material.VILLAGER_SPAWN_EGG;
            case "Wandering Trader":
                return Material.WANDERING_TRADER_SPAWN_EGG;
            /*Neutral Mobs*/
            case "Bee":
                return Material.BEE_SPAWN_EGG;
            case "Dolphin":
                return Material.DOLPHIN_SPAWN_EGG;
            case "Llama":
                return Material.LLAMA_SPAWN_EGG;
            case "Panda":
                return Material.PANDA_SPAWN_EGG;
            case "Polar Bear":
                return Material.POLAR_BEAR_SPAWN_EGG;
            case "Wolf":
                return Material.WOLF_SPAWN_EGG;
            case "Spider":
                return Material.SPIDER_SPAWN_EGG;
            case "Caver Spider":
                return Material.CAVE_SPIDER_SPAWN_EGG;
            case "Enderman":
                return Material.ENDERMAN_SPAWN_EGG;
            case "Zombie Pigman":
                return Material.ZOMBIE_PIGMAN_SPAWN_EGG;
            /*Hostile Mobs*/
            case "Blaze":
                return Material.BLAZE_SPAWN_EGG;
            case "Creeper":
                return Material.CREEPER_SPAWN_EGG;
            case "Drowned":
                return Material.DROWNED_SPAWN_EGG;
            case "Elder Guardian":
                return Material.ELDER_GUARDIAN_SPAWN_EGG;
            case "Endermite":
                return Material.ENDERMITE_SPAWN_EGG;
            case "Evoker":
                return Material.EVOKER_SPAWN_EGG;
            case "Ghast":
                return Material.GHAST_SPAWN_EGG;
            case "Guardian":
                return Material.GUARDIAN_SPAWN_EGG;
            case "Husk":
                return Material.HUSK_SPAWN_EGG;
            case "Magma Cube":
                return Material.MAGMA_CUBE_SPAWN_EGG;
            case "Phantom":
                return Material.PHANTOM_SPAWN_EGG;
            case "Pillager":
                return Material.PILLAGER_SPAWN_EGG;
            case "Ravager":
                return Material.RAVAGER_SPAWN_EGG;
            case "Shulker":
                return Material.SHULKER_SPAWN_EGG;
            case "Silverfish":
                return Material.SILVERFISH_SPAWN_EGG;
            case "Skeleton":
                return Material.SKELETON_SPAWN_EGG;
            case "Slime":
                return Material.SLIME_SPAWN_EGG;
            case "Stray":
                return Material.STRAY_SPAWN_EGG;
            case "Vex":
                return Material.VEX_SPAWN_EGG;
            case "Vindicator":
                return Material.VINDICATOR_SPAWN_EGG;
            case "Wither Skeleton":
                return Material.WITHER_SKELETON_SPAWN_EGG;
            case "Zombie":
                return Material.ZOMBIE_SPAWN_EGG;
            case "Zombie Villager":
                return Material.ZOMBIE_VILLAGER_SPAWN_EGG;
            default:
                return null;
        }
    }
}
