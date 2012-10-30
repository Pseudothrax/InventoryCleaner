package edu.unca.atjones.InventoryCleaner;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.google.common.base.Joiner;

/*
 * This is the Inventory Cleaner Command Executor
 */
public class InventoryCleanerCommandExecutor implements CommandExecutor {
	
	public Map<Player, HashMap<String,ItemStack[]>> playerInventories = new HashMap<Player, HashMap<String,ItemStack[]>>();
	
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
    		//inv clear
	    	if(p.hasPermission("inv.clear") && args[0].equalsIgnoreCase("clear")) {
	    		PlayerInventory i = p.getInventory();
	    		i.clear();
	    		this.plugin.logger.info(p.getName() + "used clear inventory");
	    		return true;
	    	}
	    	else if(!p.hasPermission("inv.clear")) {
	    		this.plugin.logger.info(p.getName() + "denied access to clear inventory");
	    	}
	    	//inv save
	    	if(p.hasPermission("inv.save") && args[0].equalsIgnoreCase("save")) {
	    		
	    		if(args[1] == null || !(args[1] instanceof String)){ return false; }
	    		
	    		HashMap<String,ItemStack[]> invCollection;
	    		ItemStack[] newInv = p.getInventory().getContents();
	    		String key = (String)args[1];
	    		
	    		if(playerInventories.containsKey(p)) {
	    			invCollection = playerInventories.get(p);
	    		} else {
	    			invCollection = new HashMap<String,ItemStack[]>();
	    		}
	    		
	    		if(invCollection.size() < this.plugin.getConfig().getInt("inv.num_saves")) {
	    			invCollection.put(key, newInv);
	    			playerInventories.put(p, invCollection);
	    			p.sendMessage("Inventory Saved as " + args[1]);
	    		} else {
	    			p.sendMessage("Cannot save any additional inventories. Max reached.");
	    		}
	    		
	    		return true;
	    		
	    	}
	    	//inv load
	    	if(p.hasPermission("inv.save") && args[0].equalsIgnoreCase("save")) {
	    		if(args[1] == null || !(args[1] instanceof String)){ return false; }
	    		
	    		HashMap<String,ItemStack[]> invCollection;
	    		
	    		if(playerInventories.containsKey(p)) {
	    			invCollection = playerInventories.get(p);
	    			if(invCollection.containsKey(args[1])){
	    				ItemStack[] loadInv = invCollection.get(args[1]);
	    				p.getInventory().setContents(loadInv);
	    				p.sendMessage("Inventory " + args[1] + " loaded.");
	    			} else {
		    			p.sendMessage("You have no saved inventory called " + args[1]);
		    		}
	    		} else {
	    			p.sendMessage("You have no saved inventory called " + args[1]);
	    		}
	    		return true;
	    	}
    	}
    	return false;
    }

}
