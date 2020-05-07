package at.valentinerinferno.mobcapture;

import at.valentinerinferno.mobcapture.commands.GetCatcher;
import at.valentinerinferno.mobcapture.events.PlayerInteractEntity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class MobCapture extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        String catcher = getConfig().getString("item");
        String catcherName = getConfig().getString("name");
        ArrayList<String> catcherLore = (ArrayList<String>) getConfig().getStringList("lore");
        ArrayList<String> mobs = (ArrayList<String>) getConfig().getStringList("mobs");

        getServer().getPluginManager().registerEvents(new PlayerInteractEntity(catcherName, catcherLore, mobs), this);
        getCommand("catcher").setExecutor(new GetCatcher(catcher, catcherName, catcherLore));
    }


}
