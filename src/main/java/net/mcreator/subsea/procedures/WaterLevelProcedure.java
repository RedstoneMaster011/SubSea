package net.mcreator.subsea.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.subsea.network.SubseaModVariables;

public class WaterLevelProcedure {
	public static String execute(Entity entity) {
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
		return (entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SubseaModVariables.PlayerVariables())).AirLevel + ""
				+ (entity.getCapability(SubseaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SubseaModVariables.PlayerVariables())).AirLevel;
	}
}
