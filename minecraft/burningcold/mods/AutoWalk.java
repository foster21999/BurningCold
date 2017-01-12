package burningcold.mods;

import org.lwjgl.input.Keyboard;
import burningcold.BurningCold;
import burningcold.modUtils.Module;

public class AutoWalk extends Module
{
	
	public AutoWalk()
	{
		super("Auto Walk", burningcold.modUtils.Category.MOVEMENT, Keyboard.KEY_H, 00);
	}
	
	@Override
	public void onEnable()
	{
		super.onEnable();
	}
	
	@Override
	public void onDisable()
	{
		mc.gameSettings.keyBindForward.setKeyBindState(Keyboard.KEY_W, false);
		super.onDisable();
	}
	
	@Override
	public void onUpdate()
	{
		if (!isEnabled())
			return;
		
		if (!mc.gameSettings.keyBindForward.isPressed())
			mc.gameSettings.keyBindForward.setKeyBindState(Keyboard.KEY_W, true);
		
		super.onUpdate();
	}
}
