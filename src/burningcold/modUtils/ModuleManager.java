package burningcold.modUtils;

import java.util.ArrayList;

import burningcold.BurningCold;
import burningcold.gui.InGameGui;
import burningcold.mods.AutoWalk;
import burningcold.mods.Flight;
import burningcold.mods.Freecam;
import burningcold.mods.FullBright;
import burningcold.mods.KillAura;
import burningcold.mods.NoSlowDown;
import burningcold.mods.StorageESP;
import burningcold.mods.Tracers;
import burningcold.mods.WaterWalking;
import burningcold.mods.Xray;
import burningcold.utils.XrayUtils;

public class ModuleManager
{
	private static InGameGui inGameGui;
	private static ArrayList<Module> mods;
	
	public Module getModsByClass(Class <? extends Module> c)
	{
		for (Module m: mods)
		{
			if (m.getClass().equals(c))
				return m;
		}
		return null;
	}
	
	public static void register()
	{
		XrayUtils.addDefaultBlocks();
		mods = new ArrayList();
		
		addModule(new Flight());     //0
		addModule(new FullBright()); //1
		addModule(new KillAura());   //2
		addModule(new StorageESP()); //3
		addModule(new Tracers());    //4
		addModule(new Freecam());    //5
		addModule(new Xray());       //6
		addModule(new AutoWalk());   //7
		addModule(new NoSlowDown());
		//addModule(new WaterWalking());
		
		inGameGui = new InGameGui();
		
		mods.get(3).toggleModule(); //Toggle StorageESP
		mods.get(4).toggleModule(); //Toggle Tracers
	}
	
	public static ArrayList<Module> getModules()
	{
		return mods;
	}
	
	public static InGameGui getInGameGui()
	{
		return inGameGui;
	}
	
	public static void addModule(Module m)
	{
		mods.add(m);
	}
	
	public static void onKeypressed(int k)
	{
		for (Module m: mods)
		{
			if (k == m.getKeybind())
				m.toggleModule();
		}
	}
	
	public static void onUpdate()
	{
		for (Module m: mods)
			m.onUpdate();
	}
	
	public static void onRender()
	{
		for (Module m: mods)
			m.onRender();
	}
}
