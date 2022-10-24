package me.connor.quantekk;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RelayBlocker extends JavaPlugin implements Listener
{
	public static String prefix = ChatColor.BOLD+""+ChatColor.WHITE+"["+ChatColor.GOLD+"Quantekk"+ChatColor.WHITE+"] ";
	
  public void onEnable()
  {
    Bukkit.getPluginManager().registerEvents(this, this);
  }

  public void onDisable() {
  }

  @EventHandler
  public void onPlace(BlockPlaceEvent e) {
    if ((e.getBlockPlaced().getTypeId() == 126) && 
      (!e.getPlayer().hasPermission("shop.relay")) && 
      ((e.getBlockPlaced().getData() == 0) || 
      (e.getBlockPlaced().getData() == 1) || 
      (e.getBlockPlaced().getData() == 2) || 
      (e.getBlockPlaced().getData() == 5) || 
      (e.getBlockPlaced().getData() == 6) || 
      (e.getBlockPlaced().getData() == 7)) && (e.getBlockPlaced().getWorld().getName().equalsIgnoreCase("Spawn"))) {
      e.setCancelled(true);
      e.getPlayer().sendMessage(prefix+ChatColor.BOLD+""+ChatColor.YELLOW+"Sorry, relays and collectors are not allowed in here");
    }
  }
}