package burningcold;

import java.util.logging.Logger;

import org.apache.commons.logging.Log;

import burningcold.modUtils.ModuleManager;

public class BurningCold
{
	public static BurningCold instance = new BurningCold();
	public static ModuleManager modManager;
	
	public static void onStart()
	{
		System.out.println("Setting fire to the rain...");
		modManager = new ModuleManager();
	}

	public static int getProtocolVersion()
	{
		//316 : 1.11.2
		return 316;
	}
}
