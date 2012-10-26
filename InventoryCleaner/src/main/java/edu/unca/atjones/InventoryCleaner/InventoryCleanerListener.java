package edu.unca.atjones.InventoryCleaner;

import java.text.MessageFormat;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/*
 * Currently no events are handled by InventoryCleaner.
 */
public class InventoryCleanerListener implements Listener {
    private final InventoryCleaner plugin;

    /*
     * This listener needs to know about the plugin which it came from
     */
    public InventoryCleanerListener(InventoryCleaner plugin) {
        // Register the listener
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        
        this.plugin = plugin;
    }

}
