package mw.common.item;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TestItem extends ItemSword{
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
	
	public TestItem(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
	}

}
