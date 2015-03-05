package mw.common.proxy;

import mw.api.IManaStorage;
import mw.client.Render.ManaCardRenderer;
import mw.client.Render.RenderMWBlocks;
import mw.client.Render.RenderTileApperifier;
import mw.common.item.ItemsCore;
import mw.common.tile.TileApperifier;
import mw.server.MWServer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

import org.lwjgl.opengl.GL11;

import DummyCore.Utils.MathUtils;
import DummyCore.Utils.MiscUtils;
import cofh.api.energy.IEnergyHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class MWClient extends MWServer
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		RenderingRegistry.registerBlockHandler(new RenderMWBlocks());
		ClientRegistry.bindTileEntitySpecialRenderer(TileApperifier.class, new RenderTileApperifier());
		
		MinecraftForgeClient.registerItemRenderer(ItemsCore.card, new ManaCardRenderer());
	}
	
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) 
	{
		return null;
	}
	
	public static void drawManaEnergy(IManaStorage storage)
	{
		Tessellator tec = Tessellator.instance;
		
		tec.startDrawingQuads();
		
		tec.addVertexWithUV(0, 0, 0, 0.25F, 0.25F);
		tec.addVertexWithUV(0, 1, 0, 0.25F, 0);
		tec.addVertexWithUV(1, 1, 0, 0, 0);
		tec.addVertexWithUV(1, 0, 0, 0, 0.25F);
		
		tec.draw();
		
		if(storage != null)
		{
			float scaledTexturedRect = (storage.getMana()/storage.getMaxMana()*100F)/100F*10F;
			
			float offsetPower = 0F;
			int percentage = MathUtils.getPercentage((int)storage.getMana(), (int)storage.getMaxMana());
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
	}
	
	public static void drawRFEnergy(IEnergyHandler gen)
	{
		Tessellator tec = Tessellator.instance;
		
		tec.startDrawingQuads();
		
		tec.addVertexWithUV(0, 0, 0, 0.75F, 0.5F);
		tec.addVertexWithUV(0, 1, 0, 0.75F, 0.25F);
		tec.addVertexWithUV(1, 1, 0, 0.5F, 0.25F);
		tec.addVertexWithUV(1, 0, 0, 0.5F, 0.5F);
		
		tec.draw();
		
		if(gen != null)
		{
			float energyPercentage = (float)gen.getEnergyStored(ForgeDirection.UNKNOWN)/(float)gen.getMaxEnergyStored(ForgeDirection.UNKNOWN);
			
			tec.startDrawingQuads();
			
			tec.addVertexWithUV(0, 0, -0.001F, 1F, 0.5F);
			tec.addVertexWithUV(0, energyPercentage, -0.001F, 1, 0.5F-energyPercentage*0.25F);
			tec.addVertexWithUV(1, energyPercentage, -0.001F, 0.75F, 0.5F-energyPercentage*0.25F);
			tec.addVertexWithUV(1, 0, -0.001F, 0.75F, 0.5F);
			
			tec.draw();
		}
	}
	

	
	public static void drawFluid(FluidTank tank)
	{
		Tessellator tec = Tessellator.instance;
		
		tec.startDrawingQuads();
		
		tec.addVertexWithUV(0, 0, 0.002F, 0.25F, 0.75F);
		tec.addVertexWithUV(0, 1, 0.002F, 0.25F, 0.5F);
		tec.addVertexWithUV(1, 1, 0.002F, 0F, 0.5F);
		tec.addVertexWithUV(1, 0, 0.002F, 0F, 0.75F);
		
		tec.draw();
		
		
		tec.startDrawingQuads();
		
		tec.addVertexWithUV(0, 0, 0, 0.5F, 0.75F);
		tec.addVertexWithUV(0, 1, 0, 0.5F, 0.5F);
		tec.addVertexWithUV(1, 1, 0, 0.25F, 0.5F);
		tec.addVertexWithUV(1, 0, 0, 0.25F, 0.75F);
		
		tec.draw();
		if(tank != null)
		{
			float fluidPercentage = (float)tank.getFluidAmount()/(float)tank.getCapacity();
			
			if(tank.getFluid() != null)
			{
				FluidStack fluid = tank.getFluid();
				
				IIcon icon = fluid.getFluid().getIcon();
				
				MiscUtils.bindTexture("minecraft", "textures/atlas/blocks.png");
	            double minU = icon.getMinU();
	            double maxU = icon.getMaxU();
	            double minV = icon.getMinV();
	            double maxV = icon.getMaxV();
	            double height = 16D;
	            double width = 16D;
	            
	    		tec.startDrawingQuads();
	    		if(fluidPercentage - 0.1F < 0.125F)fluidPercentage = 0.225F;
	    		tec.addVertexWithUV(0.25F, 0.125F, 0.001F, maxU, maxV);
	    		tec.addVertexWithUV(0.25F, fluidPercentage-0.1F, 0.001F, maxU, minV);
	    		tec.addVertexWithUV(0.75F, fluidPercentage-0.1F, 0.001F, minU, minV);
	    		tec.addVertexWithUV(0.75F, 0.125F, 0.001F, minU, maxV);
	    		
	    		tec.draw();
			}
		}
		/*
		tec.startDrawingQuads();
		
		tec.addVertexWithUV(0, 0, -0.001F, 1F, 0.5F);
		tec.addVertexWithUV(0, energyPercentage, -0.001F, 1, 0.5F-energyPercentage*0.25F);
		tec.addVertexWithUV(1, energyPercentage, -0.001F, 0.75F, 0.5F-energyPercentage*0.25F);
		tec.addVertexWithUV(1, 0, -0.001F, 0.75F, 0.5F);
		
		tec.draw();
		*/
	}
	
	public static void drawBlueBar(float genFlt)
	{
		Tessellator tec = Tessellator.instance;
		
		tec.startDrawingQuads();
		
		tec.addVertexWithUV(0, 0, -0.001F, 0.25F, 0.5F);
		tec.addVertexWithUV(0, 1, -0.001F, 0.25F, 0.25F);
		tec.addVertexWithUV(1, 1, -0.001F, 0, 0.25F);
		tec.addVertexWithUV(1, 0, -0.001F, 0, 0.5F);
		
		tec.draw();
		
		tec.startDrawingQuads();
		tec.addVertexWithUV(1-genFlt*4, 0, -0.002F, 0.25F+genFlt, 0.5F);
		tec.addVertexWithUV(1-genFlt*4, 1, -0.002F, 0.25F+genFlt, 0.25F);
		tec.addVertexWithUV(1, 1, -0.002F, 0.25F, 0.25F);
		tec.addVertexWithUV(1, 0, -0.002F, 0.25F, 0.5F);
		
		tec.draw();
	}
	
	public static void glRotatefBasedOnLoop(int i)
	{
		GL11.glRotatef(90*i, 0, 1, 0);
		if(i == 0)
			GL11.glTranslatef(0, 0, -0.01F);
		if(i == 1)
			GL11.glTranslatef(-1, 0, -0.01F);
		if(i == 2)
			GL11.glTranslatef(-1.00F, 0, -1.01F);
		if(i == 3)
			GL11.glTranslatef(0, 0, -1.01F);
		
	}
	
	public static void drawDeviceConfiguration(ForgeDirection side, boolean output, int type)
	{
		MiscUtils.bindTexture("Manamod", "textures/models/common/deviceConfig.png");
		
		Tessellator tec = Tessellator.instance;
		
		float texturePosX = 0F;
		float texturePosY = 0F;
		if(type == 1)
			texturePosX = 0.5F;
		if(type == 2)
			texturePosY = 0.25F;
		if(type == 3)
		{
			texturePosY = 0.25F;
			texturePosX = 0.5F;
		}
		if(type == 4)
		{
			texturePosY = 0.5F;
			texturePosX = 0.0F;
		}
		if(output)
			texturePosX += 0.25F;

		
		if(side == ForgeDirection.UP)
		{
			tec.startDrawingQuads();
			
			tec.addVertexWithUV(0, 1.001F, 0F, texturePosX+0.25F, texturePosY+0.25F);
			tec.addVertexWithUV(0, 1.001F, 1F, texturePosX+0.25F, texturePosY);
			tec.addVertexWithUV(1, 1.001F, 1F, texturePosX, texturePosY);
			tec.addVertexWithUV(1, 1.001F, 0F, texturePosX, texturePosY+0.25F);
			
			tec.draw();
		}
		if(side == ForgeDirection.DOWN)
		{
			tec.startDrawingQuads();
			
			tec.addVertexWithUV(1, -0.001F, 0F, texturePosX+0.25F, texturePosY+0.25F);
			tec.addVertexWithUV(1, -0.001F, 1F, texturePosX+0.25F, texturePosY);
			tec.addVertexWithUV(0, -0.001F, 1F, texturePosX, texturePosY);
			tec.addVertexWithUV(0, -0.001F, 0F, texturePosX, texturePosY+0.25F);
			
			tec.draw();
		}
	}
}
