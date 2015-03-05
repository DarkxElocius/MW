package mw.common.tile;

import java.util.ArrayList;

import mw.api.IManaStorage;
import mw.utils.ManaUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import DummyCore.Utils.MiscUtils;

public class TileManaCommon extends TileEntity implements IManaStorage, IInventory, ISidedInventory{
	
	public ArrayList<ArrayList<Integer>> slotsFromSize = new ArrayList();
	public int syncTick;
	public ArrayList<Integer> notAccessible = new ArrayList();
	
	public float Mana, maxMana;
	private ItemStack[] items = new ItemStack[1];
	
	public boolean canAcceptMana = false, canEjectMana = false;
	
	public void setAcceptMana(boolean b)
	{
		canAcceptMana = b;
	}
	
	public void setEjectMana(boolean b)
	{
		canEjectMana = b;
	}
	
	public void setSlotsNum(int i)
	{
		items = new ItemStack[i];
	}
	
	public void setSlotAccessibleFrom(int slot, ForgeDirection... dir)
	{
		if(slotsFromSize.isEmpty())
		{
			for(int i = 0; i < 6; ++i)
			{
				slotsFromSize.add(new ArrayList<Integer>());
			}
		}
		
		for(ForgeDirection d : dir)
		{
			slotsFromSize.get(d.ordinal()).add(slot);
		}
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int side) 
	{
		if(slotsFromSize.isEmpty())
		{
			for(int i = 0; i < 6; ++i)
			{
				slotsFromSize.add(new ArrayList<Integer>());
			}
		}
		ArrayList<Integer> slots = slotsFromSize.get(side);
		int[] retInt = new int[]{};
		if(slots.isEmpty())
		{
			retInt = new int[this.getSizeInventory()];
			for(int i = 0; i < this.getSizeInventory(); ++i)
			{
				retInt[i] = i;
			}
			for(int i = 0; i < this.notAccessible.size(); ++i)
			{
				retInt[this.notAccessible.get(i)] = 0;
			}
		}else
		{
			retInt = new int[slots.size()];
			for(int i = 0; i < retInt.length; ++i)
			{
				retInt[i] = slots.get(i);
			}
		}
		return retInt;
	}

	@Override
    public void readFromNBT(NBTTagCompound i)
    {
		super.readFromNBT(i);
		ManaUtils.loadInventory(this,i);
		MiscUtils.loadInventory(this, i);
    }
	
	@Override
    public void writeToNBT(NBTTagCompound i)
    {
    	super.writeToNBT(i);
    	ManaUtils.saveInventory(this,i);
    	MiscUtils.saveInventory(this, i);
    }
	
	public void updateEntity() 
	{
		if(canEjectMana)
		{
			for(int i = 0; i < 6; ++i)
			{
				ForgeDirection dir = ForgeDirection.getOrientation(i);
				TileEntity tile = this.worldObj.getTileEntity(xCoord+dir.offsetX, yCoord+dir.offsetY, zCoord+dir.offsetZ);
				if(tile instanceof IManaStorage)
				{
					if(((IManaStorage) tile).canInsertManaInto(dir.getOpposite()))
					{
						IManaStorage storage = (IManaStorage) tile;
						float leftoverMana = (storage.getMaxMana() - storage.getMana())/10;
						if(this.getMana()-leftoverMana >= 0)
						{
							if(storage.increaseManaBy(leftoverMana))
								this.increaseManaBy(-leftoverMana);
						}else
						{
							float addedMana = this.getMana();
							if(storage.increaseManaBy(addedMana))
								this.increaseManaBy(-addedMana);
						}
					}
				}
			}
		}
		
		if(syncTick == 0)
		{
			if(!this.worldObj.isRemote)
			{
				MiscUtils.sendPacketToAllAround(worldObj, getDescriptionPacket(), xCoord, yCoord, zCoord, this.worldObj.provider.dimensionId, 128);
			}
			syncTick = 10;
		}else
			--this.syncTick;
	}
	
	@Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, -10, nbttagcompound);
    }
	
	@Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
		if(net.getNetHandler() instanceof INetHandlerPlayClient)
			if(pkt.func_148853_f() == -10)
				this.readFromNBT(pkt.func_148857_g());
    }
	
	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_,
			int p_102007_3_) {
		return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
	}
	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_,
			int p_102008_3_) {
		return true;
	}

	@Override
	public int getSizeInventory() {
		return this.items.length;
	}

	@Override
	public ItemStack getStackInSlot(int par1) {
		return this.items[par1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
        if (this.items[par1] != null)
        {
            ItemStack itemstack;

            if (this.items[par1].stackSize <= par2)
            {
                itemstack = this.items[par1];
                this.items[par1] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.items[par1].splitStack(par2);

                if (this.items[par1].stackSize == 0)
                {
                    this.items[par1] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
	}

	@Override
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.items[par1] != null)
        {
            ItemStack itemstack = this.items[par1];
            this.items[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
	{
        this.items[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
	}

	@Override
	public String getInventoryName()
	{
		return "genericInvName";
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
	{
		return p_70300_1_.dimension == this.worldObj.provider.dimensionId;
	}

	@Override
	public void openInventory() 
	{
		
	}

	@Override
	public void closeInventory()
	{
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
	{
		return true;
	}

	@Override
	public float getMana() 
	{
		return this.Mana;
	}

	@Override
	public boolean canEjectManaFrom(ForgeDirection dir) 
	{
		return dir != ForgeDirection.UP && dir != ForgeDirection.DOWN;
	}

	@Override
	public boolean canInsertManaInto(ForgeDirection dir)
	{
		return (dir == ForgeDirection.UP || dir == ForgeDirection.DOWN) && canAcceptMana;
	}

	@Override
	public boolean setMana(float newAmount) 
	{
		if(newAmount >= 0 && newAmount <= this.getMaxMana())
		{
			this.Mana = newAmount;
			return true;
		}
		return false;
	}

	@Override
	public boolean increaseManaBy(float increasedBy) 
	{
		if(this.getMana()+increasedBy <= this.getMaxMana() && this.getMana()+increasedBy >= 0)
		{
			return this.setMana(this.getMana()+increasedBy);
		}
		return false;
	}

	@Override
	public float getMaxMana() {
		return this.maxMana;
	}

	@Override
	public boolean setMaxMana(float newAmount) {
		this.maxMana = newAmount;
		return true;
	}

}