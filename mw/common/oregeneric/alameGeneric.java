package mw.common.oregeneric;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import mw.common.block.BlocksCore;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class alameGeneric implements IWorldGenerator{
	
	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId) {
        
       
     
        case -1:
        {     
            generateNether();
            break;
        }
           case 0:
    {
            generateSurface(world, random, chunkX*16, chunkZ*16);
            break;
    }
           case 1:
    {
            generateEnd();
            break;
            }
    }
}

	private void generateEnd() {
		// TODO Auto-generated method stub
		
	}

	private void generateNether() {
		// TODO Auto-generated method stub
		
	}

	public void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        for (int i = 0; i < 7; i++) {
        int randPosX = chunkX + rand.nextInt(16);
        int randPosY = rand.nextInt(20);
        int randPosZ = chunkZ + rand.nextInt(16);
 
        (new WorldGenMinable(BlocksCore.alameore, 3)).generate(world, rand,
        randPosX, randPosY, randPosZ);
        }
    }
}



