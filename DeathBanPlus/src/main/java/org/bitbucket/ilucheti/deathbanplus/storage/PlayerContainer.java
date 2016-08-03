package org.bitbucket.ilucheti.deathbanplus.storage;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bitbucket.ilucheti.deathbanplus.configs.ConfigManager;
import org.bitbucket.ilucheti.deathbanplus.instances.BanInfo;

public class PlayerContainer {
	
	private ArrayList<UUID> _playerList = new ArrayList<UUID>();
	private ConcurrentHashMap<UUID, Integer> _playersLifes = new ConcurrentHashMap<UUID, Integer>();
	private ConcurrentHashMap<UUID, BanInfo> _playersBan = new ConcurrentHashMap<UUID, BanInfo>();
	
	public void load(UUID player)
	{
		if(!_playerList.contains(player))
		{
			StorageHandler.load(this, player);
		}
	}
	
	private synchronized void save(UUID player, boolean singlePlayer)
	{
		StorageHandler.save(this, player);
		
		if(singlePlayer)
		{
			StorageHandler.saveUserFile();
		}
	}
	
	public void saveAll()
	{
		if(_playerList != null)
		{
			for(UUID player : _playerList)
			{
				save(player, false);
			}
		}
		
		StorageHandler.saveUserFile();
	}
	
	public void setPlayerLife(UUID player, int life)
	{
		_playersLifes.put(player, life);
	}
	
	public void addPlayerLife(UUID player, int life)
	{
		_playersLifes.put(player, getLife(player) + life);
	}
	
	public void removePlayerLife(UUID player, int life)
	{
		int newLife = getLife(player) - life;
		
		if (newLife < 0)
		{
			_playersLifes.put(player, 0);
		}
		else
		{
			_playersLifes.put(player, newLife);
		}
	}
	
	public void addPlayerBanInfo(UUID player, BanInfo banInfo)
	{
		_playersBan.put(player, banInfo);
	}
	
	public int getLife(UUID player)
	{
		return _playersLifes.get(player);
	}
	
	public BanInfo getBanInfo(UUID player)
	{
		return _playersBan.get(player);
	}
	
	public boolean isBanned(UUID player)
	{		
		BanInfo info = _playersBan.get(player);
		
		if(info.isCurrentlyBanned())
		{
			if(System.currentTimeMillis() < info.getEndTime())
			{
				return true;
			}
			
			info.unban();
			_playersLifes.put(player, ConfigManager.getInstance().getMaxLife());
		}
		return false;
	}
	
	public void addPlayer(UUID player)
	{
		if(!_playerList.contains(player))
		{
			_playerList.add(player);
		}
	}
	
	public void removePlayer(UUID player)
	{
		save(player, true);
		_playerList.remove(player);
		_playersLifes.remove(player);
		_playersBan.remove(player);
	}
}
