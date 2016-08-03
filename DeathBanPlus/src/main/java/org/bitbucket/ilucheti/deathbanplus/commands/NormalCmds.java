package org.bitbucket.ilucheti.deathbanplus.commands;

import org.bitbucket.ilucheti.deathbanplus.DeathBanPlus;
import org.bitbucket.ilucheti.deathbanplus.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NormalCmds implements CommandExecutor {
	
	private DeathBanPlus _plugin;

	public NormalCmds(DeathBanPlus plugin) {
		_plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) 
		{
			return false;
		}
		
		Player player = (Player) sender;
		
		if(Utils.isNormalCmdValid(label)) {
			
			if(args.length == 0) 
			{
				help(player);
			}
			else if (args[0].equalsIgnoreCase("checklife") && player.hasPermission("DeathbanPlus.CheckLives"))
			{
				player.sendMessage(Utils.sChatHeader + "\n"
						+ ChatColor.BLUE + "Life: " + ChatColor.GRAY + _plugin.getInfo().getLife(player.getUniqueId()) + "\n"
						+ ChatColor.BLUE +" Times banned: " + ChatColor.GRAY + _plugin.getInfo().getBanInfo(player.getUniqueId()).getTimesBanned());
			}
			else
			{
				help(player);
			}
		}
		
		return false;
	}
	
	private void help(Player player)
	{
		player.sendMessage(Utils.sChatHeader + Utils.sPluginVersion);
		
		if(player.hasPermission("DeathbanPlus.CheckLives")) 
		{
			player.sendMessage(Utils.sChatHeader + "/DeathbanPlus checklife " + ChatColor.GRAY + "- Check your lives until ban");
		}
	}

}
