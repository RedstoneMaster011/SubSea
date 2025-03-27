
package net.mcreator.subsea.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.subsea.procedures.WaterLevelProcedure;
import net.mcreator.subsea.procedures.DeepLevelProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class OverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					WaterLevelProcedure.execute(entity), w / 2 + -210, h / 2 + 107, -16777063, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.subsea.overlay.label_air"), w / 2 + -210, h / 2 + 97, -16776961, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.subsea.overlay.label_deep"), w / 2 + -209, h / 2 + 74, -16711681, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DeepLevelProcedure.execute(y), w / 2 + -210, h / 2 + 85, -16751002, false);
		}
	}
}
