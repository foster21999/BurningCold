package burningcold.mods;

import org.lwjgl.input.Keyboard;
import burningcold.BurningCold;
import burningcold.modUtils.Category;
import burningcold.modUtils.Module;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class WaterWalking extends Module
{
	public WaterWalking()
	{
		super("Water Walking", burningcold.modUtils.Category.MOVEMENT, Keyboard.KEY_J, 00);
	}

	private int ticksOutOfWater = 10;
	public int time = 0;
	public final int delay = 4;
	
	@Override
	public void onEnable()
	{
		super.onEnable();
	}
	
	@Override
	public void onDisable()
	{
		super.onDisable();
	}
	
	@Override
	public void onUpdate()
	{
		if(!mc.gameSettings.keyBindSneak.isPressed())
			if(mc.player.isInWater())
			{
				mc.player.motionY = 0.11;
				ticksOutOfWater = 0;
			} else
			{
				if(ticksOutOfWater == 0)
					mc.player.motionY = 0.3;
				else if(ticksOutOfWater == 1)
					mc.player.motionY = 0;
				
				ticksOutOfWater++;
			}
		 
		super.onUpdate();
	}
	
	//@SuppressWarnings("deprecation")
	public boolean isOverWater()
	{
		final EntityPlayerSP thePlayer = mc.player;
		
		boolean isOnWater = false;
		boolean isOnSolid = false;
		
		for(final Object o : mc.world.getCollisionBoxes(thePlayer, thePlayer.getEntityBoundingBox().offset(0, -1.0D, 0).expand(-0.001, 0, -0.001)))
		{
			final AxisAlignedBB bbox = (AxisAlignedBB)o;
			final BlockPos blockPos =
				new BlockPos(bbox.maxX - (bbox.maxX - bbox.minX) / 2.0,
					bbox.maxY - (bbox.maxY - bbox.minY) / 2.0,
					bbox.maxZ - (bbox.maxZ - bbox.minZ) / 2.0);
			final Block block = mc.world.getBlockState(blockPos).getBlock();
			if(block.getMaterial(null) == Material.WATER
				|| block.getMaterial(null) == Material.LAVA)
				isOnWater = true;
			else if(block.getMaterial(null) != Material.AIR)
				isOnSolid = true;
		}
		
		return isOnWater && !isOnSolid;
	}
	
	public boolean shouldBeSolid()
	{
		return isEnabled() && !(mc.player == null)
			&& !(mc.player.fallDistance > 3)
			&& !mc.gameSettings.keyBindSneak.isPressed() && !mc.player.isInWater();
	}
}
