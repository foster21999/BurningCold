package burningcold.mods;

import org.lwjgl.input.Keyboard;
import burningcold.BurningCold;
import burningcold.modUtils.Module;

public class NoSlowDown extends Module
{
	
	public NoSlowDown()
	{
		super("No SlowDown", burningcold.modUtils.Category.MOVEMENT, Keyboard.KEY_K, 00);
	}
	
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
		if (!isEnabled())
			return;
		
		if(mc.player.onGround && mc.player.isInWater() && mc.gameSettings.keyBindJump.isPressed())
				mc.player.jump();
		
		if (mc.gameSettings.keyBindUseItem.isKeyDown())
			mc.player.jump();
		
		super.onUpdate();
	}
}
