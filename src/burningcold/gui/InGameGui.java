package burningcold.gui;

import burningcold.modUtils.Module;
import burningcold.modUtils.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class InGameGui extends GuiScreen
{
	public InGameGui()
	{
		this.mc = Minecraft.getMinecraft();
	}
	
	public void renderScreen()
	{
		String client_name = "\247c\247lBurning \2479\247lCold \247f\247lv0.0.1";
		
		mc.fontRendererObj.drawString(client_name, 4, 4, 0xffffffff);
		
		int c = 0;
		for (Module m: ModuleManager.getModules())
		{
			if (m.isEnabled())
			{
				mc.fontRendererObj.drawString("\247f" + m.getName(), 4, 20 + (10 * c), 0xffffffff);
				c++;
			}
		}
	}
}
