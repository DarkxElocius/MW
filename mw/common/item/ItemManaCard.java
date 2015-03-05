package mw.common.item;

import java.util.List;

import mw.utils.ManaUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import DummyCore.Utils.UnformedItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemManaCard extends Item{
	
	public ItemManaCard()
	{
		this.setHasSubtypes(true);
		this.setMaxStackSize(16);
		this.setMaxDamage(0);
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item i, CreativeTabs ct, List lst)
    {
    	for(int j = 0; j < ManaUtils.allRegisteredStacks.size(); ++j)
    		lst.add(new ItemStack(i, 1, j));
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stk, EntityPlayer p, List lst, boolean held) 
    {
    	if(ManaUtils.allRegisteredStacks.size() > stk.getItemDamage())
    	{
    		UnformedItemStack is = ManaUtils.allRegisteredStacks.get(stk.getItemDamage());
    		ItemStack istk = is.getISToDraw(p.ticksExisted);
    		if(istk != null)
    		{
    			lst.add(EnumChatFormatting.BOLD+istk.getDisplayName());
    			lst.add("");
    			lst.add("Mana Cost: "+EnumChatFormatting.AQUA+MathHelper.floor_float(ManaUtils.manaCosts.get(is)));
    		}else
    		{
    			if(ManaUtils.oreDictionaryNames.containsKey(is))
    			{
    				lst.add(EnumChatFormatting.BOLD+ManaUtils.oreDictionaryNames.get(is));
    				lst.add(EnumChatFormatting.RED+"Ore not found!");
        			lst.add("");
        			lst.add("Mana Cost: "+EnumChatFormatting.AQUA+MathHelper.floor_float(ManaUtils.manaCosts.get(is)));
    			}
    		}	
    	}
    }

}
