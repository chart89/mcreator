package net.mcreator.testblock.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.testblock.network.TestblockModVariables;
import net.mcreator.testblock.init.TestblockModBlocks;

public class MagicznaArmorHelmetTickEventProcedure {
	public static boolean hasItem(Entity entity) {
		if (((Player) entity).getInventory().contains(new ItemStack(Blocks.GLOWSTONE))) {
			return true;
		}
		return false;
	}

	public static void execute(Entity entity) {
		if (entity == null)
			return;
		int x = (int) entity.getX();
		int z = (int) entity.getZ();
		int y = (int) entity.getY() + 1;
		int prevX = (int) TestblockModVariables.MapVariables.get(entity.level).x;
		int prevY = (int) TestblockModVariables.MapVariables.get(entity.level).y;
		int prevZ = (int) TestblockModVariables.MapVariables.get(entity.level).z;
		if (x < 0) {
			x -= 1;
		}
		if (z < 0) {
			z -= 1;
		}
		Block block = entity.level.getBlockState(new BlockPos(x, y, z)).getBlock();
		if ((block == Blocks.AIR || block == Blocks.CAVE_AIR) && hasItem(entity)) {
			if (x != prevX || y != prevY || z != prevZ) {
				entity.level.setBlock(new BlockPos(x, y, z), TestblockModBlocks.LIGHT.get().defaultBlockState(), 3);
				entity.level.setBlock(new BlockPos(prevX, prevY, prevZ), Blocks.AIR.defaultBlockState(), 3);
			} else {
				entity.level.setBlock(new BlockPos(x, y, z), TestblockModBlocks.LIGHT.get().defaultBlockState(), 3);
			}
		}
		TestblockModVariables.MapVariables.get(entity.level).x = x;
		TestblockModVariables.MapVariables.get(entity.level).y = y;
		TestblockModVariables.MapVariables.get(entity.level).z = z;
	}
}
