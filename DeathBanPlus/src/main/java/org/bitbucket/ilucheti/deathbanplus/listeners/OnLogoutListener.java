package org.bitbucket.ilucheti.deathbanplus.listeners;

import org.bitbucket.ilucheti.deathbanplus.DeathBanPlus;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnLogoutListener implements Listener {

	DeathBanPlus _plugin;
	
	public OnLogoutListener(DeathBanPlus plugin)
	{
		_plugin = plugin;
		_plugin.getServer().getPluginManager().registerEvents(this, _plugin);
	}
	
	@EventHandler
	public void onPlayerLogout(PlayerQuitEvent event)
	{
		_plugin.getInfo().removePlayer(event.getPlayer().getUniqueId());
	}
}
