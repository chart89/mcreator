package net.mcreator.testblock.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.testblock.network.TestblockModVariables;

public class TestBlockBlockDestroyedByPlayerProcedure {
	static LevelAccessor myWorld;
	static double myX, myY, myZ;

	public static int randomInt(int max) {
		int random = (int) (Math.random() * max);
		return random;
	}

	public static void spawnCreeper() {
		int[] tab = {2, 4, 8, 16, 32, 64};
		int randomNum = randomInt(6);
		for (int i = 0; i < tab[randomNum]; i++) {
			if (myWorld instanceof ServerLevel _level) {
				Entity entityToSpawn = new Creeper(EntityType.CREEPER, _level);
				entityToSpawn.moveTo(myX, myY, myZ, myWorld.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, myWorld.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				myWorld.addFreshEntity(entityToSpawn);
			}
		}
		System.out.println("Liczba mobów " + randomNum);
	}

	public static void spawnDiamond() {
		if (myWorld instanceof Level _level && !_level.isClientSide()) {
			ItemEntity entityToSpawn = new ItemEntity(_level, myX, myY, myZ, new ItemStack(Items.DIAMOND));
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		myWorld = world;
		myX = x;
		myY = y;
		myZ = z;
		int randomVal = (int) (Math.random() * 2);
		int currentVal = (int) TestblockModVariables.MapVariables.get(world).clicks;
		if (randomVal == 0) {
			spawnCreeper();
		} else if (randomVal == 1) {
			spawnDiamond();
		}
	}
}
