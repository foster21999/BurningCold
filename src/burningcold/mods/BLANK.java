package burningcold.mods;

import org.lwjgl.input.Keyboard;
import burningcold.BurningCold;
import burningcold.modUtils.Module;

public class BLANK extends Module
{
	
	public BLANK()
	{
		super("MOD NAME", burningcold.modUtils.Category.MOVEMENT, Keyboard.KEY_J, 00);
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
		
		super.onUpdate();
	}
}
