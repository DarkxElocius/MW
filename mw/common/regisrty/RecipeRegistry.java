package mw.common.regisrty;

import mw.common.block.BlocksCore;
import mw.common.item.ItemsCore;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeRegistry {

	public static RecipeRegistry instance;
	
	public void main()
	{
		registerDictionary();
		registerRecipes();
	}
	
	public void registerDictionary()
	{
		
	//=========================================================================================================================//
	//================================================Ore Dictionary===========================================================//
	//=========================================================================================================================//	

		OreDictionary.registerOre("shardFire", new ItemStack(ItemsCore.fireCrystal,1,0));
		OreDictionary.registerOre("shardWater", new ItemStack(ItemsCore.waterCrystal,1,0));
		OreDictionary.registerOre("shardEarth", new ItemStack(ItemsCore.earthCrystal,1,0));
		OreDictionary.registerOre("shardAir", new ItemStack(ItemsCore.airCrystal,1,0));
		OreDictionary.registerOre("shardOrdo", new ItemStack(ItemsCore.lightCrystal,1,0));
		OreDictionary.registerOre("shardEntrepy", new ItemStack(ItemsCore.darknessCrystal,1,0));
		
		
	//=========================================================================================================================//	
	//===============================================Items/Blocks for Craft====================================================//	
	//=========================================================================================================================//	
		
		OreDictionary.registerOre("koneIngot", new ItemStack(ItemsCore.koneIngot,1,0));
		OreDictionary.registerOre("alameIngot", new ItemStack(ItemsCore.alameIngot,1,0));
		OreDictionary.registerOre("orumIngot", new ItemStack(ItemsCore.orumIngot,1,0));
		OreDictionary.registerOre("orumblock", new ItemStack(BlocksCore.orumblock,1,0));
		OreDictionary.registerOre("alameblock", new ItemStack(BlocksCore.alameblock,1,0));
		OreDictionary.registerOre("koneblock", new ItemStack(BlocksCore.koneblock,1,0));

	}
		
		
		public void registerRecipes()
		{
	
	//=========================================================================================================================//	
    //=================================================Recipe==================================================================//
	//=========================================================================================================================//	
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksCore.koneblock,1,0), new Object[]{
				"OOO",
				"OOO",
				"OOO",
				'O',"koneIngot"
		}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksCore.orumblock,1,0), new Object[]{
				"OOO",
				"OOO",
				"OOO",
				'O',"orumIngot"
		}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksCore.alameblock,1,0), new Object[]{
				"OOO",
				"OOO",
				"OOO",
				'O',"alameIngot"
		}));
			
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsCore.koneIngot,9,0), new Object[]{
				"koneblock"
		}));
			
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsCore.alameIngot,9,0), new Object[]{
				"alameblock"
		}));
			
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsCore.orumIngot,9,0), new Object[]{
				"orumblock"
		}));
			
		}

}
