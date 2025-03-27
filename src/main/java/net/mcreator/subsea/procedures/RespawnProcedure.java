package net.mcreator.subsea.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.subsea.network.SubseaModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RespawnProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HasFirstJoined = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		JoinProcedure.execute(entity);
	}
}
