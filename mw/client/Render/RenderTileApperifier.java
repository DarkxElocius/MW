package mw.client.Render;

import mw.api.IManaStorage;
import mw.common.proxy.MWClient;
import mw.common.tile.TileApperifier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import DummyCore.Utils.MathUtils;

public class RenderTileApperifier extends TileEntitySpecialRenderer{
	
	public static final ResourceLocation generatorTextures = new ResourceLocation("mysteriosworld","textures/models/common/powerCharge.png");

	@Override
	public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_,
			double p_147500_4_, double p_147500_6_, float p_147500_8_)
	{
		int x = p_147500_1_.xCoord;
		int y = p_147500_1_.yCoord;
		int z = p_147500_1_.zCoord;
		World w = p_147500_1_.getWorldObj();
		Minecraft.getMinecraft().renderEngine.bindTexture(generatorTextures);
		GL11.glPushMatrix();
		TileApperifier ap = (TileApperifier) p_147500_1_;
		RenderHelper.disableStandardItemLighting();
			GL11.glTranslated(p_147500_2_, p_147500_4_, p_147500_6_);
			Tessellator tec = Tessellator.instance;
			
			for(int i = 0; i < 4; ++i)
			{
				GL11.glPushMatrix();
				
				MWClient.glRotatefBasedOnLoop(i);
				
				GL11.glColor3f(1, 1, 1);
				
				IManaStorage storage = (IManaStorage) p_147500_1_;
				
				tec.startDrawingQuads();
				
				tec.addVertexWithUV(0, 0, 0, 0.25F, 0.25F);
				tec.addVertexWithUV(0, 1, 0, 0.25F, 0);
				tec.addVertexWithUV(1, 1, 0, 0, 0);
				tec.addVertexWithUV(1, 0, 0, 0, 0.25F);
				
				tec.draw();
				
				if(storage != null)
				{
					float scaledTexturedRect = (storage.getMana()/ap.requiredToCreate*100F)/100F*10F;
					
					float offsetPower = 0F;
					int percentage = MathUtils.getPercentage((int)storage.getMana(), (int)ap.requiredToCreate);
					if(percentage < 42)
					{
						offsetPower = 0.75F;
					}else
						if(percentage < 67)
						{
							offsetPower = 0.5F;
						}else
							offsetPower = 0.25F;
					tec.startDrawingQuads();
					
					tec.addVertexWithUV(0, 0, -0.001F, 0.25F+offsetPower, 0.25F);
					tec.addVertexWithUV(0, ((double)scaledTexturedRect/10D), -0.001F, 0.25F+offsetPower, 0.25F-((double)scaledTexturedRect/10D)*0.25F);
					tec.addVertexWithUV(1, ((double)scaledTexturedRect/10D), -0.001F, offsetPower, 0.25F-((double)scaledTexturedRect/10D)*0.25F);
					tec.addVertexWithUV(1, 0, -0.001F, offsetPower, 0.25F);
					
					tec.draw();
				}
				
				GL11.glPopMatrix();
			}
		MWClient.drawDeviceConfiguration(ForgeDirection.DOWN, false, 2);
		MWClient.drawDeviceConfiguration(ForgeDirection.UP, true, 0);
		RenderHelper.enableStandardItemLighting();
		GL11.glPopMatrix();
	}

}
