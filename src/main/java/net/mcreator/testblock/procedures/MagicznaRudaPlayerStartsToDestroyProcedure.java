package net.mcreator.testblock.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class MagicznaRudaPlayerStartsToDestroyProcedure {
	public static int randomPosition() {//metoda do losowania przesunięcia
		int random = (int) (Math.random() * 10);
		int isMinus = (int) (Math.random() * 2);
		if (isMinus == 1) {
			random = random * (-1);
		}
		return random;
	}

	public static void spawnCreeper(LevelAccessor world, double x, double y, double z) {
		int X = randomPosition();
		int Z = randomPosition();
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new Creeper(EntityType.CREEPER, _level);
			entityToSpawn.moveTo(x + X, y, z + Z, world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
	}

	public static void spawnZombie(LevelAccessor world, double x, double y, double z) {
		int X = randomPosition();
		int Z = randomPosition();
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new Zombie(EntityType.ZOMBIE, _level);
			entityToSpawn.moveTo(x + X, y, z + Z, world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
	}

	public static void spawnSkeleton(LevelAccessor world, double x, double y, double z) {
		int X = randomPosition();
		int Z = randomPosition();
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new Skeleton(EntityType.SKELETON, _level);
			entityToSpawn.moveTo(x + X, y, z + Z, world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		int random = (int) (Math.random() * 4);
		System.out.println("Wartosc zmiennej clicks: " + random);
		if (random == 0) { // szansa na pojawienie się potwora 1/4
			for (int index = 0; index < 4; index++) {
				random = (int) (Math.random() * 3);
				if (random == 0) {
					spawnCreeper(world, x, x, x);
				} else if (random == 1) {
					spawnZombie(world, x, x, x);
				} else if (random == 2) {
					spawnSkeleton(world, x, x, x);
				}
			}
		}
	}
}
/*
 
 
*/
