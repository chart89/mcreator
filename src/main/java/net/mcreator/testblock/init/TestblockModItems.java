
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.testblock.item.WandItem;
import net.mcreator.testblock.item.MagicznaBrylkaItem;
import net.mcreator.testblock.item.MagicznaArmorItem;
import net.mcreator.testblock.TestblockMod;

public class TestblockModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TestblockMod.MODID);
	public static final RegistryObject<Item> TEST_BLOCK = block(TestblockModBlocks.TEST_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> MAGICZNA_RUDA = block(TestblockModBlocks.MAGICZNA_RUDA, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TOWER = block(TestblockModBlocks.TOWER, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> WAND = REGISTRY.register("wand", () -> new WandItem());
	public static final RegistryObject<Item> MAGICZNA_BRYLKA = REGISTRY.register("magiczna_brylka", () -> new MagicznaBrylkaItem());
	public static final RegistryObject<Item> MAGICZNA_ARMOR_HELMET = REGISTRY.register("magiczna_armor_helmet", () -> new MagicznaArmorItem.Helmet());
	public static final RegistryObject<Item> MAGICZNA_ARMOR_CHESTPLATE = REGISTRY.register("magiczna_armor_chestplate",
			() -> new MagicznaArmorItem.Chestplate());
	public static final RegistryObject<Item> MAGICZNA_ARMOR_LEGGINGS = REGISTRY.register("magiczna_armor_leggings",
			() -> new MagicznaArmorItem.Leggings());
	public static final RegistryObject<Item> MAGICZNA_ARMOR_BOOTS = REGISTRY.register("magiczna_armor_boots", () -> new MagicznaArmorItem.Boots());
	public static final RegistryObject<Item> LIGHT = block(TestblockModBlocks.LIGHT, CreativeModeTab.TAB_BUILDING_BLOCKS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
