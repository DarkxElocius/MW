package mw.client.Render;

import mw.common.block.BlockApperifier;
import mw.common.block.BlockRFGen;
import mw.common.proxy.MWClient;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderMWBlocks implements ISimpleBlockRenderingHandler{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId,
			RenderBlocks renderer)
	{
		
		if(block instanceof BlockApperifier)
		{
			renderer.setOverrideBlockTexture(block.getBlockTextureFromSide(0));
			renderer.renderBlockAsItem(Blocks.glass, 1, 1);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			
			for(int i = 0; i < 4; ++i)
			{
				GL11.glPushMatrix();
				GL11.glColor3f(1, 1, 1);
				MWClient.glRotatefBasedOnLoop(i);
				
				MWClient.drawManaEnergy(null);
				
				GL11.glPopMatrix();
			}
			MWClient.drawDeviceConfiguration(ForgeDirection.UP, true, 0);
			MWClient.drawDeviceConfiguration(ForgeDirection.DOWN, false, 2);
			renderer.clearOverrideBlockTexture();
			
		}
		
		if(block instanceof BlockRFGen)
		{
			renderer.setOverrideBlockTexture(block.getBlockTextureFromSide(0));
			renderer.renderBlockAsItem(Blocks.glass, 1, 1);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			
			for(int i = 0; i < 4; ++i)
			{
				GL11.glPushMatrix();
				GL11.glColor3f(1, 1, 1);
				MWClient.glRotatefBasedOnLoop(i);
				
				MWClient.drawManaEnergy(null);
				
				MWClient.drawRFEnergy(null);
				
				GL11.glPopMatrix();
			}
			MWClient.drawDeviceConfiguration(ForgeDirection.UP, true, 2);
			renderer.clearOverrideBlockTexture();
			}
			
		}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		if (block instanceof BlockApperifier
		)
		{
			renderer.setOverrideBlockTexture(block.getBlockTextureFromSide(0));
			renderer.renderStandardBlock(Blocks.glass, x, y, z);
			renderer.clearOverrideBlockTexture();
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return 66996688;
	}

}
