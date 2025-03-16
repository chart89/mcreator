package net.mcreator.testblock.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class WandProjectileHitsLivingEntityProcedure {
	public static void litEntity(int time, Entity entity) {
		System.out.println("ogień");
		entity.setSecondsOnFire(time);

	}

	public static void yeeEntity(int height, Entity entity) {
		System.out.println("wyrzut");
		entity.setPos(entity.getX(), entity.getY() + height, entity.getZ());
	}

	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		int Y = (int) sourceentity.getY();
		int X = (int) sourceentity.getX();
		int Z = (int) sourceentity.getZ();
		int[] tab = {10, 20, 40, 80, 160};
		if (sourceentity.level.getBlockState(new BlockPos(X, Y - 1, Z)).getBlock() == Blocks.AIR) {
			sourceentity.startRiding(entity);
		} else if (Y < 79 && Y >= 48) {
			litEntity(tab[0], entity);
		} else if (Y < 48 && Y >= 38) {
			litEntity(tab[1], entity);
		} else if (Y < 36 && Y >= 34) {
			litEntity(tab[2], entity);
		} else if (Y < 24 && Y >= 12) {
			litEntity(tab[3], entity);
		} else if (Y < 12) {
			litEntity(tab[4], entity);
		}
		if (Y >= 80) {
			yeeEntity(100, entity);
		}
	}
}
