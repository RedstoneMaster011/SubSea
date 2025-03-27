
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.subsea.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.subsea.client.gui.CompresserGuiScreen;
import net.mcreator.subsea.client.gui.CompresserGuiRecipesPage1Screen;
import net.mcreator.subsea.client.gui.CommpresserGuiRecipesPage2Screen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SubseaModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(SubseaModMenus.COMPRESSER_GUI.get(), CompresserGuiScreen::new);
			MenuScreens.register(SubseaModMenus.COMPRESSER_GUI_RECIPES_PAGE_1.get(), CompresserGuiRecipesPage1Screen::new);
			MenuScreens.register(SubseaModMenus.COMMPRESSER_GUI_RECIPES_PAGE_2.get(), CommpresserGuiRecipesPage2Screen::new);
		});
	}
}
