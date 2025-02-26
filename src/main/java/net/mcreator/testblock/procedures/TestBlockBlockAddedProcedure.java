package net.mcreator.testblock.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.testblock.network.TestblockModVariables;

public class TestBlockBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		int setVal = 0;
		TestblockModVariables.MapVariables.get(world).clicks = setVal;
		TestblockModVariables.MapVariables.get(world).syncData(world);

		System.out.println("Wartosc zmiennej clicks: " + TestblockModVariables.MapVariables.get(world).clicks);
	}
}
