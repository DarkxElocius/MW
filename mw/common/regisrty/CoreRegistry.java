package mw.common.regisrty;

import mw.common.block.BlocksCore;
import mw.common.entity.EntitiesCore;
import mw.common.item.ItemsCore;
import mw.common.oregeneric.GenericCore;
import mw.utils.config.Config;

public class CoreRegistry {
	
public static CoreRegistry instance;
	
	public static void register()
	{
		Config.instance = new Config();
		BlocksCore.instance = new BlocksCore();
		ItemsCore.instance = new ItemsCore();
		RecipeRegistry.instance = new RecipeRegistry();
		EntitiesCore.instance = new EntitiesCore();
		GenericCore.instance = new GenericCore();
		}

}
