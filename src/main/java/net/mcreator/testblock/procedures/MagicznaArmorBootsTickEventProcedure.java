package net.mcreator.testblock.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.testblock.network.TestblockModVariables;

public class MagicznaArmorBootsTickEventProcedure {
	public static Block block;

	public static void getBlock(Entity entity, int x, int y, int z) {
		block = entity.level.getBlockState(new BlockPos(x, y, z)).getBlock();
	}

	public static void activatedBoots(Entity entity) {
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("Buty aktywne"), (false));
	}

	public static void deactivatedBoots(Entity entity) {
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("Buty wyłączone"), (false));
	}

	public static void execute(Entity entity) {
		if (entity == null)
			return;
		int x = (int) entity.getX();
		int z = (int) entity.getZ();
		int y = (int) entity.getY() - 1;
		if (x < 0) {
			x -= 1;
		}
		if (z < 0) {
			z -= 1;
		}
		boolean state = TestblockModVariables.MapVariables.get(entity.level).state;
		boolean button = TestblockModVariables.MapVariables.get(entity.level).button;
		if (entity.isCrouching()) {
			if (!button) {
				if (state) {
					state = false;
					deactivatedBoots(entity);
				} else {
					getBlock(entity, x, y, z);
					state = true;
					activatedBoots(entity);
				}
			}
			button = true;
		} else {
			button = false;
		}
		if (state) {
			Block noDiamondBlock = entity.level.getBlockState(new BlockPos(x, y, z)).getBlock();
			if (noDiamondBlock != Blocks.DIAMOND_BLOCK && noDiamondBlock != Blocks.TNT) {
				entity.level.setBlock(new BlockPos(x, y, z), block.defaultBlockState(), 3);
			} else {
				entity.level.setBlock(new BlockPos(x, y, z), Blocks.TNT.defaultBlockState(), 3);
			}
		}
		TestblockModVariables.MapVariables.get(entity.level).state = state;
		TestblockModVariables.MapVariables.get(entity.level).button = button;
	}
}
