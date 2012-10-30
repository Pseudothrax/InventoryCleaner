package edu.unca.atjones.InventoryCleaner;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * The main plugin class..
 */
public final class InventoryCleaner extends JavaPlugin {

	InventoryCleanerLogger logger;
	
	private void checkConfig() {
        if(this.getConfig().get("inv.num_saves") != null) {
        	logger.info("save configuration loaded");
        } else {
        	logger.warn("save configuration not found. Setting default");
        	this.getConfig().set("inv.num_saves", 1);
        }
        
        if(this.getConfig().get("inv.delete_on_load") != null) {
        	logger.info("delete configuration loaded");
        } else {
        	logger.warn("delete configuration not found. Setting default");
        	this.getConfig().set("inv.delete_on_load", "yes");
        }
	}
	
    @Override
    public void onEnable() {
    	
		logger = new InventoryCleanerLogger(this);
		logger.info("plugin enabled");
		
        // save the configuration file
        saveDefaultConfig();
        checkConfig();
		
        // Create the event listener
        new InventoryCleanerListener(this);
        
        // set the command executor
        this.getCommand("inv").setExecutor(new InventoryCleanerCommandExecutor(this));
    }
    
    /*
     * Nothing here for now
     */
    @Override
    public void onDisable() {
    	logger.info("plugin disabled");
    }

}
