package burningcold.mods;

import java.awt.Color;
import org.lwjgl.input.Keyboard;
import burningcold.modUtils.Module;
import burningcold.utils.RenderUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;

public class Tracers extends Module
{
	
	public Tracers()
	{
		super("Tracers", burningcold.modUtils.Category.RENDER, Keyboard.KEY_C, 00);
	}
	
	@Override
	public void onRender()
	{
		if (!isEnabled())
			return;
		
		for (Object entity: mc.world.loadedEntityList)
		{
			if (entity instanceof EntityPlayer && !((Entity) entity).getName().equals(mc.getSession().getUsername()))
			{
					RenderUtils.drawTracerLine((Entity) entity, 3);
			}
		}
		
		super.onRender();
	}
	
	@Override
	public void onDisable()
	{
		super.onDisable();
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}
}
