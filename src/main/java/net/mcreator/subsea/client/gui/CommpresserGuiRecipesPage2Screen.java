package net.mcreator.subsea.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.subsea.world.inventory.CommpresserGuiRecipesPage2Menu;
import net.mcreator.subsea.network.CommpresserGuiRecipesPage2ButtonMessage;
import net.mcreator.subsea.SubseaMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CommpresserGuiRecipesPage2Screen extends AbstractContainerScreen<CommpresserGuiRecipesPage2Menu> {
	private final static HashMap<String, Object> guistate = CommpresserGuiRecipesPage2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty1;

	public CommpresserGuiRecipesPage2Screen(CommpresserGuiRecipesPage2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("subsea:textures/screens/commpresser_gui_recipes_page_2.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.commpresser_gui_recipes_page_2.label_compresser"), 39, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.subsea.commpresser_gui_recipes_page_2.label_page_1"), 71, 16, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty1 = Button.builder(Component.translatable("gui.subsea.commpresser_gui_recipes_page_2.button_empty1"), e -> {
			if (true) {
				SubseaMod.PACKET_HANDLER.sendToServer(new CommpresserGuiRecipesPage2ButtonMessage(0, x, y, z));
				CommpresserGuiRecipesPage2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 5, this.topPos + 6, 30, 20).build();
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
	}
}
