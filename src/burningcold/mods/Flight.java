package burningcold.mods;

import org.lwjgl.input.Keyboard;
import burningcold.BurningCold;
import burningcold.modUtils.Module;

public class Flight extends Module
{
	
	public Flight()
	{
		super("Flight", burningcold.modUtils.Category.MOVEMENT, Keyboard.KEY_P, 00);
	}
	
	@Override
	public void onDisable()
	{
		mc.player.capabilities.isFlying = false;
		super.onDisable();
	}
	
	@Override
	public void onUpdate()
	{
		if (!isEnabled())
		{
			return;
		}
		
		mc.player.capabilities.isFlying = true;
		super.onUpdate();
	}
}
