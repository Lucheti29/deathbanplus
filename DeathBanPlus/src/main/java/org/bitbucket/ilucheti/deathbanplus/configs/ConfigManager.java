package org.bitbucket.ilucheti.deathbanplus.configs;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bitbucket.ilucheti.deathbanplus.DeathBanPlus;
import org.bitbucket.ilucheti.deathbanplus.enums.MessageType;
import org.bitbucket.ilucheti.deathbanplus.utils.IOUtils;
import org.bitbucket.ilucheti.deathbanplus.utils.models.Config;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class ConfigManager {
	
	private static ConfigManager sInstance;
	
	private Config mGeneralConfig;
	private Config mMsgConfig;

	private int mMaxLife = 0;
	private String mBanTimeFormula;
	
	private Set<String> mEnabledWorlds = new HashSet<>();
	private Map<DamageCause, Integer> mEnabledDeaths = new HashMap<>();
	
	private Map<MessageType, String> mMessages = new HashMap<>();
	
	public void init() {
		mGeneralConfig = new Config("config.yml");
		mMsgConfig = new Config("messages.yml");
		
		loadYMLFile(mGeneralConfig);
		loadYMLFile(mMsgConfig);
		
		loadGeneralConfig();
		loadMessageConfig();
	}
	
	private void loadGeneralConfig() {
		YamlConfiguration generalConfig = mGeneralConfig.getYaml();
		
		mMaxLife = Integer.parseInt(generalConfig.getString("General.life"));
		mBanTimeFormula = generalConfig.getString("General.banTimeFormula");
		
		List<String> enabledWorlds = generalConfig.getStringList("General.enabledWorlds");
		for (String world : enabledWorlds) {
			mEnabledWorlds.add(world.toLowerCase());
		}
		
		List<String> enabledDeaths = generalConfig.getStringList("General.enabledDeaths");
		for (String death : enabledDeaths) {
			try {
				DamageCause cause = DamageCause.valueOf(death.split("\\(")[0]);
				Integer takePoints = Integer.parseInt(death.split("\\(")[1].split("\\)")[0]);
				if (cause != null && takePoints != null) {
					mEnabledDeaths.put(cause, takePoints);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void loadMessageConfig() {
		for (MessageType type : MessageType.values()) {
			String msg = mMsgConfig.getYaml().getString(type.getValue());
			if (msg != null && !msg.isEmpty()) {
				msg = msg.replaceAll("&" , "§");
				mMessages.put(type, msg);
			}
		}
	}
	
	public int getMaxLife() {
		return mMaxLife;
	}
	
	public String getBanTimeFormula() {
		return mBanTimeFormula;
	}
	
	public Set<String> getEnabledWorlds() {
		return mEnabledWorlds;
	}
	
	public boolean isEnabledDamage(DamageCause damageType) {
		return mEnabledDeaths.containsKey(damageType);
	}
	
	public int getTakeLife(DamageCause damageType) {
		return mEnabledDeaths.get(damageType);
	}
	
	public String getMsg(MessageType type) {
		return mMessages.get(type);
	}
	
	private void loadYMLFile(Config config) {
		config.setFile(new File(DeathBanPlus.getInstance().getDataFolder(), config.getFileName()));
		
		if (!config.getFile().exists()) {
			config.getFile().getParentFile().mkdirs();
	        IOUtils.copy(DeathBanPlus.getInstance().getResource(config.getFileName()), config.getFile());
	    }
		
		IOUtils.loadFile(config);
	}
	
	public static ConfigManager getInstance() {
		if (sInstance == null) sInstance = new ConfigManager();
		return sInstance;
	}
}
