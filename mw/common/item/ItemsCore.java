package mw.common.item;

import mw.common.block.BlocksCore;
import mw.common.core.Core;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import DummyCore.Items.ItemRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemsCore {

	public static ItemsCore instance;
	
	//***************************************************************************************************************************************//
	//******************************************************Item Register********************************************************************//
	//***************************************************************************************************************************************//


	public void loadItems() {
		
		MysticIron = EnumHelper.addToolMaterial("MysticIron", 5, 8765, 14.0F, 10.0F, 21);
		SuperStick = EnumHelper.addToolMaterial("SuperStick", 99999999, 99999999, 9999999999.9F, 999999999999.9F, 100);
		
		koneIngot = new KoneIngot().setUnlocalizedName("mysteriosworld:koneingot").setTextureName("mysteriosworld:koneIngot").setMaxStackSize(64);
		ItemRegistry.registerItem(koneIngot, Core.class);
		GameRegistry.registerItem(koneIngot, "KoneIngot");
		
		orumIngot = new OrumIngot().setUnlocalizedName("mysteriosworld:orumingot").setTextureName("mysteriosworld:orumIngot").setMaxStackSize(64);
		ItemRegistry.registerItem(orumIngot, Core.class);
		GameRegistry.registerItem(orumIngot, "OrumIngot");
		
		alameIngot = new AlameIngot().setUnlocalizedName("mysteriosworld:alameingot").setTextureName("mysteriosworld:alameIngot").setMaxStackSize(64);
		ItemRegistry.registerItem(alameIngot, Core.class);
		GameRegistry.registerItem(alameIngot, "AlameIngot");
		
		waterCrystal = new WaterCrystal().setUnlocalizedName("mysteriosworld:watercrystal").setTextureName("mysteriosworld:waterCrystal").setMaxStackSize(64);
		ItemRegistry.registerItem(waterCrystal, Core.class);
		GameRegistry.registerItem(waterCrystal, "WaterCrystal");
		
		earthCrystal = new EarthCrystal().setUnlocalizedName("mysteriosworld:earthcrystal").setTextureName("mysteriosworld:earthCrystal").setMaxStackSize(64);
		ItemRegistry.registerItem(earthCrystal, Core.class);
		GameRegistry.registerItem(earthCrystal, "EarthCrystal");
		
		fireCrystal = new FireCrystal().setUnlocalizedName("mysteriosworld:firecrystal").setTextureName("mysteriosworld:fireCrystal").setMaxStackSize(64);
		ItemRegistry.registerItem(fireCrystal, Core.class);
		GameRegistry.registerItem(fireCrystal, "FireCrystal");
		
		airCrystal = new AirCrystal().setUnlocalizedName("mysteriosworld:aircrystal").setTextureName("mysteriosworld:airCrystal").setMaxStackSize(64);
		ItemRegistry.registerItem(airCrystal, Core.class);
		GameRegistry.registerItem(airCrystal, "AirCrystal");
		
		darknessCrystal = new DarknessCrystal().setUnlocalizedName("mysteriosworld:darknesscrystal").setTextureName("mysteriosworld:darknesscrystal").setMaxStackSize(64);
		ItemRegistry.registerItem(darknessCrystal, Core.class);
		GameRegistry.registerItem(darknessCrystal, "DarknessCrystal");
		
		lightCrystal = new LightCrystal().setUnlocalizedName("mysteriosworld:lightcrystal").setTextureName("mysteriosworld:lightcrystal").setMaxStackSize(64);
		ItemRegistry.registerItem(lightCrystal, Core.class);
		GameRegistry.registerItem(lightCrystal, "LightCrystal");
		
		ItemTest = new TestItem(SuperStick).setUnlocalizedName("mysteriosworld:itemtest").setTextureName("minecraft:stick").setMaxStackSize(3);
		ItemRegistry.registerItem(ItemTest, Core.class);
		GameRegistry.registerItem(ItemTest, "ItemTest");
		
		alchemicalPerl = new AlchemicalPerl().setUnlocalizedName("mysteriosworld.alchemicalperl").setTextureName("mysteriosworld:alchemicalPerl").setMaxStackSize(16);
		ItemRegistry.registerItem(alchemicalPerl, Core.class);
		GameRegistry.registerItem(alchemicalPerl, "AlchemicalPerl");
		
		card = new ItemManaCard().setUnlocalizedName("mysteriosworld.card").setTextureName("mysteriosworld:card");
		ItemRegistry.registerItem(card, "manaCard", Core.class);
		
		manaBucket = new ItemBucketMana(BlocksCore.manaLiquid).setUnlocalizedName("mysteriosworld.bucketMana").setTextureName("mysteriosworld:bucket_Mana");
		ItemRegistry.registerItem(manaBucket, "manaBucket", Core.class);
		FluidContainerRegistry.registerFluidContainer(new FluidStack(BlocksCore.manaFluid, 1000), new ItemStack(manaBucket),new ItemStack(Items.bucket));
		
		
	//***************************************************************************************************************************************//	
	//******************************************************Register Tools*******************************************************************//
	//***************************************************************************************************************************************//
		
		
		mysticSword = new MysticSword(MysticIron).setUnlocalizedName("mysteriosworld:mysticsword").setTextureName("mysteriosworld:mysticSword").setMaxStackSize(1);
		ItemRegistry.registerItem(mysticSword, Core.class);
		GameRegistry.registerItem(mysticSword, "MysticSword");
		
		mysticPickaxe = new MysticPickaxe(MysticIron).setUnlocalizedName("mysteriosworld:mysticpickaxe").setTextureName("mysteriosworld:mysticPickaxe").setMaxStackSize(1);
		ItemRegistry.registerItem(mysticPickaxe, Core.class);
		GameRegistry.registerItem(mysticPickaxe, "mysticPickaxe");
		
		mysticShovel = new MysticShovel(MysticIron).setUnlocalizedName("mysteriosworld:mysticShovel").setTextureName("mysteriosworld:mysticShovel").setMaxStackSize(1);
		ItemRegistry.registerItem(mysticShovel, Core.class);
		GameRegistry.registerItem(mysticShovel, "mysticShovel");
		
		mysticHoe = new MysticHoe(MysticIron).setUnlocalizedName("mysteriosworld:mysticHoe").setTextureName("mysteriosworld:mysticHoe").setMaxStackSize(1);
		ItemRegistry.registerItem(mysticHoe, Core.class);
		GameRegistry.registerItem(mysticHoe, "mysticHoe");
		
		mysticAxe = new MysticAxe(MysticIron).setUnlocalizedName("mysteriosworld:mysticAxe").setTextureName("mysteriosworld:mysticAxe").setMaxStackSize(1);
		ItemRegistry.registerItem(mysticAxe, Core.class);
		GameRegistry.registerItem(mysticAxe, "mysticAxe");
		
		
}
	
	//***************************************************************************************************************************************//	
	//******************************************************Item Name************************************************************************//
	//***************************************************************************************************************************************//

	public static Item koneIngot;
	public static Item orumIngot;
	public static Item alameIngot;
	public static Item mysticSword;
	public static Item mysticPickaxe;
	public static Item mysticShovel;
	public static Item mysticHoe;
	public static Item mysticAxe;
	public static Item waterCrystal;
	public static Item earthCrystal;
	public static Item fireCrystal;
	public static Item airCrystal;
	public static Item darknessCrystal;
	public static Item lightCrystal;
	public static Item alchemicalPerl;
	public static Item card;
	public static Item manaBucket;
	
	public static Item ItemTest;
	
	public static ToolMaterial MysticIron;
	public static ToolMaterial SuperStick;
	
}
