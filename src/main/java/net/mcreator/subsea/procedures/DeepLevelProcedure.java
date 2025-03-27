package net.mcreator.subsea.procedures;

public class DeepLevelProcedure {
	public static String execute(double y) {
		return new java.text.DecimalFormat("#").format(151 - y) + "m";
	}
}
