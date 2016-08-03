package org.bitbucket.ilucheti.deathbanplus.storage;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bitbucket.ilucheti.deathbanplus.configs.ConfigManager;
import org.bitbucket.ilucheti.deathbanplus.instances.BanInfo;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class StorageHandler {
	
	 public static File f = new File("plugins/DeathbanPlus/Users.yml");
	 public static YamlConfiguration _yamlFile = YamlConfiguration.loadConfiguration(f);

	public static void load(PlayerContainer playerContainer, UUID player)
	{
		playerContainer.addPlayer(player);
		
		int lives = 0;
		long dateBanned = 0;
		long endTime = 0;
		String reason = "Not banned";
		boolean banned = false;
		int timesBanned = 0;
		
		if(_yamlFile.get(player.toString()) != null)
		{
			lives = _yamlFile.getInt(player + ".Life");
			dateBanned = _yamlFile.getLong(player + ".DateBanned");
			endTime = _yamlFile.getLong(player + ".BanEnd");
			reason = (String) _yamlFile.get(player + ".BanReason");
			banned = _yamlFile.getBoolean(player + ".Banned");
			timesBanned = _yamlFile.getInt(player + ".TimesBanned");
		}
		else
		{
			lives = ConfigManager.getInstance().getMaxLife();
		}
		
		BanInfo info = new BanInfo(reason, dateBanned, endTime, banned, timesBanned);
		
		playerContainer.setPlayerLife(player, lives);
		playerContainer.addPlayerBanInfo(player, info);
	}

	public static void save(PlayerContainer playerContainer, UUID player) 
	{
		_yamlFile.set(player + ".Name", Bukkit.getOfflinePlayer(player).getName());
		_yamlFile.set(player + ".Life", playerContainer.getLife(player));
		_yamlFile.set(player + ".BanEnd", playerContainer.getBanInfo(player).getEndTime());
		_yamlFile.set(player + ".BanReason", playerContainer.getBanInfo(player).getReason());
		_yamlFile.set(player + ".DateBanned", playerContainer.getBanInfo(player).getStartedTime());
		_yamlFile.set(player + ".Banned", playerContainer.getBanInfo(player).isCurrentlyBanned());
		_yamlFile.set(player + ".TimesBanned", playerContainer.getBanInfo(player).getTimesBanned());
	}

	public static void saveUserFile () 
	{
	 	try 
	 	{
	 		_yamlFile.save(f);
	 	} 
	 	catch(IOException e) 
	 	{
			  e.printStackTrace();
		}
	}

}
