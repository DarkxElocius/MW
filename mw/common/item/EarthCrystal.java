package mw.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EarthCrystal extends Item{
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par3ItemStack)
    {
        return true;
    }
	
	

}
