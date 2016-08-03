package org.bitbucket.ilucheti.deathbanplus.commands;

import java.util.Date;
import java.util.UUID;

import org.bitbucket.ilucheti.deathbanplus.DeathBanPlus;
import org.bitbucket.ilucheti.deathbanplus.configs.ConfigManager;
import org.bitbucket.ilucheti.deathbanplus.instances.BanInfo;
import org.bitbucket.ilucheti.deathbanplus.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class AdminCmds implements CommandExecutor {

	public enum Cmd {
		HELP("help", ""),
		INFO("info", "DeathbanPlus.admin.info"),
		SET_LIFE("setLife", "DeathbanPlus.admin.setLife"),
		ADD_LIFE("addLife", "DeathbanPlus.admin.addLife"),
		REMOVE_LIFE("removeLife", "DeathbanPlus.admin.removeLife"),
		UNBAN("unban", "DeathbanPlus.admin.unban"),
		UNDEFINED("undefined", "");
		
	    private final String _cmd;
	    private final String _permission;

	    private Cmd(String cmd, String permission) {
	        _cmd = cmd;
	        _permission = permission;
	    }

	    public String getCmd() {
	        return _cmd;
	    }
	    
	    public String getPermission() {
	    	return _permission;
	    }

	    public static Cmd getType(String status) {
	        for (Cmd s : Cmd.values()) {
	            if (s.getCmd().equalsIgnoreCase(status)) return s;
	        }
	        return UNDEFINED;
	    }
	}
	
	private DeathBanPlus _plugin;

	public AdminCmds(DeathBanPlus plugin) 
	{
		_plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(Utils.isAdminCmdValid(label)) {
			
			if (args.length == 0)
			{
				help(sender);
				return false;
			}
			
			switch (Cmd.getType(args[0])) 
			{
				case INFO:
					if (hasPermission(sender, Cmd.INFO))
					{
						if (args.length > 1 && args[1] != "")
						{
							@SuppressWarnings("deprecation")
							UUID uuid = _plugin.getServer().getOfflinePlayer(args[1]).getUniqueId();
							_plugin.getInfo().load(uuid);
							
							String banMsg = "";
							
							if(_plugin.getInfo().getBanInfo(uuid).isCurrentlyBanned())
							{
								Date banStartedTime = new Date(_plugin.getInfo().getBanInfo(uuid).getStartedTime());
							    Date banEndTime = new Date(_plugin.getInfo().getBanInfo(uuid).getEndTime());
							    
								banMsg = ChatColor.BLUE + " Banned: " + ChatColor.GRAY + " true " + "\n"
								+ ChatColor.BLUE + " Started time " + ChatColor.GRAY + banStartedTime + " \n"
								+ ChatColor.BLUE + " End time " + ChatColor.GRAY + banEndTime + " \n"
								+ ChatColor.BLUE + " Reason " + ChatColor.GRAY + _plugin.getInfo().getBanInfo(uuid).getReason() + " \n";
							}
							
							sendMessage(sender, Utils.sChatHeader + "\n"
									+ ChatColor.BLUE + "Life: " + ChatColor.GRAY + _plugin.getInfo().getLife(uuid) + "\n"
									+ banMsg
									+ ChatColor.BLUE +"Times banned: " + ChatColor.GRAY + _plugin.getInfo().getBanInfo(uuid).getTimesBanned());
							
							if(_plugin.getServer().getPlayer(uuid) == null)
							{
								_plugin.getInfo().removePlayer(uuid);
							}
						}
					}
				break;
				
				case SET_LIFE:
					if(hasPermission(sender, Cmd.SET_LIFE))
					{
						if (args.length > 2 && args[1] != "" && args[2] != "")
						{
							try
							{
								int newLife = Integer.parseInt(args[2]);
								
								@SuppressWarnings("deprecation")
								UUID uuid = _plugin.getServer().getOfflinePlayer(args[1]).getUniqueId();
								_plugin.getInfo().load(uuid);
								
								_plugin.getInfo().setPlayerLife(uuid, newLife);
								
								sendMessage(sender, Utils.sChatHeader + "New life setted successfully");
								
								if(_plugin.getServer().getPlayer(uuid) == null)
								{
									_plugin.getInfo().removePlayer(uuid);
								}
							}
							catch(NumberFormatException e)
							{
								sendMessage(sender, Utils.sChatHeader + "Error");
							}
						}
						else
						{
							sendMessage(sender, Utils.sChatHeader + "Incorrect syntax. Use /ADeathbanPlus setlife <playerName> <newLife>");
						}
					}
				break;
				
				case ADD_LIFE:
					if(hasPermission(sender, Cmd.ADD_LIFE))
					{
						if (args.length > 2 && args[1] != "" && args[2] != "")
						{
							try
							{
								int newLife = Integer.parseInt(args[2]);
								
								@SuppressWarnings("deprecation")
								UUID uuid = _plugin.getServer().getOfflinePlayer(args[1]).getUniqueId();
								_plugin.getInfo().load(uuid);
								
								_plugin.getInfo().addPlayerLife(uuid, newLife);
								
								sendMessage(sender, Utils.sChatHeader + "New life added successfully");
								
								if(_plugin.getServer().getPlayer(uuid) == null)
								{
									_plugin.getInfo().removePlayer(uuid);
								}
							}
							catch(NumberFormatException e)
							{
								sendMessage(sender, Utils.sChatHeader + "Error");
							}
						}
						else
						{
							sendMessage(sender, Utils.sChatHeader + "Incorrect syntax. Use /ADeathbanPlus addlife <playerName> <extraLife>");
						}
					}
				break;
				
				case REMOVE_LIFE:
					if(hasPermission(sender, Cmd.REMOVE_LIFE))
					{
						if (args.length > 2 && args[1] != "" && args[2] != "")
						{
							try
							{
								int newLife = Integer.parseInt(args[2]);
								
								@SuppressWarnings("deprecation")
								UUID uuid = _plugin.getServer().getOfflinePlayer(args[1]).getUniqueId();
								_plugin.getInfo().load(uuid);
								
								_plugin.getInfo().removePlayerLife(uuid, newLife);
								
								sendMessage(sender, Utils.sChatHeader + "Life removed successfully");
								
								if(_plugin.getServer().getPlayer(uuid) == null)
								{
									_plugin.getInfo().removePlayer(uuid);
								}
							}
							catch(NumberFormatException e)
							{
								sendMessage(sender, Utils.sChatHeader + "Error");
							}
						}
						else
						{
							sendMessage(sender, Utils.sChatHeader + "Incorrect syntax. Use /ADeathbanPlus removeLife <playerName> <removeLife>");
						}
					}
				break;
					
				case UNBAN:
					if(hasPermission(sender, Cmd.UNBAN))
					{
						if (args.length > 1 && args[1] != "")
						{
							@SuppressWarnings("deprecation")
							UUID uuid = _plugin.getServer().getOfflinePlayer(args[1]).getUniqueId();
							_plugin.getInfo().load(uuid);
							
							BanInfo banInfo = _plugin.getInfo().getBanInfo(uuid);
											
							if(banInfo.isCurrentlyBanned())
							{
								banInfo.unban();
								_plugin.getInfo().setPlayerLife(uuid, ConfigManager.getInstance().getMaxLife());
								sendMessage(sender, Utils.sChatHeader + "Player has been unbanned successfully");
							}
							else
							{
								sendMessage(sender, Utils.sChatHeader + "The player is not banned");
							}
							
							if(_plugin.getServer().getPlayer(uuid) == null)
							{
								_plugin.getInfo().removePlayer(uuid);
							}
						}
					}
				break;
				
				default:
					help(sender);
				break;
			}
		}
		return false;
	}
	
	private void sendMessage(CommandSender sender, String msg) {
		if (sender instanceof Player) 
		{
			Player player = (Player) sender;
			player.sendMessage(msg);
		} 
		else if (sender instanceof ConsoleCommandSender) 
		{
			ConsoleCommandSender console = (ConsoleCommandSender) sender;
			console.sendMessage(msg);
		}
	}
	
	private boolean hasPermission(CommandSender sender, Cmd cmd) {
		if (sender instanceof ConsoleCommandSender)
		{
			return true;
		}
		
		if (sender instanceof Player) 
		{
			if (cmd.getPermission().length() > 0)
			{
				Player player = (Player) sender;
				return player.isOp() || player.hasPermission(cmd.getPermission());
			}
			
			return true;
		} 

		return false;
	}
	
	private void help(CommandSender sender)
	{
		sendMessage(sender, Utils.sChatHeader + Utils.sPluginVersion);
		
		if (hasPermission(sender, Cmd.INFO)) 
		{
			sendMessage(sender, Utils.sChatHeader + "/ADeathbanPlus info <playerName> " + ChatColor.GRAY + "- Check player's deathban info");
		}
		
		if (hasPermission(sender, Cmd.SET_LIFE))
		{
			sendMessage(sender, Utils.sChatHeader + "/ADeathbanPlus setlife <playerName> <newLife> " + ChatColor.GRAY + "- Set new player's life");
		}
		
		if (hasPermission(sender, Cmd.UNBAN))
		{
			sendMessage(sender, Utils.sChatHeader + "/ADeathbanPlus unban <playerName> " + ChatColor.GRAY + "- Unban player from DeathBan");
		}
	}

}
