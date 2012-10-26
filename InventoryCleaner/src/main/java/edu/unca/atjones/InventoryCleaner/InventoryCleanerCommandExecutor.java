package edu.unca.atjones.InventoryCleaner;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.google.common.base.Joiner;

/*
 * This is a sample CommandExectuor
 */
public class InventoryCleanerCommandExecutor implements CommandExecutor {
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
    	return true;
    }

}
