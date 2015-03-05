package mw.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockGeneric extends ItemBlock{

	public ItemBlockGeneric(Block p_i45328_1_) {
		super(p_i45328_1_);
	}

    public int getMetadata(int par1)
    {
        return par1;
    }

}
