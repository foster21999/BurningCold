package burningcold.mods;

import org.lwjgl.input.Keyboard;
import burningcold.BurningCold;
import burningcold.modUtils.Module;

public class FullBright extends Module
{
	private float gammaSetting = 0F;
	
	public FullBright()
	{
		super("Full Bright", burningcold.modUtils.Category.RENDER, Keyboard.KEY_B, 00);
	}
	
	@Override
	public void onEnable()
	{
		this.gammaSetting = mc.gameSettings.gammaSetting;
		super.onEnable();
	}
	
	@Override
	public void onDisable()
	{
		mc.gameSettings.gammaSetting = this.gammaSetting;
		super.onDisable();
	}
	
	@Override
	public void onUpdate()
	{
		if (!isEnabled())
			return;
		
		mc.gameSettings.gammaSetting = 100F;
		super.onUpdate();
	}
}
