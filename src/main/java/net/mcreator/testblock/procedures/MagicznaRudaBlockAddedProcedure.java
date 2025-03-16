package net.mcreator.testblock.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.core.BlockPos;

import net.mcreator.testblock.init.TestblockModItems;
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

	public static boolean isOre(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == TestblockModBlocks.MAGICZNA_RUDA.get()) {
			return true;
		}
		return false;
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.STONE) {
			makeGravel(world, x, y, z);
		} else if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK) {
			makeTrees(world, x, y, z);
		} else if (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.BEDROCK && y >= 120) {
			if ((isOre(world, x - 1, y, z + 1) && isOre(world, x + 1, y, z - 1))
					|| (isOre(world, x + 1, y, z + 1) && isOre(world, x - 1, y, z - 1))) {
				for (int X = (int) x - 1; X <= (int) x + 1; X++) {
					for (int Z = (int) z - 1; Z <= (int) z + 1; Z++) {
						world.setBlock(new BlockPos(X, y, Z), Blocks.AIR.defaultBlockState(), 3);
					}
				}
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TestblockModItems.WAND.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}

			}
		}
	}
}
