
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.subsea.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.subsea.block.CompresserBlock;
import net.mcreator.subsea.SubseaMod;

public class SubseaModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SubseaMod.MODID);
	public static final RegistryObject<Block> COMPRESSER = REGISTRY.register("compresser", () -> new CompresserBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
