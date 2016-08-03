package org.bitbucket.ilucheti.deathbanplus;

import org.bitbucket.ilucheti.deathbanplus.commands.AdminCmds;
import org.bitbucket.ilucheti.deathbanplus.commands.AdminCmds.Cmd;
import org.bitbucket.ilucheti.deathbanplus.commands.NormalCmds;
import org.bitbucket.ilucheti.deathbanplus.configs.ConfigManager;
import org.bitbucket.ilucheti.deathbanplus.listeners.OnDeathListener;
import org.bitbucket.ilucheti.deathbanplus.listeners.OnLoginListener;
import org.bitbucket.ilucheti.deathbanplus.listeners.OnLogoutListener;
import org.bitbucket.ilucheti.deathbanplus.storage.PlayerContainer;
import org.bitbucket.ilucheti.deathbanplus.storage.StorageHandler;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathBanPlus extends JavaPlugin {
	
	private static DeathBanPlus sInstance;
	
	public Permission mBypass = new Permission("DeathbanPlus.bypass");
	public Permission mCheckLives = new Permission("DeathbanPlus.CheckLives");
	
	private PlayerContainer mPlayerContainer;

	@Override
	public void onEnable() {
		sInstance = this;
		mPlayerContainer = new PlayerContainer();
		
		ConfigManager.getInstance().init();
		StorageHandler.saveUserFile();
		
	    PluginManager pm = getServer().getPluginManager();
	    
	    pm.addPermission(mBypass);
	    pm.addPermission(mCheckLives);
	    
	    for (Cmd adminCmd : AdminCmds.Cmd.values()) {
	    	if (adminCmd.getPermission().length() > 0) {
	    		pm.addPermission(new Permission(adminCmd.getPermission()));
	    	}
	    }
	    
		NormalCmds normalCmds = new NormalCmds(this);
		AdminCmds adminCmds = new AdminCmds(this);
		getCommand("DeathBanPlus").setExecutor(normalCmds);
		getCommand("ADeathBanPlus").setExecutor(adminCmds);
		
		new OnLoginListener(this);
		new OnDeathListener(this);
		new OnLogoutListener(this);
	}
	
	@Override
	public void onDisable() {
		mPlayerContainer.saveAll();
		super.onDisable();
	}
	
	public PlayerContainer getInfo() {
		return mPlayerContainer;
	}
	
	public static DeathBanPlus getInstance() {
		return sInstance;
	}
}
