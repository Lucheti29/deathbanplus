package org.bitbucket.ilucheti.deathbanplus.configs;

import org.bitbucket.ilucheti.deathbanplus.DeathBanPlus;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class Config {

	private static int MAX_LIFE = 0;
	private static int BAN_TIME = 0;
	
	private static boolean BLOCK_EXPLOSION_ENABLED = false;
	private static boolean CONTACT_ENABLED = false;
	private static boolean CUSTOM_ENABLED = false;
	private static boolean DROWNING_ENABLED = false;
	private static boolean ENTITY_ATTACK_ENABLED = false;
	private static boolean ENTITY_EXPLOSION_ENABLED = false;
	private static boolean FALL_ENABLED = false;
	private static boolean FALLING_BLOCK_ENABLED = false;
	private static boolean FIRE_ENABLED = false;
	private static boolean FIRE_TICK_ENABLED = false;
	private static boolean LAVA_ENABLED = false;
	private static boolean LIGHTNING_ENABLED = false;
	private static boolean MAGIC_ENABLED = false;
	private static boolean MELTING_ENABLED = false;
	private static boolean POISON_ENABLED = false;
	private static boolean PROJECTILE_ENABLED = false;
	private static boolean STARVATION_ENABLED = false;
	private static boolean SUFFOCATION_ENABLED = false;
	private static boolean SUICIDE_ENABLED = false;
	private static boolean THORNS_ENABLED = false;
	private static boolean VOID_ENABLED = false;
	private static boolean WITHER_ENABLED = false;
	
	private static int BLOCK_EXPLOSION_TAKE_LIFE = 0;
	private static int CONTACT_TAKE_LIFE = 0;
	private static int CUSTOM_TAKE_LIFE = 0;
	private static int DROWNING_TAKE_LIFE = 0;
	private static int ENTITY_ATTACK_TAKE_LIFE = 0;
	private static int ENTITY_EXPLOSION_TAKE_LIFE = 0;
	private static int FALL_TAKE_LIFE = 0;
	private static int FALLING_BLOCK_TAKE_LIFE = 0;
	private static int FIRE_TAKE_LIFE = 0;
	private static int FIRE_TICK_TAKE_LIFE = 0;
	private static int LAVA_TAKE_LIFE = 0;
	private static int LIGHTNING_TAKE_LIFE = 0;
	private static int MAGIC_TAKE_LIFE = 0;
	private static int MELTING_TAKE_LIFE = 0;
	private static int POISON_TAKE_LIFE = 0;
	private static int PROJECTILE_TAKE_LIFE = 0;
	private static int STARVATION_TAKE_LIFE = 0;
	private static int SUFFOCATION_TAKE_LIFE = 0;
	private static int SUICIDE_TAKE_LIFE = 0;
	private static int THORNS_TAKE_LIFE = 0;
	private static int VOID_TAKE_LIFE = 0;
	private static int WITHER_TAKE_LIFE = 0;
	
	public static void load(DeathBanPlus plugin)
	{
		MAX_LIFE = Integer.parseInt(plugin.getConfig().getString("General.life"));
		BAN_TIME = Integer.parseInt(plugin.getConfig().getString("General.banTime"));
		
		BLOCK_EXPLOSION_ENABLED = plugin.getConfig().getBoolean("DeathType.BlockExplosion.enabled");
		CONTACT_ENABLED = plugin.getConfig().getBoolean("DeathType.Contact.enabled");
		CUSTOM_ENABLED = plugin.getConfig().getBoolean("DeathType.Custom.enabled");
		DROWNING_ENABLED = plugin.getConfig().getBoolean("DeathType.Drowning.enabled");
		ENTITY_ATTACK_ENABLED = plugin.getConfig().getBoolean("DeathType.EntityAttack.enabled");
		ENTITY_EXPLOSION_ENABLED = plugin.getConfig().getBoolean("DeathType.EntityExplosion.enabled");
		FALL_ENABLED = plugin.getConfig().getBoolean("DeathType.Fall.enabled");
		FALLING_BLOCK_ENABLED = plugin.getConfig().getBoolean("DeathType.FallingBlock.enabled");
		FIRE_ENABLED = plugin.getConfig().getBoolean("DeathType.Fire.enabled");
		FIRE_TICK_ENABLED = plugin.getConfig().getBoolean("DeathType.FireTick.enabled");
		LAVA_ENABLED = plugin.getConfig().getBoolean("DeathType.Lava.enabled");
		LIGHTNING_ENABLED = plugin.getConfig().getBoolean("DeathType.Lightning.enabled");
		MAGIC_ENABLED = plugin.getConfig().getBoolean("DeathType.Magic.enabled");
		MELTING_ENABLED = plugin.getConfig().getBoolean("DeathType.Melting.enabled");
		POISON_ENABLED = plugin.getConfig().getBoolean("DeathType.Poison.enabled");
		PROJECTILE_ENABLED = plugin.getConfig().getBoolean("DeathType.Projectile.enabled");
		STARVATION_ENABLED = plugin.getConfig().getBoolean("DeathType.Starvation.enabled");
		SUFFOCATION_ENABLED = plugin.getConfig().getBoolean("DeathType.Suffocation.enabled");
		SUICIDE_ENABLED = plugin.getConfig().getBoolean("DeathType.Suicide.enabled");
		THORNS_ENABLED = plugin.getConfig().getBoolean("DeathType.Thorns.enabled");
		VOID_ENABLED = plugin.getConfig().getBoolean("DeathType.Void.enabled");
		WITHER_ENABLED = plugin.getConfig().getBoolean("DeathType.Wither.enabled");
		
		BLOCK_EXPLOSION_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.BlockExplosion.takeLife"));
		CONTACT_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Contact.takeLife"));
		CUSTOM_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Custom.takeLife"));
		DROWNING_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Drowning.takeLife"));
		ENTITY_ATTACK_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.EntityAttack.takeLife"));
		ENTITY_EXPLOSION_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.EntityExplosion.takeLife"));
		FALL_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Fall.takeLife"));
		FALLING_BLOCK_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.FallingBlock.takeLife"));
		FIRE_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Fire.takeLife"));
		FIRE_TICK_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.FireTick.takeLife"));
		LAVA_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Lava.takeLife"));
		LIGHTNING_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Lightning.takeLife"));
		MAGIC_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Magic.takeLife"));
		MELTING_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Melting.takeLife"));
		POISON_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Poison.takeLife"));
		PROJECTILE_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Projectile.takeLife"));
		STARVATION_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Starvation.takeLife"));
		SUFFOCATION_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Suffocation.takeLife"));
		SUICIDE_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Suicide.takeLife"));
		THORNS_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Thorns.takeLife"));
		VOID_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Void.takeLife"));
		WITHER_TAKE_LIFE = Integer.parseInt(plugin.getConfig().getString("DeathType.Wither.takeLife"));
	}
	
	public static int getMaxLife()
	{
		return MAX_LIFE;
	}
	
	public static int getBanTime()
	{
		return BAN_TIME;
	}
	
	public static int getTakeLife(DamageCause damageType)
	{
		if(damageType == DamageCause.BLOCK_EXPLOSION)
		{
			return BLOCK_EXPLOSION_TAKE_LIFE;
		}
		else if(damageType == DamageCause.CONTACT)
		{
			return CONTACT_TAKE_LIFE;
		}
		else if(damageType == DamageCause.CUSTOM)
		{
			return CUSTOM_TAKE_LIFE;
		}
		else if(damageType == DamageCause.DROWNING)
		{
			return DROWNING_TAKE_LIFE;
		}
		else if(damageType == DamageCause.ENTITY_ATTACK)
		{
			return ENTITY_ATTACK_TAKE_LIFE;
		}
		else if(damageType == DamageCause.ENTITY_EXPLOSION)
		{
			return ENTITY_EXPLOSION_TAKE_LIFE;
		}
		else if(damageType == DamageCause.FALL)
		{
			return FALL_TAKE_LIFE;
		}
		else if(damageType == DamageCause.FALLING_BLOCK)
		{
			return FALLING_BLOCK_TAKE_LIFE;
		}
		else if(damageType == DamageCause.FIRE)
		{
			return FIRE_TAKE_LIFE;
		}
		else if(damageType == DamageCause.FIRE_TICK)
		{
			return FIRE_TICK_TAKE_LIFE;
		}
		else if(damageType == DamageCause.LAVA)
		{
			return LAVA_TAKE_LIFE;
		}
		else if(damageType == DamageCause.LIGHTNING)
		{
			return LIGHTNING_TAKE_LIFE;
		}
		else if(damageType == DamageCause.MAGIC)
		{
			return MAGIC_TAKE_LIFE;
		}
		else if(damageType == DamageCause.MELTING)
		{
			return MELTING_TAKE_LIFE;
		}
		else if(damageType == DamageCause.POISON)
		{
			return POISON_TAKE_LIFE;
		}
		else if(damageType == DamageCause.PROJECTILE)
		{
			return PROJECTILE_TAKE_LIFE;
		}
		else if(damageType == DamageCause.STARVATION)
		{
			return STARVATION_TAKE_LIFE;
		}
		else if(damageType == DamageCause.SUFFOCATION)
		{
			return SUFFOCATION_TAKE_LIFE;
		}
		else if(damageType == DamageCause.SUICIDE)
		{
			return SUICIDE_TAKE_LIFE;
		}
		else if(damageType == DamageCause.THORNS)
		{
			return THORNS_TAKE_LIFE;
		}
		else if(damageType == DamageCause.VOID)
		{
			return VOID_TAKE_LIFE;
		}
		else if(damageType == DamageCause.WITHER)
		{
			return WITHER_TAKE_LIFE;
		}
		return 0;
	}
	
	public static boolean isEnabledDamage(DamageCause damageType)
	{
		if(damageType == DamageCause.BLOCK_EXPLOSION)
		{
			return BLOCK_EXPLOSION_ENABLED;
		}
		else if(damageType == DamageCause.CONTACT)
		{
			return CONTACT_ENABLED;
		}
		else if(damageType == DamageCause.CUSTOM)
		{
			return CUSTOM_ENABLED;
		}
		else if(damageType == DamageCause.DROWNING)
		{
			return DROWNING_ENABLED;
		}
		else if(damageType == DamageCause.ENTITY_ATTACK)
		{
			return ENTITY_ATTACK_ENABLED;
		}
		else if(damageType == DamageCause.ENTITY_EXPLOSION)
		{
			return ENTITY_EXPLOSION_ENABLED;
		}
		else if(damageType == DamageCause.FALL)
		{
			return FALL_ENABLED;
		}
		else if(damageType == DamageCause.FALLING_BLOCK)
		{
			return FALLING_BLOCK_ENABLED;
		}
		else if(damageType == DamageCause.FIRE)
		{
			return FIRE_ENABLED;
		}
		else if(damageType == DamageCause.FIRE_TICK)
		{
			return FIRE_TICK_ENABLED;
		}
		else if(damageType == DamageCause.LAVA)
		{
			return LAVA_ENABLED;
		}
		else if(damageType == DamageCause.LIGHTNING)
		{
			return LIGHTNING_ENABLED;
		}
		else if(damageType == DamageCause.MAGIC)
		{
			return MAGIC_ENABLED;
		}
		else if(damageType == DamageCause.MELTING)
		{
			return MELTING_ENABLED;
		}
		else if(damageType == DamageCause.POISON)
		{
			return POISON_ENABLED;
		}
		else if(damageType == DamageCause.PROJECTILE)
		{
			return PROJECTILE_ENABLED;
		}
		else if(damageType == DamageCause.STARVATION)
		{
			return STARVATION_ENABLED;
		}
		else if(damageType == DamageCause.SUFFOCATION)
		{
			return SUFFOCATION_ENABLED;
		}
		else if(damageType == DamageCause.SUICIDE)
		{
			return SUICIDE_ENABLED;
		}
		else if(damageType == DamageCause.THORNS)
		{
			return THORNS_ENABLED;
		}
		else if(damageType == DamageCause.VOID)
		{
			return VOID_ENABLED;
		}
		else if(damageType == DamageCause.WITHER)
		{
			return WITHER_ENABLED;
		}
		return false;
	}
}
