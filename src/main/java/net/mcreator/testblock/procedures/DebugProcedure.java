/*
package net.mcreator.testblock.procedures;

public class DebugProcedure {
	static double myX, myY;
	static LevelAccessor myWorld;

	public static int randomInt(int max) {
		int random = (int) (Math.random() * max);
		return random;

	public static void spawnCreeper() {
		int tab[] = {2, 4, 8, 16, 32, 64)
		int random = randomInt();
		for (i = 0; i < tab[6]; i++) {
			if (myWorld instanceof ServerLevel _level) {
				Entity entityToSpawn = new Creeper(EntityType.CREEPER, _level);
				entityToSpawn.moveTo(myX, myY, myZ, myWorld.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, myWorld.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				myWorld.addFreshEntity(entityToSpawn);
			}
		}
		int random = 3;
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
		int randomVal;
		randomVaal = (int) (Math.random() * 2);
		if (randomVal == 0) {
			spawnCreeper();
		} else if (randomVal = 1) {
			for (int index = 0; index < 10; index++) {
				spawnDiamond();
			}
		}
	}
}
*/