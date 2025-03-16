package net.mcreator.testblock.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class WandProjectileHitsBlockProcedure {
	public static int getSide(Entity entity) {
		double X = entity.getDeltaMovement().x;
		double Y = entity.getDeltaMovement().y;
		double Z = entity.getDeltaMovement().z;
		double max = Math.abs(X);
		System.out.println("X " + X);
		System.out.println("Y " + Y);
		System.out.println("Z " + Z);
		if (max < Math.abs(Y)) {
			max = Math.abs(Y);
		}
		if (max < Math.abs(Z)) {
			max = Math.abs(Z);
		}
		System.out.println("max " + max);
		if (max == Math.abs(X)) {
			if (X < 0) {
				return 0; //prawa
			}
			return 1; //lewa
		} else if (max == Math.abs(Y)) {
			if (Y < 0) {
				return 2; //góra
			}
			return 3; //dół
		} else {
			if (Z < 0) {
				return 4; //tył
			}
			return 5; //przód
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		Block[] blocks = {Blocks.GRASS_BLOCK, Blocks.STONE, Blocks.DIRT};
		int side = getSide(immediatesourceentity);
		Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
		for (int i = 0; i <= blocks.length; i++) {
			if (block == blocks[i]) {
				for (int j = 0; j <= 4; j++) {
					if (side == 0) {
						world.setBlock(new BlockPos(x + j, y, z), block.defaultBlockState(), 3);
					} else if (side == 1) {
						world.setBlock(new BlockPos(x - j, y, z), block.defaultBlockState(), 3);
					} else if (side == 2) {
						world.setBlock(new BlockPos(x, y + j, z), block.defaultBlockState(), 3);
					} else if (side == 3) {
						world.setBlock(new BlockPos(x, y - j, z), block.defaultBlockState(), 3);
					} else if (side == 4) {
						world.setBlock(new BlockPos(x, y, z + j), block.defaultBlockState(), 3);
					} else {
						world.setBlock(new BlockPos(x, y, z - j), block.defaultBlockState(), 3);
					}
				}
				break;
			}
		}
	}
}
