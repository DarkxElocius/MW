package mw.utils;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import mw.common.item.ItemsCore;
import mw.common.tile.TileManaCommon;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import DummyCore.Utils.UnformedItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ManaUtils {
	
	public static Hashtable<UnformedItemStack, Float> manaCosts = new Hashtable();
	public static Hashtable<UnformedItemStack, String> oreDictionaryNames = new Hashtable();
	public static List<UnformedItemStack> allRegisteredStacks = new ArrayList();
	
	
	public static UnformedItemStack findUnformedISByIS(ItemStack is)
	{
		for(UnformedItemStack stk : allRegisteredStacks)
		{
			if(stk != null && stk.itemStackMatches(is))
				return stk;
		}
		return null;
	}
	
	public static float getManaValue(ItemStack is)
	{
		UnformedItemStack stk = findUnformedISByIS(is);
		if(stk != null)
		{
			return manaCosts.get(stk);
		}
		return -1;
	}
	
	public static void registerManaValueFor(UnformedItemStack is, float value)
	{
		manaCosts.put(is, value);
		allRegisteredStacks.add(is);
	}
	
	public static void registerManaValueFor(String s, float value)
	{
		UnformedItemStack is = new UnformedItemStack(s);
		manaCosts.put(is, value);
		allRegisteredStacks.add(is);
		oreDictionaryNames.put(is, s);
	}
	
	public static void saveInventory(TileManaCommon tile, NBTTagCompound saveTag)
	{
		saveTag.setFloat("mana", tile.getMana());
		saveTag.setFloat("maxMana", tile.getMaxMana());
	}
	
	public static void loadInventory(TileManaCommon tile, NBTTagCompound loadTag)
	{
		tile.setMana(loadTag.getFloat("mana"));
		tile.setMaxMana(loadTag.getFloat("maxMana"));
	}
	
	public static void initAllCardsCrafts()
	{
		for(int i = 0; i < allRegisteredStacks.size(); ++i)
		{
		
		}
	}
	

}
