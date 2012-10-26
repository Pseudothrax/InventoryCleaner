package edu.unca.atjones.InventoryCleaner;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * The main plugin class..
 */
public final class InventoryCleaner extends JavaPlugin {
    /*
     * Nothing here for now
     */
    @Override
    public void onEnable() {
        // save the configuration file
        saveDefaultConfig();
        
        // Create the InventoryCleanerListener
        new InventoryCleanerListener(this);
        
        // set the command executor for sample
        this.getCommand("inv").setExecutor(new InventoryCleanerCommandExecutor(this));
    }
    
    /*
     * Nothing here for now
     */
    @Override
    public void onDisable() {
        
    }

}
