
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.subsea.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.subsea.world.inventory.CompresserGuiMenu;
import net.mcreator.subsea.SubseaMod;

public class SubseaModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SubseaMod.MODID);
	public static final RegistryObject<MenuType<CompresserGuiMenu>> COMPRESSER_GUI = REGISTRY.register("compresser_gui", () -> IForgeMenuType.create(CompresserGuiMenu::new));
}
