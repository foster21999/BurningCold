package burningcold.modUtils;

public abstract interface ModuleInterface
{
	public abstract String getName();
	public abstract Category getCategory();
	public abstract int getKeybind();
	public abstract int getColor();
	public abstract boolean isEnabled();
	public abstract void setKeybind(int paramInt);
	public abstract void setToggle(boolean paramBoolean);
	public abstract void toggleModule();
	public abstract void onToggle();
	public abstract void onEnable();
	public abstract void onDisable();
	public abstract void onUpdate();
	public abstract void onRender();
}
