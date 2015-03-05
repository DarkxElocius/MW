package mw.common.core;

import mw.common.block.BlocksCore;
import mw.common.entity.EntitiesCore;
import mw.common.item.ItemsCore;
import mw.common.oregeneric.GenericCore;
import mw.common.regisrty.CoreRegistry;
import mw.common.regisrty.RecipeRegistry;
import mw.common.tile.TileApperifier;
import mw.common.tile.TileRFGenerator;
import mw.utils.CardLibrary;
import mw.utils.GCLibrary;
import mw.utils.ManaUtils;
import mw.utils.config.Config;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=ModInfo.MODID, name=ModInfo.NAME,version=ModInfo.VERSION)
public class Core {

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		try
		{
			DummyCore.Core.Core.registerModAbsolute(getClass(), "MysteriosWorld", event.getModConfigurationDirectory().getAbsolutePath(), new Config());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return;
		}
		CoreRegistry.register();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		GCLibrary.register();
		BlocksCore.instance.loadBlocks();
		ItemsCore.instance.loadItems();
		RecipeRegistry.instance.main();
		EntitiesCore.registerEntities();
		GenericCore.instance.main();
		GameRegistry.registerTileEntity(TileApperifier.class, "mw.common.tile.TileApperifier");
		GameRegistry.registerTileEntity(TileRFGenerator.class, "mw.common.tile.TileRFGenerator");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		CardLibrary.load();
		ManaUtils.initAllCardsCrafts();
	}
	
	@EventHandler
	public void serverStart(FMLServerStartingEvent event)
    {
		
    }
}
