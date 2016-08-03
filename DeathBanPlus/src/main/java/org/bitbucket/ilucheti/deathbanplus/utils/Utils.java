package org.bitbucket.ilucheti.deathbanplus.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.bitbucket.ilucheti.deathbanplus.configs.ConfigManager;
import org.bitbucket.ilucheti.deathbanplus.enums.MessageType;
import org.bitbucket.ilucheti.deathbanplus.instances.DeathTypeInfo;
import org.bukkit.ChatColor;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;


public class Utils {
	
	public static String sChatHeader = ChatColor.GRAY + "[" + ChatColor.GOLD + "DeathBanPlus" + ChatColor.GRAY + "] " + ChatColor.GOLD;
	public static String sPluginVersion = "By iLucheti. v0.5";
	
	public static DeathTypeInfo getDeathTypeInfo(DamageCause type) {
		return new DeathTypeInfo(type, ConfigManager.getInstance().getTakeLife(type), ConfigManager.getInstance().getMsg(MessageType.BANNED));
	}
	
	public static int getNewLife(int actualLife, int takeLife) {
		int value = actualLife - takeLife;
		
		if (value < 0) {
			value = 0;
		}
		
		return value;
	}
	
	public static boolean isNormalCmdValid(String cmd) {
		if(cmd.equalsIgnoreCase("DeathBanPlus") || cmd.equalsIgnoreCase("dbp") || cmd.equalsIgnoreCase("deathbanp")) {
			return true;
		}
		return false;
	}
	
	public static boolean isAdminCmdValid(String cmd) {
		if(cmd.equalsIgnoreCase("ADeathBanPlus") || cmd.equalsIgnoreCase("adbp") 
				|| cmd.equalsIgnoreCase("admindbp") || cmd.equalsIgnoreCase("adeathbanp")) {
			return true;
		}
		return false;
	}
	
	public static double calculateBanTime(String formula, int timesBanned) {
	    ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    try {
	    	Object evaluation = engine.eval(formula.replaceAll("%n%", String.valueOf(timesBanned)));
	    	int result = 0;
	    	if (evaluation instanceof Double) {
	    		Double doubleResult = (Double) evaluation;
	    		result = doubleResult.intValue();
	    	} else if (evaluation instanceof Integer) {
	    		result = (Integer) evaluation;
	    	}
			return result * 1000; // Milliseconds
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
