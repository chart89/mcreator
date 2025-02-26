
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.testblock.world.features.ores.MagicznaRudaFeature;
import net.mcreator.testblock.TestblockMod;

@Mod.EventBusSubscriber
public class TestblockModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, TestblockMod.MODID);
	public static final RegistryObject<Feature<?>> MAGICZNA_RUDA = REGISTRY.register("magiczna_ruda", MagicznaRudaFeature::feature);
}
