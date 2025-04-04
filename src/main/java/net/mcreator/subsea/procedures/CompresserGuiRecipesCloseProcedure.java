package net.mcreator.subsea.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.subsea.world.inventory.CompresserGuiRecipesPage1Menu;
import net.mcreator.subsea.world.inventory.CompresserGuiMenu;
import net.mcreator.subsea.world.inventory.CommpresserGuiRecipesPage2Menu;
import net.mcreator.subsea.SubseaMod;

import io.netty.buffer.Unpooled;

public class CompresserGuiRecipesCloseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		SubseaMod.queueServerWork(2, () -> {
			if (!(entity instanceof Player _plr0 && _plr0.containerMenu instanceof CompresserGuiRecipesPage1Menu)) {
				if (!(entity instanceof Player _plr1 && _plr1.containerMenu instanceof CommpresserGuiRecipesPage2Menu)) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("CompresserGui");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new CompresserGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		});
	}
}
