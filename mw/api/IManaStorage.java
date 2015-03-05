package mw.api;

import net.minecraftforge.common.util.ForgeDirection;

public interface IManaStorage {
		
		public float getMana();
		
		public boolean canEjectManaFrom(ForgeDirection dir);
		
		public boolean canInsertManaInto(ForgeDirection dir);
		
		public boolean setMana(float newAmount);
		
		public boolean setMaxMana(float newAmount);
		
		public boolean increaseManaBy(float increasedBy);
		
		public float getMaxMana();

}
