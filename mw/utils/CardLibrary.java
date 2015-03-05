package mw.utils;

import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.OreDictionary;

public class CardLibrary {
	
	public static void load()
	{
		OreDictionary.registerOre("blockEndstone", Blocks.end_stone);
		OreDictionary.registerOre("blockSoulSand", Blocks.soul_sand);
		ManaUtils.registerManaValueFor("oreCopper", 270);
		ManaUtils.registerManaValueFor("oreCertusQuartz", 500);
		ManaUtils.registerManaValueFor("oreIron", 280);
		ManaUtils.registerManaValueFor("oreCinnabar", 450);
		ManaUtils.registerManaValueFor("oreLead", 300);
		ManaUtils.registerManaValueFor("oreTin", 300);
		ManaUtils.registerManaValueFor("oreQuartz", 450);
		ManaUtils.registerManaValueFor("oreInfusedFire", 350);
		ManaUtils.registerManaValueFor("oreInfusedWater", 350);
		ManaUtils.registerManaValueFor("oreInfusedEarth", 350);
		ManaUtils.registerManaValueFor("oreInfusedAir", 350);
		ManaUtils.registerManaValueFor("oreInfusedOrder",350);
		ManaUtils.registerManaValueFor("oreInfusedEntropy", 350);
		ManaUtils.registerManaValueFor("oreGold", 400);
		ManaUtils.registerManaValueFor("oreLapis", 450);
		ManaUtils.registerManaValueFor("oreYellorium", 800);
		ManaUtils.registerManaValueFor("oreRedstone", 300);
		ManaUtils.registerManaValueFor("oreDiamond", 550);
		ManaUtils.registerManaValueFor("oreEmerald", 580);
		ManaUtils.registerManaValueFor("blockSoulSand", 100);
	}

}