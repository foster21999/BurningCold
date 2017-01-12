package burningcold.mods;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import burningcold.BurningCold;
import burningcold.modUtils.Module;
import net.minecraft.block.Block;

public class Xray extends Module
{
	private float gammaSetting = 0F;
	public static ArrayList<Block> blockList = new ArrayList();;
	
	public Xray()
	{
		super("Xray", burningcold.modUtils.Category.RENDER, Keyboard.KEY_X, 00);
	}
	
	@Override
	public void onToggle()
	{
		mc.renderGlobal.loadRenderers();
		super.onToggle();
	}
}
