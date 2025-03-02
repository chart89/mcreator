package net.mcreator.testblock.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class TowerOnBlockRightClickedProcedure {
	public static void wallX(LevelAccessor world, int x, int Y, int z) {
		for (int X = x - 10; X <= x + 10; X++) {
			int Z = z - 10;
			world.setBlock(new BlockPos(X, Y, Z), Blocks.STONE_BRICKS.defaultBlockState(), 3);
			Z = z + 10;
			world.setBlock(new BlockPos(X, Y, Z), Blocks.STONE_BRICKS.defaultBlockState(), 3);
		}
	}

	public static void wallZ(LevelAccessor world, int x, int Y, int z) {
		for (int Z = z - 10; Z <= z + 10; Z++) {
			int X = x - 10;
			world.setBlock(new BlockPos(X, Y, Z), Blocks.STONE_BRICKS.defaultBlockState(), 3);
			X = x + 10;
			world.setBlock(new BlockPos(X, Y, Z), Blocks.STONE_BRICKS.defaultBlockState(), 3);
		}
	}

	public static void glassX(LevelAccessor world, int x, int Y, int z) {
		for (int X = x - 10; X <= x + 10; X++) {
			int Z = z - 10;
			world.setBlock(new BlockPos(X, Y, Z), Blocks.GLASS.defaultBlockState(), 3);
			Z = z + 10;
			world.setBlock(new BlockPos(X, Y, Z), Blocks.GLASS.defaultBlockState(), 3);
		}
	}

	public static void glassZ(LevelAccessor world, int x, int Y, int z) {
		for (int Z = z - 10; Z <= z + 10; Z++) {
			int X = x - 10;
			world.setBlock(new BlockPos(X, Y, Z), Blocks.GLASS.defaultBlockState(), 3);
			X = x + 10;
			world.setBlock(new BlockPos(X, Y, Z), Blocks.GLASS.defaultBlockState(), 3);
		}
	}

	public static void makeLevel(LevelAccessor world, int x, int Y, int z) {
		wallX(world, x, Y, z);
		wallZ(world, x, Y, z);
	}

	public static void makeWindow(LevelAccessor world, int x, int Y, int z) {
		glassX(world, x, Y, z);
		glassZ(world, x, Y, z);
	}

	public static void makeFloor(LevelAccessor world, int x, int Y, int z) {
		for (int X = x - 9; X <= x + 9; X++) {
			for (int Z = z - 9; Z <= z + 9; Z++) {
				world.setBlock(new BlockPos(X, Y, Z), Blocks.OAK_PLANKS.defaultBlockState(), 3);
			}
		}
	}

	public static int isFour(int count) {
		if (count == 4) {
			return 1;
		}
		return 0;
	}

	public static void makeTower(LevelAccessor world, int x, int y, int z, int height) {
		int Y = y;
		int count = 0;
		while (Y <= y + height) {
			makeLevel(world, x, Y, z);
			int floor = isFour(count);
			if (floor == 1 || Y == y) {
				makeFloor(world, x, Y, z);
				count = 0;
			}
			count++;
			Y++;
		}
		Y = y + 2;
		while (Y <= y + height) {
			makeWindow(world, x, Y, z);
			Y += 4;
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		int blockX = (int) x;
		int blockY = (int) y;
		int blockZ = (int) z;
		makeTower(world, blockX, blockY, blockZ, 64);
	}
}
