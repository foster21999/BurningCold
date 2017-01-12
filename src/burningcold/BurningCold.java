package burningcold;

import burningcold.modUtils.ModuleManager;
import net.minecraft.client.Minecraft;

public class BurningCold
{
	public static BurningCold instance = new BurningCold();
	public static ModuleManager modManager;
	
	public static void onStart()
	{
		Minecraft.LOGGER.info("Setting fire to the rain...");
		//System.out.println("Setting fire to the rain...");
		modManager = new ModuleManager();
	}

	public static int getProtocolVersion()
	{
		//315 : 1.11
		//316 : 1.11.2
		return 316;
	}
}
