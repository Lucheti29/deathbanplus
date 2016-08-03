package org.bitbucket.ilucheti.deathbanplus.listeners;

import org.bitbucket.ilucheti.deathbanplus.DeathBanPlus;
import org.bitbucket.ilucheti.deathbanplus.configs.ConfigManager;
import org.bitbucket.ilucheti.deathbanplus.enums.MessageType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class OnLoginListener implements Listener {

	DeathBanPlus _plugin;
	
	public OnLoginListener(DeathBanPlus plugin)
	{
		_plugin = plugin;
		_plugin.getServer().getPluginManager().registerEvents(this, _plugin);
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent event)
	{
		_plugin.getInfo().load(event.getPlayer().getUniqueId());
		
		if(_plugin.getInfo().isBanned(event.getPlayer().getUniqueId()))
		{
			event.disallow(PlayerLoginEvent.Result.KICK_BANNED, ConfigManager.getInstance().getMsg(MessageType.BANNED));
			_plugin.getInfo().removePlayer(event.getPlayer().getUniqueId());
		}	
	}
}
