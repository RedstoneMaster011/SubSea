
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.subsea.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.subsea.world.inventory.CompresserGuiRecipesPage1Menu;
import net.mcreator.subsea.world.inventory.CompresserGuiMenu;
import net.mcreator.subsea.world.inventory.CommpresserGuiRecipesPage2Menu;
import net.mcreator.subsea.SubseaMod;

public class SubseaModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SubseaMod.MODID);
	public static final RegistryObject<MenuType<CompresserGuiMenu>> COMPRESSER_GUI = REGISTRY.register("compresser_gui", () -> IForgeMenuType.create(CompresserGuiMenu::new));
	public static final RegistryObject<MenuType<CompresserGuiRecipesPage1Menu>> COMPRESSER_GUI_RECIPES_PAGE_1 = REGISTRY.register("compresser_gui_recipes_page_1", () -> IForgeMenuType.create(CompresserGuiRecipesPage1Menu::new));
	public static final RegistryObject<MenuType<CommpresserGuiRecipesPage2Menu>> COMMPRESSER_GUI_RECIPES_PAGE_2 = REGISTRY.register("commpresser_gui_recipes_page_2", () -> IForgeMenuType.create(CommpresserGuiRecipesPage2Menu::new));
}
