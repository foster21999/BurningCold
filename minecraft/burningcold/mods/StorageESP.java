package burningcold.mods;

import java.awt.Color;
import org.lwjgl.input.Keyboard;
import burningcold.modUtils.Module;
import burningcold.utils.RenderUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.*;

public class StorageESP extends Module
{
	private int maxQueue = 750;
	
	public StorageESP()
	{
		super("Storage ESP", burningcold.modUtils.Category.RENDER, Keyboard.KEY_G, 00);
	}
	
	@Override
	public void onRender()
	{
		int numStorage = 0;
		
		if (!isEnabled())
			return;
		
		for (TileEntity tE: mc.world.loadedTileEntityList)
		{
			/*
			 	if (numStorage >= maxQueue)
				break;
			*/
			if (tE instanceof TileEntityChest) {
				RenderUtils.drawEspBox(tE.getPos(), 0.0, 0.0, 1); //BLUE
			} 
			else if (tE instanceof TileEntityDropper) {
				RenderUtils.drawEspBox(tE.getPos(), 0.0, 1, 0.0); //GREEN
			} 
			else if (tE instanceof TileEntityDispenser) {
				RenderUtils.drawEspBox(tE.getPos(), 1, 0.0, 0.0);
			} 
			else if (tE instanceof TileEntityFurnace) {
				RenderUtils.drawEspBox(tE.getPos(), 1, 1, 1); //WHITE
			} 
			else if (tE instanceof TileEntityShulkerBox) {
				RenderUtils.drawEspBox(tE.getPos(), 1, 0.0, 1);
			} 
			else if (tE instanceof TileEntityHopper) {
				RenderUtils.drawEspBox(tE.getPos(), 1, 1, 0.0);
			} 
			else if (tE instanceof TileEntityEnderChest) {
				RenderUtils.drawEspBox(tE.getPos(), 0.5, 0.5, 0.5); //GREY
			}
			
			for (Entity eM: mc.world.loadedEntityList)
			{
				if (eM instanceof EntityMinecartChest) {
					RenderUtils.drawEspBox(eM.getPosition(), 0.0, 0.0, 1);
				}
				else if (eM instanceof EntityMinecartHopper) {
					RenderUtils.drawEspBox(eM.getPosition(), 1, 1, 0.0);
				}
			}
		}
		
		super.onRender();
	}
	
	@Override
	public void onDisable()
	{
		super.onDisable();
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}
}
