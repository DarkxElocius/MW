package mw.common.block;

import mw.common.core.Core;
import mw.common.item.ItemBlockGeneric;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import DummyCore.Blocks.BlocksRegistry;

public class BlocksCore {

	public static BlocksCore instance;
	
	//***************************************************************************************************************************************//
	//******************************************************Block Register*******************************************************************//
	//***************************************************************************************************************************************//

	public void loadBlocks() {
		koneore = new KoneOre().setHardness(3.0F).setResistance(5.0F).setLightOpacity(1).setBlockName("mysteriosworld:koneore").setBlockTextureName("mysteriosworld:koneOre");
		BlocksRegistry.registerBlock(koneore, "KoneOre", Core.class, ItemBlockGeneric.class);
		
		orumore = new OrumOre().setHardness(3.0F).setResistance(5.0F).setLightOpacity(1).setBlockName("mysteriosworld:orumore").setBlockTextureName("mysteriosworld:orumOre");
		BlocksRegistry.registerBlock(orumore, "OrumOre", Core.class, ItemBlockGeneric.class);
		
		alameore = new AlameOre().setHardness(3.0F).setResistance(5.0F).setLightOpacity(1).setBlockName("mysteriosworld:alameore").setBlockTextureName("mysteriosworld:alameOre");
		BlocksRegistry.registerBlock(alameore, "AlameOre", Core.class, ItemBlockGeneric.class);
		
		koneblock = new KoneBlock().setHardness(4.0F).setResistance(10.0F).setLightOpacity(1).setBlockName("mysteriosworld:koneblock").setBlockTextureName("mysteriosworld:koneBlock");
		BlocksRegistry.registerBlock(koneblock, "KoneBlock", Core.class, ItemBlockGeneric.class);
		
		orumblock = new OrumBlock().setHardness(4.0F).setResistance(10.0F).setLightOpacity(1).setBlockName("mysteriosworld:orumblock").setBlockTextureName("mysteriosworld:orumBlock");
		BlocksRegistry.registerBlock(orumblock, "OrumBlock", Core.class, ItemBlockGeneric.class);
		
		alameblock = new AlameBlock ().setHardness(4.0F).setResistance(10.0F).setLightOpacity(1).setBlockName("mysteriosworld:alameblock").setBlockTextureName("mysteriosworld:alameBlock");
		BlocksRegistry.registerBlock(alameblock, "AlameBlock", Core.class, ItemBlockGeneric.class);
	
	//***************************************************************************************************************************************//
	//**********************************************************Devices Blocks***************************************************************//
	//***************************************************************************************************************************************//
		apperifier = new BlockApperifier().setBlockName("mysteriosworld:apperifier").setBlockTextureName("mysteriosworld:clock").setHardness(1.0F).setLightOpacity(1).setLightLevel(0).setResistance(1).setStepSound(Block.soundTypeMetal);
		BlocksRegistry.registerBlock(apperifier, "apperifier", Core.class, ItemBlock.class);
		
		rFGen = new BlockRFGen().setBlockName("mysteriosworld.rFGen").setBlockTextureName("mysteriosworld:clock").setHardness(1.0F).setLightOpacity(1).setLightLevel(0).setResistance(1).setStepSound(Block.soundTypeMetal);
		BlocksRegistry.registerBlock(rFGen, "rFGen", Core.class, ItemBlockHasMetadata.class);
		
		
		
	//***************************************************************************************************************************************//
	//**********************************************************Fluids***********************************************************************//
	//***************************************************************************************************************************************//
	
		manaFluid = new Fluid("manaFluid").setDensity(10000).setLuminosity(15).setTemperature(290).setViscosity(10000);
		FluidRegistry.registerFluid(manaFluid);
		
		manaLiquid = new BlockManaLiquid(manaFluid, Material.water).setBlockName("mysteriosworld.fluid.mana").setBlockTextureName("mysteriosworld:mana").setBlockUnbreakable().setLightLevel(15F).setTickRandomly(true);
		BlocksRegistry.registerBlock(manaLiquid, "manaLiquid", Core.class, ItemBlock.class);
		manaFluid.setBlock(manaLiquid);
	
	}
	
	
	//***************************************************************************************************************************************//
	//**********************************************************Block Name*******************************************************************//
	//***************************************************************************************************************************************//
	
	public static Block koneore;
	public static Block orumore;
	public static Block alameore;
	public static Block koneblock;
	public static Block orumblock;
	public static Block alameblock;
	public static Block apperifier;
	public static Block rFGen;
	public static Block manaLiquid;
	
	
	public static Fluid manaFluid;
	
}
