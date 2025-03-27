package net.mcreator.subsea.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Boolean> SPAWNOVERWORLD;
	static {
		BUILDER.push("Spawn In Overworld");
		SPAWNOVERWORLD = BUILDER.comment("Spawns You In The OverWorld").define("Spawn In Overworld", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
