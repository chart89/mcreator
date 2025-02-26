package net.mcreator.testblock.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.testblock.network.TestblockModVariables;

public class TestBlockRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		int clickVal = 1;
		TestblockModVariables.MapVariables.get(world).clicks += clickVal;
		TestblockModVariables.MapVariables.get(world).syncData(world);
		int currentVal = (int) TestblockModVariables.MapVariables.get(world).clicks;
		if (currentVal > 10) {
			TestblockModVariables.MapVariables.get(world).clicks = 0;
			TestblockModVariables.MapVariables.get(world).syncData(world);
		}
		System.out.println("Wartosc zmiennej clicks: " + TestblockModVariables.MapVariables.get(world).clicks);
	}
}
