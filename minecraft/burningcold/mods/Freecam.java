package burningcold.mods;

import org.lwjgl.input.Keyboard;
import burningcold.BurningCold;
import burningcold.modUtils.Module;
import net.minecraft.client.entity.EntityOtherPlayerMP;

public class Freecam extends Module
{
	private EntityOtherPlayerMP newPlayer = null;
	private double preX;
	private double preY;
	private double preZ;
	
	public Freecam()
	{
		super("Free Cam", burningcold.modUtils.Category.RENDER, Keyboard.KEY_M, 00);
	}
	
	@Override
	public void onEnable()
	{
		preX = mc.player.posX;
		preY = mc.player.posY;
		preZ = mc.player.posZ;
		newPlayer = new EntityOtherPlayerMP(mc.world, mc.player.getGameProfile());
		newPlayer.clonePlayer(mc.player, true);
		newPlayer.copyLocationAndAnglesFrom(mc.player);
		newPlayer.rotationYawHead = mc.player.rotationYawHead;
		mc.world.addEntityToWorld(-69, newPlayer);
		super.onEnable();
	}
	
	@Override
	public void onDisable()
	{
		mc.player.setPositionAndRotation(preX, preY, preZ, mc.player.rotationYaw, mc.player.rotationPitch);
		mc.world.removeEntityFromWorld(-69);
		newPlayer = null;
		super.onDisable();
	}
	
	@Override
	public void onUpdate()
	{
		if (!isEnabled())
			return;
		
		mc.player.motionX = 0;
		mc.player.motionY = 0; 
		mc.player.motionZ = 0;
		mc.player.jumpMovementFactor = .5f;
		
		if (mc.gameSettings.keyBindJump.isKeyDown())
			mc.player.motionY += .5f;
		if (mc.gameSettings.keyBindSneak.isKeyDown())
			mc.player.motionY -= .5f;
		
		super.onUpdate();
	}
}
