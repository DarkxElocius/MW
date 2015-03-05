package mw.common.oregeneric;

import cpw.mods.fml.common.registry.GameRegistry;

public class GenericCore {

	public static GenericCore instance;
	
	public void main()
	{
		GameRegistry.registerWorldGenerator(new alameGeneric(), 0);
		GameRegistry.registerWorldGenerator(new koneGeneric(), 0);
		GameRegistry.registerWorldGenerator(new orumGeneric(), 0);
	}

}
