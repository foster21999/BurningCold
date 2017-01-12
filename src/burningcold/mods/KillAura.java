package burningcold.mods;

import java.util.Iterator;
import java.util.Timer;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.network.play.client.C03PacketPlayer;

import org.lwjgl.input.Keyboard;

import burningcold.modUtils.*;
import burningcold.utils.EntityUtils;

public class KillAura extends Module
{
	private Timer timer;
	
	public KillAura()
	{
		super("KillAura", burningcold.modUtils.Category.COMBAT, Keyboard.KEY_R, 00);
	}
	
	@Override
	public void onUpdate()
	{
		
		if(!this.isEnabled())
			return;
		
		if (mc.player.getCooledAttackStrength(0f) < 1f)
			return;
		
		/*Entity e = EntityUtils.getClosestEntity();
		
		if (mc.player.getDistanceToEntity(e) <= 6.12736)
		{
			mc.playerController.attackEntity(mc.player, e);
			mc.player.swingArm(net.minecraft.util.EnumHand.MAIN_HAND);
		}*/
		
		for(Iterator entities = mc.world.loadedEntityList.iterator(); entities.hasNext();)
		{
			Object theObject = entities.next();
			if(theObject instanceof EntityLivingBase)
			{
				EntityLivingBase entity = (EntityLivingBase) theObject;
				
				if(entity instanceof EntityPlayerSP) continue;
				
				if(mc.player.getDistanceToEntity(entity) <= 6.2173613)
				{
					if(entity.isEntityAlive())
					{
						mc.playerController.attackEntity(mc.player, entity);
						mc.player.swingArm(net.minecraft.util.EnumHand.MAIN_HAND);
						continue;
					}
				}
			}
		}
		
		super.onUpdate();
	}

}