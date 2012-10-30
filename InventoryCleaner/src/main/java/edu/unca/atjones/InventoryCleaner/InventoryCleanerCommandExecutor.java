package edu.unca.atjones.InventoryCleaner;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import com.google.common.base.Joiner;

/*
 * This is the Inventory Cleaner Command Exectuor
 */
public class InventoryCleanerCommandExecutor implements CommandExecutor {
	
	public Map<Player, Boolean> playerInventories = new HashMap<Player, Boolean>();
	
    private final InventoryCleaner plugin;

    /*
     * This command executor needs to know about its plugin from which it came from
     */
    public InventoryCleanerCommandExecutor(InventoryCleaner plugin) {
        this.plugin = plugin;
    }

    /*
     * On command set the sample message
     */
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	Player p = (Player)sender;
    	if(args.length > 0) {
	    	if(p.hasPermission("inv.clear") && args[0].equalsIgnoreCase("clear")) {
	    		PlayerInventory i = p.getInventory();
	    		i.clear();
	    		this.plugin.logger.info(p.getName() + "used clear inventory");
	    		return true;
	    	}
	    	else if(!p.hasPermission("inv.clear")) {
	    		this.plugin.logger.info(p.getName() + "denied access to clear inventory");
	    	}
	    	
    	}
    	return false;
    }

}
