
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.testblock.block.TestBlockBlock;
import net.mcreator.testblock.block.MagicznaRudaBlock;
import net.mcreator.testblock.TestblockMod;

public class TestblockModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TestblockMod.MODID);
	public static final RegistryObject<Block> TEST_BLOCK = REGISTRY.register("test_block", () -> new TestBlockBlock());
	public static final RegistryObject<Block> MAGICZNA_RUDA = REGISTRY.register("magiczna_ruda", () -> new MagicznaRudaBlock());
}
