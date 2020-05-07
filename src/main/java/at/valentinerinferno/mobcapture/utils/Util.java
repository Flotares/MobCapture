package at.valentinerinferno.mobcapture.utils;

import org.bukkit.entity.Entity;

public class Util {

    public static boolean isPassive(Entity e){
        switch (e.getName()){
            case "Bat":
            case "Cat":
            case "Chicken":
            case "Cod":
            case "Cow":
            case "Donkey":
            case "Fox":
            case "Horse":
            case "Mooshroom":
            case "Mule":
            case "Ocelot":
            case "Parrot":
            case "Pig":
            case "Pufferfish":
            case "Rabbit":
            case "Salmon":
            case "Sheep":
            case "Skeleton Horse":
            case "Squid":
            case "Tropical Fish":
            case "Turtle":
            case "Villager":
            case "Wandering Trader":
                return true;
            default:
                return false;
        }
    }

    public static boolean isNeutral(Entity e){
        switch (e.getName()){
            case "Bee":
            case "Dolphin":
            case "Llama":
            case "Panda":
            case "Polar Bear":
            case "Wolf":
            case "Spider":
            case "Caver Spider":
            case "Enderman":
            case "Zombie Pigman":
                return true;
            default:
                return false;
        }
    }
    public static boolean isHostile(Entity e){
        switch(e.getName()){
            case "Blaze":
            case "Creeper":
            case "Drowned":
            case "Elder Guardian":
            case "Endermite":
            case "Evoker":
            case "Ghast":
            case "Guardian":
            case "Husk":
            case "Magma Cube":
            case "Phantom":
            case "Pillager":
            case "Ravager":
            case "Shulker":
            case "Silverfish":
            case "Skeleton":
            case "Slime":
            case "Stray":
            case "Vex":
            case "Vindicator":
            case "Wither Skeleton":
            case "Zombie":
            case "Zombie Villager":
                return true;
            default:
                return false;
        }
    }
}
