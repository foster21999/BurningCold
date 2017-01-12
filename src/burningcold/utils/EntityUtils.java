package burningcold.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class EntityUtils
{
	public static Entity getClosestEntity()
	{
		Minecraft mc = Minecraft.getMinecraft();
		Entity closestEntity = null;
		
		for(Entity entity : mc.world.loadedEntityList)
			if(entity instanceof EntityLivingBase || entity instanceof EntityPlayerSP)
				if(closestEntity == null || mc.player.getDistanceToEntity(entity) < mc.player.getDistanceToEntity(closestEntity))
					closestEntity = entity;
			
		return closestEntity;
	}
}
