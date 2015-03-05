package mw.common.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;

public class TileRFGenerator extends TileManaCommon implements IEnergyHandler{
	
	public EnergyStorage storage;
	
	public int rfToP;
	
	public void setup(int meta)
	{
		this.setAcceptMana(false);
		this.setEjectMana(true);
		switch(meta)
		{
			case 0:
			{
				this.setMaxMana(100);
				storage = new EnergyStorage(32000);
				break;
			}
			case 1:
			{
				this.setMaxMana(250);
				storage = new EnergyStorage(64000);
				break;
			}
			case 2:
			{
				this.setMaxMana(500);
				storage = new EnergyStorage(128000);
				break;
			}
			case 3:
			{
				this.setMaxMana(1000);
				storage = new EnergyStorage(512000);
				break;
			}
		}
	}
	
	public TileRFGenerator()
	{
		this.setAcceptMana(false);
		this.setEjectMana(true);
	}
	
	public TileRFGenerator(int meta)
	{
		this.setAcceptMana(false);
		this.setEjectMana(true);
		switch(meta)
		{
			case 0:
			{
				this.setMaxMana(100);
				storage = new EnergyStorage(32000);
				break;
			}
			case 1:
			{
				this.setMaxMana(250);
				storage = new EnergyStorage(64000);
				break;
			}
			case 2:
			{
				this.setMaxMana(500);
				storage = new EnergyStorage(128000);
				break;
			}
			case 3:
			{
				this.setMaxMana(1000);
				storage = new EnergyStorage(512000);
				break;
			}
		}

	}
	
	public int getMetadata()
	{
		return this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
	}
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {

		return true;
	}
	
	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {

		return storage.receiveEnergy(maxReceive, simulate);
	}
	
	@Override
	public int getEnergyStored(ForgeDirection from) {

		return storage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {

		return storage.getMaxEnergyStored();
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {

		return 0;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {

		super.readFromNBT(nbt);
		if(this.storage == null)
			this.setup(nbt.getInteger("meta"));
		storage.readFromNBT(nbt);
		rfToP = nbt.getInteger("rtp");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {

		nbt.setInteger("meta", this.getMetadata());
		super.writeToNBT(nbt);
		storage.writeToNBT(nbt);
		nbt.setInteger("rtp", rfToP);
	}
	
	public void updateEntity()
	{
		int currentEnergy = this.storage.getEnergyStored();
		switch(this.getMetadata())
		{
			case 0:
			{
				if(rfToP < 80 && this.storage.extractEnergy(10, true) >= 10 && this.getMana()+1<=this.getMaxMana())
				{
					++rfToP;
					this.storage.extractEnergy(10, false);
				}
				if(rfToP >= 80 && this.getMana() + 1 <= this.getMaxMana())
				{
					if(this.increaseManaBy(1))
						rfToP -= 80;
				}
				break;
			}
			case 1:
			{
				if(rfToP < 40 && this.storage.extractEnergy(60, true) >= 60 && this.getMana()+3<=this.getMaxMana())
				{
					++rfToP;
					this.storage.extractEnergy(60, false);
				}
				if(rfToP >= 40 && this.getMana() + 3 <= this.getMaxMana())
				{
					if(this.increaseManaBy(3))
						rfToP -= 40;
				}
				break;
			}
			case 2:
			{
				if(rfToP < 20 && this.storage.extractEnergy(300, true) >= 300 && this.getMana()+8<=this.getMaxMana())
				{
					++rfToP;
					this.storage.extractEnergy(300, false);
				}
				if(rfToP >= 20 && this.getMana() + 8 <= this.getMaxMana())
				{
					if(this.increaseManaBy(8))
						rfToP -= 20;
				}
				break;
			}
			case 3:
			{
				if(rfToP < 20 && this.storage.extractEnergy(1500, true) >= 1500 && this.getMana()+40<=this.getMaxMana())
				{
					++rfToP;
					this.storage.extractEnergy(1500, false);
				}
				if(rfToP >= 20 && this.getMana() + 40 <= this.getMaxMana())
				{
					if(this.increaseManaBy(40))
						rfToP -= 20;
				}
				break;
			}
		}
		super.updateEntity();
	}

}

