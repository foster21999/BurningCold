package burningcold.modUtils;

import net.minecraft.client.Minecraft;

public class Module implements ModuleInterface
{
	protected static Minecraft mc = Minecraft.getMinecraft();
	private String name;
	private Category category;
	private int key;
	private boolean enabled;
	private int color;
	
	public Module(String n, Category c, int k, int co)
	{
		name = n;
		category = c;
		key = k;
		color = co;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public Category getCategory()
	{
		return category;
	}

	@Override
	public int getKeybind()
	{
		return key;
	}
	
	@Override
	public int getColor()
	{
		return color;
	}

	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	@Override
	public void setKeybind(int k)
	{
		key = k;
	}

	@Override
	public void setToggle(boolean b)
	{
		onToggle();
		enabled = b;
		if (b)
		{
			onEnable();
		} else
		{
			onDisable();
		}
	}

	@Override
	public void toggleModule()
	{
		setToggle(!enabled);
	}

	@Override
	public void onToggle()
	{
		//empty for now
	}

	@Override
	public void onEnable()
	{
		//empty for now
	}

	@Override
	public void onDisable()
	{
		//empty for now
	}

	@Override
	public void onUpdate()
	{
		//empty for now
	}

	@Override
	public void onRender()
	{
		//empty for now
	}
}
