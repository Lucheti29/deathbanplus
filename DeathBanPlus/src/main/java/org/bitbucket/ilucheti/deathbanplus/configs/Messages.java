package org.bitbucket.ilucheti.deathbanplus.configs;

import org.bitbucket.ilucheti.deathbanplus.DeathBanPlus;
import org.bitbucket.ilucheti.deathbanplus.enums.MessageType;

public class Messages {

	private static String BANNED;
	
	public static void load(DeathBanPlus plugin)
	{
		BANNED = plugin.getConfig().getString("Messages.banned");
	}
	
	public static String get(MessageType type)
	{
		String message = "";
		
		if(type == MessageType.BANNED)
		{
			message = BANNED;
		}
		
		return message;
	}
}
