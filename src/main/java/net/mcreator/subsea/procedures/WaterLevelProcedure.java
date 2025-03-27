package net.mcreator.subsea.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.subsea.network.SubseaModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WaterLevelProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static String execute(LevelAccessor world, Entity entity) {
		return execute(null, world, entity);
	}

	private static String execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		if (entity.isInWater() == true) {
			if (!((entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SubseaModVariables.PlayerVariables())).AirLevel <= 0)) {
				{
					double _setval = (entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SubseaModVariables.PlayerVariables())).AirLevel - 0.05;
					entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.AirLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DROWN)), 2);
				{
					double _setval = 0;
					entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.AirLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			if (!((entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SubseaModVariables.PlayerVariables())).AirLevel >= (entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SubseaModVariables.PlayerVariables())).MaxAir)) {
				{
					double _setval = (entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SubseaModVariables.PlayerVariables())).AirLevel + 5;
					entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.AirLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					double _setval = (entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SubseaModVariables.PlayerVariables())).MaxAir;
					entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.AirLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		return new java.text.DecimalFormat("#").format((entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SubseaModVariables.PlayerVariables())).AirLevel) + "s";
	}
}
