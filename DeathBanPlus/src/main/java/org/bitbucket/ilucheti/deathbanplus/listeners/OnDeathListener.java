package org.bitbucket.ilucheti.deathbanplus.listeners;

import org.bitbucket.ilucheti.deathbanplus.DeathBanPlus;
import org.bitbucket.ilucheti.deathbanplus.configs.ConfigManager;
import org.bitbucket.ilucheti.deathbanplus.enums.MessageType;
import org.bitbucket.ilucheti.deathbanplus.instances.BanInfo;
import org.bitbucket.ilucheti.deathbanplus.instances.DeathTypeInfo;
import org.bitbucket.ilucheti.deathbanplus.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;

public class OnDeathListener implements Listener {
	
	private DeathBanPlus mPlugin;
	
	public OnDeathListener(DeathBanPlus plugin)	{
		mPlugin = plugin;
		mPlugin.getServer().getPluginManager().registerEvents(this, mPlugin);
	}

	@EventHandler
	public void onPlayerDeath(EntityDeathEvent event) {
		   if (ConfigManager.getInstance().getEnabledWorlds().contains(event.getEntity().getWorld().getName().toLowerCase()) 
				   && event.getEntity() instanceof Player) {
			   Player player = (Player)event.getEntity();
			   
			   if (!player.hasPermission("DeathBanPlus.bypass")) handleDeath(player);
		   }
	}
	
	private void handleDeath(Player player) {
		if (player.getLastDamageCause() != null)	{
			DamageCause deathCause = player.getLastDamageCause().getCause();
			
			if (!ConfigManager.getInstance().isEnabledDamage(deathCause)) return;
			
			DeathTypeInfo deathInfo = Utils.getDeathTypeInfo(deathCause);
			
			int newLife = Utils.getNewLife(mPlugin.getInfo().getLife(player.getUniqueId()), deathInfo.getTakeLife());
				
			mPlugin.getInfo().setPlayerLife(player.getUniqueId(), newLife);
				
			if (newLife <= 0) {
				BanInfo banInfo = mPlugin.getInfo().getBanInfo(player.getUniqueId());
				long actualTime = System.currentTimeMillis();
				long endTime = actualTime;
				
				double asd = Utils.calculateBanTime(ConfigManager.getInstance().getBanTimeFormula(), banInfo.getTimesBanned()); // Milliseconds
				endTime += asd;
				
				System.out.println("Time banned" + asd);
				
				if (endTime > actualTime) {
					banInfo.ban(actualTime, endTime, deathInfo.getBanReason());
					player.getInventory().clear();
					player.kickPlayer(ConfigManager.getInstance().getMsg(MessageType.BANNED));
				}
			} else {
				player.sendMessage(Utils.sChatHeader + ChatColor.GRAY + "Now you have " + ChatColor.DARK_RED + newLife + " life points");
			}
		}
	}
}
