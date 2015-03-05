package mw.utils;

import DummyCore.Utils.GuiContainerLibrary;

public class GCLibrary {
	
	public static void register()
	{
		guiApperifierID = GuiContainerLibrary.registerGuiContainer("DummyCore.Client.GuiCommon", "mw.common.inventory.InventoryApperifier");
	}
	
	public static int guiApperifierID;

}
