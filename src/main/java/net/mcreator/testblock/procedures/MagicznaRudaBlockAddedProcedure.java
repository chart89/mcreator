package net.mcreator.testblock.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.core.BlockPos;

import net.mcreator.testblock.init.TestblockModBlocks;

public class MagicznaRudaBlockAddedProcedure {
	public static int randomPosition() {//metoda do losowania przesunięcia
		int random = (int) (Math.random() * 10);
		int isMinus = (int) (Math.random() * 2);
		if (isMinus == 1) {
			random = random * (-1);
		}
		return random;
	}

	public static void makeGravel(LevelAccessor world, double x, double y, double z) {
		int i, j, k;
		for (i = (int) x - 4; i < (int) x + 5; i++) {
			for (j = (int) y - 4; j < (int) y + 5; j++) {
				for (k = (int) z - 4; k < (int) z + 5; k++) {
					if ((world.getBlockState(new BlockPos(i, j, k))).getBlock() != TestblockModBlocks.MAGICZNA_RUDA.get()) {
						if ((world.getBlockState(new BlockPos(i, j, k))).getBlock() != Blocks.AIR) {
							world.setBlock(new BlockPos(i, j, k), Blocks.GRAVEL.defaultBlockState(), 3);
						}
					}
				}
			}
		}
	}

	public static void makeTrees(LevelAccessor world, double x, double y, double z) {
		int X, Y, Z;
		for (int i = 0; i < 5; i++) {
			X = randomPosition();
			Z = randomPosition();
			Y = (int) (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x + X, (int) z + Z));
			if (Math.abs(Y - y) < 2) {
				world.setBlock(new BlockPos(x + X, Y, z + Z), Blocks.OAK_SAPLING.defaultBlockState(), 3);
				for (int j = 0; j < 10; j++) {
					if (world instanceof Level _level) {
						BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, new BlockPos(x + X, Y, z + Z));
					}
				}
			}
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.STONE) {
			makeGravel(world, x, y, z);
		} else if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK) {
			makeTrees(world, x, y, z);
		}
	}
}
