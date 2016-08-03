package org.bitbucket.ilucheti.deathbanplus.instances;

import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class DeathTypeInfo 
{
	private DamageCause _type;
	private int _takeLife;
	private String _banReason;
	
	public DeathTypeInfo(DamageCause type, int takeLife, String banReason)
	{
		_type = type;
		_takeLife = takeLife;
		_banReason = banReason;
	}
	
	public DamageCause getType()
	{
		return _type;
	}
	
	public int getTakeLife()
	{
		return _takeLife;
	}
	
	public String getBanReason()
	{
		return _banReason;
	}
}
