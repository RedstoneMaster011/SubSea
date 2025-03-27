package net.mcreator.subsea.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.subsea.configuration.ConfigConfiguration;
import net.mcreator.subsea.SubseaMod;

@Mod.EventBusSubscriber(modid = SubseaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SubseaModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigConfiguration.SPEC, "SubSea Config.toml");
		});
	}
}
